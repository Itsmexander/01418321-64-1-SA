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

import javax.swing.JOptionPane;

public class SiteController implements Initializable {
    @FXML
    private Label site_id_label,site_name_label,site_foreman_name_label,site_status_label;
    @FXML
    private TextField site_id_textField,site_name_textField,site_foreman_name_textField;
    @FXML
    private TextField site_status_choiceBox;
    @FXML
    TableView<Site> site_table;
    @FXML
    TableColumn<Site , String> site_ID,site_Name,site_Status,site_DirName;
    ObservableList<Site> listM;
    int index = -1;

    Connection conn =null;
    ResultSet rs=null;
    PreparedStatement pst = null;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        site_ID.setCellValueFactory(new PropertyValueFactory<Site, String>("SiteID"));
        site_Name.setCellValueFactory(new PropertyValueFactory<Site, String>("SiteName"));
        site_Status.setCellValueFactory(new PropertyValueFactory<Site, String>("SiteStatus"));
        site_DirName.setCellValueFactory(new PropertyValueFactory<Site, String>("SiteDirName"));

        listM = MysqlConnect.getSiteData();
        site_table.setItems(listM);

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
        String sql = "insert into worker (SiteID,SiteName,SiteStatus,SiteDirName)values(?,?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, site_id_textField.getText());
            pst.setString(2, site_name_textField.getText());
            pst.setString(3, site_status_choiceBox.getText());
            pst.setString(4, site_foreman_name_textField.getText());

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
            String value1 = site_id_textField.getText();
            String value2 = site_name_textField.getText();
            String value3 = site_status_choiceBox.getText();
            String value4 = site_foreman_name_textField.getText();

            String sql = "update site set SiteID= '"+value1+"', SiteName = '"+value2+"', SiteStatus= '"+
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
        index = site_table.getSelectionModel().getSelectedIndex();
        if (index <= -1){

            return;
        }
        site_id_label.setText(site_ID.getCellData(index));
        site_name_label.setText(site_Name.getCellData(index));
        site_status_label.setText(site_Status.getCellData(index));
        site_foreman_name_label.setText(site_DirName.getCellData(index));

    }
    @FXML
    public void handleEditBut(){
        try {
            conn = MysqlConnect.ConnectDb();
            String value1 = site_id_textField.getText();
            String value2 = site_name_textField.getText();
            String value3 = site_status_choiceBox.getText();
            String value4 = site_foreman_name_textField.getText();
            String sql = "update site set SiteID= '"+value1+"', SiteName = '"+value2+"', SiteStatus= '"+
                    value3+"', SiteDirName= '"+value4+"', ' where SiteID='"+value1+"' ";
            pst= conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Update");
//            UpdateTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    @FXML
    public void handleDelBut(){
        conn = MysqlConnect.ConnectDb();
        String sql = "delete from site where SiteID = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1,site_id_textField.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Delete");
//            UpdateTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }


}
