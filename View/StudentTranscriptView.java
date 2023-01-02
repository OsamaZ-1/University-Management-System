package View;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import java.awt.*;
import java.util.*;

public class StudentTranscriptView extends JFrame{

	//labels for information
	private JLabel nameLabel;
	private JLabel idLabel;
	private JLabel emailLabel;
	private JLabel phoneLabel;
	private JLabel earnedCreditsLabel;
	private JLabel totalCreditsLabel;
	private JLabel gpaLabel;
	
	//student information
	private JLabel name;
	private JLabel id;
	private JLabel email;
	private JLabel phone;
	private JLabel earnedCredits;
	private JLabel totalCredits;
	private JLabel gpa;
	
	//transcripts table for student marks
	private JTable transcriptTable;
    private JScrollPane scrollPane;
    private Object[] tableColumns;
    private DefaultTableModel tableModelInfo;
    private Object[][] s;
    
    //panels
    private JPanel studentInfoPanel;
    private JPanel infoP1;
    private JPanel infoP2;
    private JPanel infoP3;
    private JPanel infoP4;
    private JPanel studentGpaPanel;
    private JPanel gpaP1;
    private JPanel gpaP2;
    private JPanel gpaP3;
    private JPanel trascriptPanel;
    private JPanel mainPanel;
    
