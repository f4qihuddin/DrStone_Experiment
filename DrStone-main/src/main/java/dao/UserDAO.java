package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;
import model.User;

public class UserDAO extends BaseDAO
{
    private static PreparedStatement st;
    private static Connection con;

    public static User validate(String username, String password)
    {
        User user = null;
        try
        {
            con = getCon();
            String query = "SELECT idUser FROM users WHERE username = '%s' AND pass = '%s'";
            query = String.format(query, username, password);
            st = con.prepareStatement(query);
            ResultSet resultSet = st.executeQuery();
            if (resultSet.next())
            {
                user = new User(UUID.fromString(resultSet.getString("idUser")), username, password);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            closeCon(con);
        }
        return user;
    }

    public static void registerUser(User user) {
        String query = String.format(
                "INSERT INTO users (idUser, username, pass) VALUES ('%s', '%s', '%s')",  user.getUserID(), user.getUsername(), user.getPassword()
        );

        try (Connection con = getCon();
            PreparedStatement st = con.prepareStatement(query)) {
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

