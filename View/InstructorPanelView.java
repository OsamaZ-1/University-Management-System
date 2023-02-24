package View;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
public class InstructorPanelView implements View{

	private JLabel header;
	private JLabel idLabel;
	private JLabel nameLabel;
	private JLabel studentIdLabel;
	private JLabel courseCodeLabel;
	private JLabel studentGradeLabel;
	private JComboBox<String> instrutorCourses;
	
	//Table
    private JTable studentsCourseGradesTable;
    private JScrollPane scrollPane;
    private Object[] tableColumns;
    private DefaultTableModel tableModel;
    
    private JTextField studentId;
    private JTextField courseCode;
    private JTextField studentGrade;
    private JButton addButton;
    private JButton logoutButton;
    private JButton saveButton;
    
    private JFrame instructorFrame;
    private JPanel mainPanel;
    private JPanel northPanel;
    private JPanel centerPanel;
    private JPanel southPanel;
    private JPanel headPanel;
    private JPanel instructorInfoPanel;
    private JPanel instructorNamePanel;
    private JPanel instructorIdPanel;
    private JPanel instructorLogoutPanel;
    private JPanel coursesListPanel;
    private JPanel tablePanel;
    private JPanel courseCodePanel;
    private JPanel studentIdPanel;
    private JPanel studentGradePanel;
    private JPanel addButtonPanel;
    
    //Fonts and Color
    private Font font,fontTable;
    private Color color;

    //Layout
    SpringLayout springLayout;

