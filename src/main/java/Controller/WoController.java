package Controller;

import com.github.saacsos.FXRouter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class WoController {
    @FXML
    private Label wo_id_label,wo_desc_label,start_date_label,fin_date_label,wo_status_label,plan_id_label;
    @FXML
    private TextField wo_id_textField,wo_desc_textField,plain_id_textField;
    @FXML
    private ChoiceBox wo_status_choiceBox;
    @FXML
    private DatePicker startDate_datePicker,finDate_datePicker;

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
