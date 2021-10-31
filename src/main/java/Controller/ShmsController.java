package Controller;
import com.github.saacsos.FXRouter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.File;
import java.io.IOException;

public class ShmsController {

    @FXML
    public void handleSiteBut(ActionEvent actionEvent){
        try {
            FXRouter.goTo("Site");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า Site ไม่ได้");
        }
    }

    @FXML
    public void handleWoBut(ActionEvent actionEvent){
        try {
            FXRouter.goTo("WO");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า WO ไม่ได้");
        }
    }

    @FXML
    public void handlePlanBut(ActionEvent actionEvent){
        try {
            FXRouter.goTo("Plan");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า Plan ไม่ได้");
        }
    }

    @FXML
    public void handleWorkerBut(ActionEvent actionEvent){
        try {
            FXRouter.goTo("Worker");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า Worker ไม่ได้");
        }
    }
}
