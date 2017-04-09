package githubcrawler;

import githubcrawler.service.RestFetcher;
import githubcrawler.service.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

// http://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/package-summary.html
// https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#_learning_about_spring_boot_features

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String args[]) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public RestController restController(){
        return new RestController();
    }

    @Bean
    public RestFetcher restFetcher(RestTemplate restTemplate){
        return new RestFetcher(restTemplate);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    //@Bean
    /*public CommandLineRunner run(RestTemplate restTemplate) throws Exception {

        URI github_root_uri = new URI(GitHubURIconsts.github_url);
        URI org_repos_uri = new URI(GitHubURIconsts.org_repos_url);

        return args -> {

            restFetcher.fetch();

            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Authorization", GitHubURIconsts.as_token);

            RequestEntity<GitHubRoot> requestEntity = new RequestEntity<>(httpHeaders, HttpMethod.GET, github_root_uri);
            ResponseEntity<GitHubRoot> resp = restTemplate.exchange(requestEntity, GitHubRoot.class);

            GitHubRoot gitHubRoot = resp.getBody();


            RequestEntity<GitHubOrgRepo> requestReposForOrg = new RequestEntity<>(httpHeaders, HttpMethod.GET, org_repos_uri);
            ResponseEntity<List<GitHubOrgRepo>> responseEntityReposForOrg = restTemplate.exchange(requestReposForOrg, new ParameterizedTypeReference<List<GitHubOrgRepo>>() {
            });

            List<GitHubOrgRepo> OrgReposlist = responseEntityReposForOrg.getBody();

            System.out.println("repos count is: " + OrgReposlist.size());*//*

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
    }*/
}