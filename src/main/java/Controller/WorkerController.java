package Controller;

import com.github.saacsos.FXRouter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class WorkerController {
    @FXML
    private Label worker_id_label,worker_name_label,worker_surname_label,worker_telNo_label,worker_status_label,worker_typeID_label,site_id_label,wo_id_label;

    @FXML
    private TextField wo_id_textField,wo_name_textField,wo_surname_textField,wo_telNo_textField,site_id_textField,worker_id_textField;

    @FXML
    private ChoiceBox wo_status_choiceBox,work_typeid_choiceBox;

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
