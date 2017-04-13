
package githubcrawler.dto.branchprotection;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "url",
        "strict",
        "include_admins",
        "contexts",
        "contexts_url"
})
public class RequiredStatusChecks {

    @JsonProperty("url")
    private String url;
    @JsonProperty("strict")
    private Boolean strict;
    @JsonProperty("include_admins")
    private Boolean includeAdmins;
    @JsonProperty("contexts")
    private List<Object> contexts = null;
    @JsonProperty("contexts_url")
    private String contextsUrl;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("strict")
    public Boolean getStrict() {
        return strict;
    }

    @JsonProperty("strict")
    public void setStrict(Boolean strict) {
        this.strict = strict;
    }

    @JsonProperty("include_admins")
    public Boolean getIncludeAdmins() {
        return includeAdmins;
    }

    @JsonProperty("include_admins")
    public void setIncludeAdmins(Boolean includeAdmins) {
        this.includeAdmins = includeAdmins;
    }

    @JsonProperty("contexts")
    public List<Object> getContexts() {
        return contexts;
    }

    @JsonProperty("contexts")
    public void setContexts(List<Object> contexts) {
        this.contexts = contexts;
    }

    @JsonProperty("contexts_url")
    public String getContextsUrl() {
        return contextsUrl;
    }

    @JsonProperty("contexts_url")
    public void setContextsUrl(String contextsUrl) {
        this.contextsUrl = contextsUrl;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
