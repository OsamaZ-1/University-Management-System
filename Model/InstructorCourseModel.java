package Model;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import DAO.InstructorDaoImplementation;

public class InstructorCourseModel implements Model{
    InstructorDaoImplementation instDao=new InstructorDaoImplementation();

    public List<String> getInstructorCourses(String instEmail, String instPass) throws SQLException
    {
        return instDao.getInstructorCourses(instEmail, instPass);
    }

    public HashMap<String,String> getInstructorInfo(String instEmail, String instPass) throws SQLException
    {
        return instDao.getInstructorInfo(instEmail, instPass);
    }

    public Object[][] getEnrolledStudents(String courseCode) throws SQLException
    {
        return instDao.getEnrolledStudents(courseCode);
    }

    public boolean updateStudentGrade(String studentId, String courseCode, String grade) throws SQLException
    {
        return instDao.updateStudentGrade(studentId, courseCode, grade);
    }

    public boolean saveStudentsGrades(String courseCode) throws SQLException
    {
        return instDao.saveStudentsGrades(courseCode);
    }
}
