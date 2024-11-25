package controller;

import dao.StoneDAO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import model.Stone;

import java.awt.*;
import java.io.IOException;
import java.net.URI;

public class StoneController {
    @FXML
    private Text characteristics;

    @FXML
    private Text description;

    @FXML
    private ImageView stoneImage;

    @FXML
    private Text stoneName;

    @FXML
    private Text subCategory;

    @FXML
    private Hyperlink youtubeLink;

    @FXML
    private Hyperlink googleLink;

    @FXML
    private Hyperlink webLink;

    @FXML
    private Button bookmark;

    @FXML
    private AnchorPane dialogBox;

    @FXML
    private TextField bookmarkName;

    @FXML
    private Button saveButton;

    @FXML
    private Button cancelButton;

    @FXML
    private Button backButton;

    private RootController rootController;

    String googleScholarURI;

    String youtubeURI;

    String webURI;

    public void showStone(String name)
    {
        Stone stone = new Stone(StoneDAO.searchStone(name).getName(), StoneDAO.searchStone(name).getImage(), StoneDAO.searchStone(name).getDescription(), StoneDAO.searchStone(name).getCharacteristics(), StoneDAO.searchStone(name).getGoogleScholar(), StoneDAO.searchStone(name).getWeb(), StoneDAO.searchStone(name).getYoutube());

        stoneName.setText(stone.getName());
        characteristics.setText(stone.getCharacteristics());
        description.setText(stone.getDescription());

        String stoneName = stone.getName().replace(" ", "_");
        var inputStream = CategoryController.class.getResourceAsStream("/images/" + stoneName + ".jpg");
        if (inputStream == null)
        {
            throw new IllegalArgumentException("Image file not found: " + stoneName);
        }
        stoneImage.setImage(new Image(inputStream));

        webLink.setText("Referensi Website");
        youtubeLink.setText("Referensi Youtube");
        googleLink.setText("Referensi Google");

        webURI = stone.getWeb();
        youtubeURI = stone.getYoutube();
        googleScholarURI = stone.getGoogleScholar();
    }

    public void setRootController(RootController rootController)
    {
        this.rootController = rootController;
    }

    public void goToGoogleScholar(ActionEvent event)
    {
        try
        {
            Desktop.getDesktop().browse(new URI(googleScholarURI));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void goToWebsite(ActionEvent event)
    {
        try
        {
            Desktop.getDesktop().browse(new URI(webURI));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void goToYoutube(ActionEvent event)
    {
        try
        {
            Desktop.getDesktop().browse(new URI(youtubeURI));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void saveBookmark() throws IOException
    {
        rootController.addBookmark(stoneImage, bookmarkName.getText());
    }

    public void bookmarkPage()
    {
        bookmarkName.setText(stoneName.getText());

        if (!dialogBox.isVisible())
        {
            dialogBox.setVisible(true);
        }
        else
        {
            dialogBox.setVisible(false);
        }
    }

    public void closeDialogBox()
    {
        dialogBox.setVisible(false);
    }

    public void backToLearningMenu()
    {
        try
        {
            rootController.showLearningView();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}
