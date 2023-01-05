package Model;

public class UniversityMember {
    private String fname,lname,password,email;
    private int phone;

    public UniversityMember(String fname, String lname, String password,String email,int phone){
        this.fname = fname;
        this.lname = lname;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }

    public String getFname() {
        return fname;
    }
    public String getLname() {
        return lname;
    }
    public String getPassword() {
        return password;
    }
    public String getEmail() {
        return email;
    }
    public int getPhone() {
        return phone;
    }
    public void setFname(String fname) {
        this.fname = fname;
    }
    public void setLname(String lname) {
        this.lname = lname;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPhone(int phone) {
        this.phone = phone;
    }
}
