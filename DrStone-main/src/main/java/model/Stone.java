package model;

public class Stone {
    private String name;
    private String image;
    private String description;
    private String characteristics;
    private String googleScholar;
    private String web;
    private String youtube;


    public Stone(String name, String image, String description, String characteristics, String googleScholar, String web, String youtube){
        this.setName(name);
        this.setImage(image);
        this.setDescription(description);
        this.setCharacteristics(characteristics);
        this.setGoogleScholar(googleScholar);
        this.setWeb(web);
        this.setYoutube(youtube);

    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setImage(String image){
        this.image = image;
    }

    public String getImage(){
        return image;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setCharacteristics(String characteristics){
        this.characteristics = characteristics;
    }

    public String getCharacteristics(){
        return characteristics;
    }

    public void setGoogleScholar(String googleScholar){
        this.googleScholar = googleScholar;
    }

    public String getGoogleScholar(){
        return googleScholar;
    }

    public void setWeb(String web){
        this.web = web;
    }

    public String getWeb(){
        return web;
    }

    public void setYoutube(String youtube){
        this.youtube = youtube;
    }

    public String getYoutube(){
        return youtube;
    }

}
