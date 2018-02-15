
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
    "@href",
    "offset",
    "limit"
})
public class Next implements Serializable
{

    @JsonProperty("@href")
    private String href;
    @JsonProperty("offset")
    private Long offset;
    @JsonProperty("limit")
    private Long limit;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -1589667516356604575L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Next() {
    }

    /**
     * 
     * @param limit
     * @param offset
     * @param href
     */
    public Next(String href, Long offset, Long limit) {
        super();
        this.href = href;
        this.offset = offset;
        this.limit = limit;
    }

    @JsonProperty("@href")
    public String getHref() {
        return href;
    }

    @JsonProperty("@href")
    public void setHref(String href) {
        this.href = href;
    }

    @JsonProperty("offset")
    public Long getOffset() {
        return offset;
    }

    @JsonProperty("offset")
    public void setOffset(Long offset) {
        this.offset = offset;
    }

    @JsonProperty("limit")
    public Long getLimit() {
        return limit;
    }

    @JsonProperty("limit")
    public void setLimit(Long limit) {
        this.limit = limit;
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
        return new ToStringBuilder(this).append("href", href).append("offset", offset).append("limit", limit).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(limit).append(additionalProperties).append(offset).append(href).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Next) == false) {
            return false;
        }
        Next rhs = ((Next) other);
        return new EqualsBuilder().append(limit, rhs.limit).append(additionalProperties, rhs.additionalProperties).append(offset, rhs.offset).append(href, rhs.href).isEquals();
    }

}
