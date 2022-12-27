package DAO;

import java.sql.Connection;
import java.sql.*;
import java.util.List;

import Database.DatabaseConnection;
import Model.Student;

public class StudentDaoImplementation implements StudentDao {
    static Connection con = DatabaseConnection.getConnection();
    private final String TABLE_NAME = "student";
    @Override
    public int add(Student s) throws SQLException {
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
    public int uniqueStudentExists(String email, String pass) throws SQLException {
        String query = "SELECT Id, Accepted FROM " + TABLE_NAME + " WHERE Password = ? AND Email = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, pass);
        ps.setString(2, email);
        ResultSet res = ps.executeQuery();
        if (res.next()){
            if (Integer.parseInt(res.getString(2)) == 0){
                if (res.next())
                    return 0; //more than one student with the same information were found
                return 1; //a unique student was found but is not accepted yet
            }
            //check again to prioratize answer 0 over all others
            if (res.next())
                return 0;
            return 2; //unique student was found and is accepted
        }
        else
            return -1; //student with this information was not found
    }

    @Override
    public List<Student> getStudents() throws SQLException {
        return null;
    }

    @Override
    public void update(Student s) throws SQLException {
        
    }
    
}
