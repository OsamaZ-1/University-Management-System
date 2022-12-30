package Model;

public class Course {

	private String code,name,major;
	private int credits,hours,year;
	
	public Course(String code,String name,int credits,int hours,String major,int year) {
		this.code=code;
		this.name=name;
		this.credits=credits;
		this.hours=hours;
		this.major=major;
		this.year=year;
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
    	return this.getHours();
    }
    public String getMajor() {
    	return this.major;
    }
    public int getYear() {
    	return this.year;
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
}
