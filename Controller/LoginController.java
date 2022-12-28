package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import Model.LoginModel;
import Model.Student;
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
                try{
                    int res = loginModel.getLoginStudent(email, pass);
                    if (res == -1){
                        //display not found error
                        System.out.println("User not found.");
                        System.out.println(pass + ' ' + email);
                    }
                    else if (res == 0){
                        //student was not accepted yet
                        System.out.println("Wait until acceptance");
                    }
                    else{
                        //take student to Transcript page
                        System.out.println("Transcript diplayed!");
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
