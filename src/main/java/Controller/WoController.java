package Controller;

import com.github.saacsos.FXRouter;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.Site;
import model.WorkOrder;

import javax.swing.JOptionPane;

public class WoController implements Initializable {
    @FXML
    private Label wo_id_label,wo_desc_label,start_date_label,fin_date_label,wo_status_label,plan_id_label,wkid_label;
    @FXML
    private TextField wo_id_textField,wo_desc_textField,plain_id_textField,startDate_datePicker,finDate_datePicker,wo_status_choiceBox,wkid_textField;

    @FXML
    private TableColumn<WorkOrder, String> woid_c,desc_c,start_c,fin_c,status_c,plan_c,wkid_c;
    @FXML
    private TableView<WorkOrder> wo_table;
    ObservableList<WorkOrder> listM;
    int index = -1;

    Connection conn =null;
    ResultSet rs=null;
    PreparedStatement pst = null;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        woid_c.setCellValueFactory(new PropertyValueFactory<WorkOrder, String>("WOID"));
        desc_c.setCellValueFactory(new PropertyValueFactory<WorkOrder, String>("WODesc"));
        start_c.setCellValueFactory(new PropertyValueFactory<WorkOrder, String>("WOStDate"));
        fin_c.setCellValueFactory(new PropertyValueFactory<WorkOrder, String>("WOFinDate"));
        status_c.setCellValueFactory(new PropertyValueFactory<WorkOrder, String>("WOStatus"));
        plan_c.setCellValueFactory(new PropertyValueFactory<WorkOrder, String>("PlanID"));
        wkid_c.setCellValueFactory(new PropertyValueFactory<WorkOrder, String>("WkID"));


        listM = MysqlConnect.getWorkOrderData();
        wo_table.setItems(listM);

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
        String sql = "insert into workorder (WOID,WODesc,WOStDate,WOFinDate,WOStatus,PlanID,WKID)values(?,?,?,?,?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, wo_id_textField.getText());
            pst.setString(2, wo_desc_textField.getText());
            pst.setString(3, startDate_datePicker.getText());
            pst.setString(4, finDate_datePicker.getText());
            pst.setString(5, wo_status_choiceBox.getText());
            pst.setString(6, plain_id_textField.getText());
            pst.setString(7, wkid_textField.getText());

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
            String value1 = wo_id_textField.getText();
            String value2 = wo_desc_textField.getText();
            String value3 = startDate_datePicker.getText();
            String value4 = finDate_datePicker.getText();
            String value5 = wo_status_choiceBox.getText();
            String value6 = plain_id_textField.getText();
            String value7 = wkid_textField.getText();
            String sql = "update workorder set WOID= '"+value1+"', WODesc = '"+value2+"', WOStDate= '"+
                    value3+"', WOFinDate= '"+value4+"',WoStatus= '"+value5+"',PlanID= '"+value6+"',WKID= '"+value7+"' ' where WOID='"+value1+"' ";
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
        index = wo_table.getSelectionModel().getSelectedIndex();
        if (index <= -1){

            return;
        }
        wo_id_label.setText(woid_c.getCellData(index));
        wo_desc_label.setText(desc_c.getCellData(index));
        start_date_label.setText(start_c.getCellData(index));
        fin_date_label.setText(fin_c.getCellData(index));
        wo_status_label.setText(status_c.getCellData(index));
        plan_id_label.setText(plan_c.getCellData(index));
        wkid_label.setText(wkid_c.getCellData(index));

    }
    public void handleDelBut(){
        conn = MysqlConnect.ConnectDb();
        String sql = "delete from workorder where WOID = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, wo_id_textField.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Delete");
//            UpdateTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }


}
