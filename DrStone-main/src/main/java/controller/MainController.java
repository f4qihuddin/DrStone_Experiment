package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.application.Platform;

import java.io.IOException;

public class MainController
{
    @FXML
    private Button exitButton;

    @FXML
    private Button logInButton;

    @FXML
    private Button signUpButton;

    @FXML
    public void goToSignUp() throws IOException
    {
        Stage stage = (Stage) signUpButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("/view/sign-up-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Sign Up");
        stage.setScene(scene);
    }

    @FXML
    public void goToLogin() throws IOException
    {
        Stage stage = (Stage) logInButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("/view/log-in-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("login");
        stage.setScene(scene);
    }

    public void exit()
    {
        javafx.application.Platform.exit();
    }
}

