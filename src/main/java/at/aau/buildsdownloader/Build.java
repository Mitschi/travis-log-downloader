
package at.aau.buildsdownloader;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "@type",
    "@href",
    "@representation",
    "@permissions",
    "id",
    "number",
    "state",
    "duration",
    "event_type",
    "previous_state",
    "pull_request_title",
    "pull_request_number",
    "started_at",
    "finished_at",
    "repository",
    "branch",
    "tag",
    "commit",
    "jobs",
    "stages",
    "created_by",
    "updated_at"
})
public class Build implements Serializable
{

    @JsonProperty("@type")
    private String type;
    @JsonProperty("@href")
    private String href;
    @JsonProperty("@representation")
    private String representation;
    @JsonProperty("@permissions")
    private Permissions permissions;
    @JsonProperty("id")
    private Long id;
    @JsonProperty("number")
    private String number;
    @JsonProperty("state")
    private String state;
    @JsonProperty("duration")
    private Long duration;
    @JsonProperty("event_type")
    private String eventType;
    @JsonProperty("previous_state")
    private String previousState;
    @JsonProperty("pull_request_title")
    private Object pullRequestTitle;
    @JsonProperty("pull_request_number")
    private Object pullRequestNumber;
    @JsonProperty("started_at")
    private String startedAt;
    @JsonProperty("finished_at")
    private String finishedAt;
    @JsonProperty("repository")
    private Repository repository;
    @JsonProperty("branch")
    private Branch branch;
    @JsonProperty("tag")
    private Object tag;
    @JsonProperty("commit")
    private Commit commit;
    @JsonProperty("jobs")
    private List<Job> jobs = new ArrayList<Job>();
    @JsonProperty("stages")
    private List<Object> stages = new ArrayList<Object>();
    @JsonProperty("created_by")
    private CreatedBy createdBy;
    @JsonProperty("updated_at")
    private String updatedAt;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 920667025896121946L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Build() {
    }

    /**
     * 
     * @param jobs
     * @param tag
     * @param startedAt
     * @param state
     * @param number
     * @param eventType
     * @param type
     * @param pullRequestTitle
     * @param stages
     * @param updatedAt
     * @param id
     * @param duration
     * @param createdBy
     * @param commit
     * @param repository
     * @param representation
     * @param finishedAt
     * @param permissions
     * @param branch
     * @param pullRequestNumber
     * @param previousState
     * @param href
     */
    public Build(String type, String href, String representation, Permissions permissions, Long id, String number, String state, Long duration, String eventType, String previousState, Object pullRequestTitle, Object pullRequestNumber, String startedAt, String finishedAt, Repository repository, Branch branch, Object tag, Commit commit, List<Job> jobs, List<Object> stages, CreatedBy createdBy, String updatedAt) {
        super();
        this.type = type;
        this.href = href;
        this.representation = representation;
        this.permissions = permissions;
        this.id = id;
        this.number = number;
        this.state = state;
        this.duration = duration;
        this.eventType = eventType;
        this.previousState = previousState;
        this.pullRequestTitle = pullRequestTitle;
        this.pullRequestNumber = pullRequestNumber;
        this.startedAt = startedAt;
        this.finishedAt = finishedAt;
        this.repository = repository;
        this.branch = branch;
        this.tag = tag;
        this.commit = commit;
        this.jobs = jobs;
        this.stages = stages;
        this.createdBy = createdBy;
        this.updatedAt = updatedAt;
    }

    @JsonProperty("@type")
    public String getType() {
        return type;
    }

