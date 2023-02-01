package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Model.Instructor;
import Model.RegisterModel;
import Model.Student;
import Model.UniversityMember;
import View.Register;

public class RegisterController {

    private RegisterModel registerModel;
    private Register registerView;

    public RegisterController(){
        registerModel = new RegisterModel();
        registerView = new Register();

        registerMember();
        goToLoginPage();
        userModeListener();
    }

    public void registerMember(){
        registerView.getRegisterButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Fname = registerView.getFirstNameField().getText();
                String Lname = registerView.getLastNameField().getText();
                String Major = String.valueOf(registerView.getUserMajorField().getSelectedItem());
                String password = registerView.getPasswordField().getText().toString();
                String email = registerView.getEmailField().getText();
                int phone = Integer.parseInt(registerView.getPhoneNumberField().getText().toString());
                
                if(registerView.getUserModeField().getSelectedIndex()==1){
                    // register student
                    UniversityMember uniMember = new Student(Fname, Lname, Major, email, password,phone);
                    try {
                        if(registerModel.registerMember(uniMember,"Student")==0)
                            registerView.displayErrorMessage();
                        else    
                            registerView.displaySuccessMessage();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
                else if(registerView.getUserModeField().getSelectedIndex()==2){
                    // register instructor
                    UniversityMember uniMember = new Instructor(Fname, Lname, password, email, phone);
                    try {
                        if(registerModel.registerMember(uniMember,"Instructor")==0)
                            registerView.displayErrorMessage();
                        else    
                            registerView.displaySuccessMessage();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });  
    }

    public void goToLoginPage(){
        registerView.getLoginButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                registerView.getRegisterFrame().dispose();
                new LoginController();
            }
        });
    }

    public void userModeListener()
    {
        registerView.getUserModeField().addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e) {
                // TODO Auto-generated method stub
                String mode = String.valueOf(registerView.getUserModeField().getSelectedItem());
                if(mode.equals("Student"))
                    registerView.getUserMajorField().setVisible(true);
                else
                    registerView.getUserMajorField().setVisible(false);    
            }
        });
    }
}
