package githubcrawler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

@org.springframework.web.bind.annotation.RestController
@EnableAutoConfiguration
public class RestController {

    private RestGitHubFetcher restGitHubFetcher;

    @RequestMapping(value = "/github-metrics", method = RequestMethod.GET)
    public GitHubMetrics getGitHubMetrics(@RequestParam(value = "test", defaultValue = "dupa") String name) {
        try {
            restGitHubFetcher.fetchDTOs();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new GitHubMetrics(name);
    }
    @RequestMapping("/")
    String home() {
        return "GitHub metrics gatherer";
    }


    @Autowired
    public void setRestGitHubFetcher(RestGitHubFetcher restGitHubFetcher) {
        this.restGitHubFetcher = restGitHubFetcher;
    }
}