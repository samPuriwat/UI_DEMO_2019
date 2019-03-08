import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javax.swing.*;
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
    public void Login(ActionEvent event){

        String usn = txtUser.getText();
        String psw = txtPass.getText();

        Admin admin = adminDAOImpl.getInstance().authentication(usn, psw);
        if (admin == null) {
            JOptionPane.showMessageDialog(null,
                    "Username or Password is invalid.","Warning Message",JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null,
                    "Welcome to our App "+ admin.getName());
        }


    }
}




