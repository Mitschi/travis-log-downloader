
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
    "limit",
    "offset",
    "count",
    "is_first",
    "is_last",
    "next",
    "prev",
    "first",
    "last"
})
public class Pagination implements Serializable
{

    @JsonProperty("limit")
    private Long limit;
    @JsonProperty("offset")
    private Long offset;
    @JsonProperty("count")
    private Long count;
    @JsonProperty("is_first")
    private Boolean isFirst;
    @JsonProperty("is_last")
    private Boolean isLast;
    @JsonProperty("next")
    private Next next;
    @JsonProperty("prev")
    private Object prev;
    @JsonProperty("first")
    private First first;
    @JsonProperty("last")
    private Last last;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 3691674005831294698L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Pagination() {
    }

    /**
     * 
     * @param isLast
     * @param limit
     * @param last
     * @param count
     * @param next
     * @param isFirst
     * @param offset
     * @param first
     * @param prev
     */
    public Pagination(Long limit, Long offset, Long count, Boolean isFirst, Boolean isLast, Next next, Object prev, First first, Last last) {
        super();
        this.limit = limit;
        this.offset = offset;
        this.count = count;
        this.isFirst = isFirst;
        this.isLast = isLast;
        this.next = next;
        this.prev = prev;
        this.first = first;
        this.last = last;
    }

    @JsonProperty("limit")
    public Long getLimit() {
        return limit;
    }

    @JsonProperty("limit")
    public void setLimit(Long limit) {
        this.limit = limit;
    }

    @JsonProperty("offset")
    public Long getOffset() {
        return offset;
    }

    @JsonProperty("offset")
    public void setOffset(Long offset) {
        this.offset = offset;
    }

    @JsonProperty("count")
    public Long getCount() {
        return count;
    }

    @JsonProperty("count")
    public void setCount(Long count) {
        this.count = count;
    }

    @JsonProperty("is_first")
    public Boolean getIsFirst() {
        return isFirst;
    }

    @JsonProperty("is_first")
    public void setIsFirst(Boolean isFirst) {
        this.isFirst = isFirst;
    }

    @JsonProperty("is_last")
    public Boolean getIsLast() {
        return isLast;
    }

    @JsonProperty("is_last")
    public void setIsLast(Boolean isLast) {
        this.isLast = isLast;
    }

    @JsonProperty("next")
    public Next getNext() {
        return next;
    }

    @JsonProperty("next")
    public void setNext(Next next) {
        this.next = next;
    }

    @JsonProperty("prev")
    public Object getPrev() {
        return prev;
    }

    @JsonProperty("prev")
    public void setPrev(Object prev) {
        this.prev = prev;
    }

    @JsonProperty("first")
    public First getFirst() {
        return first;
    }

    @JsonProperty("first")
    public void setFirst(First first) {
        this.first = first;
    }

    @JsonProperty("last")
    public Last getLast() {
        return last;
    }

    @JsonProperty("last")
    public void setLast(Last last) {
        this.last = last;
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
        return new ToStringBuilder(this).append("limit", limit).append("offset", offset).append("count", count).append("isFirst", isFirst).append("isLast", isLast).append("next", next).append("prev", prev).append("first", first).append("last", last).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(isLast).append(limit).append(last).append(count).append(additionalProperties).append(next).append(isFirst).append(offset).append(first).append(prev).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Pagination) == false) {
            return false;
        }
        Pagination rhs = ((Pagination) other);
        return new EqualsBuilder().append(isLast, rhs.isLast).append(limit, rhs.limit).append(last, rhs.last).append(count, rhs.count).append(additionalProperties, rhs.additionalProperties).append(next, rhs.next).append(isFirst, rhs.isFirst).append(offset, rhs.offset).append(first, rhs.first).append(prev, rhs.prev).isEquals();
    }

}
