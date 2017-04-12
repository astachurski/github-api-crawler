package githubcrawler.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import githubcrawler.domain.ReportPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.web.bind.annotation.*;

@org.springframework.web.bind.annotation.RestController
@EnableAutoConfiguration
public class RestController {

    private RestGitHubFetcher restGitHubFetcher;

    @RequestMapping(value = "/github-metrics", method = RequestMethod.GET)
    public String getGitHubMetrics(@RequestParam(value = "test", defaultValue = "dupa") String name) {
        String report = "empty";
        try {
            ReportPojo reportPojo = restGitHubFetcher.fetchDTOs();
            ObjectMapper om = new ObjectMapper();
            report = om.writeValueAsString(reportPojo);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return report;
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