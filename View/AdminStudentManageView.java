package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class AdminStudentManageView extends JFrame {

	private JLabel title;
    private JLabel studentIdLabel;
    private JLabel courseIdLabel;
    
    private JTextField studentId;
    private JTextField courseId;
    
    private JButton add;
    private JButton delete;
   
    private JTable studentTable;
    private JScrollPane scrollPane;
    private Object[] tableColumns;
    private DefaultTableModel tableModelInfo;
    
    private JPanel mainPanel;
    private JPanel tablePanel;
    private JPanel studentIdPanel;
    private JPanel courseIdPanel;
    private JPanel buttonsPanel;
    private JPanel southPanel;
    private JPanel nourthPanel;
    
    private Font font,fontTable;
    public AdminStudentManageView() {
    	title=new JLabel("Student Manage");
    	studentIdLabel=new JLabel("Student ID:");
    	courseIdLabel=new JLabel("Course ID:");
    	studentId=new JTextField();
        studentId.setEditable(false);
    	courseId=new JTextField();
    	add=new JButton("ADD");
    	delete=new JButton("DELETE");
    	
    	font=new Font ("Arial", Font.BOLD, 17);
    	fontTable=new Font("Arial", Font.BOLD, 15);
    	
    	title.setFont(new Font("Arial", Font.BOLD, 25));
    	studentIdLabel.setFont(font);
    	courseIdLabel.setFont(font);
    	
    	studentId.setFont(font);
    	studentId.setColumns(5);
    	courseId.setFont(font);
    	courseId.setColumns(5);
    	
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
        
        mainPanel=new JPanel();
        tablePanel=new JPanel();
        studentIdPanel=new JPanel();
        courseIdPanel=new JPanel();
        buttonsPanel=new JPanel();;
        southPanel=new JPanel();
        nourthPanel=new JPanel();
        
        tablePanel.setLayout(new BorderLayout());
        tablePanel.add(scrollPane,BorderLayout.CENTER);
        tablePanel.setBackground(new Color(114,128,255));
        
        studentIdPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        studentIdPanel.add(studentIdLabel);
        studentIdPanel.add(studentId);
        studentIdPanel.setBackground(new Color(114,128,255));
        
        courseIdPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        courseIdPanel.add(courseIdLabel);
        courseIdPanel.add(courseId);
        courseIdPanel.setBackground(new Color(114,128,255));
        
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonsPanel.add(add);
        buttonsPanel.add(delete);
        buttonsPanel.setBackground(new Color(114,128,255));
        
        nourthPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        nourthPanel.add(title);
        nourthPanel.setBackground(new Color(114,128,255));
        
        southPanel.setLayout(new GridLayout(3,1));
        southPanel.add(studentIdPanel);
        southPanel.add(courseIdPanel);
        southPanel.add(buttonsPanel);
        southPanel.setBackground(new Color(114,128,255));
        
        mainPanel.setLayout(new BorderLayout(1,1));
        mainPanel.add(nourthPanel,BorderLayout.NORTH);
        mainPanel.add(tablePanel,BorderLayout.CENTER);
        mainPanel.add(southPanel,BorderLayout.SOUTH);
        mainPanel.setBackground(new Color(114,128,255));
        
        add(mainPanel);
        setBackground(new Color(114,128,255));
        setTitle("Student Manage");
		setSize(850, 550);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
    }
   
    public JTextField getStudentIdField() {
    	return this.studentId;
    }
    public JTextField getCourseIdField() {
    	return this.courseId;
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
    
}
