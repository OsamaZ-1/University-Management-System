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
                    int res = loginModel.loginMember(email, pass, userMode);

                    if (res == -1){
                        loginView.displayErrorMessage("Wrong Credentials!!!"); //Wrong Credentials
                    }
                    else if (res == 0){
                        //member was not accepted yet
                        loginView.displayErrorMessage("You have not been accepted yet.");
                    }
                    else if (res == 1){
                        //successfull student login
                        loginView.getLoginFrame().dispose();
                        new StrudentTranscriptController(email,pass);
                    }
                    else if (res == 2){
                        //successfull instructor login
                        loginView.getLoginFrame().dispose();
                        new InstructorController(email,pass);
                    }
                    else if (res == 3){
                        //successfull admin login
                        loginView.getLoginFrame().dispose();
                        new AdminPanelController();
                    }
                    else if (res == -2){
                        //user mode not selected
                        loginView.displayErrorMessage("You must select the User Mode.");
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
