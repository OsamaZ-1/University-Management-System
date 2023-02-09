package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Database.DatabaseConnection;

public class AdminDaoImplementation implements AdminDao{
    static Connection con = DatabaseConnection.getConnection();
    private final String TABLE_ADMIN = "Admin";

    public int uniqueAdminExists(String email, String pass) throws SQLException
    {
        String query = "SELECT Id FROM " + TABLE_ADMIN + " WHERE Email = ? AND Password = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, email);
        ps.setString(2, pass);
        ResultSet res = ps.executeQuery();
        if (res.next())
            return 3; //Admin was found
        else
            return -1; //Admin wasn't found
    }
}
