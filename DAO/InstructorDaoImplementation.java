package DAO;

import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Database.DatabaseConnection;
import Model.Instructor;

public class InstructorDaoImplementation implements InstructorDao{
    static Connection con = DatabaseConnection.getConnection();
    private final String TABLE_NAME = "instructors";
    @Override
    public int add(Instructor s) throws SQLException {
        String query
        = "INSERT INTO "+TABLE_NAME+"(Fname,Lname,Password,Email,Phone) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, s.getFname());
        ps.setString(2, s.getLname());
        ps.setString(3, s.getPassword());
        ps.setString(4, s.getEmail());
        ps.setInt(5, s.getPhone());
        int n = ps.executeUpdate();
        return n;
    }

    @Override
    public void delete(int id) throws SQLException {
        
    }

    @Override
    public int uniqueInstructorExists(String email, String pass) throws SQLException {
        String query = "SELECT Id, Accepted FROM " + TABLE_NAME + " WHERE Password = ? AND Email = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, pass);
        ps.setString(2, email);
        ResultSet res = ps.executeQuery();
        if (res.next()){
            if (Integer.parseInt(res.getString(2)) == 0){
                return 0; //instructor was found but is not accepted yet
            }
            return 2; //instructor was found and is accepted
        }
        else
            return -1; //instructor with this information was not found
    }

    @Override
    public int instructorEmailExist(String email) throws SQLException{
        String query = "SELECT Id FROM " + TABLE_NAME + " WHERE Email = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, email);
        ResultSet res = ps.executeQuery();
        
        if(res.next())
            return 1; //instructor with same email already exist
        return 0; //instructor with provided email doesn't exist    
    }
    

    @Override
    public List<Instructor> getInstructors() throws SQLException {
        String query = "SELECT Fname,Lname,Password,Email,Phone,Accepted FROM " + TABLE_NAME + " WHERE Accepted = 0";
        Statement stmt = con.createStatement();
        ResultSet res = stmt.executeQuery(query);
        List<Instructor> listInstructors = new ArrayList<>();
        while(res.next())
        {
            Instructor s = new Instructor(res.getString("Fname"), res.getString("Lname"), res.getString("Password"), res.getString("Email"), res.getInt("Phone"));
            listInstructors.add(s);
        }
        return listInstructors;
       
    }

    @Override
    public void update(Instructor s) throws SQLException {
        
    }
    
}
