package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import Model.LoginModel;
import View.Login;

public class LoginController {
    private LoginModel loginModel;
    private Login loginView;

    public LoginController(){
        loginModel = new LoginModel();
        loginView = new Login();

        logStudentIn();
        goToRegisterPage();
    }

    public void logStudentIn(){
        loginView.getLoginButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String email = loginView.getEmailField().getText();
                String pass = loginView.getPasswordField().getText().toString();
                int userMode = loginView.getUserModeField().getSelectedIndex();

                try{
                    int res = -2;
                    if (userMode == 2)
                        res = loginModel.getLoginStudent(email, pass);
                    else if (userMode == 3)
                        res = loginModel.getLoginInstructor(email, pass);

                    if (res == -1){
                        loginView.displayErrorMessage(); //Wrong Credentials
                    }
                    else if (res == 0){
                        //student was not accepted yet
                        System.out.println("Wait until acceptance");
                    }
                    else if (res == 1){
                        //successfull login
                        System.out.println("Student Login Succeeded");
                        loginView.getLoginFrame().dispose();
                        new StrudentTranscriptController(email,pass);
                    }
                    else if (res == 2){
                        System.out.println("Instructor Login Succeeded");
                    }
                    else if (res == -2){
                        //user mode not selected
                        System.out.println("You must select the User Mode.");
                    }
                }catch(SQLException e1) {e1.printStackTrace();}
            }
        });
    }

    public void goToRegisterPage(){
        loginView.getRegisterButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                loginView.getLoginFrame().dispose();
                new RegisterController();
            }
        });
    }
}
