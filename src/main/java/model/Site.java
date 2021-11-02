package model;

public class Site {
    private String SiteID;
    private String SiteName;
    private String SiteStatus;
    private String SiteDirName;

    public Site(String siteID, String siteName, String siteStatus, String siteDirName) {
        SiteID = siteID;
        SiteName = siteName;
        SiteStatus = siteStatus;
        SiteDirName = siteDirName;
    }

    public String getSiteID() {
        return SiteID;
    }

    public void setSiteID(String siteID) {
        SiteID = siteID;
    }

    public String getSiteName() {
        return SiteName;
    }

    public void setSiteName(String siteName) {
        SiteName = siteName;
    }

    public String getSiteStatus() {
        return SiteStatus;
    }

    public void setSiteStatus(String siteStatus) {
        SiteStatus = siteStatus;
    }

    public String getSiteDirName() {
        return SiteDirName;
    }

    public void setSiteDirName(String siteDirName) {
        SiteDirName = siteDirName;
    }
}
