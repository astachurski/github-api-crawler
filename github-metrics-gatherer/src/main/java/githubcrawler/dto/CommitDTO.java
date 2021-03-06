
package githubcrawler.dto;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "author",
        "committer",
        "message",
        "tree",
        "url",
        "comment_count"
})
public class CommitDTO {

    @JsonProperty("author")
    private AuthorDTO author;
    @JsonProperty("committer")
    private CommitterDTO committer;
    @JsonProperty("message")
    private String message;
    @JsonProperty("tree")
    private TreeDTO tree;
    @JsonProperty("url")
    private String url;
    @JsonProperty("comment_count")
    private Integer commentCount;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("author")
    public AuthorDTO getAuthor() {
        return author;
    }

    @JsonProperty("author")
    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }

    @JsonProperty("committer")
    public CommitterDTO getCommitter() {
        return committer;
    }

    @JsonProperty("committer")
    public void setCommitter(CommitterDTO committer) {
        this.committer = committer;
    }

    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    @JsonProperty("tree")
    public TreeDTO getTree() {
        return tree;
    }

    @JsonProperty("tree")
    public void setTree(TreeDTO tree) {
        this.tree = tree;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("comment_count")
    public Integer getCommentCount() {
        return commentCount;
    }

    @JsonProperty("comment_count")
    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
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
        return "CommitDTO{" +
                "message='" + message + '\'' +
                '}';
    }
}
