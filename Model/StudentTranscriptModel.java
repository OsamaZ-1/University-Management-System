package Model;

import java.sql.SQLException;
import java.util.List;

import DAO.CourseDaoImplementation;
import DAO.StudentDaoImplementation;

public class StudentTranscriptModel implements Model{

	private StudentDaoImplementation stdDao;
	private CourseDaoImplementation crseDao;
	private String email,password;
	private double[] grades;
	
	private int earnedCredits;
	private int earnedSemesterCredits;
	private int[] registerCredits;
	private int[] registerSemesterCredits;
	private double[] semesterGrades;
	
	private List<Course> semesterMajorCourses;
	private List<Course> majorCourses;
	public StudentTranscriptModel(String email,String password) {
		stdDao = new StudentDaoImplementation();
	    crseDao=new CourseDaoImplementation();
	    this.email=email;
	    this.password=password;
	}
	
	public String[] getStudentInformation() throws SQLException {
		return stdDao.getStudent(this.email,this.password);
	}
	public Object[][] getNotRegistedCourses() throws SQLException{
		List<Course> notRegistedCourses=stdDao.getNonRegisteredCourses(this.email, this.password);
		Object[][] notRegistedCoursesInfo=new Object[notRegistedCourses.size()][7];
		for(int i=0;i<notRegistedCourses.size();i++) {
			notRegistedCoursesInfo[i][0]="Not Registed";
			notRegistedCoursesInfo[i][1]=notRegistedCourses.get(i).getSemester();
			notRegistedCoursesInfo[i][2]=notRegistedCourses.get(i).getCode();
			notRegistedCoursesInfo[i][3]=notRegistedCourses.get(i).getName();
			notRegistedCoursesInfo[i][4]=notRegistedCourses.get(i).getCredits();
			notRegistedCoursesInfo[i][5]="Not Registed";
			notRegistedCoursesInfo[i][6]="Not Registed";
		}
		return notRegistedCoursesInfo;
	}
	public Object[][] getStudentGrades() throws SQLException{
		Object[][] info=stdDao.getStudentCoursesInformation(this.email,this.password);
		grades=new double[info.length];
		registerCredits=new int[info.length];
		earnedCredits=0;
		for(int i=0;i<info.length;i++) {
			registerCredits[i]=Integer.parseInt(String.valueOf(info[i][4]));
			if(info[i][5]!="N/A") {
			grades[i]=Double.parseDouble(String.valueOf(info[i][5]));
			}
			else {
				grades[i]=0;
			}
			if(grades[i]>=50)
				earnedCredits+=Integer.parseInt(String.valueOf(info[i][4]));
		}
		return info;
	}
	public Object[][] getStudentSemesterGrades(int semester) throws SQLException{
		Object[][] info=stdDao.getStudentSemesterCoursesInformation(this.email, this.password, semester);
		earnedSemesterCredits=0;
		registerSemesterCredits=new int[info.length];
		semesterGrades=new double[info.length];
		for(int i=0;i<info.length;i++) {
			registerSemesterCredits[i]=Integer.parseInt(String.valueOf(info[i][3]));
			if(info[i][4]!="grade not in Acc. history") {
				semesterGrades[i]=Double.parseDouble(String.valueOf(info[i][4]));
			}
			else {
				semesterGrades[i]=0;
			}
			if(semesterGrades[i]>=50)
				earnedSemesterCredits+=Integer.parseInt(String.valueOf(info[i][3]));
			
		}
		return info;
	}
	//edit it
	public int getTotalCredits() throws SQLException {
		String[] studentInfo=this.getStudentInformation();
		majorCourses=crseDao.getMajorCourses(studentInfo[3]);
		int sum=0;
		for(int i=0;i<majorCourses.size();i++) {
			sum+=majorCourses.get(i).getCredits();
		}
		return sum;
	}
	public int getEarnedCredits() throws SQLException {
		
		return this.earnedCredits;
	}
	public Double getStudentGpa() throws SQLException {
		double gpa=0;
		for(int i=0;i<registerCredits.length;i++) {
			gpa+=registerCredits[i]*grades[i];
		}
		double result=gpa/(double)this.getTotalCredits();
		result=Math.round(result*100)/100.00;
		return result;
	}
	
	//edit it
	public int getTotalSemesterCredits(int semester) throws SQLException {
		String[] studentInfo=this.getStudentInformation();
		semesterMajorCourses=crseDao.getSemesterMajorCourses(studentInfo[3], semester);
		int sum=0;
		for(int i=0;i<semesterMajorCourses.size();i++) {
			sum+=semesterMajorCourses.get(i).getCredits();
		}
		return sum;
		
	}
	public int getEarnedSemesterCredits(int semester) throws SQLException {
		return this.earnedSemesterCredits;
	}
	public Double getStudentSemesterGpa(int semester) throws SQLException {
		double gpa=0;
		for(int i=0;i<registerSemesterCredits.length;i++) {
			gpa+=registerSemesterCredits[i]*semesterGrades[i];
		}
		double result=gpa/(double)this.getTotalSemesterCredits(semester);
		result=Math.round(result*100)/100.00;
		return result;
	}
	public List<String> getStudentSemesters() throws SQLException {
		return stdDao.getStudentSemesters(this.email, this.password);
	}
}