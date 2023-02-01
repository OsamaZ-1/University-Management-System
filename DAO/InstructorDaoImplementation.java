package DAO;

import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Database.DatabaseConnection;
import Model.Instructor;
import Model.UniversityMember;

public class InstructorDaoImplementation implements InstructorDao{
    static Connection con = DatabaseConnection.getConnection();
    private final String TABLE_NAME = "instructors";
    private final String TABLE_INST_TEACH = "instructorteaches";
    @Override
    public int add(Instructor s) throws SQLException {
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
    public int uniqueInstructorExists(String email, String pass) throws SQLException {
        String query = "SELECT Id, Accepted FROM " + TABLE_NAME + " WHERE Password = ? AND Email = ?";
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
    public int instructorEmailExist(String email) throws SQLException{
        String query = "SELECT Id FROM " + TABLE_NAME + " WHERE Email = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, email);
        ResultSet res = ps.executeQuery();
        
        if(res.next())
            return 1; //instructor with same email already exist
        return 0; //instructor with provided email doesn't exist    
    }
    

    @Override
    public List<Instructor> getInstructors() throws SQLException {
        String query = "SELECT Fname,Lname,Password,Email,Phone,Accepted FROM " + TABLE_NAME + " WHERE Accepted = 1";
        Statement stmt = con.createStatement();
        ResultSet res = stmt.executeQuery(query);
        List<Instructor> listInstructors = new ArrayList<>();
        while(res.next())
        {
            Instructor s = new Instructor(res.getString("Fname"), res.getString("Lname"), res.getString("Password"), res.getString("Email"), res.getInt("Phone"));
            listInstructors.add(s);
        }
        return listInstructors;
       
    }

    public ArrayList<UniversityMember> getUnacceptedInstructors() throws SQLException{
        String query = "SELECT Fname,Lname,Password,Email,Phone,Accepted FROM " + TABLE_NAME + " WHERE Accepted = 0";
        Statement stmt = con.createStatement();
        ResultSet res = stmt.executeQuery(query);
        ArrayList<UniversityMember> listInstructors = new ArrayList<>();
        while(res.next())
        {
            Instructor s = new Instructor(res.getString("Fname"), res.getString("Lname"), res.getString("Email"), res.getString("Password"), res.getInt("Phone"));
            listInstructors.add(s);
        }
        return listInstructors;
    }

    public int acceptInstructor(String email, String pass) throws SQLException{
        String query = "UPDATE " + TABLE_NAME + " SET Accepted = 1 WHERE Email = ? AND Password = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, email);
        ps.setString(2, pass);
        int res = ps.executeUpdate();
        return res;
    }

    @Override
    public Object[][] getInstructorsWithId() throws SQLException{
        String query = "SELECT Id,Fname,Lname,Email,Password,Phone FROM "+TABLE_NAME+" WHERE Accepted = 1";
        String countRows = "SELECT COUNT(*) FROM "+TABLE_NAME+" WHERE Accepted = 1";

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
            acceptedInstructors[i][5] = (Object)res.getInt("Phone");
            i++;
        }
        return acceptedInstructors;
    }

    @Override
    public boolean updateInstructor(String[] instInfo) throws SQLException {
        String query = "UPDATE "+TABLE_NAME+" SET Fname=?,Lname=?,Email=?,Password=?,Phone=? WHERE Id=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1,instInfo[1]);
        ps.setString(2,instInfo[2]);
        ps.setString(3,instInfo[3]);
        ps.setString(4,instInfo[4]);
        ps.setInt(5,Integer.parseInt(instInfo[5]));
        ps.setInt(6,Integer.parseInt(instInfo[0]));

        return ps.executeUpdate()>0;
    }

    @Override
    public boolean addInstructorToCourse(String instID, String courseId) throws SQLException
    {
        String query = "INSERT INTO " + TABLE_INST_TEACH + " (Id, CourseId) VALUES(?,?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1,Integer.parseInt(instID));
        ps.setInt(2,Integer.parseInt(courseId));

        return ps.executeUpdate()>0;
    }

    @Override 
    public boolean deleteInstructorFromCourse(String instID, String courseId) throws SQLException
    {
        String query = "DELETE FROM " + TABLE_INST_TEACH + " WHERE Id = ? AND CourseId = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1,Integer.parseInt(instID));
        ps.setInt(2,Integer.parseInt(courseId));

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
    
}
