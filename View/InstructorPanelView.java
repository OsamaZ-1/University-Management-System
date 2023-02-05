package View;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
public class InstructorPanelView extends JFrame{

	private JLabel header;
	private JLabel idLabel;
	private JLabel nameLabel;
	private JLabel studentIdLabel;
	private JLabel courseCodeLabel;
	private JLabel studentGradeLabel;
	private JLabel id;
	private JLabel name;
	private JComboBox instrutorCourses;
	
	//Table
    private JTable studentsCourseGradesTable;
    private JScrollPane scrollPane;
    private Object[] tableColumns;
    private DefaultTableModel tableModel;
    
    private JTextField studentId;
    private JTextField courseCode;
    private JTextField studentGrade;
    private JButton add;
    private JButton logout;
    
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
    
    private Font font,fontTable;
    public InstructorPanelView() {
    	
    	font = new Font("Arial", Font.BOLD, 17);
        fontTable = new Font("Arial", Font.BOLD, 15);
    	header=new JLabel("Courses Grade Management");
    	header.setFont(new Font("Arial", Font.BOLD, 25));
    	idLabel=new JLabel("ID:");
    	idLabel.setFont(font);
    	nameLabel=new JLabel("DR.");
    	nameLabel.setFont(font);
    	name=new JLabel("");
    	name.setFont(font);
    	id=new JLabel("");
    	id.setFont(font);
    	studentIdLabel=new JLabel("Student ID:");
    	studentIdLabel.setFont(font);
    	courseCodeLabel=new JLabel("Course Code:");
    	courseCodeLabel.setFont(font);
    	studentGradeLabel=new JLabel("Grade:");
    	studentGradeLabel.setFont(font);
    	
    	instrutorCourses= new JComboBox<String>(new String[]{"Courses"});
    	instrutorCourses.setPreferredSize(new Dimension(150,40));
    	instrutorCourses.setFont(font);
    	
    	tableColumns = new Object[]{"ID","First Name","Last Name","Grade"};
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
        
        add=new JButton("Add");
        add.setFont(font);
        add.setBackground(Color.yellow);
        logout=new JButton("Logout");
        logout.setFont(font);
        
        headPanel=new JPanel();
        headPanel.setBackground(new Color(114,128,255));
        instructorInfoPanel=new JPanel();
        instructorInfoPanel.setBackground(new Color(114,128,255));
        instructorNamePanel=new JPanel();
        instructorNamePanel.setBackground(new Color(114,128,255));
        instructorIdPanel=new JPanel();
        instructorIdPanel.setBackground(new Color(114,128,255));
        instructorLogoutPanel=new JPanel();
        instructorLogoutPanel.setBackground(new Color(114,128,255));
        coursesListPanel=new JPanel();
        coursesListPanel.setBackground(new Color(114,128,255));
        tablePanel=new JPanel();
        tablePanel.setBackground(new Color(114,128,255));
        northPanel=new JPanel();
        northPanel.setBackground(new Color(114,128,255));
        southPanel=new JPanel();
        southPanel.setBackground(new Color(114,128,255));
        centerPanel=new JPanel();
        centerPanel.setBackground(new Color(114,128,255));
        mainPanel=new JPanel();
        mainPanel.setBackground(new Color(114,128,255));
        studentIdPanel=new JPanel();
        studentIdPanel.setBackground(new Color(114,128,255));
        courseCodePanel=new JPanel();
        courseCodePanel.setBackground(new Color(114,128,255));
        studentGradePanel=new JPanel();
        studentGradePanel.setBackground(new Color(114,128,255));
        addButtonPanel=new JPanel();
        addButtonPanel.setBackground(new Color(114,128,255));
        
        headPanel.setLayout(new FlowLayout(FlowLayout.CENTER,1,2));
        headPanel.add(header);
        
        instructorNamePanel.setLayout(new FlowLayout(FlowLayout.LEFT,1,3));
        instructorNamePanel.add(nameLabel);
        instructorNamePanel.add(name);
        
        instructorIdPanel.setLayout(new FlowLayout(FlowLayout.CENTER,1,3));
        instructorIdPanel.add(idLabel);
        instructorIdPanel.add(id);
        
        instructorLogoutPanel.setLayout(new FlowLayout(FlowLayout.RIGHT,1,3));
        instructorLogoutPanel.add(logout);
        
        instructorInfoPanel.setLayout(new GridLayout(1,3));
        instructorInfoPanel.add(instructorNamePanel);
        instructorInfoPanel.add(instructorIdPanel);
        instructorInfoPanel.add(instructorLogoutPanel);
        
        northPanel.setLayout(new GridLayout(2,1));
        northPanel.add(headPanel);
        northPanel.add(instructorInfoPanel);
        
        coursesListPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        coursesListPanel.add(instrutorCourses);
        
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
        
        addButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER,1,3));
        addButtonPanel.add(add);
        
        southPanel.setLayout(new GridLayout(4,1,1,1));
        southPanel.add(courseCodePanel);
        southPanel.add(studentIdPanel);
        southPanel.add(studentGradePanel);
        southPanel.add(addButtonPanel);
        
        mainPanel.setLayout(new BorderLayout(10,10));
        mainPanel.add(northPanel,BorderLayout.NORTH);
        mainPanel.add(centerPanel,BorderLayout.CENTER);
        mainPanel.add(southPanel,BorderLayout.SOUTH);
        
        add(mainPanel);
    	setBackground(new Color(114,128,255));
        setTitle("Instructor Panel");
		setSize(900, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
    }
    public JLabel getInstructorNameLabel() {
    	return this.name;
    }
    public JLabel getInstructorIdLabel() {
    	return this.id;
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
    	return this.logout;
    }
    public JButton getAddButton() {
    	return this.add;
    }
}
