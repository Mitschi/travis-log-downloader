
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
    "@pagination",
    "builds"
})
public class Builds implements Serializable
{

    @JsonProperty("@type")
    private String type;
    @JsonProperty("@href")
    private String href;
    @JsonProperty("@representation")
    private String representation;
    @JsonProperty("@pagination")
    private Pagination pagination;
    @JsonProperty("builds")
    private List<Build> builds = new ArrayList<Build>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -3095215269818650825L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Builds() {
    }

    /**
     * 
     * @param builds
     * @param representation
     * @param pagination
     * @param type
     * @param href
     */
    public Builds(String type, String href, String representation, Pagination pagination, List<Build> builds) {
        super();
        this.type = type;
        this.href = href;
        this.representation = representation;
        this.pagination = pagination;
        this.builds = builds;
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

    @JsonProperty("@pagination")
    public Pagination getPagination() {
        return pagination;
    }

    @JsonProperty("@pagination")
    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    @JsonProperty("builds")
    public List<Build> getBuilds() {
        return builds;
    }

    @JsonProperty("builds")
    public void setBuilds(List<Build> builds) {
        this.builds = builds;
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
        return new ToStringBuilder(this).append("type", type).append("href", href).append("representation", representation).append("pagination", pagination).append("builds", builds).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(builds).append(additionalProperties).append(representation).append(pagination).append(type).append(href).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Builds) == false) {
            return false;
        }
        Builds rhs = ((Builds) other);
        return new EqualsBuilder().append(builds, rhs.builds).append(additionalProperties, rhs.additionalProperties).append(representation, rhs.representation).append(pagination, rhs.pagination).append(type, rhs.type).append(href, rhs.href).isEquals();
    }

}
