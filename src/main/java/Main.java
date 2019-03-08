import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class Main extends Application {

    public void start(Stage primaryStage) throws Exception {
        URL url = getClass().getResource("ui/login.fxml");
        if (url == null) {
            System.out.println("No FXML File.");
        }else {
            Parent root = FXMLLoader.load(url);
            primaryStage.setTitle("UI DEMO 2019");
            primaryStage.setScene(new Scene(root, 600,400));
            primaryStage.setResizable(false);
            primaryStage.show();
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}
