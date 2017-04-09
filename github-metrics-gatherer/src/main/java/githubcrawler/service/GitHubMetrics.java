package githubcrawler.service;

public class GitHubMetrics {

    private final String content;

    public GitHubMetrics(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}