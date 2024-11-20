package model;

import javafx.scene.image.Image;
import dao.StoneDAO;

public class Card
{
    private String name;
    protected Image image;
    private Image cardBack;
    private String fileName;
    private boolean matched;

    public Card(String name, String fileName)
    {
        this.setName(name);
        this.setFileName(fileName);
        this.setCardBack();
        this.matched = false;
    }

    public String getFileName()
    {
        return fileName;
    }

    public void setFileName(String namaFile)
    {
        this.fileName = namaFile;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        if (StoneDAO.getListOfNames().contains(name))
        {
            this.name = name;
        }
        else
        {
            throw new IllegalArgumentException("Nama tidak valid, nama harus ada di daftar: " + StoneDAO.getListOfNames());
        }
    }

    public Image getCardBack()
    {
        return cardBack;
    }

    public void setCardBack()
    {
        this.cardBack = new Image(Card.class.getResourceAsStream("/images/Card_Back.jpg"));
    }

    public boolean isMatched()
    {
        return matched;
    }

    public void setMatched(boolean matched)
    {
        this.matched = matched;
    }

    public boolean isSameCard(Card otherCard)
    {
        return(this.getName().equals(otherCard.getName()));
    }

    public Image getImage()
    {
        return null;
    }
}
