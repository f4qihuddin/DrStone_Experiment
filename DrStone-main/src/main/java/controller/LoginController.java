package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import dao.UserDAO;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.User;

import java.io.IOException;

public class LoginController
{
    @FXML
    private PasswordField inputPassword;
    @FXML
    private TextField inputUsername;
    @FXML
    private Button loginButton;
    @FXML
    private Text text;

    @FXML
    public void validateUser() throws IOException
    {
        User user;
        user = UserDAO.validate(inputUsername.getText(), inputPassword.getText());
        if (user != null)
        {
            Stage stage = (Stage) loginButton.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(LoginController.class.getResource("/view/main-menu-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Main Menu");
            stage.setScene(scene);
        }
        else
        {
            text.setText("Data tidak valid!");
        }
    }
}
