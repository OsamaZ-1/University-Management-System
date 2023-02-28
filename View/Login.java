package View;
import javax.swing.*;
import java.awt.*;

public class Login implements View{
    //Icons
    private ImageIcon logo;
    private ImageIcon userLogo;
    private ImageIcon mailLogo;
    private ImageIcon keyLogo;

    //Input Fields
    private JTextField emailField;
    private JPasswordField passwordField;
    private JComboBox<String> userModeField;

    //Labels for Icons
    private JLabel mainIcon;
    private JLabel emailIcon;
    private JLabel passwordIcon;
    private JLabel userIcon;

    //Labels for Input Fields
    private JLabel welcomeLabel;
    private JLabel emailLabel;
    private JLabel passwordLabel;

    //Buttons
    private JButton loginButton;
    private JButton registerButton;

    //Panels
    private JFrame loginFrame;
    private JPanel head;
    private JPanel center;
    private JPanel foot;
    private SpringLayout springLayout;

    //Font and color
    private Font font;
    private Color color;
    public Login()
    {   
        //Initializations
        logo = new ImageIcon("./Images/main_Icon.png");
        userLogo = new ImageIcon("./Images/person.png");
        mailLogo = new ImageIcon("./Images/mail.png");
        keyLogo = new ImageIcon("./Images/key.png");
        font = new Font("Arial",Font.PLAIN,17);
        color = new Color(83,131,255);
        emailField = new JTextField(15);
        passwordField = new JPasswordField(15);
        userModeField = new JComboBox<String>(new String[]{"Select User Mode","Admin","Student","Instructor"});
        welcomeLabel = new JLabel("Welcome to Login Page");
        mainIcon = new JLabel(logo);
        emailIcon = new JLabel(mailLogo);
        passwordIcon = new JLabel(keyLogo);
        userIcon = new JLabel(userLogo);
        emailLabel = new JLabel("Email");
        passwordLabel = new JLabel("Password");
        loginButton = new JButton("Login");
        registerButton = new JButton("Register");
        
        loginFrame = new JFrame();
        head = new JPanel();
        center = new JPanel();
        foot = new JPanel();

        //Layouts and Designs
        loginFrame.setLayout(new BorderLayout());
        loginFrame.getContentPane().setBackground(color);
        registerButton.setBackground(Color.GREEN);
        loginButton.setBackground(Color.red);
        welcomeLabel.setFont(new Font("Arial",Font.BOLD,18));
        emailField.setFont(font);
        passwordField.setFont(font);
        userModeField.setFont(font);
        
        head.setLayout(new BoxLayout(head,BoxLayout.Y_AXIS));
        head.setPreferredSize(new Dimension(400,150));
        head.setBackground(color);

        springLayout = new SpringLayout();
        center.setPreferredSize(new Dimension(400,250));
        center.setBackground(color);
        center.setLayout(springLayout);
        springLayout.putConstraint(SpringLayout.WEST, userIcon, 80, SpringLayout.WEST, loginFrame);
        springLayout.putConstraint(SpringLayout.WEST, emailIcon, 80, SpringLayout.WEST, loginFrame);
        springLayout.putConstraint(SpringLayout.WEST, passwordIcon, 80, SpringLayout.WEST, loginFrame);
        
        springLayout.putConstraint(SpringLayout.WEST, userModeField, 30, SpringLayout.EAST, userIcon);
        springLayout.putConstraint(SpringLayout.WEST, emailField, 30, SpringLayout.EAST, emailIcon);
        springLayout.putConstraint(SpringLayout.WEST, passwordField, 30, SpringLayout.EAST, passwordIcon);

        springLayout.putConstraint(SpringLayout.NORTH, userModeField, 25, SpringLayout.NORTH, loginFrame);
        springLayout.putConstraint(SpringLayout.NORTH, emailField, 40, SpringLayout.SOUTH, userModeField);
        springLayout.putConstraint(SpringLayout.NORTH, passwordField, 43, SpringLayout.SOUTH, emailField);
        springLayout.putConstraint(SpringLayout.NORTH, userIcon, 21, SpringLayout.NORTH, loginFrame);
        springLayout.putConstraint(SpringLayout.NORTH, emailIcon, 38, SpringLayout.SOUTH, userIcon);
        springLayout.putConstraint(SpringLayout.NORTH, passwordIcon, 41, SpringLayout.SOUTH, emailIcon);
        
        springLayout.putConstraint(SpringLayout.SOUTH, emailLabel, 0, SpringLayout.NORTH, emailField);
        springLayout.putConstraint(SpringLayout.SOUTH, passwordLabel, 0, SpringLayout.NORTH, passwordField);
        springLayout.putConstraint(SpringLayout.WEST, emailLabel, 33, SpringLayout.EAST, emailIcon);
        springLayout.putConstraint(SpringLayout.WEST, passwordLabel, 33, SpringLayout.EAST, passwordIcon);

        foot.setLayout(new BoxLayout(foot, BoxLayout.X_AXIS));
        foot.setPreferredSize(new Dimension(400,70));
        foot.setBackground(color);

        welcomeLabel.setAlignmentX(Box.CENTER_ALIGNMENT);
        mainIcon.setAlignmentX(Box.CENTER_ALIGNMENT);

        //Adding Components to Panels
        head.add(Box.createRigidArea(new Dimension(400,30)));
        head.add(welcomeLabel);
        head.add(Box.createRigidArea(new Dimension(400,30)));
        head.add(mainIcon);

        center.add(userIcon);
        center.add(userModeField);
        center.add(emailIcon);
        center.add(emailField);
        center.add(passwordIcon);
        center.add(passwordField);
        center.add(emailLabel);
        center.add(passwordLabel);
        
        foot.add(Box.createRigidArea(new Dimension(135,70)));
        foot.add(loginButton);
        foot.add(registerButton);
        foot.add(Box.createRigidArea(new Dimension(135,70)));
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        registerButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        loginFrame.add(head, BorderLayout.NORTH);
        loginFrame.add(center, BorderLayout.CENTER);
        loginFrame.add(foot, BorderLayout.SOUTH);

        loginFrame.setTitle("Login Page");
        loginFrame.setSize(440,480);
        loginFrame.setLocationRelativeTo(null);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setVisible(true);
        
    }

  public JComboBox<String> getUserModeField()
  {
    return this.userModeField;
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

  public JFrame getLoginFrame()
  {
    return this.loginFrame;
  }

  public void displayMessage(String msg)
  {
    JOptionPane.showMessageDialog(loginFrame, msg);
  }
}
