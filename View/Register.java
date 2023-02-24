package View;

import javax.swing.*;
import java.awt.*;

public class Register implements View{
    //Icons
    private ImageIcon logo;
    private ImageIcon userLogo;
    private ImageIcon keyLogo;
    private ImageIcon mailLogo;
    private ImageIcon phoneLogo;
    private ImageIcon userModeLogo;

    //input fields
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JPasswordField passwordField;
    private JTextField emailField;
    private JTextField phoneNumberField;
    private JComboBox<String> userModeField;
    private JComboBox<String> userMajorField;

    //Labels for Icons
    private JLabel mainIcon;
    private JLabel userIcon1;
    private JLabel userIcon2;
    private JLabel passwordIcon;
    private JLabel emailIcon;
    private JLabel phoneIcon;
    private JLabel userModeIcon;

    //Labels for Input Fields
    private JLabel welcomeLabel;
    private JLabel fnameLabel;
    private JLabel lnameLabel;
    private JLabel passwordLabel;
    private JLabel emailLabel;
    private JLabel phoneLabel;

    //Buttons
    private JButton registerButton;
    private JButton loginButton;

    //Panels
    private JFrame registerFrame;
    private JPanel head;
    private JPanel center;
    private JPanel foot;
    private SpringLayout springLayout;
    
    //font and Color
    private Font font;
    private Color color;

