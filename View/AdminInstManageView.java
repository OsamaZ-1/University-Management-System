package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class AdminInstManageView extends JFrame {

	private JLabel title;
    private JLabel instIdLabel;
    private JLabel courseIdLabel;
    
    private JTextField instId;
    private JTextField courseId;
    
    private JButton add;
    private JButton delete;
   
    private JTable instTable;
    private JScrollPane scrollPane;
    private Object[] tableColumns;
    private DefaultTableModel tableModelInfo;
    
    private JPanel mainPanel;
    private JPanel tablePanel;
    private JPanel instIdPanel;
    private JPanel courseIdPanel;
    private JPanel buttonsPanel;
    private JPanel southPanel;
    private JPanel nourthPanel;
    
    private Font font,fontTable;
    public AdminInstManageView() {
    	title=new JLabel("Instructor Manage");
    	instIdLabel=new JLabel("Instrucot ID:");
    	courseIdLabel=new JLabel("Course ID:");
    	instId=new JTextField();
        instId.setEditable(false);
    	courseId=new JTextField();
    	add=new JButton("ADD");
    	delete=new JButton("DELETE");
    	
    	font=new Font ("Arial", Font.BOLD, 17);
    	fontTable=new Font("Arial", Font.BOLD, 15);
    	
    	title.setFont(new Font("Arial", Font.BOLD, 25));
    	instIdLabel.setFont(font);
    	courseIdLabel.setFont(font);
    	
    	instId.setFont(font);
    	instId.setColumns(5);
    	courseId.setFont(font);
    	courseId.setColumns(5);
    	
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
        
        mainPanel=new JPanel();
        tablePanel=new JPanel();
        instIdPanel=new JPanel();
        courseIdPanel=new JPanel();
        buttonsPanel=new JPanel();;
        southPanel=new JPanel();
        nourthPanel=new JPanel();
        
        tablePanel.setLayout(new BorderLayout());
        tablePanel.add(scrollPane,BorderLayout.CENTER);
        tablePanel.setBackground(new Color(114,128,255));
        
        instIdPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        instIdPanel.add(instIdLabel);
        instIdPanel.add(instId);
        instIdPanel.setBackground(new Color(114,128,255));
        
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
        southPanel.add(instIdPanel);
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
        setTitle("inst Manage");
		setSize(850, 550);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
    }
   
    public JTextField getInstIdField() {
    	return this.instId;
    }
    public JTextField getCourseIdField() {
    	return this.courseId;
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
    
}

