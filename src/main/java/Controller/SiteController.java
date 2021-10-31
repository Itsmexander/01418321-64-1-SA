package Controller;

import com.github.saacsos.FXRouter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class SiteController {
    @FXML
    private Label site_id_label,site_name_label,site_foreman_name_label,site_status_label;
    @FXML
    private TextField site_id_textField,site_name_textField,site_foreman_name_textField;
    @FXML
    private ChoiceBox site_status_choiceBox;

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
