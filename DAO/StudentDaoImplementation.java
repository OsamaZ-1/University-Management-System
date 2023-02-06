package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Database.DatabaseConnection;
import Model.Student;
import Model.UniversityMember;

public class StudentDaoImplementation implements StudentDao {
    static Connection con = DatabaseConnection.getConnection();
    private final String TABLE_NAME = "student";
    private final String TABLE_STUDENT_COURSE = "studentgrades";
    @Override
    public int add(Student s) throws SQLException {
        String query
        = "INSERT INTO "+TABLE_NAME+"(Fname,Lname,Major,Password,Email,Phone) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, s.getFname());
        ps.setString(2, s.getLname());
        ps.setString(3, s.getMajor());
        ps.setString(4, s.getPassword());
        ps.setString(5, s.getEmail());
        ps.setInt(6, s.getPhone());
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
        String query = "SELECT Fname,Lname,Major,Password,Email,Phone FROM " + TABLE_NAME+" WHERE Accepted = 1";
        Statement stmt = con.createStatement();
        ResultSet res = stmt.executeQuery(query);
        List<Student> listStudents = new ArrayList<>();
        while(res.next())
        {
            Student s = new Student(res.getString("Fname"), res.getString("Lname"), res.getString("Major"),res.getString("Email"), res.getString("Password"), res.getInt("Phone"));
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
		
		String query = "SELECT Id,Fname,Lname,Major,Email,Phone FROM student WHERE Email=? AND Password=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1,email);
        ps.setString(2, password);
        ResultSet res = ps.executeQuery();
        String[] information=new String[6];
        while(res.next()) {
            information[0]=Integer.toString(res.getInt(1));
            information[1]=(String)res.getString(2);
            information[2]=(String)res.getString(3);
            information[3]=(String)res.getString(4);
            information[4]=(String)res.getString(5);
            information[5]=Integer.toString(res.getInt(6));
        }
       return information;
	}

    @Override
    public ArrayList<UniversityMember> getWaitingAcceptanceStudent() throws SQLException{
        String query = "SELECT Fname, Lname, Major, Password, Email, Phone FROM student WHERE Accepted = 0";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet res = ps.executeQuery();
        
        //query again to go back to first row and then define the array
        res = ps.executeQuery();
        ArrayList<UniversityMember> unaccepted = new ArrayList<>();
        while (res.next()){
            unaccepted.add(new Student(
                res.getString(1),
                res.getString(2),
                res.getString(3),
                res.getString(5),
                res.getString(4),
                Integer.parseInt(res.getString(6))
            ));
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
        System.out.println(res);
        return res;
    }

	@Override
	public Object[][] getAcceptedStudentsInfo(String id) throws SQLException {
		String queryCount="SELECT COUNT(*) FROM student LEFT JOIN studentgrades ON studentgrades.Id=student.Id AND student.Id = ? WHERE student.Accepted=1;";
		PreparedStatement sCount=con.prepareStatement(queryCount);
        sCount.setInt(1,Integer.parseInt(id));
		ResultSet resCount=sCount.executeQuery();
		resCount.next();
		int countRows=resCount.getInt(1);
		String query="SELECT "
				+ " student.Id,"
				+ " student.Fname,"
				+ " student.Lname,"
                + " student.Major,"
				+ " course.CourseId,"
				+ " course.Code,"
				+ " course.Name"
				+ " FROM"
				+ " student "
				+ "LEFT JOIN studentgrades ON studentgrades.Id = student.Id "
				+ "LEFT JOIN course ON studentgrades.CourseId = course.CourseId "
				+ "WHERE "
				+ "    student.Accepted = ? AND student.Id = ?;";
		
		PreparedStatement ps=con.prepareStatement(query);
		ps.setInt(1, 1);
        ps.setInt(2, Integer.parseInt(id));
		ResultSet res=ps.executeQuery();
		ResultSetMetaData md=res.getMetaData();
		int colCount=md.getColumnCount();
		
		Object[][] gradesInformation=new Object[countRows][colCount+1];
		int i=0;
		while(res.next()) {
			gradesInformation[i][0]=(Object)res.getInt(1);
			gradesInformation[i][1]=(Object)res.getString(2);
			gradesInformation[i][2]=(Object)res.getString(3);
            gradesInformation[i][2]=(Object)res.getString(4);
			gradesInformation[i][3]=(Object)res.getString(5);
		    gradesInformation[i][4]=(Object)res.getString(6);
		    gradesInformation[i][5]=(Object)res.getString(7);
			i++;
		}
		
		return gradesInformation;
	}

    @Override
    public Object[][] getStudentsWithId() throws SQLException{
        String query = "SELECT Id,Fname,Lname,Major,Email,Password,Phone FROM "+TABLE_NAME+" WHERE Accepted = 1";
        String countRows = "SELECT COUNT(*) FROM "+TABLE_NAME+" WHERE Accepted = 1";

        Statement stmt = con.createStatement();
        ResultSet res = stmt.executeQuery(countRows);
        res.next();
        int numRows = res.getInt(1);

        res = stmt.executeQuery(query);
        int i=0;
        Object[][] acceptedStudents = new Object[numRows][7];

        while(res.next())
        {
            acceptedStudents[i][0] = (Object)res.getInt("Id");
            acceptedStudents[i][1] = (Object)res.getString("Fname");
            acceptedStudents[i][2] = (Object)res.getString("Lname");
            acceptedStudents[i][3] = (Object)res.getString("Major");
            acceptedStudents[i][4] = (Object)res.getString("Email");
            acceptedStudents[i][5] = (Object)res.getString("Password");
            acceptedStudents[i][6] = (Object)res.getInt("Phone");
            i++;
        }
        return acceptedStudents;
    }

    @Override
    public boolean updateStudent(String[] studentInfo) throws SQLException
    {
        String query = "UPDATE "+TABLE_NAME+" SET Fname=?,Lname=?,Major=?,Email=?,Password=?,Phone=? WHERE Id=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1,studentInfo[1]);
        ps.setString(2,studentInfo[2]);
        ps.setString(3,studentInfo[3]);
        ps.setString(4,studentInfo[4]);
        ps.setString(5,studentInfo[5]);
        ps.setInt(6,Integer.parseInt(studentInfo[6]));
        ps.setInt(7,Integer.parseInt(studentInfo[0]));

        return ps.executeUpdate()>0;
    }

    @Override
    public boolean addStudentToCourse(String studentId, String courseId) throws SQLException
    {
        String query = "INSERT INTO "+TABLE_STUDENT_COURSE+" (Id, CourseId) VALUES(?,?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1,Integer.parseInt(studentId));
        ps.setInt(2,Integer.parseInt(courseId));

        return ps.executeUpdate()>0;
    }

    @Override 
    public boolean deleteStudentFromCourse(String studentId, String courseId) throws SQLException
    {
        String query = "DELETE FROM "+TABLE_STUDENT_COURSE+" WHERE Id = ? AND CourseId = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1,Integer.parseInt(studentId));
        ps.setInt(2,Integer.parseInt(courseId));

        return ps.executeUpdate()>0;
    }
    
}
