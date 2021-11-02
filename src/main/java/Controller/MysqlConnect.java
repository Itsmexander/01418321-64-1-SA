package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Plan;
import model.Site;
import model.WorkOrder;

import javax.swing.JOptionPane;
public class MysqlConnect {

    Connection conn = null;
    public static Connection ConnectDb(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/sa_sophonchai_hs","root","");
            JOptionPane.showMessageDialog(null, "Connection Established");
            return conn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }

    }

    public static ObservableList<worker> getWorkerData(){
        Connection conn = ConnectDb();
        ObservableList<worker> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from worker");
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                    list.add(new worker(rs.getString("worker_ID"),
                        rs.getString("worker_Name"),
                        rs.getString("worker_Surname"),
                        rs.getString("workType_ID"),
                        rs.getString("worker_Status"),
                        rs.getString("worker_telNum"),
                        rs.getString("site_ID"),
                        rs.getString("workOrder_ID")));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public static ObservableList<WorkOrder> getWorkOrderData(){
        Connection conn = ConnectDb();
        ObservableList<WorkOrder> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from workorder");
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                list.add(new WorkOrder(rs.getString("workOrder_ID"),
                        rs.getString("workOrder_Desc"),
                        rs.getString("workOrder_StartDate"),
                        rs.getString("workOrder_FinishDate"),
                        rs.getString("workOrder_Status"),
                        rs.getString("planId"),
                        rs.getString("worker_ID")));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public static ObservableList<Site> getSiteData(){
        Connection conn = ConnectDb();
        ObservableList<Site> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from site");
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                list.add(new Site(rs.getString("site_ID"),
                        rs.getString("site_Name"),
                        rs.getString("site_Status"),
                        rs.getString("site_DirName")));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public static ObservableList<Plan> getPlanData(){
        Connection conn = ConnectDb();
        ObservableList<Plan> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from plan");
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                list.add(new Plan(rs.getString("planId"),
                        rs.getString("planName"),
                        rs.getString("planDesc"),
                        rs.getString("siteId")));
            }
        } catch (Exception e) {
        }
        return list;
    }

}
