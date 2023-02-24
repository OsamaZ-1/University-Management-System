package Factory;

import java.sql.SQLException;
import Controller.*;

public class ControllerFactory implements Factory{
    private String email, pass;

    public Controller createController(String type) throws SQLException{
        switch (type){
            case "AdminCourse": return new AdminCourseController();
            case "AdminInst": return new AdminInstructorController();
            case "AdminPanel": return new AdminPanelController();
            case "AdminStudent": return new AdminStudentController();
            case "History": return new HistoryController();
            case "Inst": return new InstructorController(email, pass);
            case "Login": return new LoginController();
            case "Register": return new RegisterController();
            case "StudentTrans": return new StrudentTranscriptController(email, pass);
            default: return null;
        }        
    }

    public void setInfo(String email, String pass){
        this.email = email;
        this.pass = pass;
    }
}
