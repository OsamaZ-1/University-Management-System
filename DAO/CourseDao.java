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
	public List<Course> getCourses()
	   throws SQLException;
	public List<Course> getMajorCourses(String major)
		throws SQLException;
	public List<Course> getSemesterMajorCourses(String major,int semester) 
	    throws SQLException;
	public void updateCoursePrerequisites(String code)
		throws SQLException;
	public List<String> getPreRequisiteCourses(String major, int year)
		throws SQLException;
}
