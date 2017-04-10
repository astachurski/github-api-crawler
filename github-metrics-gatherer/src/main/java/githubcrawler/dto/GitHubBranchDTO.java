
package githubcrawler.dto;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "commitDTO"
})
public class GitHubBranchDTO {

    @JsonProperty("name")
    private String name;
    @JsonProperty("commitDTO")
    private CommitDTO commitDTO;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("commitDTO")
    public CommitDTO getCommitDTO() {
        return commitDTO;
    }

    @JsonProperty("commitDTO")
    public void setCommitDTO(CommitDTO commitDTO) {
        this.commitDTO = commitDTO;
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
