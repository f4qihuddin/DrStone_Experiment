package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Stone;

public class BookmarkDAO extends BaseDAO{
    private static PreparedStatement st;
    private static Connection con;

    public static Object[][] showBookmark(String idUser)
    {
        Object[][] bookmarks = new Object[50][2];
        try
        {
            con = getCon();
            String query = "SELECT bookmark.namaBookmark, batu.namaBatu, batu.deskripsi, batu.gambar, batu.karakteristik, batu.sumberGoogleScholar, batu.sumberWebsite, batu.sumberYoutube" +
                           "FROM bookmark" +
                           "INNER JOIN batu ON bookmark.idBatu = batu.idBatu" +
                           "INNER JOIN users ON bookmark.idUser = users.idUser" +
                           "WHERE users.idUser = '%s'";
            query = String.format(query, idUser);
            st = con.prepareStatement(query);
            ResultSet resultSet= st.executeQuery();
            int count = 0;
            while (resultSet.next())
            {
                Stone batu = new Stone(resultSet.getString("namaBatu"), resultSet.getString("gambar"), resultSet.getString("deskripsi"), resultSet.getString("karakteristik"), resultSet.getString("sumberGoogleScholar"), resultSet.getString("sumberWebsite"), resultSet.getString("sumberYoutube"));
                bookmarks[count][0] = resultSet.getString("namaBookmark");
                bookmarks[count][1] = batu;
                count++;
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
        return bookmarks;
    }

    public static boolean addBookmark(String namaBookmark, String idUser, String idBatu) {
        boolean success = false;
        try {
            con = getCon();
            String query = "INSERT INTO bookmarks (id_bookmark, namaBookmark, id_user, id_batu) VALUES ('UUID()', '%s', '%s', '%s')";
            query = String.format(query, namaBookmark, idUser, idBatu);
            st = con.prepareStatement(query);
            success = st.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeCon(con);
        }
        return success;
    }

    public static boolean deleteBookmark(String idBookmark) {
        boolean success = false;
        try {
            con = getCon();
            String query = "DELETE FROM bookmarks WHERE id_bookmark = '%s'";
            query = String.format(query, idBookmark);
            st = con.prepareStatement(query);
            success = st.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeCon(con);
        }
        return success;
    }

    public static boolean updateBookmark(String namaBookmark, String idBookmark) {
        boolean success = false;
        try {
            con = getCon();
            String query = "UPDATE bookmarks SET nama = '%s' WHERE id_bookmark = '%s'";
            query = String.format(query, namaBookmark, idBookmark);
            st = con.prepareStatement(query);
            success = st.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeCon(con);
        }
        return success;
    }
}
