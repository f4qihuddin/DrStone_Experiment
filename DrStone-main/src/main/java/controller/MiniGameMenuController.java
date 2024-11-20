package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MiniGameMenuController
{
    @FXML
    private Button easyModeButton;

    @FXML
    private Button hardModeButton;

    @FXML
    private Button mediumModeButton;

    @FXML
    public void goToEasyMode() throws IOException
    {
        Stage stage = (Stage) easyModeButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("/view/mini-game-diff-1-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Easy Mode");
        stage.setScene(scene);
    }

    @FXML
    public void goToMediumMode() throws IOException
    {
        Stage stage = (Stage) mediumModeButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("/view/mini-game-diff-2-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Medium Mode");
        stage.setScene(scene);
    }

    @FXML
    public void goToHardMode() throws IOException
    {
        Stage stage = (Stage) hardModeButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("/view/mini-game-diff-3-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hard Mode");
        stage.setScene(scene);
    }

}

