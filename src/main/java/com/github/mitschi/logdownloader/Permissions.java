
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
    "read",
    "cancel",
    "restart"
})
public class Permissions implements Serializable
{

    @JsonProperty("read")
    private Boolean read;
    @JsonProperty("cancel")
    private Boolean cancel;
    @JsonProperty("restart")
    private Boolean restart;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -6448848064127981404L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Permissions() {
    }

    /**
     * 
     * @param restart
     * @param read
     * @param cancel
     */
    public Permissions(Boolean read, Boolean cancel, Boolean restart) {
        super();
        this.read = read;
        this.cancel = cancel;
        this.restart = restart;
    }

    @JsonProperty("read")
    public Boolean getRead() {
        return read;
    }

    @JsonProperty("read")
    public void setRead(Boolean read) {
        this.read = read;
    }

    @JsonProperty("cancel")
    public Boolean getCancel() {
        return cancel;
    }

    @JsonProperty("cancel")
    public void setCancel(Boolean cancel) {
        this.cancel = cancel;
    }

    @JsonProperty("restart")
    public Boolean getRestart() {
        return restart;
    }

    @JsonProperty("restart")
    public void setRestart(Boolean restart) {
        this.restart = restart;
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
        return new ToStringBuilder(this).append("read", read).append("cancel", cancel).append("restart", restart).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(restart).append(additionalProperties).append(read).append(cancel).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Permissions) == false) {
            return false;
        }
        Permissions rhs = ((Permissions) other);
        return new EqualsBuilder().append(restart, rhs.restart).append(additionalProperties, rhs.additionalProperties).append(read, rhs.read).append(cancel, rhs.cancel).isEquals();
    }

}
