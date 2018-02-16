package com.github.mitschi.logdownloader;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class BuildsDownloader {
    private static final Logger LOG = LoggerFactory.getLogger(BuildsDownloader.class);

    public String authenticationToken = "";

    public BuildsDownloader(String authenticationToken) {
        this.authenticationToken = authenticationToken;
    }

    public void retrieveBuilds(File targetFolder, String projectName) throws IOException {
        Long repoId = transformProjectNameToId(projectName);
        Long numberOfBuilds = countBuilds(repoId);
        List<Builds> builds = new ArrayList<>();

        for (int i = 0; i < numberOfBuilds; i += 100) {
            LOG.info("Offset: " + i);
            Builds currentBuilds = downloadBuilds(repoId, i);
            builds.add(currentBuilds);
        }

        if (!targetFolder.exists()) {
            targetFolder.mkdirs();
        }
        //download the respective logs
        for (Builds buildss : builds) {
            for (Build build : buildss.getBuilds()) {
                downloadLog(targetFolder, build);
            }
            LOG.info("Waiting...");
            try {Thread.sleep(30000);} catch (InterruptedException e) {}
        }
    }


    //        curl -L http://api.travis-ci.org/repos/<repo/Name>
    private Long transformProjectNameToId(String projectName) throws IOException {
        URL url = new URL("https://api.travis-ci.org/repos/" + projectName);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        setGetToAPINoAuthorizationToken(con);

        boolean redirect = false;
        int status = con.getResponseCode();

        if (status != HttpURLConnection.HTTP_OK) {
            if (isMovedStatus(status))
                redirect = true;
        }

        LOG.info("Response Code ... " + status);

        if (redirect) {
            con = retry(con);
        }

        StringBuffer content = readResponseToStringBuffer(con);

        ObjectMapper mapper = new ObjectMapper();
        Rates rates = mapper.readValue(content.toString(), Rates.class);
        return rates.getId();
    }

    //        curl -L -H "Travis-API-Version: 3" -H "Authorization: token <token>" https://api.travis-ci.org/repo/<repoId>/builds
    private Long countBuilds(Long repoId) throws IOException {
        URL url = new URL("https://api.travis-ci.org/repo/" + repoId + "/builds");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        setGetToAPIWithAuthorizationToken(con);

        int status = con.getResponseCode();

        StringBuffer content = readResponseToStringBuffer(con);

        ObjectMapper mapper = new ObjectMapper();
        Builds builds = mapper.readValue(content.toString(), Builds.class);

        return builds.getPagination().getCount();
    }

    //        curl -L -H "Travis-API-Version: 3" -H "Authorization: token <token>" "https://api.travis-ci.org/repo/<repoId>/builds?limit=100&offset=0"
    private Builds downloadBuilds(Long repoId, int offset) throws IOException {
        URL url = new URL("https://api.travis-ci.org/repo/" + repoId + "/builds?limit=100&offset=" + offset);
        HttpURLConnection con = null;
        boolean retry=false;
        int counter=1;
        do {
            con = (HttpURLConnection) url.openConnection();
            setGetToAPIWithAuthorizationToken(con);

            boolean redirect = false;
            int status = con.getResponseCode();

            if (status != HttpURLConnection.HTTP_OK) {
                if (isMovedStatus(status))
                    redirect = true;
            }

            LOG.info("Response Code ... " + status);

            if (redirect) {
                con = retry(con);
                status = con.getResponseCode();
            }
            retry=isFailing(status) && counter <3;
            counter++;
        }while(retry);

        StringBuffer content = readResponseToStringBuffer(con);

        ObjectMapper mapper = new ObjectMapper();
        Builds builds = mapper.readValue(content.toString(), Builds.class);
        return builds;
    }

    //        curl -L -H "Travis-API-Version: 3" -H "Authorization: token <token>" https://api.travis-ci.org/v3/job/<jobId>/log.txt
    private void downloadLog(File targetFolder, Build build) throws IOException {
        List<Job> jobs = build.getJobs();
        for (int i = 0; i < jobs.size(); i++) {
            Job job = jobs.get(i);

            URL url = new URL("https://api.travis-ci.org/v3/job/" + job.getId() + "/log.txt");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            setGetToAPIWithAuthorizationToken(con);

            boolean redirect = false;
            boolean skip = false;
            int status = con.getResponseCode();

            if (status != HttpURLConnection.HTTP_OK) {
                if (isMovedStatus(status))
                    redirect = true;
                if (status == HttpURLConnection.HTTP_NOT_FOUND) {
                    skip = true;
                }
            }

            LOG.info("Response Code ... " + status);
            if (!skip) {
                if (redirect) {
                    con = retry(con);
                }
                StringBuffer content = readResponseToStringBuffer(con);
                writeLogToFile(targetFolder, build, i, content);
            }
        }
    }

    private void writeLogToFile(File targetFolder, Build build, int i, StringBuffer content) throws IOException {
        String filename = build.getCommit().getSha() + "_" + build.getId();
        if (build.getJobs().size() > 1) {
            filename += "_" + build.getBranch().getName() + "_" + i;
        }
        filename += ".txt";
        File outputFile = new File(targetFolder, filename);
        FileUtils.writeStringToFile(outputFile, content.toString());
    }
    private HttpURLConnection retry(HttpURLConnection con) throws IOException {
        // get redirect url from "location" header field
        String newUrl = con.getHeaderField("Location");

        // get the cookie if need, for login
        String cookies = con.getHeaderField("Set-Cookie");

        // open the new connnection again
        con = (HttpURLConnection) new URL(newUrl).openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Travis-API-Version", "3");
        con.setRequestProperty("Authorization", "token " + this.authenticationToken);
//            con.setRequestProperty("Cookie", cookies);
//            con.addRequestProperty("Accept-Language", "en-US,en;q=0.8");
//            con.addRequestProperty("User-Agent", "Mozilla");
//            con.addRequestProperty("Referer", "google.com");

        LOG.info("Redirect to URL : " + newUrl);
        return con;
    }
    private StringBuffer readResponseToStringBuffer(HttpURLConnection con) throws IOException {
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        con.disconnect();
        return content;
    }
    private boolean isMovedStatus(int status) {
        return status == HttpURLConnection.HTTP_MOVED_TEMP
                || status == HttpURLConnection.HTTP_MOVED_PERM
                || status == HttpURLConnection.HTTP_SEE_OTHER;
    }
    private boolean isFailing(int status) {
        return  status==HttpURLConnection.HTTP_BAD_GATEWAY ||
                status==HttpURLConnection.HTTP_INTERNAL_ERROR ||
                status==HttpURLConnection.HTTP_BAD_METHOD ||
                status==HttpURLConnection.HTTP_GATEWAY_TIMEOUT ||
                status==HttpURLConnection.HTTP_UNAVAILABLE;
    }
    private void setGetToAPINoAuthorizationToken(HttpURLConnection con) throws ProtocolException {
        con.setRequestMethod("GET");
        con.setInstanceFollowRedirects(true);
    }
    private void setGetToAPIWithAuthorizationToken(HttpURLConnection con) throws ProtocolException {
        con.setRequestMethod("GET");
        con.setRequestProperty("Travis-API-Version", "3");
        con.setRequestProperty("Authorization", "token " + this.authenticationToken);
        con.setInstanceFollowRedirects(true);
    }

}