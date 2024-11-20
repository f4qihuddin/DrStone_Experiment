package dao;

import model.Stone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StoneDAO extends BaseDAO {

    private static PreparedStatement st;
    private static Connection con;

    public static ArrayList<String> getListOfNames()
    {
        ArrayList<String> listOfNames = new ArrayList<>();

        try
        {
            con = getCon();
            String query = "SELECT namaBatu FROM batu";
            st = con.prepareStatement(query);
            ResultSet resultSet = st.executeQuery();
            while (resultSet.next())
            {
                listOfNames.add(resultSet.getString("namaBatu"));
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
        return listOfNames;
    }

    public static ArrayList<Stone> getListOfStones(String subCategoryName)
    {
        ArrayList<Stone> listOfStones = new ArrayList<>();
        Stone stone;

        try
        {
            con = getCon();
            String query = "SELECT *\n" +
                           "FROM batu\n" +
                           "INNER JOIN sub_kategori ON batu.idSubKategoriBatu = sub_kategori.idSubKategoriBatu\n" +
                           "WHERE sub_kategori.namaSubKategori = '%s'";
            query = String.format(query, subCategoryName);
            st = con.prepareStatement(query);
            ResultSet resultSet = st.executeQuery();
            while (resultSet.next())
            {
                stone = new Stone(resultSet.getString("namaBatu"), resultSet.getString("gambar"), resultSet.getString("deskripsi"), resultSet.getString("karakteristik"), resultSet.getString("sumberGoogleScholar"), resultSet.getString("sumberWebsite"), resultSet.getString("sumberYoutube"));
                listOfStones.add(stone);
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
        return listOfStones;
    }

    public static void searchStone(String name) {
        try {
            con = getCon();
            String query = String.format("SELECT * FROM batu WHERE name = '%s'", name);
            st = con.prepareStatement(query);
            ResultSet resultSet = st.executeQuery();
            if (resultSet.next()) {
                System.out.println("Nama Batu: " + resultSet.getString("namaBatu"));
                System.out.println("Deskripsi: " + resultSet.getString("deskripsi"));
                System.out.println("Karakteristik: " + resultSet.getString("karakteristik"));
                System.out.println("Gambar: " + resultSet.getString("gambar"));
                System.out.println("Sumber YouTube: " + resultSet.getString("sumberYoutube"));
                System.out.println("Sumber Website: " + resultSet.getString("sumberWebsite"));
                System.out.println("Sumber Google Scholar: " + resultSet.getString("sumberGoogleScholar"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeCon(con);
        }

    }
}
