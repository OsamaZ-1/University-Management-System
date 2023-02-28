package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.ResultSetMetaData;

import Database.DatabaseConnection;

public class AdminDaoImplementation implements AdminDao{
    static Connection con = DatabaseConnection.getConnection();
    private final String TABLE_ADMIN = "admin";

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

    @Override
    public Object[][] getTableRows(String chosenTable) throws SQLException{
        String query = "SELECT * FROM " + chosenTable;
        String countRows = "SELECT COUNT(*) FROM " + chosenTable;
        PreparedStatement ps1 = con.prepareStatement(query);
        PreparedStatement ps2 = con.prepareStatement(countRows);

        ResultSet countRes = ps2.executeQuery();
        countRes.next();
        int n = countRes.getInt(1);

        ResultSet res = ps1.executeQuery();
        ResultSetMetaData meta = res.getMetaData();
        int colCount = meta.getColumnCount();
        Object[][] rows = new Object[n][colCount];

        int i = 0;
        while (res.next()){
            for (int j = 0; j < colCount; ++j)
                rows[i][j] = res.getObject(j + 1);
            ++i;
        }

        return rows;
    }

    @Override
    public int retrieveFromHistory(String chosenTable, String[] info) throws SQLException {
        
        String query = "INSERT INTO " + chosenTable + " VALUES(";
        
        switch (chosenTable){
            case "student": query += info[0] + ", \"" + info[1] + "\", \"" + info[2] + "\", \"" + info[3] + "\", \"" + info[4] + "\", \"" + info[5] + "\", \"" + info[6] + "\", " + info[7]; break;
            case "instructors": query += info[0] + ", \"" + info[1] + "\", \"" + info[2] + "\", \"" + info[3] + "\", \"" + info[4] + "\", \"" + info[5] + "\", " + info[6]; break;
            case "course": query += info[0] + ", \"" + info[1] + "\", \"" + info[2] + "\", \"" + info[3] + "\", " + info[4] + ", " + info[5] + ", \"" + info[6] + "\", " + info[7] + ", " + info[8]; break;
            case "instructorteaches": query += info[0] + ", " + info[1]; break;
            case "studentgrades": query += info[0] +", " + info[1] + ", " + info[2] + ", \"" + info[3] + "\", " + info[4]; break;
        }

        query += ")";
        PreparedStatement ps = con.prepareStatement(query);
        int res = ps.executeUpdate();
        return res;
    }

    @Override
    public int deleteFromHistory(String chosenTable, String[] info) throws SQLException {
        String query = "DELETE FROM " + chosenTable + " WHERE ";
        PreparedStatement ps;

        if (!chosenTable.equals("instructorcoursehistory") && !chosenTable.equals("studentgradeshistory")){
            if (chosenTable.equals("coursehistory"))
                query += "CourseId = ?";
            else
                query += "Id = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, info[0]);
        }
        else{
            if (chosenTable.equals("instructorcoursehistory"))
                query += "InstID = ? AND CourseID = ?";
            else
                query += "Id = ? AND CourseId = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, info[0]);
            ps.setString(2, info[1]);
        }

        int res = ps.executeUpdate();
        return res;
    }

    @Override
    public int deleteAllFromHistory(String chosenTable) throws SQLException{
        String query = "DELETE FROM "+chosenTable;
        PreparedStatement ps = con.prepareStatement(query);
        return ps.executeUpdate();
    }

}
