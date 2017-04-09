package githubcrawler.service;

import githubcrawler.GitHubURIconsts;
import githubcrawler.dao.GitHubOrgRepo;
import githubcrawler.dao.GitHubRoot;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

/**
 * Created by adrian on 4/9/17.
 */

public class RestFetcher {

    private RestTemplate restTemplate;

    public RestFetcher(RestTemplate restTemplate)
    {
        this.restTemplate = restTemplate;
    }

/*    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        restTemplate = builder.build();
        return restTemplate;
    }*/

    public void fetch() throws Exception {


        URI github_root_uri = new URI(GitHubURIconsts.github_url);
        URI org_repos_uri = new URI(GitHubURIconsts.org_repos_url);


        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", GitHubURIconsts.as_token);

        RequestEntity<GitHubRoot> requestEntity = new RequestEntity<>(httpHeaders, HttpMethod.GET, github_root_uri);
        ResponseEntity<GitHubRoot> resp = restTemplate.exchange(requestEntity, GitHubRoot.class);

        GitHubRoot gitHubRoot = resp.getBody();


        RequestEntity<GitHubOrgRepo> requestReposForOrg = new RequestEntity<>(httpHeaders, HttpMethod.GET, org_repos_uri);
        ResponseEntity<List<GitHubOrgRepo>> responseEntityReposForOrg = restTemplate.exchange(requestReposForOrg, new ParameterizedTypeReference<List<GitHubOrgRepo>>() {
        });

        List<GitHubOrgRepo> OrgReposlist = responseEntityReposForOrg.getBody();

        System.out.println("repos count is: " + OrgReposlist.size());

    }


}
