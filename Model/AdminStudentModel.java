package Model;

import java.sql.SQLException;
import java.util.List;

import DAO.StudentDaoImplementation;

public class AdminStudentModel {

	private StudentDaoImplementation stdDao = new StudentDaoImplementation();
	
	public Object[][] getAcceptedStudentsInfo(String id) throws SQLException {
		return stdDao.getAcceptedStudentsInfo(id);
	}

	public Object[][] getStudents() throws SQLException{
		return stdDao.getStudentsWithId();
	}

	public boolean updateStudent(String[] studentinfo) throws SQLException
	{
		return stdDao.updateStudent(studentinfo);
	}

	public boolean addStudentToCourse(String studentId, String courseId) throws SQLException
	{
		return stdDao.addStudentToCourse(studentId, courseId);
	}

	public boolean deleteStudentFromCourse(String studentId, String courseId) throws SQLException
	{
		return stdDao.deleteStudentFromCourse(studentId, courseId);
	}



	
}
