package Model;

import java.sql.SQLException;

import DAO.StudentDaoImplementation;
import View.Login;

public class RegisterModel {
    StudentDaoImplementation stdDao = new StudentDaoImplementation();

    public int registerStudent(Student s) throws SQLException{
        if(stdDao.studentEmailExist(s.getEmail()) == 1) //Student email already exist "student has account"
            return 0;
        return stdDao.add(s);
    }
}
