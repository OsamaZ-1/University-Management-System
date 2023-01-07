package Model;

import java.sql.SQLException;

import DAO.InstructorDaoImplementation;
import DAO.StudentDaoImplementation;

public class RegisterModel {
    StudentDaoImplementation stdDao = new StudentDaoImplementation();
    InstructorDaoImplementation instDao = new InstructorDaoImplementation();
    public int registerMember(UniversityMember uniMember, String userMode) throws SQLException {
        if(userMode.equals("Student")){
            Student s = (Student)uniMember;
        if(stdDao.studentEmailExist(s.getEmail()) == 1) //Student email already exists "student has account"
            return 0;
        return stdDao.add(s);
    }
        // at this point, the user is an instructor

        Instructor instructor = (Instructor)uniMember;
        if(instDao.instructorEmailExist(instructor.getEmail()) == 1) //Instructor email already exists "Instructor has account"
            return 0;
        return instDao.add(instructor);
    }
}