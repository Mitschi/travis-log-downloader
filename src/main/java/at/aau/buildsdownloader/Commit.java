
package at.aau.buildsdownloader;

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
    "@type",
    "@representation",
    "id",
    "sha",
    "ref",
    "message",
    "compare_url",
    "committed_at"
})
public class Commit implements Serializable
{

    @JsonProperty("@type")
    private String type;
    @JsonProperty("@representation")
    private String representation;
    @JsonProperty("id")
    private Long id;
    @JsonProperty("sha")
    private String sha;
    @JsonProperty("ref")
    private String ref;
    @JsonProperty("message")
    private String message;
    @JsonProperty("compare_url")
    private String compareUrl;
    @JsonProperty("committed_at")
    private String committedAt;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -779991474105374090L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Commit() {
    }

    /**
     * 
     * @param message
     * @param id
     * @param ref
     * @param compareUrl
     * @param sha
     * @param representation
     * @param committedAt
     * @param type
     */
    public Commit(String type, String representation, Long id, String sha, String ref, String message, String compareUrl, String committedAt) {
        super();
        this.type = type;
        this.representation = representation;
        this.id = id;
        this.sha = sha;
        this.ref = ref;
        this.message = message;
        this.compareUrl = compareUrl;
        this.committedAt = committedAt;
    }

    @JsonProperty("@type")
    public String getType() {
        return type;
    }

    @JsonProperty("@type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("@representation")
    public String getRepresentation() {
        return representation;
    }

    @JsonProperty("@representation")
    public void setRepresentation(String representation) {
        this.representation = representation;
    }

    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("sha")
    public String getSha() {
        return sha;
    }

    @JsonProperty("sha")
    public void setSha(String sha) {
        this.sha = sha;
    }

    @JsonProperty("ref")
    public String getRef() {
        return ref;
    }

    @JsonProperty("ref")
    public void setRef(String ref) {
        this.ref = ref;
    }

    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    @JsonProperty("compare_url")
    public String getCompareUrl() {
        return compareUrl;
    }

    @JsonProperty("compare_url")
    public void setCompareUrl(String compareUrl) {
        this.compareUrl = compareUrl;
    }

    @JsonProperty("committed_at")
    public String getCommittedAt() {
        return committedAt;
    }

    @JsonProperty("committed_at")
    public void setCommittedAt(String committedAt) {
        this.committedAt = committedAt;
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
        return new ToStringBuilder(this).append("type", type).append("representation", representation).append("id", id).append("sha", sha).append("ref", ref).append("message", message).append("compareUrl", compareUrl).append("committedAt", committedAt).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(message).append(id).append(ref).append(compareUrl).append(sha).append(additionalProperties).append(representation).append(committedAt).append(type).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Commit) == false) {
            return false;
        }
        Commit rhs = ((Commit) other);
        return new EqualsBuilder().append(message, rhs.message).append(id, rhs.id).append(ref, rhs.ref).append(compareUrl, rhs.compareUrl).append(sha, rhs.sha).append(additionalProperties, rhs.additionalProperties).append(representation, rhs.representation).append(committedAt, rhs.committedAt).append(type, rhs.type).isEquals();
    }

}
