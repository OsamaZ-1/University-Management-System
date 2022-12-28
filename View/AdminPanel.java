package View;

import javax.swing.border.MatteBorder;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.xml.transform.stax.StAXResult;
import javax.swing.border.*;
import javax.imageio.plugins.jpeg.JPEGHuffmanTable;
import javax.swing.*;
import java.awt.*;

public class AdminPanel {
    //Icons
    private ImageIcon logo;
    private ImageIcon studentLogo;
    private ImageIcon professorLogo;
    private ImageIcon coursesLogo;

    //Labels for Icons
    private JLabel mainIcon;
    private JLabel studentIcon;
    private JLabel professorIcon;
    private JLabel coursesIcon;

    //Labels for Fields
    private JLabel nbStudents;
    private JLabel nbProfessors;
    private JLabel nbCourses;
    private JLabel dashboardLabel;
    private JLabel activityLabel;

    //Buttons
    private JButton studentButton;
    private JButton professorButton;
    private JButton courseButton;
    private JButton logoutButton;
    private JButton refreshActivity;
    private JButton submitChanges;

    //Panels
    private JFrame adminPanelFrame;
    private JPanel leftNavbar;
    private JPanel topPanel;
    private JPanel rightPanel;
    private JPanel centerPanel;
    private JPanel centerRightPanel;
    private JPanel centerTop;
    private SpringLayout springLayout;

    //JTable
    private JTable table;
    private JScrollPane scrollPane;
    private String[] tableColumns;
    private DefaultTableModel tableModel;

