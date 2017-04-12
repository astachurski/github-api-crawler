package githubcrawler.service;

import githubcrawler.GitHubURIconsts;
import githubcrawler.dto.CommitDTO;
import githubcrawler.dto.GitHubBranchDTO;
import githubcrawler.dto.GitHubOrgRepoDTO;
import githubcrawler.dto.commitdetails.CommitDetailsDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;


public class RestGitHubFetcher {

    private static final Logger log = LoggerFactory.getLogger(RestGitHubFetcher.class);

    private RestTemplate restTemplate;
    private HttpHeaders httpHeaders = new HttpHeaders();

    public RestGitHubFetcher(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        httpHeaders.add("Authorization", GitHubURIconsts.as_token);
        httpHeaders.add("Accept", "application/vnd.github.loki-preview+json");
    }


    public void fetchDTOs() throws Exception {

        log.info("pik akakakakaka!!!");
        log.debug("debuuug");
        log.warn("waaarn");


        //URI github_root_uri = new URI(GitHubURIconsts.github_url);
        URI org_repos_uri = new URI(GitHubURIconsts.org_repos_url);

        //RequestEntity<GitHubRootDTO> requestEntity = new RequestEntity<>(httpHeaders, HttpMethod.GET, github_root_uri);
        //ResponseEntity<GitHubRootDTO> resp = restTemplate.exchange(requestEntity, GitHubRootDTO.class);
        //GitHubRootDTO gitHubRoot = resp.getBody();

        List<GitHubOrgRepoDTO> reposList = getRepos(org_repos_uri);

        log.info("repos count is: " + reposList.size());

        //iterate over repos to get branches, commits and repo-specific stuff
        for (GitHubOrgRepoDTO gitHubOrgRepoDTO : reposList) {

            String branches_uri_str = gitHubOrgRepoDTO.getBranchesUrl();
            List<GitHubBranchDTO> branchList = getBranches(branches_uri_str);

            log.info(" repository name:  " + gitHubOrgRepoDTO.getName());
            log.info(" default branch: " + gitHubOrgRepoDTO.getDefaultBranch());

            if (branchList != null)
                for (GitHubBranchDTO gitHubBranchDTO : branchList) {
                    URI branch_protection_info = new URI(gitHubBranchDTO.getAdditionalProperties().get("protection_url").toString());
                    RequestEntity<String> requestProtectionInfoForBranch = new RequestEntity<>(httpHeaders, HttpMethod.GET, branch_protection_info);
                    try {
                        ResponseEntity<String> responseProtectionInfoForBranch = restTemplate.exchange(requestProtectionInfoForBranch, new ParameterizedTypeReference<String>() {
                        });
                        log.info("protection info :" + responseProtectionInfoForBranch);
                    } catch (HttpClientErrorException e) {
                        //do nothing.
                        //happens for all NOT SET protections
                        //log.warn(e.getMessage());
                    }
                }

            String commits_for_repo_uri_str = gitHubOrgRepoDTO.getCommitsUrl();
            URI commits_uri = new URI(commits_for_repo_uri_str.substring(0, branches_uri_str.indexOf("{") - 1));

            log.info("commits for repo uri: " + commits_uri.toURL().toString());

            List<CommitDetailsDTO> commitDTOList = getCommits(commits_uri);

            if (commitDTOList != null)
                for (CommitDetailsDTO commitDetailsDTO : commitDTOList) {
                    log.info("commitDTO: " + commitDetailsDTO.getSha());
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

    private List<CommitDetailsDTO> getCommits(URI commits_uri) {

        RequestEntity<CommitDTO> commitForRepoRequest = new RequestEntity<>(httpHeaders, HttpMethod.GET, commits_uri);
        try {
            ResponseEntity<List<CommitDTO>> responseEntityCommitsForRepo = restTemplate.exchange(
                    commitForRepoRequest, new ParameterizedTypeReference<List<CommitDTO>>() {
                    });
            List<CommitDTO> commitDTOList = responseEntityCommitsForRepo.getBody();

            List<CommitDetailsDTO> commitDetailsList = new ArrayList<>();

            if (commitDTOList != null)
                for (CommitDTO commitDTO : commitDTOList) {
                    //String commitDetailsUrl = commitDTO.getUrl();
                    URI commitDetailsUri = new URI(commitDTO.getUrl());
                    RequestEntity<CommitDetailsDTO> commitDetailsRequest = new RequestEntity<>(httpHeaders, HttpMethod.GET, commitDetailsUri);
                    ResponseEntity<CommitDetailsDTO> commitDetailsResponse = restTemplate.exchange(commitDetailsRequest, new ParameterizedTypeReference<CommitDetailsDTO>() {
                    });
                    commitDetailsList.add(commitDetailsResponse.getBody());
                    //log.info("commit details: " + commitDetailsResponse.);
                }

            return commitDetailsList;
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }

    }


}
