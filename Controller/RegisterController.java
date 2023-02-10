package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;

import javax.lang.model.util.ElementScanner14;
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
                String fName = registerView.getFirstNameField().getText().toString();
                String lName = registerView.getLastNameField().getText().toString();
                String major = String.valueOf(registerView.getUserMajorField().getSelectedItem());
                String password = registerView.getPasswordField().getText().toString();
                String email = registerView.getEmailField().getText().toString();
                int phone=0;
                Boolean phoneNumberValid = true;
                try{
                     phone = Integer.parseInt(registerView.getPhoneNumberField().getText().toString());
                }catch(NumberFormatException ex){phoneNumberValid=false;ex.printStackTrace();}

                if(!fName.equals("") && !lName.equals("") && !password.equals("") && !email.equals("") && phoneNumberValid)
                {
                    if((registerView.getUserModeField().getSelectedItem().toString().equals("Student")) && !major.equals("Select Major"))
                    {   // register student
                         UniversityMember uniMember = new Student(fName, lName, major, email, password,phone);
                        try {
                            if(registerModel.registerMember(uniMember,"Student")==0)
                                registerView.displayMessage("Student with same Email or Phone Number already exists");
                            else    
                                {   
                                    refreshPage();
                                    registerView.displayMessage("Successfully Registered");
                                }
                         } catch (SQLException e1) {e1.printStackTrace();}
                    }
                    else if(registerView.getUserModeField().getSelectedItem().toString().equals("Instructor"))
                    {   // register instructor
                        UniversityMember uniMember = new Instructor(fName, lName, email, password, phone);
                        try {
                            if(registerModel.registerMember(uniMember,"Instructor")==0)
                                registerView.displayMessage("Instructor with same Email or Phone Number already exists");
                            else    
                                {   
                                    refreshPage();
                                    registerView.displayMessage("Successfully Registered");
                                }
                        } catch (SQLException e1) {e1.printStackTrace();}
                    }
                    else
                        registerView.displayMessage("You must choose user mode and a major if you are a student");
                }
                else
                    registerView.displayMessage("Make sure you enter all information and provide a valid phone number");
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
                String mode = String.valueOf(registerView.getUserModeField().getSelectedItem());
                if(mode.equals("Student"))
                    registerView.getUserMajorField().setVisible(true);
                else
                    registerView.getUserMajorField().setVisible(false);    
            }
        });
    }

    public void refreshPage()
    {
        registerView.getFirstNameField().setText("");
        registerView.getLastNameField().setText("");
        registerView.getEmailField().setText("");
        registerView.getPasswordField().setText("");
        registerView.getPhoneNumberField().setText("");
        registerView.getUserModeField().setSelectedIndex(0);
        
    }
}
