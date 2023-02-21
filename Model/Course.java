package Model;

public class Course {

	private String code,name,major,preRequisite;
	private int credits,hours,year,semester;
	
	public Course(String code,String name,String preRequisite,int credits,int hours,String major,int year,int semester) {
		this.code=code;
		this.name=name;
        this.preRequisite = preRequisite;
		this.credits=credits;
		this.hours=hours;
		this.major=major;
		this.year=year;
		this.semester=semester;
	}
    public String getCode() {
    	return this.code;
    }
    public String getName() {
    	return this.name;
    }
    public int getCredits() {
    	return this.credits;
    }
    public int getHours() {
    	return this.hours;
    }
    public String getMajor() {
    	return this.major;
    }
    public int getYear() {
    	return this.year;
    }
    public int getSemester() {
    	return this.semester;
    }
    public void setCode(String code) {
    	this.code=code;
    }
    public void setName(String name) {
    	this.name=name;
    }
    public void setCredits(int credits) {
    	this.credits=credits;
    }
    public void setHours(int hours) {
    	this.hours=hours;
    }
    public void setMajor(String major) {
    	this.major=major;
    }
    public void setYear(int year) {
    	this.year=year;
    }
    public void setSemester(int semester) {
    	this.semester=semester;
    }
    public String getPreRequisite(){
        return this.preRequisite;
    }
}
