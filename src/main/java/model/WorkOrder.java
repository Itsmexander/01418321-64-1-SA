package model;

public class WorkOrder {
    private String WOID;
    private String WODesc;
    private String WOStDate;
    private String WOFinDate;
    private String WOStatus;
    private String PlanID;
    private String WkID;

    public WorkOrder(String WOID, String WODesc, String WOStDate, String WOFinDate, String WOStatus, String planID, String wkID) {
        this.WOID = WOID;
        this.WODesc = WODesc;
        this.WOStDate = WOStDate;
        this.WOFinDate = WOFinDate;
        this.WOStatus = WOStatus;
        PlanID = planID;
        WkID = wkID;
    }

    public String getWOID() {
        return WOID;
    }

    public void setWOID(String WOID) {
        this.WOID = WOID;
    }

    public String getWODesc() {
        return WODesc;
    }

    public void setWODesc(String WODesc) {
        this.WODesc = WODesc;
    }

    public String getWOStDate() {
        return WOStDate;
    }

    public void setWOStDate(String WOStDate) {
        this.WOStDate = WOStDate;
    }

    public String getWOFinDate() {
        return WOFinDate;
    }

    public void setWOFinDate(String WOFinDate) {
        this.WOFinDate = WOFinDate;
    }

    public String getWOStatus() {
        return WOStatus;
    }

    public void setWOStatus(String WOStatus) {
        this.WOStatus = WOStatus;
    }

    public String getPlanID() {
        return PlanID;
    }

    public void setPlanID(String planID) {
        PlanID = planID;
    }

    public String getWkID() {
        return WkID;
    }

    public void setWkID(String wkID) {
        WkID = wkID;
    }
}
