package Controller;

import java.sql.SQLException;
import java.util.List;

import Model.StudentTranscriptModel;
import View.StudentFinalTranscriptView;
import View.StudentTranscriptView;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class StrudentTranscriptController {

	private StudentTranscriptView view;
	private StudentTranscriptModel model;
	private StudentFinalTranscriptView finalView;
	private Object[][] grades;
	private Object[][] notRegistedCourses;
	private Object[][] semesterGrades;
	private String[] studentInfo;

	public StrudentTranscriptController(String email,String password) throws SQLException {
    	view=new StudentTranscriptView();
    	model=new StudentTranscriptModel(email,password);
    	finalView=new StudentFinalTranscriptView();
    	finalView.getsFTFrame().setVisible(false);
    	
    	fillStudentInfo();
    	fillStudentSemesters();
    	studentSemestersListListener();
    	defaultChooseSemester();
    	finalTranscriptButtonAction();
    	logoutButtonAction();
	}
	public void fillStudentInfo() throws SQLException {
		studentInfo=model.getStudentInformation();
		view.getIdLabel().setText(studentInfo[0]);
    	view.getNameLabel().setText(studentInfo[1]+" "+studentInfo[2]);
    	view.getEmailLabel().setText(studentInfo[4]);
    	view.getPhoneLabel().setText(studentInfo[5]);
	}
	public void fillStudentSemesters() throws SQLException {
		List<String> studentSemesters = model.getStudentSemesters();
        studentSemesters.forEach(code -> view.getStudentSemestersList().addItem(code));
	}
	public void fillStudentGradesTable() throws SQLException {
       grades=model.getStudentGrades();
       finalView.getTableModelInfo().setNumRows(0);
    	for(int i=0;i<grades.length;i++)
    		finalView.getTableModelInfo().addRow(grades[i]);
    	finalView.getTableModelInfo().addRow(new Object[] {"","","","","","",""});
    	notRegistedCourses=model.getNotRegistedCourses();
    	for(int i=0;i<notRegistedCourses.length;i++) {
    		finalView.getTableModelInfo().addRow(notRegistedCourses[i]);
    	}
    	finalView.getTotalCredits().setText(Integer.toString(model.getTotalCredits()));
    	finalView.getEarnedCredits().setText(Integer.toString(model.getEarnedCredits()));
    	finalView.getGraduatedGPA().setText(String.valueOf(model.getStudentGpa())+"%");
	}
	public void fillStudentSemesterGrades(int semester) throws SQLException {
		view.getTableModel().setNumRows(0);
		semesterGrades=model.getStudentSemesterGrades(semester);
    	for(int i=0;i<semesterGrades.length;i++)
    	  view.getTableModel().addRow(semesterGrades[i]);
    	view.getTotalCreditsLabel().setText(Integer.toString(model.getTotalSemesterCredits(getSemesterNumberSelected())));
    	view.getEarnedCreditsLabel().setText(Integer.toString(model.getEarnedSemesterCredits(getSemesterNumberSelected())));
    	view.getGpaLabel().setText(String.valueOf(model.getStudentSemesterGpa(getSemesterNumberSelected()))+"%");
	}
	public void logoutButtonAction() {
		view.getLogoutButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.getMainFrame().dispose();
                new LoginController();   
			}
		});
	}
	public int getSemesterNumberSelected() {
		 char c=view.getStudentSemestersList().getSelectedItem().toString().charAt(view.getStudentSemestersList().getSelectedItem().toString().length()-1);
         int semester=Integer.parseInt(String.valueOf(c));
         return semester;
	}
	public void studentSemestersListListener() {
		view.getStudentSemestersList().addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e){
                try {
					fillStudentSemesterGrades(getSemesterNumberSelected());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
            
        });
	}
	public void defaultChooseSemester() throws SQLException {
		view.getStudentSemestersList().setSelectedIndex(view.getStudentSemestersList().getItemCount()-1);
		fillStudentSemesterGrades(getSemesterNumberSelected());
	}
	public void finalTranscriptButtonAction() {
		view.getFinalTranscriptButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					fillStudentGradesTable();
					double totalGPA=model.getStudentGpa();
					int remainingCredits=model.getTotalCredits()-model.getEarnedCredits();
					String graduate="";
					
					finalView.getRemainingCredits().setText(Integer.toString(remainingCredits));
					if(remainingCredits>0) {
						finalView.getAppreciation().setForeground(Color.red);
						graduate=view.getNameLabel().getText()+" Did Not Graduate";
					}
					else {
						finalView.getAppreciation().setForeground(Color.green);
						if(totalGPA>=90) {
							graduate=view.getNameLabel().getText()+" Graduate With Excelent GPA";
						}
						else if(totalGPA>=80) {
							graduate=view.getNameLabel().getText()+" Graduate With Very Good GPA";
						}
						else if(totalGPA>=70) {
							graduate=view.getNameLabel().getText()+" Graduate With Good GPA";
						}
						else 
							graduate=view.getNameLabel().getText()+" Graduate";
						}
					finalView.getAppreciation().setText(graduate);
					finalView.getsFTFrame().setVisible(true);
	
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
	}
}
