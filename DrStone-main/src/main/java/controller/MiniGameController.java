package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import model.CardDeck;
import model.Card;
import model.ImageCard;
import model.TextCard;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

public class MiniGameController implements Initializable
{
    @FXML
    private FlowPane board;

    private ArrayList<Card> cardsOnBoard;

    private int numOfGuesses;

    private int numOfMatches;

    private Card card1, card2;

    @FXML
    private ImageView card;

    @FXML
    private Label correctGuesses;

    @FXML
    private Label guesses;

    @FXML
    void playAgain(ActionEvent event)
    {
        card1 = null;
        card2 = null;
        CardDeck dek = new CardDeck();

        dek.addCardToDeck(new Card("Diorit", "Diorit"));
        dek.addCardToDeck(new Card("Antrasit", "Antrasit"));
        dek.addCardToDeck(new Card("Apung", "Apung"));
        dek.addCardToDeck(new Card("Filonit", "Filonit"));
        dek.addCardToDeck(new Card("Gabbro", "Gabbro"));
        dek.addCardToDeck(new Card("Gamping", "Gamping"));
        dek.addCardToDeck(new Card("Gamping Biogenik", "Gamping_Biogenik"));
        dek.addCardToDeck(new Card("Gneis", "Gneis"));
        dek.addCardToDeck(new Card("Granit", "Granit"));
        dek.addCardToDeck(new Card("Halite", "Halite"));
        dek.addCardToDeck(new Card("Kapur", "Kapur"));
        dek.addCardToDeck(new Card("Konglomerat", "Konglomerat"));
        dek.addCardToDeck(new Card("Kuarsit", "Kuarsit"));
        dek.addCardToDeck(new Card("Liparit", "Liparit"));
        dek.addCardToDeck(new Card("Marmer", "Marmer"));
        dek.addCardToDeck(new Card("Milonit", "Milonit"));
        dek.addCardToDeck(new Card("Pasir", "Pasir"));
        dek.addCardToDeck(new Card("Porfiri Gabbro", "Porfiri_Gabbro"));
        dek.addCardToDeck(new Card("Porfiri Granit", "Porfiri_Granit"));
        dek.addCardToDeck(new Card("Sabak", "Sabak"));
        dek.addCardToDeck(new Card("Sekis", "Sekis"));
        dek.addCardToDeck(new Card("Serpih", "Serpih"));
        dek.addCardToDeck(new Card("Syenit", "Syenit"));

        dek.shuffle();

        cardsOnBoard = new ArrayList<>();

        for (int i = 0; i < board.getChildren().size()/2; i++)
        {
            Card cardTaken = dek.takeTopCard();
            cardsOnBoard.add(new ImageCard(cardTaken.getName(), cardTaken.getFileName()));
            cardsOnBoard.add(new TextCard(cardTaken.getName(), cardTaken.getFileName()));
        }
        Collections.shuffle(cardsOnBoard);

        initializeCardView();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        CardDeck dek = new CardDeck();

        dek.addCardToDeck(new Card("Diorit", "Diorit"));
        dek.addCardToDeck(new Card("Antrasit", "Antrasit"));
        dek.addCardToDeck(new Card("Apung", "Apung"));
        dek.addCardToDeck(new Card("Filonit", "Filonit"));
        dek.addCardToDeck(new Card("Gabbro", "Gabbro"));
        dek.addCardToDeck(new Card("Gamping", "Gamping"));
        dek.addCardToDeck(new Card("Gamping Biogenik", "Gamping_Biogenik"));
        dek.addCardToDeck(new Card("Gneis", "Gneis"));
        dek.addCardToDeck(new Card("Granit", "Granit"));
        dek.addCardToDeck(new Card("Halite", "Halite"));
        dek.addCardToDeck(new Card("Kapur", "Kapur"));
        dek.addCardToDeck(new Card("Konglomerat", "Konglomerat"));
        dek.addCardToDeck(new Card("Kuarsit", "Kuarsit"));
        dek.addCardToDeck(new Card("Liparit", "Liparit"));
        dek.addCardToDeck(new Card("Marmer", "Marmer"));
        dek.addCardToDeck(new Card("Milonit", "Milonit"));
        dek.addCardToDeck(new Card("Pasir", "Pasir"));
        dek.addCardToDeck(new Card("Porfiri Gabbro", "Porfiri_Gabbro"));
        dek.addCardToDeck(new Card("Porfiri Granit", "Porfiri_Granit"));
        dek.addCardToDeck(new Card("Sabak", "Sabak"));
        dek.addCardToDeck(new Card("Sekis", "Sekis"));
        dek.addCardToDeck(new Card("Serpih", "Serpih"));
        dek.addCardToDeck(new Card("Syenit", "Syenit"));

        dek.shuffle();

        cardsOnBoard = new ArrayList<>();

        for (int i = 0; i < board.getChildren().size()/2; i++)
        {
            Card cardTaken = dek.takeTopCard();
            cardsOnBoard.add(new ImageCard(cardTaken.getName(), cardTaken.getFileName()));
            cardsOnBoard.add(new TextCard(cardTaken.getName(), cardTaken.getFileName()));
        }
        Collections.shuffle(cardsOnBoard);

        initializeCardView();
    }

    private void initializeCardView()
    {
        for (int i = 0; i < board.getChildren().size(); i++)
        {
            ImageView card = (ImageView) board.getChildren().get(i);
            card.setImage(new Image(Card.class.getResourceAsStream("/images/Card_Back.jpg")));
            card.setUserData(i);

            card.setOnMouseClicked(event ->
            {
                flipCard((int) card.getUserData());
            });
        }
    }

    private void flipCard(int indexOfCard)
    {
        if (card1 == null && card2 == null)
        {
            flipAllCards();
        }
        ImageView imageView = (ImageView) board.getChildren().get(indexOfCard);

        if (card1 == null)
        {
            card1 = cardsOnBoard.get(indexOfCard);
            imageView.setImage(card1.getImage());
        }
        else if (card2 == null)
        {
            numOfGuesses++;
            card2 = cardsOnBoard.get(indexOfCard);
            imageView.setImage(card2.getImage());
            checkForMatch();
            updateLabels();
        }
    }

    private void updateLabels()
    {
        correctGuesses.setText(Integer.toString(numOfMatches));
        guesses.setText(Integer.toString(numOfGuesses));
    }

    private void flipAllCards()
    {
        for (int i = 0; i < cardsOnBoard.size(); i++)
        {
            ImageView imageView = (ImageView) board.getChildren().get(i);

            if (cardsOnBoard.get(i).isMatched())
            {
                imageView.setImage(cardsOnBoard.get(i).getImage());
            }
            else
            {
                imageView.setImage(cardsOnBoard.get(i).getCardBack());
            }
        }
    }

    private void checkForMatch()
    {
        if (card1.isSameCard(card2))
        {
            card1.setMatched(true);
            card2.setMatched(true);
            numOfMatches++;
        }
        card1 = null;
        card2 = null;
    }
}

