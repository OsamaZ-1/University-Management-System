package Model;

import java.sql.SQLException;


import DAO.InstructorDaoImplementation;
import DAO.StudentDaoImplementation;

public class LoginModel {
    StudentDaoImplementation stdDao = new StudentDaoImplementation();
    InstructorDaoImplementation instDao = new InstructorDaoImplementation();

    public int loginMember(String email, String pass, int userMode) throws SQLException{
        if(userMode == 2)
            return stdDao.uniqueStudentExists(email, pass);
        else if (userMode == 3)
            return instDao.uniqueInstructorExists(email, pass);  
        if (userMode == 1){
            if (email.equals("admin@admin.com") && pass.equals("admin123456"))
                return 3;
            return -1;
        }

        //no user mode was chosen
        return -2;
    }
}
