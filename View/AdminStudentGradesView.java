package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class AdminStudentGradesView implements View{

    //Labels
	private JLabel title;
    private JLabel studentIdLabel;
    private JLabel courseCodeLabel;
    private JLabel gradeLabel;
    
    //Fields
    private JTextField studentId;
    private JTextField courseCode;
    private JTextField grade;
    
    //Buttons
    private JButton editButton;
    
    //JTable
    private JTable studentTable;
    private JScrollPane scrollPane;
    private Object[] tableColumns;
    private DefaultTableModel tableModelInfo;
    
    //Panles
    private JFrame mainPanel;
    private JPanel tablePanel;
    private JPanel studentIdPanel;
    private JPanel courseIdPanel;
    private JPanel gradePanel;
    private JPanel buttonsPanel;
    private JPanel southPanel;
    private JPanel northPanel;
    
    //Fonts and Color
    private Font font,fontTable;
    private Color color;

    public AdminStudentGradesView() {
    	title=new JLabel("Student Grades Management");
    	studentIdLabel=new JLabel("Student ID:");
    	courseCodeLabel=new JLabel("Course Code:");
        gradeLabel=new JLabel("Grade:");
    	studentId=new JTextField(5);
        courseCode = new JTextField(5);
        grade = new JTextField(5);
    	editButton=new JButton("Edit");
        color = new Color(83,131,255);
    	
    	font=new Font ("Arial", Font.BOLD, 17);
    	fontTable=new Font("Arial", Font.BOLD, 15);
    	
    	title.setFont(new Font("Arial", Font.BOLD, 25));
    	studentIdLabel.setFont(font);
    	courseCodeLabel.setFont(font);
        gradeLabel.setFont(font);
    	
        grade.setFont(font);
    	studentId.setFont(font);
        studentId.setEditable(false);
        courseCode.setFont(font);
        courseCode.setEditable(false);
        
    	
    	editButton.setBackground(Color.GREEN);
    	
    	
    	tableColumns = new Object[]{"StdID","First Name","Last Name","CourseCode","CourseName","Grade","Year"};
    	studentTable=new JTable();
    
    	studentTable.setFont(fontTable);
    	studentTable.getTableHeader().setFont(font);
    	studentTable.getTableHeader().setForeground(Color.BLUE);
    	scrollPane = new JScrollPane(studentTable);
    	
        tableModelInfo = new DefaultTableModel();
        tableModelInfo.setColumnIdentifiers(tableColumns);
        studentTable.setModel(tableModelInfo);
        
        mainPanel=new JFrame();
        tablePanel=new JPanel();
        studentIdPanel=new JPanel();
        courseIdPanel=new JPanel();
        gradePanel = new JPanel();
        buttonsPanel=new JPanel();
        southPanel=new JPanel();
        northPanel=new JPanel();
        
        tablePanel.setLayout(new BorderLayout());
        tablePanel.add(scrollPane,BorderLayout.CENTER);
        tablePanel.setBackground(color);
        
        studentIdPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        studentIdPanel.add(studentIdLabel);
        studentIdPanel.add(studentId);
        studentIdPanel.setBackground(color);
        
        courseIdPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        courseIdPanel.add(courseCodeLabel);
        courseIdPanel.add(courseCode);
        courseIdPanel.setBackground(color);

        gradePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        gradePanel.setBackground(color);
        gradePanel.add(gradeLabel);
        gradePanel.add(grade);
        courseIdPanel.setBackground(color);
        
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonsPanel.add(editButton);
        buttonsPanel.setBackground(color);
        
        northPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        northPanel.add(title);
        northPanel.setBackground(color);
        
        southPanel.setLayout(new GridLayout(4,1));
        southPanel.add(studentIdPanel);
        southPanel.add(courseIdPanel);
        southPanel.add(gradePanel);
        southPanel.add(buttonsPanel);
        southPanel.setBackground(color);
        
        mainPanel.setLayout(new BorderLayout(1,1));
        mainPanel.add(northPanel,BorderLayout.NORTH);
        mainPanel.add(tablePanel,BorderLayout.CENTER);
        mainPanel.add(southPanel,BorderLayout.SOUTH);
        mainPanel.setBackground(color);
        
        
        mainPanel.setTitle("Student Courses Management");
		mainPanel.setSize(850, 550);
		mainPanel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainPanel.setVisible(false);
		mainPanel.setLocationRelativeTo(null);
    }
    
    public JFrame getMainFrame()
    {
        return mainPanel;
    }

    public JTextField getStudentId() {
    	return this.studentId;
    }
    
    public JTextField getCourseCode()
    {
        return this.courseCode;
    }

    public JTextField getStudentGrade()
    {
        return this.grade;
    }

    public JTable getStudentTable() {
    	return this.studentTable;
    }

    public DefaultTableModel getTableModel() {
    	return this.tableModelInfo;
    }

    public JButton getEditButton() {
    	return this.editButton;
    }
    
    public void displayMessage(String message)
    {
        JOptionPane.showMessageDialog(null, message);
    }
    
}
