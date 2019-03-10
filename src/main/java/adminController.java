import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class adminController implements Initializable {
    private  Admin admin;
    @FXML
    private Label mylabel;

    public void initialize(URL location, ResourceBundle resources) {

    }
    public void getData(Admin ad){
        admin = ad;
        mylabel.setText(admin.getName());

    }

}
