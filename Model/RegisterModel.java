package Model;

import java.sql.SQLException;

import DAO.StudentDaoImplementation;
import View.Login;

public class RegisterModel {
    StudentDaoImplementation stdDao = new StudentDaoImplementation();

    public int registerStudent(Student s) throws SQLException{
        return stdDao.add(s);
    }
}