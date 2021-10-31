package model;

public class Department {
    private String workType_ID;
    private String workType_Name;

    public Department(String workType_ID, String workType_Name) {
        this.workType_ID = workType_ID;
        this.workType_Name = workType_Name;
    }

    public String getWorkType_ID() {
        return workType_ID;
    }

    public void setWorkType_ID(String workType_ID) {
        this.workType_ID = workType_ID;
    }

    public String getWorkType_Name() {
        return workType_Name;
    }

    public void setWorkType_Name(String workType_Name) {
        this.workType_Name = workType_Name;
    }
}
