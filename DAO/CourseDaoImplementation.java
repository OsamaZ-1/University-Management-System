package DAO;

import java.util.List;
import java.sql.*;
import java.util.List;

import Database.DatabaseConnection;
import Model.Course;

public class CourseDaoImplementation implements CourseDao{

	static Connection connection=DatabaseConnection.getConnection();
	private final String TABLE_COURSE="course";
	@Override
	public int add(Course course) throws SQLException {
		// TODO Auto-generated method stub
		//get max id of course to set the code
		String queryid="SELECT MAX(Id) FROM "+TABLE_COURSE;
		PreparedStatement psid=connection.prepareStatement(queryid);
		ResultSet resultmaxid=psid.executeQuery();
		resultmaxid.next();
		int maxid=Integer.parseInt(resultmaxid.getString(1));
		
		String query= "INSERT INTO "+TABLE_COURSE+"(Name,Code,Credits,Hours,Major,Year) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedstatement = connection.prepareStatement(query);
        preparedstatement.setString(1, course.getName());
        
        //set code of new couse add as major, year, and id
        /*
         * example
         * Info course of id=32 and third year 
         * code=I3032
         * */
        int numcode=course.getYear()*1000+maxid+1;
        String code=course.getMajor().toString().charAt(0)+Integer.toString(numcode);
        preparedstatement.setString(2, code);
        
        preparedstatement.setInt(3, course.getCredits());
        preparedstatement.setInt(4, course.getHours());
        preparedstatement.setString(5, course.getMajor());
        preparedstatement.setInt(6, course.getYear());
        int n = preparedstatement.executeUpdate();
        return n;
	}

	@Override
	public void update(Course course) throws SQLException {
		// TODO Auto-generated method stub
		String updatequery="UPDATE "+TABLE_COURSE+" SET Name=?, Credits=?, Hours=?, Major=? WHERE Code=?";
		PreparedStatement preparedstatement=connection.prepareStatement(updatequery);
		preparedstatement.setString(5, course.getCode());
		preparedstatement.setString(1, course.getName());
		preparedstatement.setInt(2, course.getCredits());
		preparedstatement.setInt(3, course.getHours());
		preparedstatement.setString(4, course.getMajor());
		preparedstatement.executeUpdate();
	}

	@Override
	public void delete(Course course) throws SQLException {
		// TODO Auto-generated method stub
		String deletequery="DELETE FROM "+TABLE_COURSE+" WHERE Code=?";
		PreparedStatement preparedstatement=connection.prepareStatement(deletequery);
		preparedstatement.setString(1, course.getCode());
		preparedstatement.executeUpdate();
	}

	@Override
	public Course getCourse(String code) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> getMajorCourses(String major) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> getCourses() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	

}
