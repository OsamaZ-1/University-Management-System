package Model;

import java.sql.SQLException;

import DAO.StudentDaoImplementation;

public class AdminStudentModel {

	private StudentDaoImplementation stdDao = new StudentDaoImplementation();
	
	public Object[][] getAcceptedStudentsInfo() throws SQLException {
		return stdDao.getAcceptedStudentsInfo();
	}
}
