package Model;

import java.sql.SQLException;


import DAO.InstructorDaoImplementation;
import DAO.StudentDaoImplementation;

public class LoginModel {
    StudentDaoImplementation stdDao = new StudentDaoImplementation();
    InstructorDaoImplementation instDao = new InstructorDaoImplementation();

    public int loginMember(String email, String pass, String userMode) throws SQLException{
        if(userMode.equals("Student"))
            return stdDao.uniqueStudentExists(email, pass);
        
        return instDao.uniqueInstructorExists(email, pass);  

    }
}
