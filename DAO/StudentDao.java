package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Model.Student;
import Model.UniversityMember;

interface StudentDao {
    public int add(Student s)
        throws SQLException;
    public boolean delete(String id)
        throws SQLException;
    public int uniqueStudentExists(String email, String pass)
        throws SQLException;
    public int studentEmailPhoneExist(String email, int phone)
        throws SQLException;
    public List<Student> getStudents()
        throws SQLException;
    public Object[][] getStudentSemesterCoursesInformation(String email,String password,int semester)
            throws SQLException;
    public Object[][] getStudentCoursesInformation(String email,String password)
        throws SQLException;
    public String[] getStudent(String email,String password)
        throws SQLException;
    public ArrayList<UniversityMember> getWaitingAcceptanceStudent()
        throws SQLException;
    public int acceptStudent(String email, String pass)
        throws SQLException;
    public int unacceptStudent(String email, String pass)
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
    public List<String> getStudentSemesters(String email,String password)
        throws SQLException;
}
