package Model;

import java.sql.SQLException;

import DAO.StudentDaoImplementation;

public class StudentTranscriptModel {

	private StudentDaoImplementation stdDao = new StudentDaoImplementation();
	private String email,password;
	private int[] totalCredits;
	private boolean[] earnedCredits;
	private double[] grades;
	public StudentTranscriptModel(String email,String password) {
	this.email=email;
	this.password=password;
	}
	
	public String[] getStudentInformation() throws SQLException {
		return stdDao.getStudent(this.email,this.password);
	}
	
	public Object[][] getStudentGrades() throws SQLException{
		Object[][] info=stdDao.getStudentCoursesInformation(this.email,this.password);
		totalCredits=new int[info.length];
		earnedCredits=new boolean[info.length];
		grades=new double[info.length];
		for(int i=0;i<info.length;i++) {
			totalCredits[i]=Integer.parseInt(String.valueOf(info[i][3]));
			if(info[i][4]!="grade not in Acc. history") {
			grades[i]=Double.parseDouble(String.valueOf(info[i][4]));
			}
			else {
				grades[i]=0;
			}
			if(grades[i]>=50)
				earnedCredits[i]=true;
			else
				earnedCredits[i]=false;
		}
		return info;
	}
	
	public int getTotalCredits() {
		int sum=0;
		for(int i=0;i<totalCredits.length;i++) {
			sum+=totalCredits[i];
		}
		return sum;
	}
	public int getEarnedCredits() {
		int sum=0;
		for(int i=0;i<totalCredits.length;i++) {
			if(earnedCredits[i]) {
				sum+=totalCredits[i];
			}
		}
		return sum;
	}
	public Double getStudentGpa() {
		double gpa=0;
		for(int i=0;i<totalCredits.length;i++) {
			gpa+=totalCredits[i]*grades[i];
		}
		double result=gpa/(double)this.getTotalCredits();
		result=Math.round(result*100)/100.00;
		return result;
	}
}
