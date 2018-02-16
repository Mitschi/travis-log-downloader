package com.github.mitschi;

import com.github.mitschi.logdownloader.BuildsDownloader;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String projectName=args[0];
        String targetFolder=args[1];
        String authToken=args[2];
        BuildsDownloader buildsdownloader = new BuildsDownloader(authToken);
        buildsdownloader.retrieveBuilds(new File(targetFolder),projectName);
    }
}
