import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.swing.*;
import javax.swing.plaf.nimbus.State;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private TextField txtUser;

    @FXML
    private PasswordField txtPass;

    @FXML
    private Button btnLogin;

    private adminDAOImpl adminD;

    public void initialize(URL location, ResourceBundle resources) {
    }

    public void Login(ActionEvent event) {

        String usn = txtUser.getText();
        String psw = txtPass.getText();


        Admin admin = adminDAOImpl.getInstance().authentication(usn, psw);
        if (admin == null) {
            JOptionPane.showMessageDialog(null,
                    "Username or Password is invalid.", "Warning Message", JOptionPane.WARNING_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(null,
                    "Welcome to our App " + admin.getName());
            Stage stage = (Stage)this.btnLogin.getScene().getWindow();
            stage.close();
            adminDashboard(admin);
        }


    }

    private void adminDashboard(Admin admin) {
        try {
            Stage adminStage = new Stage();
            FXMLLoader adminLoader = new FXMLLoader();
            Pane adminRoot = adminLoader.load(
                    getClass().getResource("ui/dashboard.fxml").openStream());
            adminController adminController = adminLoader.getController();
            adminController.getData(admin);
            Scene scene = new Scene(adminRoot);
            adminStage.setScene(scene);
            adminStage.setTitle("Admin Dashboard");
            adminStage.setResizable(false);
            adminStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




