package Model;

import java.sql.SQLException;

import DAO.StudentDaoImplementation;

public class AdminPanelModel {
    private StudentDaoImplementation stdDao = new StudentDaoImplementation();

    public Student[] getUnacceptedStudents() throws SQLException{
        return stdDao.getWaitingAcceptanceStudent();
    }

    public int acceptStudent(String email, String pass) throws SQLException{
        return stdDao.acceptStudent(email, pass);
    }
}
