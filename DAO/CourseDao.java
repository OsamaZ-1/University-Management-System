package DAO;
import java.sql.*;
import java.util.List;

import Model.Course;
public interface CourseDao {

	public boolean add(Course course)
	   throws SQLException;
	public boolean update(Course course)
	   throws SQLException;
	public boolean delete(String code)
	   throws SQLException;
	public Course getCourse(String code)
	   throws SQLException;
	public List<Course> getCourses()
	   throws SQLException;
	public List<Course> getMajorCourses(String major)
		throws SQLException;
}
