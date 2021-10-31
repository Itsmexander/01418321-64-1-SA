package model;

public class Plan {
    private String planId;
    private String planName;
    private String planDesc;
    private String siteId;

    public Plan(String planId, String planName, String planDesc, String siteId) {
        this.planId = planId;
        this.planName = planName;
        this.planDesc = planDesc;
        this.siteId = siteId;
    }

    public String getPlanId() {
        return planId;
    }

    public String getPlanName() {
        return planName;
    }

    public String getPlanDesc() {
        return planDesc;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public void setPlanDesc(String planDesc) {
        this.planDesc = planDesc;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }


}
