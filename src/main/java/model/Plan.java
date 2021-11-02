package model;

public class Plan {
    private String PlanID;
    private String PlanName;
    private String PlanDesc;
    private String SiteID;

    public Plan(String planID, String planName, String planDesc, String siteID) {
        PlanID = planID;
        PlanName = planName;
        PlanDesc = planDesc;
        SiteID = siteID;
    }

    public String getPlanID() {
        return PlanID;
    }

    public void setPlanID(String planID) {
        PlanID = planID;
    }

    public String getPlanName() {
        return PlanName;
    }

    public void setPlanName(String planName) {
        PlanName = planName;
    }

    public String getPlanDesc() {
        return PlanDesc;
    }

    public void setPlanDesc(String planDesc) {
        PlanDesc = planDesc;
    }

    public String getSiteID() {
        return SiteID;
    }

    public void setSiteID(String siteID) {
        SiteID = siteID;
    }
}
