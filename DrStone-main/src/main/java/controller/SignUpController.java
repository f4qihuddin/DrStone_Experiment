package controller;

import javafx.fxml.FXML;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import model.User;
import dao.UserDAO;

public class SignUpController
{
    @FXML
    private PasswordField inputPasssword;

    @FXML
    private TextField inputUsername;

    @FXML
    private Button signUpButton;

    @FXML
    private Text text;

    @FXML
    public void registerUser()
    {
        User user = new User(inputUsername.getText(), inputPasssword.getText());
        UserDAO.registerUser(user);
        text.setText(user.getUsername() + " berhasil terdaftar!");
    }
}

