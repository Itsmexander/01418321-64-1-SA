package Controller;

import com.github.saacsos.FXRouter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


import java.io.IOException;

public class PlanController {
    @FXML
    private Label plan_id_label,plan_name_label,plan_description_label,site_id_label;
    @FXML
    private TextField plan_id_textField,plan_name_textField,plan_description_textField,site_id_textField;
    @FXML
    private Button addBut,editBut,homeBut;




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

    }
    @FXML
    public void handleEditBut(ActionEvent actionEvent){

    }
}
