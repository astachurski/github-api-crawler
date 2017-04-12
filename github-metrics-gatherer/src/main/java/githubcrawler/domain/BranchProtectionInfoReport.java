package githubcrawler.domain;

/**
 * Created by adrian on 4/12/17.
 */
public class BranchProtectionInfoReport {

    Boolean isRequireStatusChecks = false;
    Boolean isIncludeAdministrators = false;
    Boolean isRequireBranchesToBeUpToDate = false;


    public Boolean getIncludeAdministrators() {
        return isIncludeAdministrators;
    }

    public void setIncludeAdministrators(Boolean includeAdministrators) {
        isIncludeAdministrators = includeAdministrators;
    }

    public Boolean getRequireBranchesToBeUpToDate() {
        return isRequireBranchesToBeUpToDate;
    }

    public void setRequireBranchesToBeUpToDate(Boolean requireBranchesToBeUpToDate) {
        isRequireBranchesToBeUpToDate = requireBranchesToBeUpToDate;
    }


    public Boolean getRequireStatusChecks() {
        return isRequireStatusChecks;
    }

    public void setRequireStatusChecks(Boolean requireStatusChecks) {
        isRequireStatusChecks = requireStatusChecks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BranchProtectionInfoReport that = (BranchProtectionInfoReport) o;

        if (!isRequireStatusChecks.equals(that.isRequireStatusChecks)) return false;
        if (!isIncludeAdministrators.equals(that.isIncludeAdministrators)) return false;
        return isRequireBranchesToBeUpToDate.equals(that.isRequireBranchesToBeUpToDate);
    }

    @Override
    public int hashCode() {
        int result = isRequireStatusChecks.hashCode();
        result = 31 * result + isIncludeAdministrators.hashCode();
        result = 31 * result + isRequireBranchesToBeUpToDate.hashCode();
        return result;
    }
}
