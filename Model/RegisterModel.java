package Model;

import java.sql.SQLException;

import DAO.InstructorDaoImplementation;
import DAO.StudentDaoImplementation;

public class RegisterModel implements Model{
    private StudentDaoImplementation stdDao = new StudentDaoImplementation();
    private InstructorDaoImplementation instDao = new InstructorDaoImplementation();

    public int registerMember(UniversityMember uniMember, String userMode) throws SQLException {
        if(userMode.equals("Student")){
            Student s = (Student)uniMember;
            if(stdDao.studentEmailPhoneExist(s.getEmail(),s.getPhone())>0) //Student email or phone number already exists "student has account"
                return 0;
            return stdDao.add(s);
        }
        // at this point, the user is an instructor

        Instructor instructor = (Instructor)uniMember;
        if(instDao.instructorEmailPhoneExist(instructor.getEmail(),instructor.getPhone())>0) //Instructor email or phone number already exists "Instructor has account"
            return 0;
        return instDao.add(instructor);
    }
}