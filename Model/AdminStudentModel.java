package Model;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import DAO.CourseDaoImplementation;
import DAO.StudentDaoImplementation;

public class AdminStudentModel implements Model{

	private StudentDaoImplementation stdDao = new StudentDaoImplementation();
	private CourseDaoImplementation coursesDao = new CourseDaoImplementation();

	public Object[][] getAcceptedStudentsInfo(String id) throws SQLException {
		return stdDao.getAcceptedStudentsInfo(id);
	}

	public Object[][] getStudents() throws SQLException{
		return stdDao.getStudentsWithId();
	}

	public Object[][] getStudentGrades(String id) throws SQLException{
		return stdDao.getStudentGrades(id);
	}

	public boolean updateStudent(String[] studentinfo) throws SQLException
	{
		return stdDao.updateStudent(studentinfo);
	}

	public boolean deleteStudent(String id) throws SQLException
	{
		return stdDao.delete(id);
	}

	public boolean addStudentToCourse(String studentId, String courseCode) throws SQLException
	{
		return stdDao.addStudentToCourse(studentId, courseCode);
	}

	public boolean deleteStudentFromCourse(String studentId, String courseCode) throws SQLException
	{
		return stdDao.deleteStudentFromCourse(studentId, courseCode);
	}

	public List<Course> getCoursesList(String major) throws SQLException
	{
		return coursesDao.getMajorCourses(major);
	}

	public boolean updateStudentGrade(String studentId, String courseCode, String grade) throws SQLException
    {
        return stdDao.updateStudentGrade(studentId, courseCode, grade);
    }

	public HashMap<String,String> getStudentEmailPassword(String id) throws SQLException
	{
		return stdDao.getStudentEmailPassword(id);
	}

	
}