    public Register()
    {   
        //Initializations
        logo = new ImageIcon("./Images/main_Icon.png");
        userModeLogo = new ImageIcon("./Images/person.png");
        mailLogo = new ImageIcon("./Images/mail.png");
        keyLogo = new ImageIcon("./Images/key.png");
        phoneLogo = new ImageIcon("./Images/phone.png");
        userLogo = new ImageIcon("./Images/user.png");
        font = new Font("Arial",Font.PLAIN,17);
        color = new Color(83,131,255);
        firstNameField = new JTextField(15);
        lastNameField = new JTextField(15);
        passwordField = new JPasswordField(15);
        emailField = new JTextField(15);
        phoneNumberField = new JTextField(15);
        userModeField = new JComboBox<String>(new String[]{"Select User Mode","Student","Instructor"});
        userMajorField = new JComboBox<String>(new String[]{"Select Major","Informatics","Math","Physics","Biology","Chemistry", "BioChemistry"});
        userMajorField.setVisible(false);
        mainIcon = new JLabel(logo);
        emailIcon = new JLabel(mailLogo);
        passwordIcon = new JLabel(keyLogo);
        phoneIcon = new JLabel(phoneLogo);
        userIcon1 = new JLabel(userLogo);
        userIcon2 = new JLabel(userLogo);
        userModeIcon = new JLabel(userModeLogo);
        welcomeLabel = new JLabel("Welcome to SignUp Page");
        fnameLabel = new JLabel("First Name");
        lnameLabel = new JLabel("Last Name");
        passwordLabel = new JLabel("Password");
        emailLabel = new JLabel("Email");
        phoneLabel = new JLabel("Phone");
        loginButton = new JButton("Login");
        registerButton = new JButton("Register");

        registerFrame = new JFrame();
        head = new JPanel();
        center = new JPanel();
        foot = new JPanel();
        
        //Layouts and Designs
        registerFrame.setLayout(new BorderLayout());
        registerFrame.getContentPane().setBackground(color);
        registerButton.setBackground(Color.GREEN);
        loginButton.setBackground(Color.red);
        
        welcomeLabel.setFont(new Font("Arial",Font.BOLD,18));
        firstNameField.setFont(font);
        lastNameField.setFont(font);
        passwordField.setFont(font);
        emailField.setFont(font);
        phoneNumberField.setFont(font);
        userModeField.setFont(font);
        userMajorField.setFont(font);

        head.setLayout(new BoxLayout(head,BoxLayout.Y_AXIS));
        head.setPreferredSize(new Dimension(400,150));
        head.setBackground(color);

        springLayout = new SpringLayout();
        center.setPreferredSize(new Dimension(400,550));
        center.setBackground(color);
        center.setLayout(springLayout);
        springLayout.putConstraint(SpringLayout.WEST, userIcon1, 85, SpringLayout.WEST, registerFrame);
        springLayout.putConstraint(SpringLayout.WEST, userIcon2, 85, SpringLayout.WEST, registerFrame);
        springLayout.putConstraint(SpringLayout.WEST, passwordIcon, 85, SpringLayout.WEST, registerFrame);
        springLayout.putConstraint(SpringLayout.WEST, emailIcon, 85, SpringLayout.WEST, registerFrame);
        springLayout.putConstraint(SpringLayout.WEST, phoneIcon, 85, SpringLayout.WEST, registerFrame);
        springLayout.putConstraint(SpringLayout.WEST, userModeIcon, 85, SpringLayout.WEST, registerFrame);
        
        springLayout.putConstraint(SpringLayout.WEST, firstNameField, 30, SpringLayout.EAST, userIcon1);
        springLayout.putConstraint(SpringLayout.WEST, lastNameField, 30, SpringLayout.EAST, userIcon2);
        springLayout.putConstraint(SpringLayout.WEST, passwordField, 30, SpringLayout.EAST, passwordIcon);
        springLayout.putConstraint(SpringLayout.WEST, emailField, 30, SpringLayout.EAST, emailIcon);
        springLayout.putConstraint(SpringLayout.WEST, phoneNumberField, 30, SpringLayout.EAST, phoneIcon);
        springLayout.putConstraint(SpringLayout.WEST, userModeField, 30, SpringLayout.EAST, userModeIcon);
        springLayout.putConstraint(SpringLayout.WEST, userMajorField, 145, SpringLayout.WEST, registerFrame);

        springLayout.putConstraint(SpringLayout.NORTH, firstNameField, 35, SpringLayout.NORTH, registerFrame);
        springLayout.putConstraint(SpringLayout.NORTH, lastNameField, 40, SpringLayout.SOUTH, firstNameField);
        springLayout.putConstraint(SpringLayout.NORTH, emailField, 43, SpringLayout.SOUTH, lastNameField);
        springLayout.putConstraint(SpringLayout.NORTH, passwordField, 43, SpringLayout.SOUTH, emailField);
        springLayout.putConstraint(SpringLayout.NORTH, phoneNumberField, 43, SpringLayout.SOUTH, passwordField);
        springLayout.putConstraint(SpringLayout.NORTH, userModeField, 43, SpringLayout.SOUTH, phoneNumberField);
        springLayout.putConstraint(SpringLayout.NORTH, userMajorField, 43, SpringLayout.SOUTH, userModeField);
        springLayout.putConstraint(SpringLayout.NORTH, userIcon1, 34, SpringLayout.NORTH, registerFrame);
        springLayout.putConstraint(SpringLayout.NORTH, userIcon2, 38, SpringLayout.SOUTH, userIcon1);
        springLayout.putConstraint(SpringLayout.NORTH, emailIcon, 43, SpringLayout.SOUTH, userIcon2);
        springLayout.putConstraint(SpringLayout.NORTH, passwordIcon, 42, SpringLayout.SOUTH, emailIcon);
        springLayout.putConstraint(SpringLayout.NORTH, phoneIcon, 42, SpringLayout.SOUTH, passwordIcon);
        springLayout.putConstraint(SpringLayout.NORTH, userModeIcon, 40, SpringLayout.SOUTH, phoneIcon);
        
        springLayout.putConstraint(SpringLayout.SOUTH, fnameLabel, 0, SpringLayout.NORTH, firstNameField);
        springLayout.putConstraint(SpringLayout.SOUTH, lnameLabel, 0, SpringLayout.NORTH, lastNameField);
        springLayout.putConstraint(SpringLayout.SOUTH, passwordLabel, 0, SpringLayout.NORTH, passwordField);
        springLayout.putConstraint(SpringLayout.SOUTH, emailLabel, 0, SpringLayout.NORTH, emailField);
        springLayout.putConstraint(SpringLayout.SOUTH, phoneLabel, 0, SpringLayout.NORTH, phoneNumberField);
        springLayout.putConstraint(SpringLayout.WEST, fnameLabel, 33, SpringLayout.EAST, userIcon1);
        springLayout.putConstraint(SpringLayout.WEST, lnameLabel, 33, SpringLayout.EAST, userIcon2);
        springLayout.putConstraint(SpringLayout.WEST, passwordLabel, 33, SpringLayout.EAST, passwordIcon);
        springLayout.putConstraint(SpringLayout.WEST, emailLabel, 33, SpringLayout.EAST, emailIcon);
        springLayout.putConstraint(SpringLayout.WEST, phoneLabel, 33, SpringLayout.EAST, phoneIcon);

        foot.setLayout(new BoxLayout(foot, BoxLayout.X_AXIS));
        foot.setPreferredSize(new Dimension(400,100));
        foot.setBackground(color);

        welcomeLabel.setAlignmentX(Box.CENTER_ALIGNMENT);
        mainIcon.setAlignmentX(Box.CENTER_ALIGNMENT);

        //Adding Components to Panels
        head.add(Box.createRigidArea(new Dimension(400,30)));
        head.add(welcomeLabel);
        head.add(Box.createRigidArea(new Dimension(400,30)));
        head.add(mainIcon);

        center.add(userIcon1);
        center.add(userIcon2);
        center.add(passwordIcon);
        center.add(emailIcon);
        center.add(phoneIcon);
        center.add(userModeIcon);
        center.add(firstNameField);
        center.add(lastNameField);
        center.add(passwordField);
        center.add(emailField);
        center.add(phoneNumberField);
        center.add(userModeField);
        center.add(userMajorField);
        center.add(fnameLabel);
        center.add(lnameLabel);
        center.add(passwordLabel);
        center.add(emailLabel);
        center.add(phoneLabel);

        foot.add(Box.createRigidArea(new Dimension(150,100)));
        foot.add(loginButton);
        foot.add(registerButton);
        foot.add(Box.createRigidArea(new Dimension(150,100)));
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        registerButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        
        registerFrame.add(head, BorderLayout.NORTH);
        registerFrame.add(center, BorderLayout.CENTER);
        registerFrame.add(foot, BorderLayout.SOUTH);

        registerFrame.setTitle("SignUp Page");
        registerFrame.setSize(490,800);
        registerFrame.setLocationRelativeTo(null);
        registerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        registerFrame.setVisible(true);
        
    }

    public JTextField getFirstNameField()
    {
        return this.firstNameField;
    }

    public JTextField getLastNameField()
    {
        return this.lastNameField;
    }

    public JPasswordField getPasswordField()
    {
        return this.passwordField;
    }

    public JTextField getEmailField()
    {
        return this.emailField;
    }

    public JTextField getPhoneNumberField()
    {
        return this.phoneNumberField;
    }

    public JComboBox<String> getUserModeField()
    {
        return this.userModeField;
    }

    public JComboBox<String> getUserMajorField()
    {
        return this.userMajorField;
    }

    public JButton getRegisterButton()
    {
        return this.registerButton;
    }

    public JButton getLoginButton()
    {
        return this.loginButton;
    }

    public JFrame getRegisterFrame()
    {
        return this.registerFrame;
    }

    public void displayMessage(String message)
    {
        JOptionPane.showMessageDialog(registerFrame, message);
    }
}
