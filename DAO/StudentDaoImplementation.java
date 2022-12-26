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
    public Student getStudent(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Student> getStudents() throws SQLException {
        return null;
    }

    @Override
    public void update(Student s) throws SQLException {
        
    }
    
}
