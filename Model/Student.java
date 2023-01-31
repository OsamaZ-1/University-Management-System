package Model;
public class Student extends UniversityMember{
    private String major;
    public Student(String fname, String lname, String major,String email,String password,int phone)
    {
        super( fname, lname, email, password, phone);
        this.major = major;
    }

    public String getMajor()
    {
        return this.major;
    }

}
