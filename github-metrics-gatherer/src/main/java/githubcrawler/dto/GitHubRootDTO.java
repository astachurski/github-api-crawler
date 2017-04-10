package githubcrawler.dto;


import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "current_user_url",
        "current_user_authorizations_html_url",
        "authorizations_url",
        "code_search_url",
        "commit_search_url",
        "emails_url",
        "emojis_url",
        "events_url",
        "feeds_url",
        "followers_url",
        "following_url",
        "gists_url",
        "hub_url",
        "issue_search_url",
        "issues_url",
        "keys_url",
        "notifications_url",
        "organization_repositories_url",
        "organization_url",
        "public_gists_url",
        "rate_limit_url",
        "repository_url",
        "repository_search_url",
        "current_user_repositories_url",
        "starred_url",
        "starred_gists_url",
        "team_url",
        "user_url",
        "user_organizations_url",
        "user_repositories_url",
        "user_search_url"
})
public class GitHubRootDTO {

    @JsonProperty("current_user_url")
    private String currentUserUrl;
    @JsonProperty("current_user_authorizations_html_url")
    private String currentUserAuthorizationsHtmlUrl;
    @JsonProperty("authorizations_url")
    private String authorizationsUrl;
    @JsonProperty("code_search_url")
    private String codeSearchUrl;
    @JsonProperty("commit_search_url")
    private String commitSearchUrl;
    @JsonProperty("emails_url")
    private String emailsUrl;
    @JsonProperty("emojis_url")
    private String emojisUrl;
    @JsonProperty("events_url")
    private String eventsUrl;
    @JsonProperty("feeds_url")
    private String feedsUrl;
    @JsonProperty("followers_url")
    private String followersUrl;
    @JsonProperty("following_url")
    private String followingUrl;
    @JsonProperty("gists_url")
    private String gistsUrl;
    @JsonProperty("hub_url")
    private String hubUrl;
    @JsonProperty("issue_search_url")
    private String issueSearchUrl;
    @JsonProperty("issues_url")
    private String issuesUrl;
    @JsonProperty("keys_url")
    private String keysUrl;
    @JsonProperty("notifications_url")
    private String notificationsUrl;
    @JsonProperty("organization_repositories_url")
    private String organizationRepositoriesUrl;
    @JsonProperty("organization_url")
    private String organizationUrl;
    @JsonProperty("public_gists_url")
    private String publicGistsUrl;
    @JsonProperty("rate_limit_url")
    private String rateLimitUrl;
    @JsonProperty("repository_url")
    private String repositoryUrl;
    @JsonProperty("repository_search_url")
    private String repositorySearchUrl;
    @JsonProperty("current_user_repositories_url")
    private String currentUserRepositoriesUrl;
    @JsonProperty("starred_url")
    private String starredUrl;
    @JsonProperty("starred_gists_url")
    private String starredGistsUrl;
    @JsonProperty("team_url")
    private String teamUrl;
    @JsonProperty("user_url")
    private String userUrl;
    @JsonProperty("user_organizations_url")
    private String userOrganizationsUrl;
    @JsonProperty("user_repositories_url")
    private String userRepositoriesUrl;
    @JsonProperty("user_search_url")
    private String userSearchUrl;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("current_user_url")
    public String getCurrentUserUrl() {
        return currentUserUrl;
    }

    @JsonProperty("current_user_url")
    public void setCurrentUserUrl(String currentUserUrl) {
        this.currentUserUrl = currentUserUrl;
    }

    @JsonProperty("current_user_authorizations_html_url")
    public String getCurrentUserAuthorizationsHtmlUrl() {
        return currentUserAuthorizationsHtmlUrl;
    }

    @JsonProperty("current_user_authorizations_html_url")
    public void setCurrentUserAuthorizationsHtmlUrl(String currentUserAuthorizationsHtmlUrl) {
        this.currentUserAuthorizationsHtmlUrl = currentUserAuthorizationsHtmlUrl;
    }

