package DAO;

import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Database.DatabaseConnection;
import Model.Instructor;
import Model.UniversityMember;

public class InstructorDaoImplementation implements InstructorDao{
    static Connection con = DatabaseConnection.getConnection();
    private final String TABLE_INSTRUCTORS = "instructors";
    private final String TABLE_INST_TEACH = "instructorteaches";
    private final String TABLE_COURSE = "course";
    private final String TABLE_STUDENT_GRADES = "studentgrades";
    private final String TABLE_STUDENT = "student";
    
    @Override
    public int add(Instructor s) throws SQLException {
        String query
        = "INSERT INTO "+TABLE_INSTRUCTORS+"(Fname,Lname,Password,Email,Phone) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, s.getFname());
        ps.setString(2, s.getLname());
        ps.setString(3, s.getPassword());
        ps.setString(4, s.getEmail());
        ps.setString(5, s.getPhone());
        int n = ps.executeUpdate();
        return n;
    }

    public boolean delete(String id) throws SQLException
    {
        String query = "DELETE FROM "+TABLE_INSTRUCTORS+ " WHERE Id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1,Integer.parseInt(id));
        return ps.executeUpdate()>0;
    }

    @Override
    public int uniqueInstructorExists(String email, String pass) throws SQLException {
        String query = "SELECT Id, Accepted FROM " + TABLE_INSTRUCTORS + " WHERE Password = ? AND Email = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, pass);
        ps.setString(2, email);
        ResultSet res = ps.executeQuery();
        if (res.next()){
            if (Integer.parseInt(res.getString(2)) == 0){
                return 0; //instructor was found but is not accepted yet
            }
            return 2; //instructor was found and is accepted
        }
        else
            return -1; //instructor with this information was not found
    }

    @Override
    public int instructorEmailPhoneExist(String email, String phone) throws SQLException{
        String query = "SELECT Id FROM " + TABLE_INSTRUCTORS + " WHERE Email = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, email);
        ResultSet res = ps.executeQuery();
        int count = 0;

        if(res.next())
            count++; //instructor with same email already exist
        
        query = "SELECT Id FROM " + TABLE_INSTRUCTORS + " WHERE Phone = ?";
        ps = con.prepareStatement(query);
        ps.setString(1,phone);
        res = ps.executeQuery();

        if(res.next())
            count++; //instructor with same phone number already exist

        return count; //instructor with provided email and password doesn't exist   
    }
    

    @Override
    public List<Instructor> getInstructors() throws SQLException {
        String query = "SELECT Fname,Lname,Password,Email,Phone,Accepted FROM " + TABLE_INSTRUCTORS + " WHERE Accepted = 1";
        Statement stmt = con.createStatement();
        ResultSet res = stmt.executeQuery(query);
        List<Instructor> listInstructors = new ArrayList<>();
        while(res.next())
        {
            Instructor s = new Instructor(res.getString("Fname"), res.getString("Lname"), res.getString("Password"), res.getString("Email"), res.getString("Phone"));
            listInstructors.add(s);
        }
        return listInstructors;
       
    }

    public ArrayList<UniversityMember> getUnacceptedInstructors() throws SQLException{
        String query = "SELECT Fname,Lname,Password,Email,Phone,Accepted FROM " + TABLE_INSTRUCTORS + " WHERE Accepted = 0";
        Statement stmt = con.createStatement();
        ResultSet res = stmt.executeQuery(query);
        ArrayList<UniversityMember> listInstructors = new ArrayList<>();
        while(res.next())
        {
            Instructor s = new Instructor(res.getString("Fname"), res.getString("Lname"), res.getString("Email"), res.getString("Password"), res.getString("Phone"));
            listInstructors.add(s);
        }
        return listInstructors;
    }

    @Override
    public int acceptInstructor(String email, String pass) throws SQLException{
        String query = "UPDATE " + TABLE_INSTRUCTORS + " SET Accepted = 1 WHERE Email = ? AND Password = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, email);
        ps.setString(2, pass);
        int res = ps.executeUpdate();
        return res;
    }

    @Override
    public int unacceptInstructor(String email, String pass) throws SQLException{
        String query = "DELETE FROM " + TABLE_INSTRUCTORS + " WHERE Email = ? AND Password = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, email);
        ps.setString(2, pass);
        int res = ps.executeUpdate();
        return res;
    }

