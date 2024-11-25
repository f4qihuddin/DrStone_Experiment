package controller;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.image.ImageView;

public class BookmarkController
{
    @FXML
    private GridPane bookmarkList;

    int row = 0;

    RootController rootController;

    public void addBookmark(ImageView image, String bookmarkName)
    {
        HBox hBox = new HBox(20);

        ImageView stoneImage = new ImageView(image.getImage());
        stoneImage.setFitWidth(50);
        stoneImage.setFitHeight(50);

        Button button = new Button();
        button.setText(bookmarkName);
        button.setPrefWidth(250);
        button.setPrefHeight(30);

        hBox.getChildren().add(stoneImage);
        hBox.getChildren().add(button);
        hBox.setAlignment(Pos.CENTER);

        bookmarkList.add(hBox, 0, row);
        row++;
    }

    public void setRootController(RootController rootController)
    {
        this.rootController = rootController;
    }
}