    @JsonProperty("authorizations_url")
    public String getAuthorizationsUrl() {
        return authorizationsUrl;
    }

    @JsonProperty("authorizations_url")
    public void setAuthorizationsUrl(String authorizationsUrl) {
        this.authorizationsUrl = authorizationsUrl;
    }

    @JsonProperty("code_search_url")
    public String getCodeSearchUrl() {
        return codeSearchUrl;
    }

    @JsonProperty("code_search_url")
    public void setCodeSearchUrl(String codeSearchUrl) {
        this.codeSearchUrl = codeSearchUrl;
    }

    @JsonProperty("commit_search_url")
    public String getCommitSearchUrl() {
        return commitSearchUrl;
    }

    @JsonProperty("commit_search_url")
    public void setCommitSearchUrl(String commitSearchUrl) {
        this.commitSearchUrl = commitSearchUrl;
    }

    @JsonProperty("emails_url")
    public String getEmailsUrl() {
        return emailsUrl;
    }

    @JsonProperty("emails_url")
    public void setEmailsUrl(String emailsUrl) {
        this.emailsUrl = emailsUrl;
    }

    @JsonProperty("emojis_url")
    public String getEmojisUrl() {
        return emojisUrl;
    }

    @JsonProperty("emojis_url")
    public void setEmojisUrl(String emojisUrl) {
        this.emojisUrl = emojisUrl;
    }

    @JsonProperty("events_url")
    public String getEventsUrl() {
        return eventsUrl;
    }

    @JsonProperty("events_url")
    public void setEventsUrl(String eventsUrl) {
        this.eventsUrl = eventsUrl;
    }

    @JsonProperty("feeds_url")
    public String getFeedsUrl() {
        return feedsUrl;
    }

    @JsonProperty("feeds_url")
    public void setFeedsUrl(String feedsUrl) {
        this.feedsUrl = feedsUrl;
    }

    @JsonProperty("followers_url")
    public String getFollowersUrl() {
        return followersUrl;
    }

    @JsonProperty("followers_url")
    public void setFollowersUrl(String followersUrl) {
        this.followersUrl = followersUrl;
    }

    @JsonProperty("following_url")
    public String getFollowingUrl() {
        return followingUrl;
    }

    @JsonProperty("following_url")
    public void setFollowingUrl(String followingUrl) {
        this.followingUrl = followingUrl;
    }

    @JsonProperty("gists_url")
    public String getGistsUrl() {
        return gistsUrl;
    }

    @JsonProperty("gists_url")
    public void setGistsUrl(String gistsUrl) {
        this.gistsUrl = gistsUrl;
    }

    @JsonProperty("hub_url")
    public String getHubUrl() {
        return hubUrl;
    }

    @JsonProperty("hub_url")
    public void setHubUrl(String hubUrl) {
        this.hubUrl = hubUrl;
    }

    @JsonProperty("issue_search_url")
    public String getIssueSearchUrl() {
        return issueSearchUrl;
    }

    @JsonProperty("issue_search_url")
    public void setIssueSearchUrl(String issueSearchUrl) {
        this.issueSearchUrl = issueSearchUrl;
    }

    @JsonProperty("issues_url")
    public String getIssuesUrl() {
        return issuesUrl;
    }

    @JsonProperty("issues_url")
    public void setIssuesUrl(String issuesUrl) {
        this.issuesUrl = issuesUrl;
    }

    @JsonProperty("keys_url")
    public String getKeysUrl() {
        return keysUrl;
    }

    @JsonProperty("keys_url")
    public void setKeysUrl(String keysUrl) {
        this.keysUrl = keysUrl;
    }

    @JsonProperty("notifications_url")
    public String getNotificationsUrl() {
        return notificationsUrl;
    }

    @JsonProperty("notifications_url")
    public void setNotificationsUrl(String notificationsUrl) {
        this.notificationsUrl = notificationsUrl;
    }

    @JsonProperty("organization_repositories_url")
    public String getOrganizationRepositoriesUrl() {
        return organizationRepositoriesUrl;
    }

