package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import Model.RegisterModel;
import Model.Student;
import View.Register;

public class RegisterController {

    private RegisterModel registerModel;
    private Register registerView;

    public RegisterController(){
        registerModel = new RegisterModel();
        registerView = new Register();
    }

    public void registerStudent(){
        registerView.getRegisterButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Fname = registerView.getFirstNameField().getText();
                String Lname = registerView.getLastNameField().getText();
                String password = registerView.getPasswordField().getText().toString();
                String email = registerView.getEmailField().getText();
                int phone = Integer.parseInt(registerView.getPhoneNumberField().getText().toString());
                Student s = new Student(Fname, Lname, password, email, phone);
                try {
                    registerModel.registerStudent(s);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });  
    }

}
