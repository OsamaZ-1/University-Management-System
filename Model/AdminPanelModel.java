package Model;

import java.sql.SQLException;
import java.util.ArrayList;

import DAO.CourseDaoImplementation;
import DAO.InstructorDaoImplementation;
import DAO.StudentDaoImplementation;

public class AdminPanelModel {
    private StudentDaoImplementation stdDao = new StudentDaoImplementation();
    private InstructorDaoImplementation insDao = new InstructorDaoImplementation();
    private CourseDaoImplementation crsDao = new CourseDaoImplementation();

    public ArrayList<Student> getUnacceptedStudents() throws SQLException{
        return stdDao.getWaitingAcceptanceStudent();
    }

    public int acceptStudent(String email, String pass) throws SQLException{
        return stdDao.acceptStudent(email, pass);
    }

    public int[] totalCIS() throws SQLException{
        //calculate total number of Couses, Instructors, Students (CIS)
        int[] total = new int[3];
        total[0] = crsDao.getCourses().size();
        total[1] = insDao.getInstructors().size();
        total[2] = stdDao.getStudents().size();

        return total;

    }
}
