package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import Model.Instructor;
import Model.UniversityMember;

interface InstructorDao {
    public int add(Instructor s)
        throws SQLException;
    public void delete(int id)
        throws SQLException;
    public int uniqueInstructorExists(String email, String pass)
        throws SQLException;
    public int instructorEmailPhoneExist(String email, int phone)
        throws SQLException;
    public List<Instructor> getInstructors()
        throws SQLException;
    public ArrayList<UniversityMember> getUnacceptedInstructors()
        throws SQLException;
    public int acceptInstructor(String email, String pass)
        throws SQLException;
    public Object[][] getInstructorsWithId()
        throws SQLException;
    public boolean updateInstructor(String[] s)
        throws SQLException;
    public boolean addInstructorToCourse(String studentId, String courseCode)
        throws SQLException;
    public boolean deleteInstructorFromCourse(String studentId, String courseCode)
        throws SQLException;
    public Object[][] getAcceptedInstructorsInfo(String id) 
        throws SQLException;
    public List<String> getInstructorCourses(String instEmail, String instPass)
        throws SQLException;
    public HashMap<String,String> getInstructorInfo(String instEmai, String intPass)
        throws SQLException;
    public Object[][] getEnrolledStudents(String courseCode) 
        throws SQLException;
    public boolean updateStudentGrade(String studentId, String courseCode, String grade)
        throws SQLException;
}