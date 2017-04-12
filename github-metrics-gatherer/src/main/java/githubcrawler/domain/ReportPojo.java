package githubcrawler.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adrian on 4/12/17.
 */
public class ReportPojo {

    private List<GitRepositoryReport> gitRepoList = new ArrayList<>();

    public void addRepoReport(GitRepositoryReport gitRepositoryReport) {
        this.gitRepoList.add(gitRepositoryReport);
    }

    public List<GitRepositoryReport> getGitRepositoryReportList() {
        return this.gitRepoList;
    }


}
