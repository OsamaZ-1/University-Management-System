package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class AdminStudentCourseView implements View{
    //Labels
	private JLabel title;
    private JLabel studentIdLabel;
    private JLabel courseIdLabel;
    
    //Fields
    private JTextField studentId;
    private JComboBox<String> coursesList;
    
    //Buttons
    private JButton add;
    private JButton delete;
    
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
    private JPanel buttonsPanel;
    private JPanel southPanel;
    private JPanel nourthPanel;
    
    //Fonts and Color
    private Font font,fontTable;
    private Color color;

    public AdminStudentCourseView() {
    	title=new JLabel("Student Courses Management");
    	studentIdLabel=new JLabel("Student ID:");
    	courseIdLabel=new JLabel("Course Code:");
    	studentId=new JTextField();
        studentId.setEditable(false);
        coursesList = new JComboBox<>();
    	add=new JButton("Add");
    	delete=new JButton("Delete");
        color = new Color(83,131,255);
    	
    	font=new Font ("Arial", Font.BOLD, 17);
    	fontTable=new Font("Arial", Font.BOLD, 15);
    	
    	title.setFont(new Font("Arial", Font.BOLD, 25));
    	studentIdLabel.setFont(font);
    	courseIdLabel.setFont(font);
    	
    	studentId.setFont(font);
    	studentId.setColumns(5);
        coursesList.setFont(font);
    	
    	add.setBackground(Color.yellow);
    	delete.setBackground(Color.red);
    	
    	tableColumns = new Object[]{"StdID","First Name","Last Name","CourseId","CourseCode","CourseName"};
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
        buttonsPanel=new JPanel();;
        southPanel=new JPanel();
        nourthPanel=new JPanel();
        
        tablePanel.setLayout(new BorderLayout());
        tablePanel.add(scrollPane,BorderLayout.CENTER);
        tablePanel.setBackground(color);
        
        studentIdPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        studentIdPanel.add(studentIdLabel);
        studentIdPanel.add(studentId);
        studentIdPanel.setBackground(color);
        
        courseIdPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        courseIdPanel.add(courseIdLabel);
        courseIdPanel.add(coursesList);
        courseIdPanel.setBackground(color);
        
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonsPanel.add(add);
        buttonsPanel.add(delete);
        buttonsPanel.setBackground(color);
        
        nourthPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        nourthPanel.add(title);
        nourthPanel.setBackground(color);
        
        southPanel.setLayout(new GridLayout(3,1));
        southPanel.add(studentIdPanel);
        southPanel.add(courseIdPanel);
        southPanel.add(buttonsPanel);
        southPanel.setBackground(color);
        
        mainPanel.setLayout(new BorderLayout(1,1));
        mainPanel.add(nourthPanel,BorderLayout.NORTH);
        mainPanel.add(tablePanel,BorderLayout.CENTER);
        mainPanel.add(southPanel,BorderLayout.SOUTH);
        mainPanel.setBackground(color);
        
        
        mainPanel.setTitle("Student Courses Management");
		mainPanel.setSize(850, 550);
		mainPanel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		mainPanel.setLocationRelativeTo(null);
    }
    
    public JFrame getMainFrame()
    {
        return mainPanel;
    }

    public JTextField getStudentIdField() {
    	return this.studentId;
    }
    
    public JComboBox<String> getCoursesList()
    {
        return this.coursesList;
    }

    public JTable getStudentTable() {
    	return this.studentTable;
    }

    public DefaultTableModel getTableModel() {
    	return this.tableModelInfo;
    }

    public JButton getAddButton() {
    	return this.add;
    }

    public JButton getDeleteButton() {
    	return this.delete;
    }
    
    public void setStudentId(String id)
    {
        this.studentId.setText(id);
    }
    
    public void displayMessage(String message)
    {
        JOptionPane.showMessageDialog(null, message);
    }
}
