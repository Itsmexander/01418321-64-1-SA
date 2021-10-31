package model;

public class Worker {
    private String site_ID;
    private String workOrder_ID;
    private String worker_ID;
    private String workType_ID;
    private String worker_Status;
    private String worker_Name;
    private String worker_Surname;
    private String worker_telNum;

    public Worker(String site_ID, String workOrder_ID, String worker_ID, String workType_ID, String worker_Status, String worker_Name, String worker_Surname, String worker_telNum) {
        this.site_ID = site_ID;
        this.workOrder_ID = workOrder_ID;
        this.worker_ID = worker_ID;
        this.workType_ID = workType_ID;
        this.worker_Status = worker_Status;
        this.worker_Name = worker_Name;
        this.worker_Surname = worker_Surname;
        this.worker_telNum = worker_telNum;
    }

    public String getSite_ID() {
        return site_ID;
    }

    public void setSite_ID(String site_ID) {
        this.site_ID = site_ID;
    }

    public String getWorkOrder_ID() {
        return workOrder_ID;
    }

    public void setWorkOrder_ID(String workOrder_ID) {
        this.workOrder_ID = workOrder_ID;
    }

    public String getWorker_ID() {
        return worker_ID;
    }

    public void setWorker_ID(String worker_ID) {
        this.worker_ID = worker_ID;
    }

    public String getWorkType_ID() {
        return workType_ID;
    }

    public void setWorkType_ID(String workType_ID) {
        this.workType_ID = workType_ID;
    }

    public String getWorker_Status() {
        return worker_Status;
    }

    public void setWorker_Status(String worker_Status) {
        this.worker_Status = worker_Status;
    }

    public String getWorker_Name() {
        return worker_Name;
    }

    public void setWorker_Name(String worker_Name) {
        this.worker_Name = worker_Name;
    }

    public String getWorker_Surname() {
        return worker_Surname;
    }

    public void setWorker_Surname(String worker_Surname) {
        this.worker_Surname = worker_Surname;
    }

    public String getWorker_telNum() {
        return worker_telNum;
    }

    public void setWorker_telNum(String worker_telNum) {
        this.worker_telNum = worker_telNum;
    }
}
