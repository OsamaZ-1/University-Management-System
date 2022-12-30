package DAO;
import java.sql.*;
import java.util.List;

import Model.Course;
public interface CourseDao {

	public int add(Course course)
	   throws SQLException;
	public void update(Course course)
	   throws SQLException;
	public void delete(Course course)
	   throws SQLException;
	public Course getCourse(String code)
	   throws SQLException;
	public List<Course> getMajorCourses(String major)
	   throws SQLException;
	public List<Course> getCourses()
	   throws SQLException;
}