    @Override
    public Object[][] getInstructorsWithId() throws SQLException{
        String query = "SELECT Id,Fname,Lname,Email,Password,Phone FROM "+TABLE_INSTRUCTORS+" WHERE Accepted = 1";
        String countRows = "SELECT COUNT(*) FROM "+TABLE_INSTRUCTORS+" WHERE Accepted = 1";

        Statement stmt = con.createStatement();
        ResultSet res = stmt.executeQuery(countRows);
        res.next();
        int numRows = res.getInt(1);

        res = stmt.executeQuery(query);
        int i=0;
        Object[][] acceptedInstructors = new Object[numRows][6];

        while(res.next())
        {
            acceptedInstructors[i][0] = (Object)res.getInt("Id");
            acceptedInstructors[i][1] = (Object)res.getString("Fname");
            acceptedInstructors[i][2] = (Object)res.getString("Lname");
            acceptedInstructors[i][3] = (Object)res.getString("Email");
            acceptedInstructors[i][4] = (Object)res.getString("Password");
            acceptedInstructors[i][5] = (Object)res.getString("Phone");
            i++;
        }
        return acceptedInstructors;
    }

    @Override
    public boolean updateInstructor(String[] instInfo) throws SQLException {
        String query = "UPDATE "+TABLE_INSTRUCTORS+" SET Fname=?,Lname=?,Email=?,Password=?,Phone=? WHERE Id=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1,instInfo[1]);
        ps.setString(2,instInfo[2]);
        ps.setString(3,instInfo[3]);
        ps.setString(4,instInfo[4]);
        ps.setString(5,instInfo[5]);
        ps.setInt(6,Integer.parseInt(instInfo[0]));

        return ps.executeUpdate()>0;
    }

    @Override
    public boolean addInstructorToCourse(String instID, String courseCode) throws SQLException
    {   
        int courseId = 0;
        boolean test = false;
        try{
            courseId = getCourseId(courseCode);
            test = instructorTeachCourse(instID, courseId);
        }catch(SQLException e){e.printStackTrace();}

        if(!test && courseId!=0)
        {
            String query = "INSERT INTO " + TABLE_INST_TEACH + " (InstID, CourseId) VALUES(?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1,Integer.parseInt(instID));
            ps.setInt(2,courseId);

            return ps.executeUpdate()>0;
        }
        return false;
    }

    public boolean instructorTeachCourse(String instID, int courseId) throws SQLException
    {
        String query = "SELECT * FROM "+TABLE_INST_TEACH+" WHERE InstID = ? AND CourseID = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, Integer.parseInt(instID));
        ps.setInt(2, courseId);
        ResultSet res = ps.executeQuery();

        if(res.next()) return true;
        return false;
    }

    @Override 
    public boolean deleteInstructorFromCourse(String instID, String courseCode) throws SQLException
    {   
        int courseId = 0;
        try{
            courseId = getCourseId(courseCode);
        }catch(SQLException e){e.printStackTrace();}

        String query = "DELETE FROM " + TABLE_INST_TEACH + " WHERE InstID = ? AND CourseId = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1,Integer.parseInt(instID));
        ps.setInt(2,courseId);

        return ps.executeUpdate()>0;
    }

    @Override
	public Object[][] getAcceptedInstructorsInfo(String id) throws SQLException {
		String queryCount="SELECT COUNT(*) FROM instructors LEFT JOIN instructorteaches ON instructorteaches.InstID=instructors.Id AND instructors.Id = ? WHERE instructors.Accepted=1;";
		PreparedStatement sCount=con.prepareStatement(queryCount);
        sCount.setInt(1,Integer.parseInt(id));
		ResultSet resCount=sCount.executeQuery();
		resCount.next();
		int countRows=resCount.getInt(1);
		String query="SELECT "
				+ " instructors.Id,"
				+ " instructors.Fname,"
				+ " instructors.Lname,"
				+ " course.CourseId,"
				+ " course.Code,"
				+ " course.Name"
				+ " FROM"
				+ " instructors "
				+ "LEFT JOIN instructorteaches ON instructorteaches.InstID = instructors.Id "
				+ "LEFT JOIN course ON instructorteaches.CourseID = course.CourseId "
				+ "WHERE "
				+ "    instructors.Accepted = ? AND instructors.Id = ?;";
		
		PreparedStatement ps=con.prepareStatement(query);
		ps.setInt(1, 1);
        ps.setInt(2, Integer.parseInt(id));
		ResultSet res=ps.executeQuery();
		ResultSetMetaData md=res.getMetaData();
		int colCount=md.getColumnCount();
		
		Object[][] teachInformation=new Object[countRows][colCount+1];
		int i=0;
		while(res.next()) {
			teachInformation[i][0]=(Object)res.getInt(1);
			teachInformation[i][1]=(Object)res.getString(2);
			teachInformation[i][2]=(Object)res.getString(3);
			teachInformation[i][3]=(Object)res.getString(4);
		    teachInformation[i][4]=(Object)res.getString(5);
		    teachInformation[i][5]=(Object)res.getString(6);
			i++;
		}
		
		return teachInformation;
	}

