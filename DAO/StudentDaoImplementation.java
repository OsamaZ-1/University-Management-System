package DAO;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Database.DatabaseConnection;
import Model.Course;
import Model.Student;
import Model.UniversityMember;

public class StudentDaoImplementation implements StudentDao {
    static private Connection con = DatabaseConnection.getConnection();
    private final String TABLE_STUDENT = "student";
    private final String TABLE_STUDENT_COURSE = "studentgrades";
    private final String TABLE_COURSE = "course";
    
    @Override
    public int add(Student s) throws SQLException {
        String query
        = "INSERT INTO "+TABLE_STUDENT+"(Fname,Lname,Major,Password,Email,Phone) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, s.getFname());
        ps.setString(2, s.getLname());
        ps.setString(3, s.getMajor());
        ps.setString(4, s.getPassword());
        ps.setString(5, s.getEmail());
        ps.setString(6, s.getPhone());
        int n = ps.executeUpdate();
        return n;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        
        String query = "DELETE FROM "+TABLE_STUDENT+ " WHERE Id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1,Integer.parseInt(id));
        return ps.executeUpdate()>0;
    }

    @Override
    public int uniqueStudentExists(String email, String pass) throws SQLException {
        String query = "SELECT Id, Accepted FROM " + TABLE_STUDENT + " WHERE Password = ? AND Email = ?";
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
    public int studentEmailPhoneExist(String email, String phone) throws SQLException{
        String query = "SELECT Id FROM " + TABLE_STUDENT + " WHERE Email = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, email);
        ResultSet res = ps.executeQuery();
        int count = 0;
        
        if(res.next())
            count++; //student with same email already exist

        query = "SELECT Id FROM " + TABLE_STUDENT + " WHERE Phone = ?";
        ps = con.prepareStatement(query);
        ps.setString(1, phone);
        res = ps.executeQuery();

        if(res.next())
            count++; //student with same phone number already exist

        return count; //student with provided email and password doesn't exist    
    }
    

    @Override
    public List<Student> getStudents() throws SQLException {
        String query = "SELECT Fname,Lname,Major,Password,Email,Phone FROM " + TABLE_STUDENT+" WHERE Accepted = 1";
        Statement stmt = con.createStatement();
        ResultSet res = stmt.executeQuery(query);
        List<Student> listStudents = new ArrayList<>();
        while(res.next())
        {
            Student s = new Student(res.getString("Fname"), res.getString("Lname"), res.getString("Major"),res.getString("Email"), res.getString("Password"), res.getString("Phone"));
            listStudents.add(s);
        }
        return listStudents;
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
		String query="SELECT "
				+ "    studentgrades.Year, "
				+ "    course.Semester, "
				+ "    course.Code, "
				+ "    course.Name, "
				+ "    course.Credits, "
				+ "    studentgrades.Grade, "
				+ "    studentgrades.Submitted "
				+ "FROM "
				+ "    student, "
				+ "    course, "
				+ "    studentgrades "
				+ "WHERE "
				+ "    studentgrades.Id = student.Id AND studentgrades.CourseId = course.CourseId AND student.Email =? AND student.Password =? "
				+ " ORDER BY course.Semester";
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1, email);
		ps.setString(2, password);
		ResultSet res=ps.executeQuery();
		ResultSetMetaData md=res.getMetaData();
		int colCount=md.getColumnCount();
		
		Object[][] gradesInformation=new Object[countRows][colCount];
		int i=0;
		while(res.next()) {
			gradesInformation[i][0]=(Object)res.getString(1);
			gradesInformation[i][1]=(Object)res.getInt(2);
			gradesInformation[i][2]=(Object)res.getString(3);
			gradesInformation[i][3]=(Object)res.getString(4);
			gradesInformation[i][4]=(Object)res.getInt(5);
			double grade=res.getDouble(6);
			if(grade==-1 || res.getInt(7)==0) {
				gradesInformation[i][5]=(Object)"N/A";
				gradesInformation[i][6]=(Object)"N/A";
			}
			else {
			gradesInformation[i][5]=(Object)grade;
			if(grade>=50) {
				gradesInformation[i][6]=(Object)"Passed";
			}
			else
			{
				gradesInformation[i][6]=(Object)"Failed";
			}
			}
			i++;
		}
		
		return gradesInformation;
	}