    @JsonProperty("organization_repositories_url")
    public void setOrganizationRepositoriesUrl(String organizationRepositoriesUrl) {
        this.organizationRepositoriesUrl = organizationRepositoriesUrl;
    }

    @JsonProperty("organization_url")
    public String getOrganizationUrl() {
        return organizationUrl;
    }

    @JsonProperty("organization_url")
    public void setOrganizationUrl(String organizationUrl) {
        this.organizationUrl = organizationUrl;
    }

    @JsonProperty("public_gists_url")
    public String getPublicGistsUrl() {
        return publicGistsUrl;
    }

    @JsonProperty("public_gists_url")
    public void setPublicGistsUrl(String publicGistsUrl) {
        this.publicGistsUrl = publicGistsUrl;
    }

    @JsonProperty("rate_limit_url")
    public String getRateLimitUrl() {
        return rateLimitUrl;
    }

    @JsonProperty("rate_limit_url")
    public void setRateLimitUrl(String rateLimitUrl) {
        this.rateLimitUrl = rateLimitUrl;
    }

    @JsonProperty("repository_url")
    public String getRepositoryUrl() {
        return repositoryUrl;
    }

    @JsonProperty("repository_url")
    public void setRepositoryUrl(String repositoryUrl) {
        this.repositoryUrl = repositoryUrl;
    }

    @JsonProperty("repository_search_url")
    public String getRepositorySearchUrl() {
        return repositorySearchUrl;
    }

    @JsonProperty("repository_search_url")
    public void setRepositorySearchUrl(String repositorySearchUrl) {
        this.repositorySearchUrl = repositorySearchUrl;
    }

    @JsonProperty("current_user_repositories_url")
    public String getCurrentUserRepositoriesUrl() {
        return currentUserRepositoriesUrl;
    }

    @JsonProperty("current_user_repositories_url")
    public void setCurrentUserRepositoriesUrl(String currentUserRepositoriesUrl) {
        this.currentUserRepositoriesUrl = currentUserRepositoriesUrl;
    }

    @JsonProperty("starred_url")
    public String getStarredUrl() {
        return starredUrl;
    }

    @JsonProperty("starred_url")
    public void setStarredUrl(String starredUrl) {
        this.starredUrl = starredUrl;
    }

    @JsonProperty("starred_gists_url")
    public String getStarredGistsUrl() {
        return starredGistsUrl;
    }

    @JsonProperty("starred_gists_url")
    public void setStarredGistsUrl(String starredGistsUrl) {
        this.starredGistsUrl = starredGistsUrl;
    }

    @JsonProperty("team_url")
    public String getTeamUrl() {
        return teamUrl;
    }

    @JsonProperty("team_url")
    public void setTeamUrl(String teamUrl) {
        this.teamUrl = teamUrl;
    }

    @JsonProperty("user_url")
    public String getUserUrl() {
        return userUrl;
    }

    @JsonProperty("user_url")
    public void setUserUrl(String userUrl) {
        this.userUrl = userUrl;
    }

    @JsonProperty("user_organizations_url")
    public String getUserOrganizationsUrl() {
        return userOrganizationsUrl;
    }

    @JsonProperty("user_organizations_url")
    public void setUserOrganizationsUrl(String userOrganizationsUrl) {
        this.userOrganizationsUrl = userOrganizationsUrl;
    }

    @JsonProperty("user_repositories_url")
    public String getUserRepositoriesUrl() {
        return userRepositoriesUrl;
    }

    @JsonProperty("user_repositories_url")
    public void setUserRepositoriesUrl(String userRepositoriesUrl) {
        this.userRepositoriesUrl = userRepositoriesUrl;
    }

    @JsonProperty("user_search_url")
    public String getUserSearchUrl() {
        return userSearchUrl;
    }

    @JsonProperty("user_search_url")
    public void setUserSearchUrl(String userSearchUrl) {
        this.userSearchUrl = userSearchUrl;
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
