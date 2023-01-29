package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Database.DatabaseConnection;
import Model.Student;

public class StudentDaoImplementation implements StudentDao {
    static Connection con = DatabaseConnection.getConnection();
    private final String TABLE_NAME = "student";
    private final String TABLE_COURSE_NAME="course";
    @Override
    public int add(Student s) throws SQLException {
        String query
        = "INSERT INTO "+TABLE_NAME+"(Fname,Lname,Password,Email,Phone) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, s.getFname());
        ps.setString(2, s.getLname());
        ps.setString(3, s.getPassword());
        ps.setString(4, s.getEmail());
        ps.setInt(5, s.getPhone());
        int n = ps.executeUpdate();
        return n;
    }

    @Override
    public void delete(int id) throws SQLException {
        
    }

    @Override
    public int uniqueStudentExists(String email, String pass) throws SQLException {
        String query = "SELECT Id, Accepted FROM " + TABLE_NAME + " WHERE Password = ? AND Email = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, pass);
        ps.setString(2, email);
        ResultSet res = ps.executeQuery();
        if (res.next()){
            if (Integer.parseInt(res.getString(2)) == 0){
                return 0; //student was found but is not accepted yet
            }
            return 1; //student was found and is accepted
        }
        else
            return -1; //student with this information was not found
    }

    @Override
    public int studentEmailExist(String email) throws SQLException{
        String query = "SELECT Id FROM " + TABLE_NAME + " WHERE Email = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, email);
        ResultSet res = ps.executeQuery();
        
        if(res.next())
            return 1; //student with same email already exist
        return 0; //student with provided email doesn't exist    
    }
    

    @Override
    public List<Student> getStudents() throws SQLException {
        String query = "SELECT Fname,Lname,Password,Email,Phone,Accepted FROM " + TABLE_NAME+" WHERE Accepted = 1";
        Statement stmt = con.createStatement();
        ResultSet res = stmt.executeQuery(query);
        List<Student> listStudents = new ArrayList<>();
        while(res.next())
        {
            Student s = new Student(res.getString("Fname"), res.getString("Lname"), res.getString("Email"), res.getString("Password"), res.getInt("Phone"));
            listStudents.add(s);
        }
        return listStudents;
    }

    @Override
    public void update(Student s) throws SQLException {
        
    }

	@Override
	public Object[][] getStudentCoursesInformation(String email,String password) throws SQLException {
		String queryCount="SELECT COUNT(studentgrades.Id) FROM studentgrades,student WHERE studentgrades.Id=student.Id AND student.Email=? AND student.Password=?";
		PreparedStatement sCount=con.prepareStatement(queryCount);
		sCount.setString(1, email);
		sCount.setString(2, password);
		ResultSet resCount=sCount.executeQuery();
		resCount.next();
		int countRows=resCount.getInt(1);
		String query="SELECT course.Year,course.Code,course.Name,course.Credits,studentgrades.Grade"
				+ " FROM student,course,studentgrades WHERE studentgrades.Id=student.Id AND studentgrades.CourseId=course.CourseId"
				+ " AND student.Email=? AND student.Password=?";
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1, email);
		ps.setString(2, password);
		ResultSet res=ps.executeQuery();
		ResultSetMetaData md=res.getMetaData();
		int colCount=md.getColumnCount();
		int rowCount=res.getRow();
		
		Object[][] gradesInformation=new Object[countRows][colCount+1];
		int i=0;
		while(res.next()) {
			gradesInformation[i][0]=(Object)res.getInt(1);
			gradesInformation[i][1]=(Object)res.getString(2);
			gradesInformation[i][2]=(Object)res.getString(3);
			gradesInformation[i][3]=(Object)res.getInt(4);
			double grade=res.getDouble(5);
			gradesInformation[i][4]=(Object)grade;
			if(grade>=50) {
				gradesInformation[i][5]=(Object)"Passed";
			}
			else
			{
				gradesInformation[i][5]=(Object)"Failed";
			}
			i++;
		}
		
		return gradesInformation;
	}

	@Override
	public String[] getStudent(String email,String password) throws SQLException {
		
		String query = "SELECT Id,Fname,Lname,Email,Phone FROM student WHERE Email=? AND Password=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1,email);
        ps.setString(2, password);
        ResultSet res = ps.executeQuery();
        String[] information=new String[5];
     while(res.next()) {
       
       information[0]=Integer.toString(res.getInt(1));
       information[1]=(String)res.getString(2);
       information[2]=(String)res.getString(3);
       information[3]=(String)res.getString(4);
       information[4]=Integer.toString(res.getInt(5));
	}
       return information;
	}

    @Override
    public Student[] getWaitingAcceptanceStudent() throws SQLException{
        String query = "SELECT Fname, Lname, Password, Email, Phone FROM student WHERE Accepted = 0";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet res = ps.executeQuery();
        //get number of unaccepted students to define the array
        int len = 0;
        while (res.next())
            ++len;
        
        //query again to go back to first row and then define the array
        res = ps.executeQuery();
        Student[] unaccepted = new Student[len];
        for (int i = 0; i < len; ++i){
            res.next();
            unaccepted[i] = new Student(
                res.getString(1),
                res.getString(2),
                res.getString(3),
                res.getString(4),
                Integer.parseInt(res.getString(5))
            );
        }
        return unaccepted;
    }

    @Override
    public int acceptStudent(String email, String pass) throws SQLException{
        String query = "UPDATE " + TABLE_NAME + " SET Accepted = 1 WHERE Email = ? AND Password = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, email);
        ps.setString(2, pass);
        int res = ps.executeUpdate();
        return res;
    }

	@Override
	public Object[][] getAcceptedStudentsInfo() throws SQLException {
		String queryCount="SELECT COUNT(*) FROM student LEFT JOIN studentgrades ON studentgrades.Id=student.Id WHERE student.Accepted=1;";
		PreparedStatement sCount=con.prepareStatement(queryCount);
		ResultSet resCount=sCount.executeQuery();
		resCount.next();
		int countRows=resCount.getInt(1);
		String query="SELECT "
				+ " student.Id,"
				+ " student.Fname,"
				+ " student.Lname,"
				+ " course.CourseId,"
				+ " course.Code,"
				+ " course.Name"
				+ " FROM"
				+ " student "
				+ "LEFT JOIN studentgrades ON studentgrades.Id = student.Id "
				+ "LEFT JOIN course ON studentgrades.CourseId = course.CourseId "
				+ "WHERE "
				+ "    student.Accepted = ?;";
		
		PreparedStatement ps=con.prepareStatement(query);
		ps.setInt(1, 1);
		ResultSet res=ps.executeQuery();
		ResultSetMetaData md=res.getMetaData();
		int colCount=md.getColumnCount();
		int rowCount=res.getRow();
		
		Object[][] gradesInformation=new Object[countRows][colCount+1];
		int i=0;
		while(res.next()) {
			gradesInformation[i][0]=(Object)res.getInt(1);
			gradesInformation[i][1]=(Object)res.getString(2);
			gradesInformation[i][2]=(Object)res.getString(3);
			gradesInformation[i][3]=(Object)res.getString(4);
		    gradesInformation[i][4]=(Object)res.getString(5);
			i++;
		}
		
		return gradesInformation;
	}
    
}
