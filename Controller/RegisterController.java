package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.regex.*;

import Model.Instructor;
import Model.RegisterModel;
import Model.Student;
import Model.UniversityMember;
import View.Register;
import Factory.*;

public class RegisterController implements Controller{

    private RegisterModel registerModel;
    private Register registerView;

    private ControllerFactory cf = (ControllerFactory) FactoryProducer.createFactory("Controller");
    private ModelFactory mf = (ModelFactory) FactoryProducer.createFactory("Model");
    private ViewFactory vf = (ViewFactory) FactoryProducer.createFactory("View");

    public RegisterController(){
        registerModel = (RegisterModel) mf.createModel("Register");
        registerView = (Register) vf.createView("Register");

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
                String phone= registerView.getPhoneNumberField().getText().toString();
                int testPhoneEmail = 2;
                
                Pattern pattern = Pattern.compile("^(03|70|71|76|81)(\\d{6})$");
                Matcher matcher = pattern.matcher(phone);
                Boolean phoneNumberValid = matcher.matches();

                pattern = Pattern.compile("^[a-zA-Z]+[a-zA-Z0-9]*[.-_]?[a-zA-Z0-9]+@(hotmail|gmail)\\.com$");
                matcher = pattern.matcher(email);
                Boolean emailValid = matcher.matches();

                if(!phoneNumberValid)
                {   
                    registerView.displayMessage("Invalid phone number, only enter 8 digit valid number");
                    testPhoneEmail--;
                }
                if(!emailValid)
                {   
                    registerView.displayMessage("Invalid email address, use only (Letters, numbers, . , - , _) @ (hotmail or gmail) .com");
                    testPhoneEmail--;
                }

                if(!fName.equals("") && !lName.equals("") && !password.equals("") && !email.equals("") && testPhoneEmail==2)
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
                    registerView.displayMessage("Make sure you enter all information Correclty");
            }
        });  
    }

    public void goToLoginPage(){
        registerView.getLoginButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                registerView.getRegisterFrame().dispose();
                try{
                    cf.createController("Login");
                } catch (SQLException e1){
                    e1.printStackTrace();
                }
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
