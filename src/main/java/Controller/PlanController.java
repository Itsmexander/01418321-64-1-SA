package Controller;

import com.github.saacsos.FXRouter;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ResourceBundle;


import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.input.MouseEvent;
import model.Plan;

import javax.swing.JOptionPane;




public class PlanController implements Initializable {
    @FXML
    private Label plan_id_label,plan_name_label,plan_description_label,site_id_label;
    @FXML
    private TextField plan_id_textField,plan_name_textField,plan_description_textField,site_id_textField;
    @FXML
    private Button addBut,editBut,homeBut;
    @FXML
    private TableColumn<Plan, String > plan_id_c,plan_name_c,plan_desc_c,site_id_c;
    @FXML
    private TableView<Plan> plan_table;
    ObservableList<Plan> listM;

    int index = -1;

    Connection conn =null;
    ResultSet rs=null;
    PreparedStatement pst = null;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        plan_id_c.setCellValueFactory(new PropertyValueFactory<Plan, String>("PlanID"));
        plan_name_c.setCellValueFactory(new PropertyValueFactory<Plan, String>("PlanName"));
        plan_desc_c.setCellValueFactory(new PropertyValueFactory<Plan, String>("PlanDesc"));
        site_id_c.setCellValueFactory(new PropertyValueFactory<Plan, String>("SiteID"));

        listM = MysqlConnect.getPlanData();
        plan_table.setItems(listM);

    }




    @FXML
    public void handleHomeBut(ActionEvent actionEvent){
        try {
            FXRouter.goTo("SHMS");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า Site ไม่ได้");
        }
    }
    @FXML
    public void handleAddBut(ActionEvent actionEvent){
        conn = MysqlConnect.ConnectDb();
        String sql = "insert into plan (SiteID,SiteName,SiteStatus,SiteDirName)values(?,?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, plan_id_textField.getText());
            pst.setString(2, plan_name_textField.getText());
            pst.setString(3, plan_description_textField.getText());
            pst.setString(4, site_id_textField.getText());

            pst.execute();

            JOptionPane.showMessageDialog(null, "Users Add success");
//            UpdateTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    @FXML
    public void handleEditBut(ActionEvent actionEvent){
        try {
            conn = MysqlConnect.ConnectDb();
            String value1 = plan_name_textField.getText();
            String value2 = plan_name_textField.getText();
            String value3 = plan_description_textField.getText();
            String value4 = site_id_textField.getText();

            String sql = "update plan set SiteID= '"+value1+"', SiteName = '"+value2+"', SiteStatus= '"+
                    value3+"', SiteDirName= '"+value4+"',' where WkID='"+value1+"' ";
            pst= conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Update");
//            UpdateTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    @FXML
    void getSelected (MouseEvent event){
        index = plan_table.getSelectionModel().getSelectedIndex();
        if (index <= -1){

            return;
        }
        plan_id_label.setText(plan_id_c.getCellData(index));
        plan_name_label.setText(plan_name_c.getCellData(index));
        plan_description_label.setText(plan_desc_c.getCellData(index));
        site_id_label.setText(site_id_c.getCellData(index));

    }
    public void handleDelBut(){
        conn = MysqlConnect.ConnectDb();
        String sql = "delete from plan where PlanID = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, plan_id_textField.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Delete");
//            UpdateTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }
}
