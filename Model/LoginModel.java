package Model;

import java.sql.SQLException;

import DAO.InstructorDaoImplementation;
import DAO.StudentDaoImplementation;

public class LoginModel {
    StudentDaoImplementation stdDao = new StudentDaoImplementation();
    InstructorDaoImplementation instDao = new InstructorDaoImplementation();

    public int getLoginStudent(String email, String pass) throws SQLException{
        return stdDao.uniqueStudentExists(email, pass);
    }

    public int getLoginInstructor(String email, String pass) throws SQLException{
        return instDao.uniqueInstructorExists(email, pass);
    }
}