    private BorderLayout borderLayout;
    private Font font,fontTable;
    public StudentTranscriptView() {
    	
    	font=new Font ("AvantGarde", Font.BOLD, 18);
    	fontTable=new Font("AvantGarde", Font.BOLD, 15);
    	nameLabel=new JLabel("Name:");
    	nameLabel.setFont(font);
    	idLabel=new JLabel("ID:");
    	idLabel.setFont(font);
    	emailLabel=new JLabel("Email:");
    	emailLabel.setFont(font);
    	phoneLabel=new JLabel("Phone:");
    	phoneLabel.setFont(font);
    	
    	earnedCreditsLabel=new JLabel("Earned Credits:");
    	earnedCreditsLabel.setFont(font);
    	totalCreditsLabel=new JLabel("Total Credits:");
    	totalCreditsLabel.setFont(font);
    	gpaLabel=new JLabel("GPA:");
    	gpaLabel.setFont(new Font ("AvantGarde", Font.BOLD, 25));
    	gpaLabel.setForeground(new Color(200,10,10));
    	
    	name=new JLabel("");
    	name.setFont(font);
    	id=new JLabel("");
    	id.setFont(font);
    	email=new JLabel("");
    	email.setFont(font);
    	phone=new JLabel("");
    	phone.setFont(font);
    	
    	earnedCredits=new JLabel("");
    	earnedCredits.setFont(font);
    	totalCredits=new JLabel("");
    	totalCredits.setFont(font);
    	gpa=new JLabel("");
    	gpa.setFont(new Font ("AvantGarde", Font.BOLD, 25));
    	gpa.setForeground(new Color(200,10,10));
    	
    	tableColumns = new Object[]{"Year","Crse Code","Title","Crd.","Grade","Observation"};
    	
    	transcriptTable = new JTable() {
    		public Component prepareRenderer(TableCellRenderer render,int row,int col) {
    			Component comp=super.prepareRenderer(render, row, col);
    			Object value=getModel().getValueAt(row, col);
    			if(value.equals("Passed")) {
    				comp.setForeground(Color.green);
    			}
    			else if(value.equals("Failed")) {
    				comp.setForeground(Color.red);
    			}
    			else {
    				comp.setForeground(Color.blue);
    			}
    			
    			return comp;
    		}};
    		
    	transcriptTable.setFont(fontTable);
    	transcriptTable.getTableHeader().setFont(font);
    	transcriptTable.getTableHeader().setForeground(Color.BLUE);
        scrollPane = new JScrollPane(transcriptTable);
        
        tableModelInfo = new DefaultTableModel();
        tableModelInfo.setColumnIdentifiers(tableColumns);
        transcriptTable.setModel(tableModelInfo);
        
        studentInfoPanel=new JPanel();
        infoP1=new JPanel();
        infoP2=new JPanel();
        infoP3=new JPanel();
        infoP4=new JPanel();
        studentGpaPanel=new JPanel();
        gpaP1=new JPanel();
        gpaP2=new JPanel();
        gpaP3=new JPanel();
        trascriptPanel=new JPanel();
        mainPanel=new JPanel();
        
        infoP1.setBackground(new Color(200,150,255));
        infoP2.setBackground(new Color(200,150,255));
        infoP3.setBackground(new Color(200,150,255));
        infoP4.setBackground(new Color(200,150,255));
        studentInfoPanel.setBackground(new Color(200,150,255));
    	trascriptPanel.setBackground(new Color(240,240,240));
    	studentGpaPanel.setBackground(new Color(200,150,255));
    	gpaP1.setBackground(new Color(200,150,255));
    	gpaP2.setBackground(new Color(200,150,255));
    	gpaP3.setBackground(new Color(200,150,255));
    	
    	borderLayout=new BorderLayout(1,1);
    	
    	//Information panel setup
    	studentInfoPanel.setLayout(new GridLayout(2,2));
        infoP1.setLayout(new FlowLayout(FlowLayout.LEFT,1,1));
        infoP1.add(nameLabel);
        infoP1.add(name);
        
        infoP2.setLayout(new FlowLayout(FlowLayout.LEFT,1,1));
        infoP2.add(emailLabel);
        infoP2.add(email);
     
        infoP3.setLayout(new FlowLayout(FlowLayout.LEFT,1,1));
        infoP3.add(phoneLabel);
        infoP3.add(phone);
        
        infoP4.setLayout(new FlowLayout(FlowLayout.LEFT,1,1));
        infoP4.add(idLabel);
        infoP4.add(id);
        
        studentInfoPanel.add(infoP1);
        studentInfoPanel.add(infoP2);
        studentInfoPanel.add(infoP3);
        studentInfoPanel.add(infoP4);
        
        //transcript panel setup
        trascriptPanel.setLayout(new BorderLayout());
        trascriptPanel.add(scrollPane,BorderLayout.CENTER);
        
        //gpa panel setup
        studentGpaPanel.setLayout(new GridLayout(1,3));
        gpaP1.setLayout(new FlowLayout(FlowLayout.LEFT,1,1));
        gpaP1.add(earnedCreditsLabel);
        gpaP1.add(earnedCredits);
        
        gpaP2.setLayout(new FlowLayout(FlowLayout.LEFT,1,1));
        gpaP2.add(totalCreditsLabel);
        gpaP2.add(totalCredits);
        
        gpaP3.setLayout(new FlowLayout(FlowLayout.RIGHT,1,1));
        gpaP3.add(gpaLabel);
        gpaP3.add(gpa);
        
        studentGpaPanel.add(gpaP1);
        studentGpaPanel.add(gpaP2);
        studentGpaPanel.add(gpaP3);
        
        //panels size
        studentInfoPanel.setPreferredSize(new Dimension(800,75));
        trascriptPanel.setPreferredSize(new Dimension(800,750));
        studentGpaPanel.setPreferredSize(new Dimension(800,75));
        
        mainPanel.setLayout(borderLayout);
        mainPanel.add(studentInfoPanel,BorderLayout.NORTH);
        mainPanel.add(trascriptPanel,BorderLayout.CENTER);
        mainPanel.add(studentGpaPanel,BorderLayout.SOUTH);
        add(mainPanel);
        setTitle("Student Transcript");
		setSize(800, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
    	
    }
    public JLabel getNameLabel() {
    	return this.name;
    }
    public JLabel getEmailLabel() {
    	return this.email;
    }
    public JLabel getPhoneLabel() {
    	return this.phone;
    }
    public JLabel getIdLabel() {
    	return this.id;
    }
    public JLabel getTotalCreditsLabel() {
    	return this.totalCredits;
    }
    public JLabel getEarnedCreditsLabel() {
    	return this.earnedCredits;
    }
    public JLabel getGpaLabel() {
    	return this.gpa;
    }
    public JTable getTranscriptTable() {
    	return this.transcriptTable;
    }
    public DefaultTableModel getTableModel() {
    	return this.tableModelInfo;
    }
    
}
