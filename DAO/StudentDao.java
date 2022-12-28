package DAO;

import java.sql.*;
import java.util.List;

import Model.Student;

interface StudentDao {
    public int add(Student s)
        throws SQLException;
    public void delete(int id)
        throws SQLException;
    public int uniqueStudentExists(String email, String pass)
        throws SQLException;
    public int studentEmailExist(String email)
        throws SQLException;
    public List<Student> getStudents()
        throws SQLException;
    public void update(Student s)
        throws SQLException;
}