    @JsonProperty("@type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("@href")
    public String getHref() {
        return href;
    }

    @JsonProperty("@href")
    public void setHref(String href) {
        this.href = href;
    }

    @JsonProperty("@representation")
    public String getRepresentation() {
        return representation;
    }

    @JsonProperty("@representation")
    public void setRepresentation(String representation) {
        this.representation = representation;
    }

    @JsonProperty("@permissions")
    public Permissions getPermissions() {
        return permissions;
    }

    @JsonProperty("@permissions")
    public void setPermissions(Permissions permissions) {
        this.permissions = permissions;
    }

    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("number")
    public String getNumber() {
        return number;
    }

    @JsonProperty("number")
    public void setNumber(String number) {
        this.number = number;
    }

    @JsonProperty("state")
    public String getState() {
        return state;
    }

    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    @JsonProperty("duration")
    public Long getDuration() {
        return duration;
    }

    @JsonProperty("duration")
    public void setDuration(Long duration) {
        this.duration = duration;
    }

    @JsonProperty("event_type")
    public String getEventType() {
        return eventType;
    }

    @JsonProperty("event_type")
    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    @JsonProperty("previous_state")
    public String getPreviousState() {
        return previousState;
    }

    @JsonProperty("previous_state")
    public void setPreviousState(String previousState) {
        this.previousState = previousState;
    }

    @JsonProperty("pull_request_title")
    public Object getPullRequestTitle() {
        return pullRequestTitle;
    }

    @JsonProperty("pull_request_title")
    public void setPullRequestTitle(Object pullRequestTitle) {
        this.pullRequestTitle = pullRequestTitle;
    }

    @JsonProperty("pull_request_number")
    public Object getPullRequestNumber() {
        return pullRequestNumber;
    }

    @JsonProperty("pull_request_number")
    public void setPullRequestNumber(Object pullRequestNumber) {
        this.pullRequestNumber = pullRequestNumber;
    }

    @JsonProperty("started_at")
    public String getStartedAt() {
        return startedAt;
    }

    @JsonProperty("started_at")
    public void setStartedAt(String startedAt) {
        this.startedAt = startedAt;
    }

    @JsonProperty("finished_at")
    public String getFinishedAt() {
        return finishedAt;
    }

    @JsonProperty("finished_at")
    public void setFinishedAt(String finishedAt) {
        this.finishedAt = finishedAt;
    }

    @JsonProperty("repository")
    public Repository getRepository() {
        return repository;
    }

    @JsonProperty("repository")
    public void setRepository(Repository repository) {
        this.repository = repository;
    }

    @JsonProperty("branch")
    public Branch getBranch() {
        return branch;
    }

    @JsonProperty("branch")
    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    @JsonProperty("tag")
    public Object getTag() {
        return tag;
    }

    @JsonProperty("tag")
    public void setTag(Object tag) {
        this.tag = tag;
    }

    @JsonProperty("commit")
    public Commit getCommit() {
        return commit;
    }

    @JsonProperty("commit")
    public void setCommit(Commit commit) {
        this.commit = commit;
    }

    @JsonProperty("jobs")
    public List<Job> getJobs() {
        return jobs;
    }

    @JsonProperty("jobs")
    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    @JsonProperty("stages")
    public List<Object> getStages() {
        return stages;
    }

    @JsonProperty("stages")
    public void setStages(List<Object> stages) {
        this.stages = stages;
    }

    @JsonProperty("created_by")
    public CreatedBy getCreatedBy() {
        return createdBy;
    }

    @JsonProperty("created_by")
    public void setCreatedBy(CreatedBy createdBy) {
        this.createdBy = createdBy;
    }

    @JsonProperty("updated_at")
    public String getUpdatedAt() {
        return updatedAt;
    }

    @JsonProperty("updated_at")
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("type", type).append("href", href).append("representation", representation).append("permissions", permissions).append("id", id).append("number", number).append("state", state).append("duration", duration).append("eventType", eventType).append("previousState", previousState).append("pullRequestTitle", pullRequestTitle).append("pullRequestNumber", pullRequestNumber).append("startedAt", startedAt).append("finishedAt", finishedAt).append("repository", repository).append("branch", branch).append("tag", tag).append("commit", commit).append("jobs", jobs).append("stages", stages).append("createdBy", createdBy).append("updatedAt", updatedAt).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(jobs).append(tag).append(startedAt).append(state).append(number).append(eventType).append(pullRequestTitle).append(type).append(stages).append(updatedAt).append(id).append(duration).append(createdBy).append(commit).append(repository).append(additionalProperties).append(representation).append(finishedAt).append(permissions).append(branch).append(pullRequestNumber).append(previousState).append(href).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Build) == false) {
            return false;
        }
        Build rhs = ((Build) other);
        return new EqualsBuilder().append(jobs, rhs.jobs).append(tag, rhs.tag).append(startedAt, rhs.startedAt).append(state, rhs.state).append(number, rhs.number).append(eventType, rhs.eventType).append(pullRequestTitle, rhs.pullRequestTitle).append(type, rhs.type).append(stages, rhs.stages).append(updatedAt, rhs.updatedAt).append(id, rhs.id).append(duration, rhs.duration).append(createdBy, rhs.createdBy).append(commit, rhs.commit).append(repository, rhs.repository).append(additionalProperties, rhs.additionalProperties).append(representation, rhs.representation).append(finishedAt, rhs.finishedAt).append(permissions, rhs.permissions).append(branch, rhs.branch).append(pullRequestNumber, rhs.pullRequestNumber).append(previousState, rhs.previousState).append(href, rhs.href).isEquals();
    }

}
