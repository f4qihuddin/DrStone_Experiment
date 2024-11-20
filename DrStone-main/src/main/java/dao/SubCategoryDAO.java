package dao;

import model.Category;
import model.Stone;
import model.SubCategory;

import java.sql.*;
import java.util.ArrayList;

public class SubCategoryDAO extends BaseDAO {

    private static PreparedStatement st;
    private static Connection con;

    public static ArrayList<SubCategory> getSubCategories(String categoryName)
    {
        SubCategory subCategory;
        ArrayList<SubCategory> subCategories = new ArrayList<>();
        ArrayList<Stone> stones;

        try
        {
            con = getCon();
            String query = "SELECT namaSubKategori\n" +
                           "FROM sub_kategori\n" +
                           "INNER JOIN kategori ON sub_kategori.idKategoriBatu = kategori.idKategoriBatu\n" +
                           "WHERE kategori.namaKategori = '%s'";
            query = String.format(query, categoryName);
            st = con.prepareStatement(query);
            ResultSet resultSet = st.executeQuery();
            while (resultSet.next())
            {
                stones = StoneDAO.getListOfStones(resultSet.getString("namaSubKategori"));
                subCategory = new SubCategory(resultSet.getString("namaSubKategori"), stones);
                subCategories.add(subCategory);
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
        return subCategories;
    }
}