    public List<String> getInstructorCourses(String instEmail, String instPass) throws SQLException
    {
        String query = "SELECT course.Code FROM "+TABLE_COURSE+","+TABLE_INSTRUCTORS+","+TABLE_INST_TEACH+" WHERE "+
                        "instructors.id = instructorteaches.InstID "+
                        "AND instructorteaches.CourseID = course.CourseId "+
                        "AND instructors.Email = ? "+
                        "AND instructors.Password = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1,instEmail);
        ps.setString(2,instPass);
        ResultSet res = ps.executeQuery();
        List<String> courses = new ArrayList<>();

        while(res.next())
            courses.add(res.getString("Code"));

        return courses;
    }

    public HashMap<String,String> getInstructorInfo(String instEmail, String instPass) throws SQLException
    {
        String query = "SELECT Id,Fname,Lname FROM "+TABLE_INSTRUCTORS+" WHERE Email=? AND Password = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1,instEmail);
        ps.setString(2,instPass);
        ResultSet res = ps.executeQuery();
        HashMap<String,String> instructorInfo = new HashMap<>();
        res.next();
        instructorInfo.put("fullName", res.getString("Fname")+" "+res.getString("Lname"));
        instructorInfo.put("ID",res.getInt("Id")+"");

        return instructorInfo;
    }

    public Object[][] getEnrolledStudents(String courseCode) throws SQLException
    {
        String queryCount = "SELECT COUNT(*) FROM "+TABLE_COURSE+","+TABLE_STUDENT_GRADES+" WHERE course.CourseId = studentgrades.CourseId AND course.Code = ?";
        PreparedStatement ps = con.prepareStatement(queryCount);
        ps.setString(1,courseCode);
        ResultSet res = ps.executeQuery();
        res.next();
        int rowsCount = res.getInt(1);
        Object[][] enrolledStudents = new Object [rowsCount][5];

        String query = "SELECT student.Id,student.Fname,student.Lname,studentgrades.Grade,studentgrades.Submitted FROM "+
                       TABLE_STUDENT+","+TABLE_COURSE+","+TABLE_STUDENT_GRADES+
                       " WHERE course.CourseId = studentgrades.CourseId "+
                       "AND studentgrades.Id = student.Id "+
                       "AND course.Code = ?"+
                       "ORDER BY studentgrades.Grade DESC";
        ps = con.prepareStatement(query);
        ps.setString(1,courseCode);
        res = ps.executeQuery();
        int i = 0;
        while(res.next())
        {
            enrolledStudents[i][0] = (Object)res.getInt("Id");
            enrolledStudents[i][1] = (Object)res.getString("Fname");
            enrolledStudents[i][2] = (Object)res.getString("Lname");
            float grade=res.getFloat("Grade");
            if(grade==-1) {
            	enrolledStudents[i][3] = (Object) "";
            }
            else {
            enrolledStudents[i][3] = (Object) grade;
            }
            enrolledStudents[i][4] = (Object)res.getInt("Submitted");
            i++;
        }

        return enrolledStudents;

    }

    public boolean updateStudentGrade(String studentId, String courseCode, String grade) throws SQLException
    {
        
        int courseId = getCourseId(courseCode);

        String update = "UPDATE "+TABLE_STUDENT_GRADES+" SET Grade = ? WHERE Id = ? AND CourseId = ? AND Submitted = ?";
        PreparedStatement ps = con.prepareStatement(update);
        ps.setFloat(1, Float.valueOf(grade));
        ps.setInt(2, Integer.valueOf(studentId));
        ps.setInt(3, courseId);
        ps.setInt(4, 0);

        return ps.executeUpdate()>0;
    }

    public boolean saveStudentsGrades(String courseCode) throws SQLException
    {
        int courseId = getCourseId(courseCode);

        String update = "UPDATE "+TABLE_STUDENT_GRADES+" SET Submitted = ? WHERE CourseId = ? AND Grade != ?";
        PreparedStatement ps = con.prepareStatement(update);
        ps.setInt(1,1);
        ps.setInt(2,courseId);
        ps.setInt(3,-1);

        return ps.executeUpdate()>0;
    }

    public int getCourseId(String courseCode) throws SQLException
    {
        String query = "SELECT CourseId FROM " + TABLE_COURSE + " WHERE Code = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1,courseCode);
        ResultSet res = ps.executeQuery();
        int courseId = 0;
        res.next();
        courseId = res.getInt("CourseId");

        return courseId;
        
    }
    
}
