package View;
import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;
import javax.swing.SpringLayout;
import javax.swing.text.FlowView;

import java.awt.*;
import java.net.PasswordAuthentication;

public class Login{
    //Icons
    private ImageIcon logo;
    private ImageIcon userLogo;
    private ImageIcon mailLogo;
    private ImageIcon keyLogo;

    //input fields
    private JTextField emailField;
    private JPasswordField passwordField;
    private JComboBox userMode;

    //Labels for Icons
    private JLabel mainIcon;
    private JLabel welcomeLabel;
    private JLabel emailIcon;
    private JLabel passwordIcon;
    private JLabel userIcon;

    //Labels for input fields
    private JLabel enterEmail;
    private JLabel enterPassword;

    //Buttons
    private JButton loginButton;
    private JButton registerButton;

    //Panels
    private JFrame loginFrame;
    private JPanel head;
    private JPanel center;
    private JPanel foot;
    private SpringLayout springLayout;

    public Login()
    {   
        //Initializations
        logo = new ImageIcon("INFO404-PROJECT/Images/main_Icon.png");
        userLogo = new ImageIcon("INFO404-PROJECT/Images/person.png");
        mailLogo = new ImageIcon("INFO404-PROJECT/Images/mail.png");
        keyLogo = new ImageIcon("INFO404-PROJECT/Images/key.png");
        emailField = new JTextField(15);
        passwordField = new JPasswordField(15);
        userMode = new JComboBox<String>(new String[]{"Select User Mode","Admin","Student","Instructor"});
        mainIcon = new JLabel(logo);
        welcomeLabel = new JLabel("Welcome to Login Page");
        emailIcon = new JLabel(mailLogo);
        passwordIcon = new JLabel(keyLogo);
        userIcon = new JLabel(userLogo);
        enterEmail = new JLabel("Enter Email");
        enterPassword = new JLabel("Enter Password");
        loginButton = new JButton("Login");
        registerButton = new JButton("Register");
        
        loginFrame = new JFrame();
        head = new JPanel();
        center = new JPanel();
        foot = new JPanel();

        //Layouts and designs
        loginFrame.setLayout(new FlowLayout(FlowLayout.CENTER,0,5));
        loginFrame.getContentPane().setBackground(new Color(114,128,255));
        registerButton.setBackground(Color.GREEN);
        loginButton.setBackground(Color.red);
        welcomeLabel.setFont(new Font("Arial",Font.BOLD,18));
        emailField.setFont(new Font("Arial",Font.PLAIN,17));
        passwordField.setFont(new Font("Arial",Font.PLAIN,17));
        userMode.setFont(new Font("Arial",Font.PLAIN,17));
        
        head.setLayout(new BoxLayout(head,BoxLayout.Y_AXIS));
        head.setPreferredSize(new Dimension(400,150));
        head.setBackground(new Color(114,128,255));

        springLayout = new SpringLayout();
        center.setPreferredSize(new Dimension(400,250));
        center.setBackground(new Color(114,128,255));
        center.setLayout(springLayout);
        springLayout.putConstraint(SpringLayout.WEST, userIcon, 50, SpringLayout.WEST, loginFrame);
        springLayout.putConstraint(SpringLayout.WEST, emailIcon, 50, SpringLayout.WEST, loginFrame);
        springLayout.putConstraint(SpringLayout.WEST, passwordIcon, 50, SpringLayout.WEST, loginFrame);
        
        springLayout.putConstraint(SpringLayout.WEST, userMode, 50, SpringLayout.EAST, userIcon);
        springLayout.putConstraint(SpringLayout.WEST, emailField, 50, SpringLayout.EAST, emailIcon);
        springLayout.putConstraint(SpringLayout.WEST, passwordField, 50, SpringLayout.EAST, passwordIcon);

        springLayout.putConstraint(SpringLayout.NORTH, userMode, 25, SpringLayout.NORTH, loginFrame);
        springLayout.putConstraint(SpringLayout.NORTH, emailField, 40, SpringLayout.SOUTH, userMode);
        springLayout.putConstraint(SpringLayout.NORTH, passwordField, 43, SpringLayout.SOUTH, emailField);
        springLayout.putConstraint(SpringLayout.NORTH, userIcon, 10, SpringLayout.NORTH, loginFrame);
        springLayout.putConstraint(SpringLayout.NORTH, emailIcon, 25, SpringLayout.SOUTH, userIcon);
        springLayout.putConstraint(SpringLayout.NORTH, passwordIcon, 25, SpringLayout.SOUTH, emailIcon);
        
        springLayout.putConstraint(SpringLayout.SOUTH, enterEmail, 0, SpringLayout.NORTH, emailField);
        springLayout.putConstraint(SpringLayout.SOUTH, enterPassword, 0, SpringLayout.NORTH, passwordField);
        springLayout.putConstraint(SpringLayout.WEST, enterEmail, 53, SpringLayout.EAST, emailIcon);
        springLayout.putConstraint(SpringLayout.WEST, enterPassword, 53, SpringLayout.EAST, passwordIcon);

        foot.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
        foot.setPreferredSize(new Dimension(400,70));
        foot.setBackground(new Color(114,128,255));

        welcomeLabel.setAlignmentX(Box.CENTER_ALIGNMENT);
        mainIcon.setAlignmentX(Box.CENTER_ALIGNMENT);

        //adding components to Panels
        head.add(Box.createRigidArea(new Dimension(400,20)));
        head.add(welcomeLabel);
        head.add(Box.createRigidArea(new Dimension(400,30)));
        head.add(mainIcon);

        center.add(userIcon);
        center.add(userMode);
        center.add(emailIcon);
        center.add(emailField);
        center.add(passwordIcon);
        center.add(passwordField);
        center.add(enterEmail);
        center.add(enterPassword);
        
        foot.add(loginButton);
        foot.add(registerButton);

        loginFrame.add(head);
        loginFrame.add(center);
        loginFrame.add(foot);

        loginFrame.setTitle("Login Page");
        loginFrame.setSize(500,520);
        loginFrame.setLocationRelativeTo(null);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setVisible(true);
        
    }

  public JComboBox getUserModeField()
  {
    return this.userMode;
  }

  public JTextField getEmailField()
  {
    return this.emailField;
  }

  public JPasswordField getPasswordField()
  {
    return this.passwordField;
  }

  public JButton getLoginButton()
  {
    return this.loginButton;
  }

  public JButton getRegisterButton()
  {
    return this.registerButton;
  }
}
