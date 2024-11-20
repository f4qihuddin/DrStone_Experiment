package model;

import java.util.UUID;

public class User
{
    private UUID userID;
    private String username;
    private String password;

    public User(String username, String password)
    {
        UUID uuid = UUID.randomUUID();
        this.setUserID(uuid);
        this.setPassword(password);
        this.setUsername(username);
    }

    public User(UUID userID, String username, String password)
    {
        this.setUserID(userID);
        this.setPassword(password);
        this.setUsername(username);
    }

    public UUID getUserID()
    {
        return userID;
    }

    public void setUserID(UUID userID)
    {
        this.userID = userID;
    }


    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }


    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }
}

