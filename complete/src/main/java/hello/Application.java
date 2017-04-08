package hello;

import githubdomain.Commit;
import githubdomain.GitHubBranch;
import githubdomain.GitHubOrgRepo;
import githubdomain.GitHubRoot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@SpringBootApplication
public class Application {
    private static final String github_url = "https://api.github.com";
    private static final String organization_name = "manlamodeinc";

    private static final String as_token = "Basic YXN0YWNodXJza2k6ZmRhMWIxOTE0M2Y4MmRiNWIyZjk5OTY3OTdlNWJlZGFmZDc3N2ZkMA==";

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String args[]) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {

        URI github_root_uri = new URI(github_url);
        URI org_repos_uri = new URI("https://api.github.com/orgs/manlamodeinc/repos");
        URI org_repo_branches_uri = new URI("https://api.github.com/orgs/manlamodeinc/repos");

        return args -> {

            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Authorization", as_token);

            RequestEntity<GitHubRoot> requestEntity = new RequestEntity<>(httpHeaders, HttpMethod.GET, github_root_uri);
            ResponseEntity<GitHubRoot> resp = restTemplate.exchange(requestEntity, GitHubRoot.class);

            GitHubRoot gitHubRoot = resp.getBody();
            System.out.println(" ---- ");
            System.out.println(gitHubRoot.getCurrentUserUrl());
            System.out.println(gitHubRoot.getRepositoryUrl());
            System.out.println(gitHubRoot.getOrganizationRepositoriesUrl());


            RequestEntity<GitHubOrgRepo> requestReposForOrg = new RequestEntity<>(httpHeaders, HttpMethod.GET, org_repos_uri);
            ResponseEntity<List<GitHubOrgRepo>> responseEntityReposForOrg = restTemplate.exchange(requestReposForOrg, new ParameterizedTypeReference<List<GitHubOrgRepo>>() {
            });
            List<GitHubOrgRepo> OrgReposlist = responseEntityReposForOrg.getBody();

            for (GitHubOrgRepo gitHubOrgRepo : OrgReposlist) {

                String branches_uri_str = gitHubOrgRepo.getBranchesUrl();

                //extract collection resource getting rid of parameter
                URI branches_uri = new URI(branches_uri_str.substring(0, branches_uri_str.indexOf("{")));

                RequestEntity<GitHubBranch> requestBranchForRepo = new RequestEntity<>(httpHeaders, HttpMethod.GET, branches_uri);
                ResponseEntity<List<GitHubBranch>> responseEntityBranchesForRepo = restTemplate.exchange(requestBranchForRepo, new ParameterizedTypeReference<List<GitHubBranch>>() {
                });
                List<GitHubBranch> branchList = responseEntityBranchesForRepo.getBody();

                System.out.println(" repository name:  " + gitHubOrgRepo.getName());
                System.out.println(" default branch: " + gitHubOrgRepo.getDefaultBranch());

                for (GitHubBranch gitHubBranch : branchList) {
                    System.out.println(gitHubBranch.getName());
                }

                String commits_for_repo_uri_str = gitHubOrgRepo.getCommitsUrl();
                URI commits_uri = new URI(commits_for_repo_uri_str.substring(0, branches_uri_str.indexOf("{") - 1));
                System.out.println("commits for repo uri: " + commits_uri.toURL().toString());


                try {

                    RequestEntity<Commit> requestCommitForRepo = new RequestEntity<>(httpHeaders, HttpMethod.GET, commits_uri);
                    ResponseEntity<List<Commit>> responseEntityCommitsForRepo = restTemplate.exchange(requestCommitForRepo, new ParameterizedTypeReference<List<Commit>>() {
                    });
                    List<Commit> commitList = responseEntityCommitsForRepo.getBody();

                    for (Commit commit : commitList) {

                        System.out.println(commit.toString());

                        //System.out.println(" commit: " + commit.getAuthor().toString() + " , " + commit.getMessage());
                    }
                } catch (Exception e) {
                    System.out.println(" ===== " + e.getMessage());
                }


            }


        };
    }
}