package Model;

import java.sql.SQLException;

import DAO.AdminDaoImplementation;
import DAO.InstructorDaoImplementation;
import DAO.StudentDaoImplementation;

public class LoginModel implements Model{
    private StudentDaoImplementation stdDao = new StudentDaoImplementation();
    private InstructorDaoImplementation instDao = new InstructorDaoImplementation();
    private AdminDaoImplementation adminDao = new AdminDaoImplementation();

    public int loginMember(String email, String pass, String userMode) throws SQLException{
        
        if (userMode.equals("Admin"))
            return adminDao.uniqueAdminExists(email, pass);
        if(userMode.equals("Student"))
            return stdDao.uniqueStudentExists(email, pass);
        if (userMode.equals("Instructor"))
            return instDao.uniqueInstructorExists(email, pass);  
              
        return -1;
    
    }
}
