
package githubcrawler.dto.branchprotection;

import java.util.HashMap;
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
        "include_admins",
        "dismissal_restrictions"
})
public class RequiredPullRequestReviews {

    @JsonProperty("url")
    private String url;
    @JsonProperty("include_admins")
    private Boolean includeAdmins;
    @JsonProperty("dismissal_restrictions")
    private DismissalRestrictions dismissalRestrictions;
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

    @JsonProperty("include_admins")
    public Boolean getIncludeAdmins() {
        return includeAdmins;
    }

    @JsonProperty("include_admins")
    public void setIncludeAdmins(Boolean includeAdmins) {
        this.includeAdmins = includeAdmins;
    }

    @JsonProperty("dismissal_restrictions")
    public DismissalRestrictions getDismissalRestrictions() {
        return dismissalRestrictions;
    }

    @JsonProperty("dismissal_restrictions")
    public void setDismissalRestrictions(DismissalRestrictions dismissalRestrictions) {
        this.dismissalRestrictions = dismissalRestrictions;
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
