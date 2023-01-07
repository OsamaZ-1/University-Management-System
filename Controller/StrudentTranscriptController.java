package Controller;

import java.awt.Color;
import java.awt.Component;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DecimalFormat;

import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import Model.StudentTranscriptModel;
import View.StudentTranscriptView;

public class StrudentTranscriptController {

	private StudentTranscriptView view;
	private StudentTranscriptModel model;
	private Object[][] grades;
	private String[] studentInfo;
	public StrudentTranscriptController(String email,String password) throws SQLException {
		
    	view=new StudentTranscriptView();
    	model=new StudentTranscriptModel(email,password);
    	studentInfo=model.getStudentInformation();
    	grades=model.getStudentGrades();
    	
    	view.getIdLabel().setText(studentInfo[0]);
    	view.getNameLabel().setText(studentInfo[1]+" "+studentInfo[2]);
    	view.getEmailLabel().setText(studentInfo[3]);
    	view.getPhoneLabel().setText(studentInfo[4]);
    	
    	for(int i=0;i<grades.length;i++)
    	  view.getTableModel().addRow(grades[i]);
    	view.getTotalCreditsLabel().setText(Integer.toString(model.getTotalCredits()));
    	view.getEarnedCreditsLabel().setText(Integer.toString(model.getEarnedCredits()));
    	view.getGpaLabel().setText(String.valueOf(model.getStudentGpa())+"%");
    	
	}
}