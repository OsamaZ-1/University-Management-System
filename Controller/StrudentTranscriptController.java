package Controller;

import java.sql.SQLException;

import Model.StudentTranscriptModel;
import View.StudentTranscriptView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StrudentTranscriptController {

	private StudentTranscriptView view;
	private StudentTranscriptModel model;
	private Object[][] grades;
	private String[] studentInfo;
	public StrudentTranscriptController(String email,String password) throws SQLException {
		
    	view=new StudentTranscriptView();
    	model=new StudentTranscriptModel(email,password);
    	
    	fillStudentInfo();
    	fillStudentGradesTable();
    	logoutButtonAction();
	}
	public void fillStudentInfo() throws SQLException {
		studentInfo=model.getStudentInformation();
		view.getIdLabel().setText(studentInfo[0]);
    	view.getNameLabel().setText(studentInfo[1]+" "+studentInfo[2]);
    	view.getEmailLabel().setText(studentInfo[4]);
    	view.getPhoneLabel().setText(studentInfo[5]);
	}
	public void fillStudentGradesTable() throws SQLException {
       grades=model.getStudentGrades();
    	for(int i=0;i<grades.length;i++)
    	  view.getTableModel().addRow(grades[i]);
    	view.getTotalCreditsLabel().setText(Integer.toString(model.getTotalCredits()));
    	view.getEarnedCreditsLabel().setText(Integer.toString(model.getEarnedCredits()));
    	view.getGpaLabel().setText(String.valueOf(model.getStudentGpa())+"%");
	}
	public void logoutButtonAction() {
		view.getLogoutButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.dispose();
                new LoginController();   
			}
		});
	}
}
