package Model;

import java.sql.SQLException;
import java.util.List;

import DAO.CourseDaoImplementation;

public class AdminCourseModel {

	CourseDaoImplementation crseDao=new CourseDaoImplementation();
	public List<Course> getAllCourses() throws SQLException {
		return crseDao.getCourses();
	}
	public void editCourse(Course course) throws SQLException {
		 crseDao.update(course);
	}
	public void deleteCourse(String code) throws SQLException {
		crseDao.delete(code);
	}
	public int addCourse(Course course) throws SQLException {
		return crseDao.add(course);
	}
}
