package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.MiniGameSession;

public class MiniGameSessionDAO extends BaseDAO{
    private static PreparedStatement st;
    private static Connection con;

    public static void insertMiniGameSessionData(MiniGameSession miniGameSession){
        try
        {
            con = getCon();
            String query = "INSERT INTO sesi_mini_game (idSesiMiniGame, idUser, score, levelSelesai, tanggalMain) VALUES (%s, %s, %d, %d, %s)";
            query = String.format (query, miniGameSession.getMiniGameSessionID(), miniGameSession.getUserID(), miniGameSession.getScore(), miniGameSession.getLevelDone(), miniGameSession.getDate());
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

    public List<MiniGameSession> getHistory() {
        List<MiniGameSession> miniGameSessions = new ArrayList<>();
        try {
            String query = "SELECT tanggalMain, score, levelSelesai FROM sesi_mini_game";
            con = getCon();
            st = con.prepareStatement(query);
            ResultSet resultSet = st.executeQuery();
            while (resultSet.next()) {
                MiniGameSession miniGameSession = new MiniGameSession(resultSet.getString("tanggalMain"), resultSet.getInt("score"), resultSet.getInt("levelSelesai"));
                miniGameSessions.add(miniGameSession);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeCon(con);
        }
        return miniGameSessions;
    }
}
