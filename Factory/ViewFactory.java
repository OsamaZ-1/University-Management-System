package Factory;

import View.*;

public class ViewFactory implements Factory {
    public View createView(String type){
        switch (type){
            case "AdminCourse": return new AdminCourseView();
            case "AdminInstManage": return new AdminInstManageView();
            case "AdminInst": return new AdminInstructorView();
            case "AdminPanel": return new AdminPanel();
            case "AdminStudentCourse": return new AdminStudentCourseView();
            case "AdminStudentGrades": return new AdminStudentGradesView();
            case "AdminStudent": return new AdminStudentView();
            case "History": return new HistoryView();
            case "InstPanel": return new InstructorPanelView();
            case "Login": return new Login();
            case "Register": return new Register();
            case "StudentFinalTrans": return new StudentFinalTranscriptView();
            case "StudentTrans": return new StudentTranscriptView();
            default: return null;
        }
    }
}
