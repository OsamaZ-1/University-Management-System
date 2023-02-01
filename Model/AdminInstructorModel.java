package Model;

import java.sql.SQLException;
import DAO.InstructorDaoImplementation;

public class AdminInstructorModel {
    private InstructorDaoImplementation instDao = new InstructorDaoImplementation();

    public Object[][] getInstructorsWithId() throws SQLException{
        return instDao.getInstructorsWithId();
    }

    public boolean updateInstructor(String[] s) throws SQLException{
        return instDao.updateInstructor(s);
    }

    public boolean addInstructorToCourse(String instID, String courseId) throws SQLException{
        return instDao.addInstructorToCourse(instID, courseId);
    }

    public boolean deleteInstructorFromCourse(String instID, String courseId) throws SQLException{
        return instDao.deleteInstructorFromCourse(instID, courseId);
    }

    public Object[][] getAcceptedInstructorsInfo(String id) throws SQLException{
        return instDao.getAcceptedInstructorsInfo(id);
    }
}
