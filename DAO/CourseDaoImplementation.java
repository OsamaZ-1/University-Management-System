package DAO;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import Database.DatabaseConnection;
import Model.Course;

public class CourseDaoImplementation implements CourseDao{

	static Connection connection=DatabaseConnection.getConnection();
	private final String TABLE_NAME = "course";
	@Override
	public boolean add(Course course) throws SQLException {
		// TODO Auto-generated method stub
		//get max id of course to set the code
		String queryid="SELECT MAX(CourseId) FROM "+TABLE_NAME;
		PreparedStatement psid=connection.prepareStatement(queryid);
		ResultSet resultmaxid=psid.executeQuery();
		resultmaxid.next();
		int maxid=Integer.parseInt(resultmaxid.getString(1));
		
		String query= "INSERT INTO "+TABLE_NAME+"(Name,Code,Credits,Hours,Major,Year) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedstatement = connection.prepareStatement(query);
        preparedstatement.setString(1, course.getName());
        
        //set code of new couse add as major, year, and id
        /*
         * example
         * Info course of id=32 and third year 
         * code=I3032
         * */
        int numcode=course.getYear()*1000+maxid+1;
        String code=course.getMajor().toString().substring(0, 1)+""+Integer.toString(numcode);
        preparedstatement.setString(2, code);
        
        preparedstatement.setInt(3, course.getCredits());
        preparedstatement.setInt(4, course.getHours());
        preparedstatement.setString(5, course.getMajor());
        preparedstatement.setInt(6, course.getYear());
        int n = preparedstatement.executeUpdate();
        return n>0;
	}

	@Override
	public boolean update(Course course) throws SQLException {
		// TODO Auto-generated method stub
		String updatequery="UPDATE "+TABLE_NAME+" SET Name=?,Credits=?,Hours=?,Major=?,Year=? WHERE Code=?";
		PreparedStatement preparedstatement=connection.prepareStatement(updatequery);
		
		preparedstatement.setString(1, course.getName());
		preparedstatement.setInt(2, course.getCredits());
		preparedstatement.setInt(3, course.getHours());
		preparedstatement.setString(4, course.getMajor());
		preparedstatement.setInt(5, course.getYear());
		preparedstatement.setString(6, course.getCode());
		return preparedstatement.executeUpdate()>0;
	}

	@Override
	public boolean delete(String code) throws SQLException {
		// TODO Auto-generated method stub
		String deletequery="DELETE FROM "+TABLE_NAME+" WHERE Code=?";
		PreparedStatement preparedstatement=connection.prepareStatement(deletequery);
		preparedstatement.setString(1, code);
		
		return preparedstatement.executeUpdate()>0;
	}

	@Override
	public List<Course> getCourses() throws SQLException {
		// TODO Auto-generated method stub/
		String query = "SELECT Name,Code,Credits,Hours,Major,Year FROM " + TABLE_NAME;
        PreparedStatement ps = connection.prepareStatement(query);
        ResultSet res = ps.executeQuery();
        List<Course> listCourses = new ArrayList<Course>();
        while(res.next())
        {
            Course s = new Course(res.getString("Code"), res.getString("Name"),res.getInt("Credits"), res.getInt("Hours"), res.getString("Major"), res.getInt("Year"));
            listCourses.add(s);
        }
        return listCourses;
	}

	@Override
	public List<Course> getMajorCourses(String major) throws SQLException
	{
		String query = "SELECT Name,Code,Credits,Hours,Major,Year FROM " + TABLE_NAME + " WHERE Major = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1,major);
        ResultSet res = ps.executeQuery();
        List<Course> listCourses = new ArrayList<Course>();
		while(res.next())
        {
            Course s = new Course(res.getString("Code"), res.getString("Name"),res.getInt("Credits"), res.getInt("Hours"), res.getString("Major"), res.getInt("Year"));
            listCourses.add(s);
        }

		return listCourses;
	}
	

}
