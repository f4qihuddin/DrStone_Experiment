package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import model.MiniGameData;


public class DataMinigameDAO extends BaseDAO {

    private  static PreparedStatement st;
    private static Connection con;

    public static void insertDataMinigame(MiniGameData dataMinigame)
    {
        try
        {
            con = getCon();
            String query = "INSERT INTO data_mini_game (idDataMiniGame, highestScore, idUser, totalLevelSelesai, totalPermainan) VALUES (%s, %d, '%s', %d, %d)";
            query = String.format(query, dataMinigame.getMiniGameDataID(), dataMinigame.getHighestScore(), dataMinigame.getUserID(), dataMinigame.getLevelFinished(), dataMinigame.getTotalPlayed());
            st = con.prepareStatement(query);
            st.executeUpdate();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            closeCon(con);
        }
    }
    public static void deleteDataMinigame(MiniGameData dataMinigame)
    {
        try
        {
            con = getCon();
            String query = "DELETE FROM data_mini_game WHERE idDataMinigame = '%s'";
            query = String.format(query, dataMinigame.getMiniGameDataID());
            st = con.prepareStatement(query);
            st.executeUpdate();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            closeCon(con);
        }
    }

    public static void updateDataMinigame(MiniGameData dataMinigameBaru, MiniGameData dataMinigameLama)
    {
        try
        {
            con = getCon();
            String query = "UPDATE data_mini_game SET totalPermainan = %d, totalLevelSelesai = %d, highestScore = %d WHERE idDataMinigame '%s'";
            query = String.format(query, dataMinigameBaru.getTotalPlayed(), dataMinigameBaru.getLevelFinished(), dataMinigameBaru.getHighestScore(), dataMinigameLama.getMiniGameDataID());
            st = con.prepareStatement(query);
            st.executeUpdate();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            closeCon(con);
        }
    }
}
