package Model;

import java.sql.SQLException;
import DAO.StudentDaoImplementation;

public class LoginModel {
    StudentDaoImplementation stdDao = new StudentDaoImplementation();

    public int getLoginStudent(String email, String pass) throws SQLException{
        return stdDao.uniqueStudentExists(email, pass);
    }
}
