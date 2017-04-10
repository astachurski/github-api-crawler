package githubcrawler.service;

import githubcrawler.GitHubURIconsts;
import githubcrawler.dto.CommitDTO;
import githubcrawler.dto.GitHubBranchDTO;
import githubcrawler.dto.GitHubOrgRepoDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;


public class RestGitHubFetcher {

    private static final Logger log = LoggerFactory.getLogger(RestGitHubFetcher.class);

    private RestTemplate restTemplate;
    private HttpHeaders httpHeaders = new HttpHeaders();

    public RestGitHubFetcher(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public void fetchDTOs() throws Exception {


        //URI github_root_uri = new URI(GitHubURIconsts.github_url);
        URI org_repos_uri = new URI(GitHubURIconsts.org_repos_url);

        httpHeaders.add("Authorization", GitHubURIconsts.as_token);

        //RequestEntity<GitHubRootDTO> requestEntity = new RequestEntity<>(httpHeaders, HttpMethod.GET, github_root_uri);
        //ResponseEntity<GitHubRootDTO> resp = restTemplate.exchange(requestEntity, GitHubRootDTO.class);
        //GitHubRootDTO gitHubRoot = resp.getBody();

        List<GitHubOrgRepoDTO> reposList = getRepos(org_repos_uri);

        log.info("repos count is: " + reposList.size());

        for (GitHubOrgRepoDTO gitHubOrgRepoDTO : reposList) {

            String branches_uri_str = gitHubOrgRepoDTO.getBranchesUrl();
            List<GitHubBranchDTO> branchList = getBranches(branches_uri_str);

            log.info(" repository name:  " + gitHubOrgRepoDTO.getName());
            log.info(" default branch: " + gitHubOrgRepoDTO.getDefaultBranch());

            if (branchList != null)
                for (GitHubBranchDTO gitHubBranchDTO : branchList) {
                    log.info(gitHubBranchDTO.getName());
                }

            String commits_for_repo_uri_str = gitHubOrgRepoDTO.getCommitsUrl();
            URI commits_uri = new URI(commits_for_repo_uri_str.substring(0, branches_uri_str.indexOf("{") - 1));

            log.info("commits for repo uri: " + commits_uri.toURL().toString());

            List<CommitDTO> commitDTOList = getCommits(commits_uri);

            if (commitDTOList != null)
                for (CommitDTO commitDTO : commitDTOList) {
                    log.info("commitDTO: " + commitDTO.toString());
                }
        }


    }

    private List<GitHubBranchDTO> getBranches(String branches_uri_str) throws URISyntaxException {
        //extract collection resource getting rid of unused parameter
        URI branches_uri = new URI(branches_uri_str.substring(0, branches_uri_str.indexOf("{")));

        RequestEntity<GitHubBranchDTO> requestBranchForRepo = new RequestEntity<>(httpHeaders, HttpMethod.GET, branches_uri);
        try {
            ResponseEntity<List<GitHubBranchDTO>> responseEntityBranchesForRepo = restTemplate.exchange(requestBranchForRepo, new ParameterizedTypeReference<List<GitHubBranchDTO>>() {
            });
            return responseEntityBranchesForRepo.getBody();
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    private List<GitHubOrgRepoDTO> getRepos(URI org_repos_uri) {

        RequestEntity<GitHubOrgRepoDTO> requestReposForOrg = new RequestEntity<>(httpHeaders, HttpMethod.GET, org_repos_uri);

        try {
            ResponseEntity<List<GitHubOrgRepoDTO>> responseEntityReposForOrg =
                    restTemplate.exchange(requestReposForOrg, new ParameterizedTypeReference<List<GitHubOrgRepoDTO>>() {
                    });
            return responseEntityReposForOrg.getBody();
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }

    }

    private List<CommitDTO> getCommits(URI commits_uri) {

        RequestEntity<CommitDTO> requestCommitForRepo = new RequestEntity<>(httpHeaders, HttpMethod.GET, commits_uri);
        try {
            ResponseEntity<List<CommitDTO>> responseEntityCommitsForRepo = restTemplate.exchange(
                    requestCommitForRepo, new ParameterizedTypeReference<List<CommitDTO>>() {
                    });
            List<CommitDTO> commitDTOList = responseEntityCommitsForRepo.getBody();
            return commitDTOList;
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }

    }


}
