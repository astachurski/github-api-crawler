
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
        "users_url",
        "teams_url",
        "users",
        "teams"
})
public class DismissalRestrictions {

    @JsonProperty("url")
    private String url;
    @JsonProperty("users_url")
    private String usersUrl;
    @JsonProperty("teams_url")
    private String teamsUrl;
    @JsonProperty("users")
    private List<Object> users = null;
    @JsonProperty("teams")
    private List<Object> teams = null;
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

    @JsonProperty("users_url")
    public String getUsersUrl() {
        return usersUrl;
    }

    @JsonProperty("users_url")
    public void setUsersUrl(String usersUrl) {
        this.usersUrl = usersUrl;
    }

    @JsonProperty("teams_url")
    public String getTeamsUrl() {
        return teamsUrl;
    }

    @JsonProperty("teams_url")
    public void setTeamsUrl(String teamsUrl) {
        this.teamsUrl = teamsUrl;
    }

    @JsonProperty("users")
    public List<Object> getUsers() {
        return users;
    }

    @JsonProperty("users")
    public void setUsers(List<Object> users) {
        this.users = users;
    }

    @JsonProperty("teams")
    public List<Object> getTeams() {
        return teams;
    }

    @JsonProperty("teams")
    public void setTeams(List<Object> teams) {
        this.teams = teams;
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
