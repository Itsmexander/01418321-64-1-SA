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
            Class.forName("com.mysql.jdbc.Driver");
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
            PreparedStatement ps = conn.prepareStatement("SELECT * from worker");
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                    list.add(new worker(rs.getString("WkID"),
                        rs.getString("WkName"),
                        rs.getString("WkSurname"),
                        rs.getString("WkTelNo"),
                        rs.getString("WkStatus"),
                        rs.getString("WTID"),
                        rs.getString("SiteID"),
                        rs.getString("WOID")));
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
                list.add(new WorkOrder(rs.getString("WOID"),
                        rs.getString("WODesc"),
                        rs.getString("WOStDate"),
                        rs.getString("WOFinDate"),
                        rs.getString("WOStatus"),
                        rs.getString("PlanID"),
                        rs.getString("WkID")));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public static ObservableList<Site> getSiteData(){
        Connection conn = ConnectDb();
        ObservableList<Site> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * from site");
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                list.add(new Site(rs.getString("SiteID"),
                        rs.getString("SiteName"),
                        rs.getString("SiteStatus"),
                        rs.getString("SiteDirName")));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public static ObservableList<Plan> getPlanData(){
        Connection conn = ConnectDb();
        ObservableList<Plan> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * from plan");
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                list.add(new Plan(rs.getString("PlanID"),
                        rs.getString("PlanName"),
                        rs.getString("PlanDesc"),
                        rs.getString("SiteId")));
            }
        } catch (Exception e) {
        }
        return list;
    }

}
