package DAO;

import java.sql.*;
import java.util.ArrayList;
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
    public int instructorEmailExist(String email)
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
    public boolean addInstructorToCourse(String studentId, String courseId)
        throws SQLException;
    public boolean deleteInstructorFromCourse(String studentId, String courseId)
        throws SQLException;
    public Object[][] getAcceptedInstructorsInfo(String id) 
        throws SQLException;
}