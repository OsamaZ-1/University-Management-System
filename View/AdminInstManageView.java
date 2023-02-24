package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;

public class AdminInstManageView implements View{

    //Labels
	private JLabel title;
    private JLabel instIdLabel;
    private JLabel courseCodeLabel;
    
    //Fields
    private JTextField instId;
    private JComboBox<String> courseCode;
    
    //Buttons
    private JButton add;
    private JButton delete;
   
    //Table
    private JTable instTable;
    private JScrollPane scrollPane;
    private Object[] tableColumns;
    private DefaultTableModel tableModelInfo;
    
    //Panels
    private JFrame mainPanel;
    private JPanel tablePanel;
    private JPanel instIdPanel;
    private JPanel courseIdPanel;
    private JPanel buttonsPanel;
    private JPanel southPanel;
    private JPanel nourthPanel;
    
    //Fonts and Color
    private Font font,fontTable;
    private Color color;

    public AdminInstManageView() {
    	title=new JLabel("Instructor Course Management");
    	instIdLabel=new JLabel("Instructor ID:");
    	courseCodeLabel=new JLabel("Course Code:");
    	instId=new JTextField();
        instId.setEditable(false);
    	courseCode=new JComboBox<>();
    	add=new JButton("ADD");
    	delete=new JButton("DELETE");
    	
    	font=new Font ("Arial", Font.BOLD, 17);
    	fontTable=new Font("Arial", Font.BOLD, 15);
        color = new Color(83,131,255);
    	
    	title.setFont(new Font("Arial", Font.BOLD, 25));
    	instIdLabel.setFont(font);
    	courseCodeLabel.setFont(font);
    	
    	instId.setFont(font);
    	instId.setColumns(5);
    	courseCode.setFont(font);
    	
    	add.setBackground(Color.yellow);
    	delete.setBackground(Color.red);
    	
    	tableColumns = new Object[]{"InstID","First Name","Last Name","CourseId","CourseCode","CourseName"};
    	instTable=new JTable();
    
    	instTable.setFont(fontTable);
    	instTable.getTableHeader().setFont(font);
    	instTable.getTableHeader().setForeground(Color.BLUE);
    	scrollPane = new JScrollPane(instTable);
    	
        tableModelInfo = new DefaultTableModel();
        tableModelInfo.setColumnIdentifiers(tableColumns);
        instTable.setModel(tableModelInfo);
        
        mainPanel=new JFrame();
        tablePanel=new JPanel();
        instIdPanel=new JPanel();
        courseIdPanel=new JPanel();
        buttonsPanel=new JPanel();;
        southPanel=new JPanel();
        nourthPanel=new JPanel();
        
        tablePanel.setLayout(new BorderLayout());
        tablePanel.add(scrollPane,BorderLayout.CENTER);
        tablePanel.setBackground(color);
        
        instIdPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        instIdPanel.add(instIdLabel);
        instIdPanel.add(instId);
        instIdPanel.setBackground(color);
        
        courseIdPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        courseIdPanel.add(courseCodeLabel);
        courseIdPanel.add(courseCode);
        courseIdPanel.setBackground(color);
        
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonsPanel.add(add);
        buttonsPanel.add(delete);
        buttonsPanel.setBackground(color);
        
        nourthPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        nourthPanel.add(title);
        nourthPanel.setBackground(color);
        
        southPanel.setLayout(new GridLayout(3,1));
        southPanel.add(instIdPanel);
        southPanel.add(courseIdPanel);
        southPanel.add(buttonsPanel);
        southPanel.setBackground(color);
        
        mainPanel.setLayout(new BorderLayout(1,1));
        mainPanel.add(nourthPanel,BorderLayout.NORTH);
        mainPanel.add(tablePanel,BorderLayout.CENTER);
        mainPanel.add(southPanel,BorderLayout.SOUTH);
      
        mainPanel.setBackground(color);
        mainPanel.setTitle("Instructor Course Management");
		mainPanel.setSize(850, 550);
		mainPanel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		mainPanel.setLocationRelativeTo(null);
    }
    
    public JFrame getMainFrame()
    {
        return this.mainPanel;
    }

    public JTextField getInstIdField() {
    	return this.instId;
    }
    public JComboBox<String> getCoursesList() {
    	return this.courseCode;
    }
    public JTable getInstTable() {
    	return this.instTable;
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
    public void setInstId(String id)
    {
        this.instId.setText(id);
    }
    public void displayMessage(String message)
    {
        JOptionPane.showMessageDialog(null, message);
    }
    
}