	@Override
	public String[] getStudent(String email,String password) throws SQLException {
		
		String query = "SELECT Id,Fname,Lname,Major,Email,Phone FROM "+ TABLE_STUDENT + " WHERE Email=? AND Password=?";
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
            information[5]=(String)res.getString(6);
        }
       return information;
	}

    @Override
    public ArrayList<UniversityMember> getWaitingAcceptanceStudent() throws SQLException{
        String query = "SELECT Fname, Lname, Major, Password, Email, Phone FROM " + TABLE_STUDENT + " WHERE Accepted = 0";
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
                res.getString(6))
            );
        }
        return unaccepted;
    }

    @Override
    public int acceptStudent(String email, String pass) throws SQLException{
        String query = "UPDATE " + TABLE_STUDENT + " SET Accepted = 1 WHERE Email = ? AND Password = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, email);
        ps.setString(2, pass);
        int res = ps.executeUpdate();
        System.out.println(res);
        return res;
    }

    @Override
    public int unacceptStudent(String email, String pass) throws SQLException{
        String query = "DELETE FROM " + TABLE_STUDENT + " WHERE Email = ? AND Password = ?";
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
		
		Object[][] gradesInformation=new Object[countRows][6];
		int i=0;
		while(res.next()) {
			gradesInformation[i][0]=(Object)res.getInt(1);
			gradesInformation[i][1]=(Object)res.getString(2);
			gradesInformation[i][2]=(Object)res.getString(3);
            gradesInformation[i][3]=(Object)res.getString(4);
			gradesInformation[i][4]=(Object)res.getString(5);
		    gradesInformation[i][5]=(Object)res.getString(6);
			i++;
		}
		
		return gradesInformation;
	}

    @Override
    public Object[][] getStudentsWithId() throws SQLException{
        String query = "SELECT Id,Fname,Lname,Major,Email,Password,Phone FROM "+TABLE_STUDENT+" WHERE Accepted = 1";
        String countRows = "SELECT COUNT(*) FROM "+TABLE_STUDENT+" WHERE Accepted = 1";

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
            acceptedStudents[i][6] = (Object)res.getString("Phone");
            i++;
        }
        return acceptedStudents;
    }

    @Override
    public boolean updateStudent(String[] studentInfo) throws SQLException
    {
        String query = "UPDATE "+TABLE_STUDENT+" SET Fname=?,Lname=?,Major=?,Email=?,Password=?,Phone=? WHERE Id=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1,studentInfo[1]);
        ps.setString(2,studentInfo[2]);
        ps.setString(3,studentInfo[3]);
        ps.setString(4,studentInfo[4]);
        ps.setString(5,studentInfo[5]);
        ps.setString(6,studentInfo[6]);
        ps.setInt(7,Integer.parseInt(studentInfo[0]));

        return ps.executeUpdate()>0;
    }

    @Override
    public boolean addStudentToCourse(String studentId, String courseCode) throws SQLException
    {   
        int courseId = 0;
        try{
                courseId = getCourseId(courseCode);
        }catch(SQLException e){e.printStackTrace();}

        boolean passedCourse = false;
        boolean isStudentInCourse = false;
        try{
            passedCourse = checkStudentGrade(courseCode);
            isStudentInCourse = isStudentInCourse(studentId,courseId);
        }catch(SQLException e){e.printStackTrace();}

        if(passedCourse && !isStudentInCourse)
        {   
            
            //get current year and month
            LocalDate currentDate = LocalDate.now(); 
	        int month=currentDate.getMonthValue();
	        int year=currentDate.getYear();
	        int year2=0;
	        String yearRegister="";
	        if(month>=1 && month<=8) 
	    	{   year2=year-1;
	    	    yearRegister=Integer.toString(year2)+"-"+Integer.toString(year);
	        }
	        else 
	    	{   
                year2=year+1;
	    	    yearRegister=Integer.toString(year)+"-"+Integer.toString(year2);
	        }
	    
             String query = "INSERT INTO "+TABLE_STUDENT_COURSE+" (Id, CourseId,Grade,Year,Submitted) VALUES(?,?,?,?,?)";
             PreparedStatement ps = con.prepareStatement(query);
             ps.setInt(1,Integer.parseInt(studentId));
             ps.setInt(2,courseId);
             ps.setDouble(3,Double.parseDouble("-1"));
             ps.setString(4, yearRegister);
             ps.setInt(5, 0);
             return ps.executeUpdate()>0;
        }

        return false;
    }

    @Override 
    public boolean deleteStudentFromCourse(String studentId, String courseCode) throws SQLException
    {   
        int courseId = 0;
        try{
            courseId = getCourseId(courseCode);
        }catch(SQLException e){e.printStackTrace();}
        String query = "DELETE FROM "+TABLE_STUDENT_COURSE+" WHERE Id = ? AND CourseId = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1,Integer.parseInt(studentId));
        ps.setInt(2,courseId);

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

	@Override
	public Object[][] getStudentSemesterCoursesInformation(String email, String password, int semester)
			throws SQLException {
		// TODO Auto-generated method stub
		String queryCount="SELECT COUNT(studentgrades.Id) FROM studentgrades,student,course WHERE studentgrades.Id=student.Id AND studentgrades.CourseId=course.CourseId AND student.Email=? AND student.Password=? AND course.Semester="+semester+";";
		PreparedStatement sCount=con.prepareStatement(queryCount);
		sCount.setString(1, email);
		sCount.setString(2, password);
		ResultSet resCount=sCount.executeQuery();
		resCount.next();
		int countRows=resCount.getInt(1);
		String query="SELECT "
				+ "    studentgrades.Year, "
				+ "    course.Code, "
				+ "    course.Name, "
				+ "    course.Credits, "
				+ "    studentgrades.Grade, "
				+ "    studentgrades.Submitted "
				+ "FROM "
				+ "    student, "
				+ "    course, "
				+ "    studentgrades "
				+ "WHERE "
				+ "    studentgrades.Id = student.Id AND studentgrades.CourseId = course.CourseId AND student.Email =? AND student.Password =? AND course.Semester = ?";
				
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1, email);
		ps.setString(2, password);
		ps.setInt(3, semester);
		ResultSet res=ps.executeQuery();
		ResultSetMetaData md=res.getMetaData();
		int colCount=md.getColumnCount();
		
		Object[][] gradesInformation=new Object[countRows][colCount+1];
		int i=0;
		while(res.next()) {
			gradesInformation[i][0]=(Object)res.getString(1);
			gradesInformation[i][1]=(Object)res.getString(2);
			gradesInformation[i][2]=(Object)res.getString(3);
			gradesInformation[i][3]=(Object)res.getInt(4);
			double grade=res.getDouble(5);
			if(grade==-1 || res.getInt(6)==0) {
				gradesInformation[i][4]=(Object)"grade not in Acc. history";
				gradesInformation[i][5]=(Object)"grade not in Acc. history";
			}
			else {
			gradesInformation[i][4]=(Object)grade;
			if(grade>=50) {
				gradesInformation[i][5]=(Object)"Passed";
			}
			else
			{
				gradesInformation[i][5]=(Object)"Failed";
			}
			}
			i++;
		}
		
		return gradesInformation;
	}

	@Override
	public List<String> getStudentSemesters(String email, String password) throws SQLException {
		// TODO Auto-generated method stub
		List<String> semestersStudent=new ArrayList<String>();
		String query="SELECT"
				+ "    course.Semester "
				+ "FROM"
				+ "    student, "
				+ "    studentgrades,"
				+ "    course "
				+ "WHERE"
				+ "    studentgrades.Id = student.Id AND studentgrades.CourseId = course.CourseId AND student.Email=? and student.Password=?"
				+ "GROUP BY"
				+ "    course.Semester "
				+ "ORDER BY course.Semester ASC";
		PreparedStatement prep=con.prepareStatement(query);
		prep.setString(1, email);
		prep.setString(2, password);
		ResultSet res=prep.executeQuery();
		
		while(res.next()) {
			semestersStudent.add("Sem"+res.getInt(1));
		}
		return semestersStudent;
	}

    public Object[][] getStudentGrades(String id) throws SQLException
    {   String query = "SELECT COUNT(*) FROM "+TABLE_STUDENT_COURSE+" WHERE Id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1,Integer.parseInt(id));
        ResultSet res = ps.executeQuery();
        res.next();
        int numRows = res.getInt(1);

        query = "SELECT studentgrades.Id,"+
                "student.Fname,student.Lname,"+
                "course.Code,course.Name,"+
                "studentgrades.Grade,studentgrades.Year "+
                "FROM "+TABLE_STUDENT+","+TABLE_COURSE+","+TABLE_STUDENT_COURSE+
                " WHERE student.Id = studentgrades.Id "+
                "AND course.CourseId = studentgrades.CourseId "+
                "AND studentgrades.Id ="+id;
        ps = con.prepareStatement(query);
        res = ps.executeQuery();
        int i=0;
        Object [][] studentGrades = new Object[numRows][7];
        while(res.next())
        {
            studentGrades[i][0] = (Object)res.getInt("Id");
            studentGrades[i][1] = (Object)res.getString("Fname");
            studentGrades[i][2] = (Object)res.getString("Lname");
            studentGrades[i][3] = (Object)res.getString("Code");
            studentGrades[i][4] = (Object)res.getString("Name");
            double grade=res.getFloat("Grade");
            if(grade==-1) {
            	studentGrades[i][5] = (Object)"";
            }
            else {
            	studentGrades[i][5] = (Object)grade;
            }
            studentGrades[i][6] = (Object)res.getString("Year");
            i++;
        }

        return studentGrades;
    }

    public boolean updateStudentGrade(String studentId, String courseCode, String grade) throws SQLException
    {
        
        int courseId = getCourseId(courseCode);

        String update = "UPDATE "+TABLE_STUDENT_COURSE+" SET Grade = ? WHERE Id = ? AND CourseId = ?";
        PreparedStatement ps = con.prepareStatement(update);
        ps.setFloat(1, Float.valueOf(grade));
        ps.setInt(2, Integer.valueOf(studentId));
        ps.setInt(3, courseId);

        return ps.executeUpdate()>0;
    }

	@Override
	public List<Course> getNonRegisteredCourses(String email, String password) throws SQLException {
		// TODO Auto-generated method stub
		List<Course> courses=new ArrayList<>();
		String[] student=this.getStudent(email,password);
		String query="SELECT "
				+"course.Semester,"
				+ "	course.Code,"
				+ "	course.Name,"
                + " course.Prerequisite,"
				+ "	course.Credits,"
				+ "	course.Hours,"
				+ "	course.Major,"
				+ "	course.Year "
				+ " FROM "
				+ "course "
				+ "WHERE "
				+ "    course.Major=? AND course.CourseId NOT IN("
				+ "SELECT "
				+ "course.CourseId "
				+ "FROM "
				+ "student "
				+ "INNER JOIN studentgrades ON studentgrades.Id = student.Id "
				+ "INNER JOIN course ON studentgrades.CourseId = course.CourseId "
				+ "WHERE "
				+ "student.Email =? AND student.Password =?"
				+ ")"
				+ "ORDER BY "
				+ "course.Semester ASC";
		PreparedStatement prep=con.prepareStatement(query);
		prep.setString(1, student[3]);
		prep.setString(2, email);
		prep.setString(3, password);
		ResultSet res=prep.executeQuery();
		while(res.next()) {
			courses.add(new Course(res.getString("Code"), res.getString("Name"),res.getString("Prerequisite"),res.getInt("Credits"), res.getInt("Hours"), res.getString("Major"), res.getInt("Year"),res.getInt("Semester")));
		}
		return courses;
	}

    @Override
    public HashMap<String,String> getStudentEmailPassword(String id) throws SQLException
    {   
        HashMap<String,String> studentInfo = new HashMap<>();
        String query = "SELECT Email,Password FROM "+TABLE_STUDENT+" WHERE Id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, Integer.parseInt(id));
        ResultSet res = ps.executeQuery();
        res.next();
        studentInfo.put("email", res.getString("Email"));
        studentInfo.put("password",res.getString("Password"));

        return studentInfo;

    }

    public boolean checkStudentGrade(String courseCode) throws SQLException
    {   
        double grade = 0.0;
        String query = "SELECT Prerequisite FROM "+TABLE_COURSE+" WHERE Code = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1,courseCode);
        ResultSet res = ps.executeQuery();
        res.next();
        String preRequisite = res.getString("Prerequisite");
        
        if(!preRequisite.equals("none"))
        {
            int courseId = getCourseId(preRequisite);
            System.out.println(courseId);
            String queryGrade = "SELECT Grade FROM "+TABLE_STUDENT_COURSE+" WHERE CourseId = ?";
            ps = con.prepareStatement(queryGrade);
            ps.setInt(1,courseId);
            res = ps.executeQuery();
            res.next();
            grade = res.getDouble("Grade");
            
            return grade>=50;
        }

        return true;   

    }

    public boolean isStudentInCourse(String studentId, int courseId) throws SQLException
    {
        String query = "SELECT COUNT(*) FROM "+TABLE_STUDENT_COURSE+" WHERE Id = ? AND CourseId = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1,Integer.parseInt(studentId));
        ps.setInt(2,courseId);
        ResultSet res = ps.executeQuery();
        res.next();

        return res.getInt(1)>0;
    }

    
}
