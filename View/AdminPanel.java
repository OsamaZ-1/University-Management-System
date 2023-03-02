package View;

import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.*;

public class AdminPanel implements View{
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
    private JButton historyButton;
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
    private DefaultTableModel tableModel;

    //Font and Color
    private Font font;
    private Color blue;
    private Color lightBlue;

    public AdminPanel()
    {  
        //Initialization of components
        logo = new ImageIcon("./Images/main_Icon.png");
        studentLogo = new ImageIcon("./Images/student.png");
        professorLogo = new ImageIcon("./Images/professor.png");
        coursesLogo = new ImageIcon("./Images/courses.png");
        font = new Font("Arial",Font.BOLD,17);
        blue = new Color(83,131,255);
        lightBlue = new Color(131, 165, 252);
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
        professorButton = new JButton("Instructors");
        courseButton = new JButton("Courses");
        logoutButton = new JButton("Logout");
        historyButton = new JButton("History");
        refreshActivity = new JButton("<html><center>Refresh<br/>Activities</center></html>");
        submitChanges = new JButton("<html><center>Submit<br/>Changes</center></html>");

        //Activity Table
        table = new JTable();
        scrollPane = new JScrollPane(table);
        tableModel = new DefaultTableModel(){
            @Override
            //This allows having a checkbox in the 2nd column and string in the 1st
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 3 || columnIndex == 2)
                    return Boolean.class;
                return String.class;
             }
        };
        tableModel.addColumn("Type");
        tableModel.addColumn("Activity");
        tableModel.addColumn("Accept");
        tableModel.addColumn("Unaccept");
        table.setModel(tableModel);
        table.getColumnModel().getColumn(1).setPreferredWidth(900);
        
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
        historyButton.setPreferredSize(new Dimension(90,50));
        refreshActivity.setPreferredSize(new Dimension(100,50));
        submitChanges.setPreferredSize(new Dimension(100,50));

        //Containers Sizes
        topPanel.setPreferredSize(new Dimension(960,120));
        leftNavbar.setPreferredSize(new Dimension(140,650));
        rightPanel.setPreferredSize(new Dimension(960,650));
        centerPanel.setPreferredSize(new Dimension(810,650));
        centerRightPanel.setPreferredSize(new Dimension(150,650));

        ///Fonts
        dashboardLabel.setFont(font);
        nbStudents.setFont(font);
        nbProfessors.setFont(font);
        nbCourses.setFont(font);
        activityLabel.setFont(new Font("Arial",Font.BOLD,18));
        
        //Backgrounds
        leftNavbar.setBackground(blue);
        topPanel.setBackground(lightBlue);
        centerRightPanel.setBackground(blue);

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
        springLayout.putConstraint(SpringLayout.WEST, historyButton, 22, SpringLayout.WEST, leftNavbar);
        springLayout.putConstraint(SpringLayout.WEST, logoutButton, 22, SpringLayout.WEST, leftNavbar);

        springLayout.putConstraint(SpringLayout.NORTH, mainIcon, 30, SpringLayout.NORTH, leftNavbar);
        springLayout.putConstraint(SpringLayout.NORTH, dashboardLabel, 20, SpringLayout.SOUTH, mainIcon);
        springLayout.putConstraint(SpringLayout.NORTH, studentButton, 60, SpringLayout.SOUTH, dashboardLabel);
        springLayout.putConstraint(SpringLayout.NORTH, professorButton, 30, SpringLayout.SOUTH, studentButton);
        springLayout.putConstraint(SpringLayout.NORTH, courseButton, 30, SpringLayout.SOUTH, professorButton);
        springLayout.putConstraint(SpringLayout.NORTH, historyButton, 30, SpringLayout.SOUTH, courseButton);
        springLayout.putConstraint(SpringLayout.NORTH, logoutButton, 70, SpringLayout.SOUTH, historyButton);

        //Adding components to leftNavbar
        leftNavbar.add(mainIcon);
        leftNavbar.add(dashboardLabel);
        leftNavbar.add(studentButton);
        leftNavbar.add(professorButton);
        leftNavbar.add(courseButton);
        leftNavbar.add(historyButton);
        leftNavbar.add(logoutButton);
        
        //topPanel Layout Constraints
        springLayout.putConstraint(SpringLayout.WEST, studentIcon, 170,SpringLayout.WEST, topPanel);
        springLayout.putConstraint(SpringLayout.WEST, nbStudents, 140,SpringLayout.WEST, topPanel);
        springLayout.putConstraint(SpringLayout.WEST, professorIcon, 200,SpringLayout.EAST, studentIcon);
        springLayout.putConstraint(SpringLayout.WEST, nbProfessors, 110,SpringLayout.EAST, nbStudents);
        springLayout.putConstraint(SpringLayout.WEST, coursesIcon, 200,SpringLayout.EAST, professorIcon);
        springLayout.putConstraint(SpringLayout.WEST, nbCourses, 115,SpringLayout.EAST, nbProfessors);
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

    public JButton getHistoryButton()
    {
        return this.historyButton;
    }

    public JButton getLogoutButton()
    {
        return this.logoutButton;
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