package Model;

import java.sql.SQLException;
import java.util.List;

import DAO.CourseDaoImplementation;

public class AdminCourseModel {

	CourseDaoImplementation crseDao=new CourseDaoImplementation();
	public List<Course> getAllCourses() throws SQLException {
		return crseDao.getCourses();
	}
	public boolean editCourse(Course course) throws SQLException {
		 return crseDao.update(course);
	}
	public boolean deleteCourse(String code) throws SQLException {
		return crseDao.delete(code);
	}
	public boolean addCourse(Course course) throws SQLException {
		return crseDao.add(course);
	}
	public void updateCoursePrerequisites(String code) throws SQLException{
	    crseDao.updateCoursePrerequisites(code);
	}
}
