
package githubcrawler.dto.commitdetails;

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
        "sha",
        "filename",
        "status",
        "additions",
        "deletions",
        "changes",
        "blob_url",
        "raw_url",
        "contents_url",
        "patch"
})
public class File {

    @JsonProperty("sha")
    private String sha;
    @JsonProperty("filename")
    private String filename;
    @JsonProperty("status")
    private String status;
    @JsonProperty("additions")
    private Integer additions;
    @JsonProperty("deletions")
    private Integer deletions;
    @JsonProperty("changes")
    private Integer changes;
    @JsonProperty("blob_url")
    private String blobUrl;
    @JsonProperty("raw_url")
    private String rawUrl;
    @JsonProperty("contents_url")
    private String contentsUrl;
    @JsonProperty("patch")
    private String patch;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("sha")
    public String getSha() {
        return sha;
    }

    @JsonProperty("sha")
    public void setSha(String sha) {
        this.sha = sha;
    }

    @JsonProperty("filename")
    public String getFilename() {
        return filename;
    }

    @JsonProperty("filename")
    public void setFilename(String filename) {
        this.filename = filename;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("additions")
    public Integer getAdditions() {
        return additions;
    }

    @JsonProperty("additions")
    public void setAdditions(Integer additions) {
        this.additions = additions;
    }

    @JsonProperty("deletions")
    public Integer getDeletions() {
        return deletions;
    }

    @JsonProperty("deletions")
    public void setDeletions(Integer deletions) {
        this.deletions = deletions;
    }

    @JsonProperty("changes")
    public Integer getChanges() {
        return changes;
    }

    @JsonProperty("changes")
    public void setChanges(Integer changes) {
        this.changes = changes;
    }

    @JsonProperty("blob_url")
    public String getBlobUrl() {
        return blobUrl;
    }

    @JsonProperty("blob_url")
    public void setBlobUrl(String blobUrl) {
        this.blobUrl = blobUrl;
    }

    @JsonProperty("raw_url")
    public String getRawUrl() {
        return rawUrl;
    }

    @JsonProperty("raw_url")
    public void setRawUrl(String rawUrl) {
        this.rawUrl = rawUrl;
    }

    @JsonProperty("contents_url")
    public String getContentsUrl() {
        return contentsUrl;
    }

    @JsonProperty("contents_url")
    public void setContentsUrl(String contentsUrl) {
        this.contentsUrl = contentsUrl;
    }

    @JsonProperty("patch")
    public String getPatch() {
        return patch;
    }

    @JsonProperty("patch")
    public void setPatch(String patch) {
        this.patch = patch;
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
