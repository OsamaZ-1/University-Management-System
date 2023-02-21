package Model;

public class UniversityMember {
    private String fname,lname,password,email,phone;

    public UniversityMember(String fname, String lname, String email,String password,String phone){
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
    public String getPhone() {
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
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
