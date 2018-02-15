
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
    "@href",
    "@representation",
    "id"
})
public class Job implements Serializable
{

    @JsonProperty("@type")
    private String type;
    @JsonProperty("@href")
    private String href;
    @JsonProperty("@representation")
    private String representation;
    @JsonProperty("id")
    private Long id;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -1655114199119124076L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Job() {
    }

    /**
     * 
     * @param id
     * @param representation
     * @param type
     * @param href
     */
    public Job(String type, String href, String representation, Long id) {
        super();
        this.type = type;
        this.href = href;
        this.representation = representation;
        this.id = id;
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

    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Long id) {
        this.id = id;
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
        return new ToStringBuilder(this).append("type", type).append("href", href).append("representation", representation).append("id", id).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(additionalProperties).append(representation).append(type).append(href).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Job) == false) {
            return false;
        }
        Job rhs = ((Job) other);
        return new EqualsBuilder().append(id, rhs.id).append(additionalProperties, rhs.additionalProperties).append(representation, rhs.representation).append(type, rhs.type).append(href, rhs.href).isEquals();
    }

}
