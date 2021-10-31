import com.github.saacsos.FXRouter;
import javafx.application.Application;
import javafx.stage.Stage;

public class main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXRouter.bind(this, primaryStage, "SHMS", 800, 600);
        configRoute();
        FXRouter.goTo("SHMS");
    }
    private static void configRoute(){
        FXRouter.when("SHMS","SHMS.fxml");
        FXRouter.when("Plan","Plan.fxml");
        FXRouter.when("Site","Site.fxml");
        FXRouter.when("WO","WO.fxml");
        FXRouter.when("Worker","Worker.fxml");




    }

    public static void main(String[] args) {
        launch(args);
    }
}

