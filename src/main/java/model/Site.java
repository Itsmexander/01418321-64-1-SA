package model;

public class Site {
    private String site_ID;
    private String site_Name;
    private String site_Status;
    private String site_DirName;

    public Site(String site_ID, String site_Name, String site_Status, String site_DirName) {
        this.site_ID = site_ID;
        this.site_Name = site_Name;
        this.site_Status = site_Status;
        this.site_DirName = site_DirName;
    }

    public String getSite_ID() {
        return site_ID;
    }

    public void setSite_ID(String site_ID) {
        this.site_ID = site_ID;
    }

    public String getSite_Name() {
        return site_Name;
    }

    public void setSite_Name(String site_Name) {
        this.site_Name = site_Name;
    }

    public String getSite_Status() {
        return site_Status;
    }

    public void setSite_Status(String site_Status) {
        this.site_Status = site_Status;
    }

    public String getSite_DirName() {
        return site_DirName;
    }

    public void setSite_DirName(String site_DirName) {
        this.site_DirName = site_DirName;
    }

}
