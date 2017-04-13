
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
        "required_status_checks",
        "restrictions",
        "required_pull_request_reviews",
        "enforce_admins"
})
public class BranchProtectionInfo {

    @JsonProperty("url")
    private String url;
    @JsonProperty("required_status_checks")
    private RequiredStatusChecks requiredStatusChecks;
    @JsonProperty("restrictions")
    private Restrictions restrictions;
    @JsonProperty("required_pull_request_reviews")
    private RequiredPullRequestReviews requiredPullRequestReviews;
    @JsonProperty("enforce_admins")
    private EnforceAdmins enforceAdmins;
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

    @JsonProperty("required_status_checks")
    public RequiredStatusChecks getRequiredStatusChecks() {
        return requiredStatusChecks;
    }

    @JsonProperty("required_status_checks")
    public void setRequiredStatusChecks(RequiredStatusChecks requiredStatusChecks) {
        this.requiredStatusChecks = requiredStatusChecks;
    }

    @JsonProperty("restrictions")
    public Restrictions getRestrictions() {
        return restrictions;
    }

    @JsonProperty("restrictions")
    public void setRestrictions(Restrictions restrictions) {
        this.restrictions = restrictions;
    }

    @JsonProperty("required_pull_request_reviews")
    public RequiredPullRequestReviews getRequiredPullRequestReviews() {
        return requiredPullRequestReviews;
    }

    @JsonProperty("required_pull_request_reviews")
    public void setRequiredPullRequestReviews(RequiredPullRequestReviews requiredPullRequestReviews) {
        this.requiredPullRequestReviews = requiredPullRequestReviews;
    }

    @JsonProperty("enforce_admins")
    public EnforceAdmins getEnforceAdmins() {
        return enforceAdmins;
    }

    @JsonProperty("enforce_admins")
    public void setEnforceAdmins(EnforceAdmins enforceAdmins) {
        this.enforceAdmins = enforceAdmins;
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
