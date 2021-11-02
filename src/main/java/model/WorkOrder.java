package model;

public class WorkOrder {
    private String workOrder_ID;
    private String workOrder_Desc;
    private String workOrder_StartDate;
    private String workOrder_FinishDate;
    private String workOrder_Status;
    private String planId;
    private String worker_ID;

    public WorkOrder(String workOrder_ID, String workOrder_Desc, String workOrder_StartDate, String workOrder_FinishDate, String workOrder_Status, String planId, String worker_ID) {
        this.workOrder_ID = workOrder_ID;
        this.workOrder_Desc = workOrder_Desc;
        this.workOrder_StartDate = workOrder_StartDate;
        this.workOrder_FinishDate = workOrder_FinishDate;
        this.workOrder_Status = workOrder_Status;
        this.planId = planId;
        this.worker_ID = worker_ID;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public String getWorker_ID() {
        return worker_ID;
    }

    public void setWorker_ID(String worker_ID) {
        this.worker_ID = worker_ID;
    }

    public String getWorkOrder_ID() {
        return workOrder_ID;
    }

    public void setWorkOrder_ID(String workOrder_ID) {
        this.workOrder_ID = workOrder_ID;
    }

    public String getWorkOrder_StartDate() {
        return workOrder_StartDate;
    }

    public void setWorkOrder_StartDate(String workOrder_StartDate) {
        this.workOrder_StartDate = workOrder_StartDate;
    }

    public String getWorkOrder_FinishDate() {
        return workOrder_FinishDate;
    }

    public void setWorkOrder_FinishDate(String workOrder_FinishDate) {
        this.workOrder_FinishDate = workOrder_FinishDate;
    }

    public String getWorkOrder_Status() {
        return workOrder_Status;
    }

    public void setWorkOrder_Status(String workOrder_Status) {
        this.workOrder_Status = workOrder_Status;
    }

    public String getWorkOrder_Desc() {
        return workOrder_Desc;
    }

    public void setWorkOrder_Desc(String workOrder_Desc) {
        this.workOrder_Desc = workOrder_Desc;
    }


}
