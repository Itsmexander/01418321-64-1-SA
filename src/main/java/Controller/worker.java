package Controller;

public class worker {

    private String WkID;
    private String WkName;
    private String WkSurname;
    private String WkTelNo;
    private String WkStatus;
    private String WTID;
    private String SiteID;
    private String WOID;

    public worker(String wkID, String wkName, String wkSurname, String wkTelNo, String wkStatus, String WTID, String siteID, String WOID) {
        WkID = wkID;
        WkName = wkName;
        WkSurname = wkSurname;
        WkTelNo = wkTelNo;
        WkStatus = wkStatus;
        this.WTID = WTID;
        SiteID = siteID;
        this.WOID = WOID;
    }

    public String getWkID() {
        return WkID;
    }

    public void setWkID(String wkID) {
        WkID = wkID;
    }

    public String getWkName() {
        return WkName;
    }

    public void setWkName(String wkName) {
        WkName = wkName;
    }

    public String getWkSurname() {
        return WkSurname;
    }

    public void setWkSurname(String wkSurname) {
        WkSurname = wkSurname;
    }

    public String getWkTelNo() {
        return WkTelNo;
    }

    public void setWkTelNo(String wkTelNo) {
        WkTelNo = wkTelNo;
    }

    public String getWkStatus() {
        return WkStatus;
    }

    public void setWkStatus(String wkStatus) {
        WkStatus = wkStatus;
    }

    public String getWTID() {
        return WTID;
    }

    public void setWTID(String WTID) {
        this.WTID = WTID;
    }

    public String getSiteID() {
        return SiteID;
    }

    public void setSiteID(String siteID) {
        SiteID = siteID;
    }

    public String getWOID() {
        return WOID;
    }

    public void setWOID(String WOID) {
        this.WOID = WOID;
    }

    @Override
    public String toString(){
        return "Worker{" +
                "WkID='" + WkID + '\'' +
                ", name=" + WkName +
                ", surname=" + WkSurname +
                ", Tel no.='" + WkTelNo + '\'' +
                ", typeID='" + WkID + '\'' +
                ", Status='" + WkStatus + '\'' +
                ", SiteID='" + SiteID + '\'' +
                ", WOID='" + WOID + '\'' +
                '}';
    }
}
