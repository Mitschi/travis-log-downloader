
package com.github.mitschi.logdownloader;

import java.io.Serializable;
import java.util.HashMap;
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
    "id",
    "slug",
    "description",
    "public_key",
    "last_build_id",
    "last_build_number",
    "last_build_status",
    "last_build_result",
    "last_build_duration",
    "last_build_language",
    "last_build_started_at",
    "last_build_finished_at",
    "active"
})
public class Rates implements Serializable
{

    @JsonProperty("id")
    private Long id;
    @JsonProperty("slug")
    private String slug;
    @JsonProperty("description")
    private String description;
    @JsonProperty("public_key")
    private String publicKey;
    @JsonProperty("last_build_id")
    private Long lastBuildId;
    @JsonProperty("last_build_number")
    private String lastBuildNumber;
    @JsonProperty("last_build_status")
    private Long lastBuildStatus;
    @JsonProperty("last_build_result")
    private Long lastBuildResult;
    @JsonProperty("last_build_duration")
    private Long lastBuildDuration;
    @JsonProperty("last_build_language")
    private Object lastBuildLanguage;
    @JsonProperty("last_build_started_at")
    private String lastBuildStartedAt;
    @JsonProperty("last_build_finished_at")
    private String lastBuildFinishedAt;
    @JsonProperty("active")
    private Boolean active;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -2338646250955982197L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Rates() {
    }

    /**
     * 
     * @param lastBuildFinishedAt
     * @param lastBuildDuration
     * @param publicKey
     * @param id
     * @param lastBuildResult
     * @param description
     * @param active
     * @param slug
     * @param lastBuildStartedAt
     * @param lastBuildNumber
     * @param lastBuildLanguage
     * @param lastBuildId
     * @param lastBuildStatus
     */
    public Rates(Long id, String slug, String description, String publicKey, Long lastBuildId, String lastBuildNumber, Long lastBuildStatus, Long lastBuildResult, Long lastBuildDuration, Object lastBuildLanguage, String lastBuildStartedAt, String lastBuildFinishedAt, Boolean active) {
        super();
        this.id = id;
        this.slug = slug;
        this.description = description;
        this.publicKey = publicKey;
        this.lastBuildId = lastBuildId;
        this.lastBuildNumber = lastBuildNumber;
        this.lastBuildStatus = lastBuildStatus;
        this.lastBuildResult = lastBuildResult;
        this.lastBuildDuration = lastBuildDuration;
        this.lastBuildLanguage = lastBuildLanguage;
        this.lastBuildStartedAt = lastBuildStartedAt;
        this.lastBuildFinishedAt = lastBuildFinishedAt;
        this.active = active;
    }

    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("slug")
    public String getSlug() {
        return slug;
    }

    @JsonProperty("slug")
    public void setSlug(String slug) {
        this.slug = slug;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("public_key")
    public String getPublicKey() {
        return publicKey;
    }

    @JsonProperty("public_key")
    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    @JsonProperty("last_build_id")
    public Long getLastBuildId() {
        return lastBuildId;
    }

    @JsonProperty("last_build_id")
    public void setLastBuildId(Long lastBuildId) {
        this.lastBuildId = lastBuildId;
    }

    @JsonProperty("last_build_number")
    public String getLastBuildNumber() {
        return lastBuildNumber;
    }

    @JsonProperty("last_build_number")
    public void setLastBuildNumber(String lastBuildNumber) {
        this.lastBuildNumber = lastBuildNumber;
    }

    @JsonProperty("last_build_status")
    public Long getLastBuildStatus() {
        return lastBuildStatus;
    }

    @JsonProperty("last_build_status")
    public void setLastBuildStatus(Long lastBuildStatus) {
        this.lastBuildStatus = lastBuildStatus;
    }

    @JsonProperty("last_build_result")
    public Long getLastBuildResult() {
        return lastBuildResult;
    }

    @JsonProperty("last_build_result")
    public void setLastBuildResult(Long lastBuildResult) {
        this.lastBuildResult = lastBuildResult;
    }

    @JsonProperty("last_build_duration")
    public Long getLastBuildDuration() {
        return lastBuildDuration;
    }

    @JsonProperty("last_build_duration")
    public void setLastBuildDuration(Long lastBuildDuration) {
        this.lastBuildDuration = lastBuildDuration;
    }

    @JsonProperty("last_build_language")
    public Object getLastBuildLanguage() {
        return lastBuildLanguage;
    }

    @JsonProperty("last_build_language")
    public void setLastBuildLanguage(Object lastBuildLanguage) {
        this.lastBuildLanguage = lastBuildLanguage;
    }

    @JsonProperty("last_build_started_at")
    public String getLastBuildStartedAt() {
        return lastBuildStartedAt;
    }

    @JsonProperty("last_build_started_at")
    public void setLastBuildStartedAt(String lastBuildStartedAt) {
        this.lastBuildStartedAt = lastBuildStartedAt;
    }

    @JsonProperty("last_build_finished_at")
    public String getLastBuildFinishedAt() {
        return lastBuildFinishedAt;
    }

    @JsonProperty("last_build_finished_at")
    public void setLastBuildFinishedAt(String lastBuildFinishedAt) {
        this.lastBuildFinishedAt = lastBuildFinishedAt;
    }

    @JsonProperty("active")
    public Boolean getActive() {
        return active;
    }

    @JsonProperty("active")
    public void setActive(Boolean active) {
        this.active = active;
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
        return new ToStringBuilder(this).append("id", id).append("slug", slug).append("description", description).append("publicKey", publicKey).append("lastBuildId", lastBuildId).append("lastBuildNumber", lastBuildNumber).append("lastBuildStatus", lastBuildStatus).append("lastBuildResult", lastBuildResult).append("lastBuildDuration", lastBuildDuration).append("lastBuildLanguage", lastBuildLanguage).append("lastBuildStartedAt", lastBuildStartedAt).append("lastBuildFinishedAt", lastBuildFinishedAt).append("active", active).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(lastBuildDuration).append(publicKey).append(lastBuildStartedAt).append(lastBuildStatus).append(lastBuildFinishedAt).append(id).append(lastBuildResult).append(additionalProperties).append(description).append(active).append(slug).append(lastBuildNumber).append(lastBuildLanguage).append(lastBuildId).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Rates) == false) {
            return false;
        }
        Rates rhs = ((Rates) other);
        return new EqualsBuilder().append(lastBuildDuration, rhs.lastBuildDuration).append(publicKey, rhs.publicKey).append(lastBuildStartedAt, rhs.lastBuildStartedAt).append(lastBuildStatus, rhs.lastBuildStatus).append(lastBuildFinishedAt, rhs.lastBuildFinishedAt).append(id, rhs.id).append(lastBuildResult, rhs.lastBuildResult).append(additionalProperties, rhs.additionalProperties).append(description, rhs.description).append(active, rhs.active).append(slug, rhs.slug).append(lastBuildNumber, rhs.lastBuildNumber).append(lastBuildLanguage, rhs.lastBuildLanguage).append(lastBuildId, rhs.lastBuildId).isEquals();
    }

}