    public InstructorPanelView() {
    	instructorFrame = new JFrame();
    	font = new Font("Arial", Font.BOLD, 17);
        fontTable = new Font("Arial", Font.BOLD, 15);
        color = new Color(83,131,255);
    	header=new JLabel("Courses Grade Management");
    	header.setFont(new Font("Arial", Font.BOLD, 25));
    	idLabel=new JLabel("ID:");
    	idLabel.setFont(font);
    	nameLabel=new JLabel("Full Name:");
    	nameLabel.setFont(font);
    	studentIdLabel=new JLabel("Student ID:");
    	studentIdLabel.setFont(font);
    	courseCodeLabel=new JLabel("Course Code:");
    	courseCodeLabel.setFont(font);
    	studentGradeLabel=new JLabel("Grade:");
    	studentGradeLabel.setFont(font);
        springLayout = new SpringLayout();

    	instrutorCourses= new JComboBox<String>(new String[]{"Courses"});
    	instrutorCourses.setPreferredSize(new Dimension(150,40));
    	instrutorCourses.setFont(font);
    	
    	tableColumns = new Object[]{"ID","First Name","Last Name","Grade","Submitted"};
    	studentsCourseGradesTable=new JTable();
        scrollPane = new JScrollPane(studentsCourseGradesTable);
        tableModel = new DefaultTableModel();
    	studentsCourseGradesTable.setFont(font);
    	studentsCourseGradesTable.getTableHeader().setFont(font);
    	studentsCourseGradesTable.getTableHeader().setForeground(Color.BLUE);

        tableModel.setColumnIdentifiers(tableColumns);
        studentsCourseGradesTable.setModel(tableModel);
        studentsCourseGradesTable.setFont(fontTable);
    	
        studentId=new JTextField();
        studentId.setColumns(5);
        studentId.setFont(font);
        studentId.setEditable(false);
        courseCode=new JTextField();
        courseCode.setColumns(5);
        courseCode.setFont(font);
        courseCode.setEditable(false);
        studentGrade=new JTextField();
        studentGrade.setColumns(5);
        studentGrade.setFont(font);
        
        addButton=new JButton("Add");
        addButton.setFont(font);
        addButton.setBackground(Color.yellow);
        logoutButton=new JButton("Logout");
        logoutButton.setFont(font);
        saveButton = new JButton("Save");
        saveButton.setFont(font);
        
        headPanel=new JPanel();
        headPanel.setBackground(color);
        instructorInfoPanel=new JPanel();
        instructorInfoPanel.setBackground(color);
        instructorNamePanel=new JPanel();
        instructorNamePanel.setBackground(color);
        instructorIdPanel=new JPanel();
        instructorIdPanel.setBackground(color);
        instructorLogoutPanel=new JPanel();
        instructorLogoutPanel.setBackground(color);
        coursesListPanel=new JPanel();
        coursesListPanel.setBackground(color);
        coursesListPanel.setPreferredSize(new Dimension(920,70));
        tablePanel=new JPanel();
        tablePanel.setBackground(color);
        northPanel=new JPanel();
        northPanel.setBackground(color);
        southPanel=new JPanel();
        southPanel.setBackground(color);
        centerPanel=new JPanel();
        centerPanel.setBackground(color);
        mainPanel=new JPanel();
        mainPanel.setBackground(color);
        studentIdPanel=new JPanel();
        studentIdPanel.setBackground(color);
        courseCodePanel=new JPanel();
        courseCodePanel.setBackground(color);
        studentGradePanel=new JPanel();
        studentGradePanel.setBackground(color);
        addButtonPanel=new JPanel();
        addButtonPanel.setBackground(color);
        
        headPanel.setLayout(new FlowLayout(FlowLayout.CENTER,1,2));
        headPanel.add(header);
        
        instructorNamePanel.setLayout(new FlowLayout(FlowLayout.LEFT,1,3));
        instructorNamePanel.add(nameLabel);
        
        instructorIdPanel.setLayout(new FlowLayout(FlowLayout.CENTER,1,3));
        instructorIdPanel.add(idLabel);
        
        instructorLogoutPanel.setLayout(new FlowLayout(FlowLayout.RIGHT,1,3));
        
        instructorInfoPanel.setLayout(new GridLayout(1,3));
        instructorInfoPanel.add(instructorNamePanel);
        instructorInfoPanel.add(instructorIdPanel);
        instructorInfoPanel.add(instructorLogoutPanel);
        
        northPanel.setLayout(new GridLayout(2,1));
        northPanel.add(headPanel);
        northPanel.add(instructorInfoPanel);
        
        springLayout.putConstraint(SpringLayout.WEST, instrutorCourses, 390, SpringLayout.WEST, coursesListPanel);
        springLayout.putConstraint(SpringLayout.NORTH, instrutorCourses, 5, SpringLayout.NORTH, coursesListPanel);
        springLayout.putConstraint(SpringLayout.EAST, saveButton, 0, SpringLayout.EAST, mainPanel);
        springLayout.putConstraint(SpringLayout.NORTH, saveButton, 5, SpringLayout.NORTH, coursesListPanel);
        springLayout.putConstraint(SpringLayout.EAST, logoutButton, -5, SpringLayout.WEST, saveButton);
        springLayout.putConstraint(SpringLayout.NORTH, logoutButton, 5, SpringLayout.NORTH, coursesListPanel);

        coursesListPanel.setLayout(springLayout);
        coursesListPanel.add(instrutorCourses);
        coursesListPanel.add(logoutButton);
        coursesListPanel.add(saveButton);

        tablePanel.setLayout(new BorderLayout());
        tablePanel.add(scrollPane,BorderLayout.CENTER);
        
        centerPanel.setLayout(new BorderLayout());
        centerPanel.add(coursesListPanel,BorderLayout.NORTH);
        centerPanel.add(tablePanel,BorderLayout.CENTER);
        
        studentIdPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        studentIdPanel.add(studentIdLabel);
        studentIdPanel.add(studentId);
        
        courseCodePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        courseCodePanel.add(courseCodeLabel);
        courseCodePanel.add(courseCode);
        
        studentGradePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        studentGradePanel.add(studentGradeLabel);
        studentGradePanel.add(studentGrade);
        
        
        
        addButtonPanel.setLayout(new BoxLayout(addButtonPanel,BoxLayout.Y_AXIS));
        addButtonPanel.add(addButton);
        addButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        
        southPanel.setLayout(new GridLayout(4,1,1,1));
        southPanel.add(courseCodePanel);
        southPanel.add(studentIdPanel);
        southPanel.add(studentGradePanel);
        southPanel.add(addButtonPanel);
        
        mainPanel.setLayout(new BorderLayout(10,10));
        mainPanel.add(northPanel,BorderLayout.NORTH);
        mainPanel.add(centerPanel,BorderLayout.CENTER);
        mainPanel.add(southPanel,BorderLayout.SOUTH);
        
        instructorFrame.add(mainPanel);
    	instructorFrame.setBackground(color);
        instructorFrame.setTitle("Instructor Panel");
		instructorFrame.setSize(920, 700);
		instructorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		instructorFrame.setLocationRelativeTo(null);
		instructorFrame.setVisible(true);
    }
    
    public JFrame getInstructorFrame()
    {
        return this.instructorFrame;
    }

    public JLabel getInstructorNameLabel() {
    	return this.nameLabel;
    }

    public JLabel getInstructorIdLabel() {
    	return this.idLabel;
    }

    public JTable getStudentsCourseGradesTable()
    {
        return this.studentsCourseGradesTable;
    }

    public DefaultTableModel getTableModel()
    {
        return this.tableModel;
    }

    public JTextField getStudentIdField() {
    	return this.studentId;
    }

    public JTextField getCourseCodeField() {
    	return this.courseCode;
    }

    public JTextField getStudentGradeField() {
    	return this.studentGrade;
    }

    public JButton getLogoutButton() {
    	return this.logoutButton;
    }

    public JButton getAddButton() {
    	return this.addButton;
    }

    public JButton getSaveButton()
    {   return this.saveButton;
    }

    public JComboBox<String> getCoursesList()
    {
        return this.instrutorCourses;
    }

    public void displayMessage(String message)
    {
        JOptionPane.showMessageDialog(null, message);
    }

}
