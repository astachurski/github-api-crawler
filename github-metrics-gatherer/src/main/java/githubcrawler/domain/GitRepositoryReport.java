package githubcrawler.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by adrian on 4/12/17.
 */
public class GitRepositoryReport {

    private String name = "";
    private String actualDefaultBranch = "";
    private List<String> branchesNames = new ArrayList<>();

    private Map<String, BranchProtectionInfoReport> branchesProtectionInfo = new HashMap<String, BranchProtectionInfoReport>();

    public void addBranchProtectionInfo(String branchName, BranchProtectionInfoReport branchProtectionInfoReport) {
        branchesProtectionInfo.put(branchName, branchProtectionInfoReport);
    }

    public Map<String, BranchProtectionInfoReport> getBranchesProtectionInfo() {
        return this.branchesProtectionInfo;
    }

    /* Criterion 1 - DTC git branching model*/
    public Boolean getMasterBranchExists() {
        return branchesNames.indexOf("master") != -1;
    }

    /* Criterion 2 - DTC git branching model*/
    public Boolean getDevelopBranchExists() {
        return branchesNames.indexOf("develop") != -1;
    }

    public void addBranchName(String name) {
        branchesNames.add(name);
    }

    public String getActualDefaultBranch() {
        return actualDefaultBranch;
    }

    public void setActualDefaultBranch(String actualDefaultBranch) {
        this.actualDefaultBranch = actualDefaultBranch;
    }

    /* Criterion 4 - DTC git branching model*/
    public Boolean getIsDefaultBranchDevelop() {
        return getActualDefaultBranch().equals("develop");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
