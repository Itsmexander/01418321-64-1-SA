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
import javax.swing.JOptionPane;

public class WorkerController<Worker> implements Initializable {



    @FXML
    private TableView<worker> worker_tab;

    @FXML
    private TableColumn<worker, String> c_worker_ID;

    @FXML
    private TableColumn<worker, String> c_worker_Name;

    @FXML
    private TableColumn<worker, String> c_worker_Surname;

    @FXML
    private TableColumn<worker, String> c_workType_ID;

    @FXML
    private TableColumn<worker, String> c_worker_Status;

    @FXML
    private TableColumn<worker, String> c_worker_telNum;

    @FXML
    private TableColumn<worker, String> c_site_ID;

    @FXML
    private TableColumn<worker, String> c_workOrder_ID;

    @FXML
    private Label worker_id_label,worker_name_label,worker_surname_label,worker_telNo_label,worker_status_label,worker_typeID_label,site_id_label,wo_id_label;

    @FXML
    private TextField wo_id_textField,wk_name_textField,wk_surname_textField,wk_telNo_textField,site_id_textField,worker_id_textField;

    @FXML
    private ChoiceBox wo_status_choiceBox,work_typeid_choiceBox;

    @FXML
    public void handleHomeBut(ActionEvent actionEvent){
        try {
            FXRouter.goTo("SHMS");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า home ไม่ได้");
        }
    }

    ObservableList<worker> listM;



    int index = -1;

    Connection conn =null;
    ResultSet rs=null;
    PreparedStatement pst = null;


    public void Add_worker (){
        conn = MysqlConnect.ConnectDb();
        String sql = "insert into worker (WkID,WkName,WkSurname,WkTelNo,WkStatus,WTID,SiteID,WOID)values(?,?,?,?,?,?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, worker_id_textField.getText());
            pst.setString(2, wk_name_textField.getText());
            pst.setString(3, wk_surname_textField.getText());
            pst.setString(4, wk_telNo_textField.getText());
            pst.setString(5, String.valueOf(wo_status_choiceBox .getValue()));
            pst.setString(6, String.valueOf(work_typeid_choiceBox.getValue()));
            pst.setString(7, site_id_textField.getText());
            pst.setString(8, wo_id_textField.getText());

            pst.execute();

            JOptionPane.showMessageDialog(null, "Users Add success");
//            UpdateTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }


    //////// methode select users ///////
    @FXML
    void getSelected (MouseEvent event){
        index = worker_tab.getSelectionModel().getSelectedIndex();
        if (index <= -1){

            return;
        }
        worker_id_label.setText(c_worker_ID.getCellData(index));
        worker_name_label.setText(c_worker_Name.getCellData(index));
        worker_surname_label.setText(c_worker_Surname.getCellData(index));
        worker_telNo_label.setText(c_worker_telNum.getCellData(index));
        worker_status_label.setText(c_worker_Status.getCellData(index));
        worker_typeID_label.setText(c_workType_ID.getCellData(index));
        site_id_label.setText(c_site_ID.getCellData(index));
        wo_id_label.setText(c_workOrder_ID.getCellData(index));

    }

    public void Edit (){
        try {
            conn = MysqlConnect.ConnectDb();
            String value1 = worker_id_textField.getText();
            String value2 = wk_name_textField.getText();
            String value3 = wk_surname_textField.getText();
            String value4 = wk_telNo_textField.getText();
            String value5 = (String) work_typeid_choiceBox.getValue();
            String value6 = (String) wo_status_choiceBox.getValue();
            String value7 = site_id_textField.getText();
            String value8 = wo_id_textField.getText();
            String sql = "update worker set WkID= '"+value1+"', WkName = '"+value2+"', WkSurname= '"+
                    value3+"', WkTelNo= '"+value4+"', WkStatus= '"+value5+"', WTID= '"+value6+"'" +
                    ", SiteID= '"+value7+"', WOID= '"+value8+"' where WkID='"+value1+"' ";
            pst= conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Update");
//            UpdateTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void handleDelBut(){
        conn = MysqlConnect.ConnectDb();
        String sql = "delete from worker where WkID = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, worker_id_textField.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Delete");
//            UpdateTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }


    public void handleEditBut(){
        c_worker_ID.setCellValueFactory(new PropertyValueFactory<>("WkID"));
        c_worker_Name.setCellValueFactory(new PropertyValueFactory<>("name"));
        c_worker_Surname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        c_worker_telNum.setCellValueFactory(new PropertyValueFactory<>("Tel no."));
        c_workType_ID.setCellValueFactory(new PropertyValueFactory<>("SiteID"));
        c_worker_Status.setCellValueFactory(new PropertyValueFactory<>("Status"));
        c_site_ID.setCellValueFactory(new PropertyValueFactory<>("SiteID"));
        c_workOrder_ID.setCellValueFactory(new PropertyValueFactory<>("WOID"));


        listM = MysqlConnect.getWorkerData();
        worker_tab.setItems(listM);
    }



    @Override
    public void initialize(URL url, ResourceBundle rb) {
        c_worker_ID.setCellValueFactory(new PropertyValueFactory<worker, String>("WkID"));
        c_worker_Name.setCellValueFactory(new PropertyValueFactory<worker, String>("WkName"));
        c_worker_Surname.setCellValueFactory(new PropertyValueFactory<worker, String>("WkSurname"));
        c_worker_telNum.setCellValueFactory(new PropertyValueFactory<worker, String>("WkTelNo"));
        c_workType_ID.setCellValueFactory(new PropertyValueFactory<worker, String>("WkStatus"));
        c_worker_Status.setCellValueFactory(new PropertyValueFactory<worker, String>("WTID"));
        c_site_ID.setCellValueFactory(new PropertyValueFactory<worker, String>("SiteID"));
        c_workOrder_ID.setCellValueFactory(new PropertyValueFactory<worker, String>("WOID"));

        listM = MysqlConnect.getWorkerData();
        worker_tab.setItems(listM);

    }



}