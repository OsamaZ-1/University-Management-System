package Model;

import java.sql.SQLException;
import java.util.List;

import DAO.CourseDaoImplementation;
import DAO.InstructorDaoImplementation;

public class AdminInstructorModel implements Model{
    private InstructorDaoImplementation instDao = new InstructorDaoImplementation();
    private CourseDaoImplementation coursesDao = new CourseDaoImplementation();

    public Object[][] getInstructorsWithId() throws SQLException{
        return instDao.getInstructorsWithId();
    }

    public boolean updateInstructor(String[] s) throws SQLException{
        return instDao.updateInstructor(s);
    }

    public boolean deleteInstructor(String id) throws SQLException{
        return instDao.delete(id);
    }

    public boolean addInstructorToCourse(String instID, String courseCode) throws SQLException{
        return instDao.addInstructorToCourse(instID, courseCode);
    }

    public boolean deleteInstructorFromCourse(String instID, String courseCode) throws SQLException{
        return instDao.deleteInstructorFromCourse(instID, courseCode);
    }

    public Object[][] getAcceptedInstructorsInfo(String id) throws SQLException{
        return instDao.getAcceptedInstructorsInfo(id);
    }

    public List<Course> getCoursesList() throws SQLException
	{
		return coursesDao.getCourses();
	}
}