    public AdminPanel()
    {   
        //Initialization of components
        logo = new ImageIcon("INFO404-PROJECT/Images/main_Icon.png");
        studentLogo = new ImageIcon("INFO404-PROJECT/Images/student.png");
        professorLogo = new ImageIcon("INFO404-PROJECT/Images/professor.png");
        coursesLogo = new ImageIcon("INFO404-PROJECT/Images/courses.png");
        mainIcon = new JLabel(logo);
        studentIcon = new JLabel(studentLogo);
        professorIcon = new JLabel(professorLogo);
        coursesIcon = new JLabel(coursesLogo);
        dashboardLabel = new JLabel("DASHBOARD");
        nbStudents = new JLabel("Total students 0");
        nbProfessors = new JLabel("Total professors 0");
        nbCourses = new JLabel("Total courses 0");
        activityLabel = new JLabel("New Registration Activities");
        studentButton = new JButton("Students");
        professorButton = new JButton("Professors");
        courseButton = new JButton("Courses");
        logoutButton = new JButton("Logout");
        refreshActivity = new JButton("<html><center>Refresh<br/>Activities</center></html>");
        submitChanges = new JButton("<html><center>Submit<br/>Changes</center></html>");
        table = new JTable();
        scrollPane = new JScrollPane(table);
        tableModel = new DefaultTableModel();
        tableColumns = new String[]{"Activity"};
        tableModel.setColumnIdentifiers(tableColumns);
        table.setModel(tableModel);
        
        //Initializations of containers
        adminPanelFrame = new JFrame();
        leftNavbar = new JPanel();
        rightPanel = new JPanel(new BorderLayout());
        topPanel = new JPanel();
        centerPanel = new JPanel(new BorderLayout());
        centerRightPanel = new JPanel();
        centerTop = new JPanel();

        //Components Sizes
        studentButton.setPreferredSize(new Dimension(90,50));
        professorButton.setPreferredSize(new Dimension(100,50));
        courseButton.setPreferredSize(new Dimension(90,50));
        studentButton.setPreferredSize(new Dimension(90,50));
        logoutButton.setPreferredSize(new Dimension(90,50));
        refreshActivity.setPreferredSize(new Dimension(100,50));
        submitChanges.setPreferredSize(new Dimension(100,50));

        //Containers Sizes
        topPanel.setPreferredSize(new Dimension(960,120));
        leftNavbar.setPreferredSize(new Dimension(140,650));
        rightPanel.setPreferredSize(new Dimension(960,650));
        centerPanel.setPreferredSize(new Dimension(810,650));
        centerRightPanel.setPreferredSize(new Dimension(150,650));

        ///Fonts
        dashboardLabel.setFont(new Font("Arial",Font.BOLD,17));
        nbStudents.setFont(new Font("Arial",Font.BOLD,17));
        nbProfessors.setFont(new Font("Arial",Font.BOLD,17));
        nbCourses.setFont(new Font("Arial",Font.BOLD,17));
        activityLabel.setFont(new Font("Arial",Font.BOLD,18));
        
        //Backgrounds
        leftNavbar.setBackground(new Color(83,131,255));
        topPanel.setBackground(Color.GREEN);
        centerRightPanel.setBackground(Color.YELLOW);

        //Layouts
        springLayout = new SpringLayout();
        adminPanelFrame.getContentPane().setLayout(new BoxLayout(adminPanelFrame.getContentPane(), BoxLayout.X_AXIS));
        leftNavbar.setLayout(springLayout);
        topPanel.setLayout(springLayout);
        centerRightPanel.setLayout(springLayout);
        centerTop.setLayout(new BoxLayout(centerTop, BoxLayout.Y_AXIS));

        //LeftNavbar Layout Constraints
        springLayout.putConstraint(SpringLayout.WEST, mainIcon, 28, SpringLayout.WEST, leftNavbar);
        springLayout.putConstraint(SpringLayout.WEST, dashboardLabel, 18, SpringLayout.WEST, leftNavbar);
        springLayout.putConstraint(SpringLayout.WEST, studentButton, 20, SpringLayout.WEST, leftNavbar);
        springLayout.putConstraint(SpringLayout.WEST, professorButton, 15, SpringLayout.WEST, leftNavbar);
        springLayout.putConstraint(SpringLayout.WEST, courseButton, 22, SpringLayout.WEST, leftNavbar);
        springLayout.putConstraint(SpringLayout.WEST, logoutButton, 22, SpringLayout.WEST, leftNavbar);

        springLayout.putConstraint(SpringLayout.NORTH, mainIcon, 30, SpringLayout.NORTH, leftNavbar);
        springLayout.putConstraint(SpringLayout.NORTH, dashboardLabel, 20, SpringLayout.SOUTH, mainIcon);
        springLayout.putConstraint(SpringLayout.NORTH, studentButton, 90, SpringLayout.SOUTH, dashboardLabel);
        springLayout.putConstraint(SpringLayout.NORTH, professorButton, 30, SpringLayout.SOUTH, studentButton);
        springLayout.putConstraint(SpringLayout.NORTH, courseButton, 30, SpringLayout.SOUTH, professorButton);
        springLayout.putConstraint(SpringLayout.NORTH, logoutButton, 120, SpringLayout.SOUTH, courseButton);

        //Adding components to leftNavbar
        leftNavbar.add(mainIcon);
        leftNavbar.add(dashboardLabel);
        leftNavbar.add(studentButton);
        leftNavbar.add(professorButton);
        leftNavbar.add(courseButton);
        leftNavbar.add(logoutButton);
        
        //topPanel Layout Constraints
        springLayout.putConstraint(SpringLayout.WEST, studentIcon, 170,SpringLayout.WEST, topPanel);
        springLayout.putConstraint(SpringLayout.WEST, nbStudents, 140,SpringLayout.WEST, topPanel);
        springLayout.putConstraint(SpringLayout.WEST, professorIcon, 200,SpringLayout.EAST, studentIcon);
        springLayout.putConstraint(SpringLayout.WEST, nbProfessors, 130,SpringLayout.EAST, nbStudents);
        springLayout.putConstraint(SpringLayout.WEST, coursesIcon, 200,SpringLayout.EAST, professorIcon);
        springLayout.putConstraint(SpringLayout.WEST, nbCourses, 130,SpringLayout.EAST, nbProfessors);
        springLayout.putConstraint(SpringLayout.NORTH, studentIcon, 20,SpringLayout.NORTH, topPanel);
        springLayout.putConstraint(SpringLayout.NORTH, professorIcon, 20,SpringLayout.NORTH, topPanel);
        springLayout.putConstraint(SpringLayout.NORTH, coursesIcon, 20,SpringLayout.NORTH, topPanel);
        springLayout.putConstraint(SpringLayout.NORTH, nbStudents, 10,SpringLayout.SOUTH, studentIcon);
        springLayout.putConstraint(SpringLayout.NORTH, nbProfessors, 10,SpringLayout.SOUTH, professorIcon);
        springLayout.putConstraint(SpringLayout.NORTH, nbCourses, 10,SpringLayout.SOUTH, coursesIcon);
        
        //Adding Components to topPanel
        topPanel.add(studentIcon);
        topPanel.add(nbStudents);
        topPanel.add(professorIcon);
        topPanel.add(nbProfessors);
        topPanel.add(coursesIcon);
        topPanel.add(nbCourses);

        //centerRightPanel Layout Constraints
        springLayout.putConstraint(SpringLayout.NORTH, refreshActivity, 150,SpringLayout.NORTH, centerRightPanel);
        springLayout.putConstraint(SpringLayout.NORTH, submitChanges, 50,SpringLayout.SOUTH, refreshActivity);
        springLayout.putConstraint(SpringLayout.WEST, refreshActivity, 25,SpringLayout.WEST, centerRightPanel);
        springLayout.putConstraint(SpringLayout.WEST, submitChanges, 25,SpringLayout.WEST, centerRightPanel);
        
        //Adding Components to centerRightPanel
        centerRightPanel.add(refreshActivity);
        centerRightPanel.add(submitChanges);

        //Adding Components to centerTopPanel
        centerTop.add(Box.createRigidArea(new Dimension(250,30)));
        centerTop.add(activityLabel);

        //Adding Components to centerPanel
        centerPanel.add(centerTop, BorderLayout.NORTH);
        centerPanel.add(scrollPane, BorderLayout.SOUTH);

        //Adding Containers to rightPanel
        rightPanel.add(topPanel, BorderLayout.NORTH);
        rightPanel.add(centerPanel, BorderLayout.CENTER);
        rightPanel.add(centerRightPanel, BorderLayout.EAST);

        //Adding Containers to Main Frame
        adminPanelFrame.add(leftNavbar);
        adminPanelFrame.add(rightPanel);

        adminPanelFrame.setTitle("Admin Panel");
        adminPanelFrame.setSize(1100,650);
        adminPanelFrame.setLocationRelativeTo(null);
        adminPanelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adminPanelFrame.setVisible(true);   

    }

    public JButton getStudentButton()
    {
        return this.studentButton;
    }

    public JButton getProfessorButton()
    {
        return this.professorButton;
    }

    public JButton getCourseButton()
    {
        return this.courseButton;
    }

    public JButton getRefreshButton()
    {
        return this.refreshActivity;
    }

    public JButton getSubmitButton()
    {
        return this.submitChanges;
    }

    public JLabel getTotalStudentsLabel()
    {
        return this.nbStudents;
    }

    public JLabel getTotalProfessorsLabel()
    {
        return this.nbProfessors;
    }

    public JLabel getTotalCoursesLabel()
    {
        return this.nbCourses;
    }

    public JFrame getAdminPanelFrame()
    {
        return this.adminPanelFrame;
    }

    public JPanel getCenterPanel()
    {
        return this.centerPanel;
    }

    public JTable getActivityTable()
    {
        return this.table;
    }

    public DefaultTableModel getTableModel()
    {
        return this.tableModel;
    }
    
}