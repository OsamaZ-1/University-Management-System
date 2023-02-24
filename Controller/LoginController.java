package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import Model.LoginModel;
import View.Login;
import Factory.*;

public class LoginController implements Controller{
    private LoginModel loginModel;
    private Login loginView;

    private ControllerFactory cf = (ControllerFactory) FactoryProducer.createFactory("Controller");
    private ModelFactory mf = (ModelFactory) FactoryProducer.createFactory("Model");
    private ViewFactory vf = (ViewFactory) FactoryProducer.createFactory("View");

    public LoginController(){
        loginModel = (LoginModel) mf.createModel("Login");
        loginView = (Login) vf.createView("Login");

        logMemberIn();
        goToRegisterPage();
    }

    public void logMemberIn(){
        loginView.getLoginButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String email = loginView.getEmailField().getText();
                String pass = loginView.getPasswordField().getText().toString();
                String userMode = loginView.getUserModeField().getSelectedItem().toString();
                int res = 0;
                if(!email.equals("") && !pass.equals("") && !userMode.equals("Select User Mode"))
                {
                    try{
                         res = loginModel.loginMember(email, pass, userMode);
                    
                        
                        if (res == -1)
                             loginView.displayMessage("Wrong Credentials!!!"); //Wrong Credentials
                        else if (res == 0)//member was not accepted yet
                             loginView.displayMessage("You have not been accepted yet.");
                        else if (res == 1)
                             {  //successfull student login
                                loginView.getLoginFrame().dispose();
                                cf.setInfo(email, pass);
                                cf.createController("StudentTrans");
                             }
                        else if (res == 2)
                             {  //successfull instructor login
                                loginView.getLoginFrame().dispose();
                                cf.setInfo(email, pass);
                                cf.createController("Inst");
                             }
                        else if (res == 3)
                             {   //successfull admin login
                                loginView.getLoginFrame().dispose();
                                cf.createController("AdminPanel");
                             }
                    }catch(SQLException ex){ex.printStackTrace();}
                }
                else
                    loginView.displayMessage("Make sure you fill all information and choose a mode");
            }
        });
    }

    public void goToRegisterPage(){
        loginView.getRegisterButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                loginView.getLoginFrame().dispose();
                try{
                    cf.createController("Register");
                } catch (SQLException e1){
                    e1.printStackTrace();
                }
            }
        });
    }
}
