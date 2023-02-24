package Factory;

import Model.*;

public class ModelFactory implements Factory {
    private String email, pass;

    public Model createModel(String type){
        switch (type){
            case "AdminCourse": return new AdminCourseModel();
            case "AdminInst": return new AdminInstructorModel();
            case "AdminPanel": return new AdminPanelModel();
            case "AdminStudent": return new AdminStudentModel();
            case "History": return new HistoryModel();
            case "InstCourse": return new InstructorCourseModel();
            case "Login": return new LoginModel();
            case "Register": return new RegisterModel();
            case "StudentTrans": return new StudentTranscriptModel(email, pass);
            default: return null;
        }
    }

    public void setInfo(String email, String pass){
        this.email = email;
        this.pass = pass;
    }
}
