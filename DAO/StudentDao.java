package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Model.Student;
import Model.UniversityMember;

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
    public Object[][] getStudentCoursesInformation(String email,String password)
        throws SQLException;
    public String[] getStudent(String email,String password)
        throws SQLException;
    public ArrayList<UniversityMember> getWaitingAcceptanceStudent()
        throws SQLException;
    public int acceptStudent(String email, String pass)
        throws SQLException;
    public Object[][] getAcceptedStudentsInfo(String id)
        throws SQLException;
    public Object[][] getStudentsWithId() 
        throws SQLException;
    public boolean updateStudent(String[] studentInfo) 
        throws SQLException;
    public boolean addStudentToCourse(String studentId, String courseId)
        throws SQLException;
    public boolean deleteStudentFromCourse(String studentId, String courseId)
        throws SQLException;
}
