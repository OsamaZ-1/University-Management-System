package View;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import java.awt.*;

public class StudentTranscriptView extends JFrame implements View{

	//Frame
	//private JFrame 
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
	
	private JComboBox<String> studentSemesters;
	
	//transcripts table for student marks
	private JTable transcriptTable;
    private JScrollPane scrollPane;
    private Object[] tableColumns;
    private DefaultTableModel tableModelInfo;
    
    private JButton finalTranscript;
    private JButton logout;
    
    //Panels
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
    private JPanel filterPanel;
    private JFrame mainPanel;
    
    //Layouts
    private BorderLayout borderLayout;
    private SpringLayout springLayout;

    //Fonts and Color
    private Font font,fontTable;
    private Color color;

    @SuppressWarnings("serial")
	public StudentTranscriptView() {
    	
    	font=new Font ("Arial", Font.BOLD, 17);
    	fontTable=new Font("Arial", Font.BOLD, 15);
        color = new Color(83,131,255);
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
    	gpaLabel.setForeground(new Color(245,5,5));
    	
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
    	gpa.setForeground(new Color(245,5,5));
    	
    	studentSemesters= new JComboBox<String>();
    	studentSemesters.setPreferredSize(new Dimension(180,40));
    	studentSemesters.setFont(font);
    	
    	tableColumns = new Object[]{"Year","Course Code","Title","Credits","Grade","Observation"};
    	
    	transcriptTable = new JTable() {
    		public Component prepareRenderer(TableCellRenderer render,int row,int col) {
    			Component comp=super.prepareRenderer(render, row, col);
    			if(this.getModel().getRowCount()>0) {
    			Object value=getModel().getValueAt(row, col);
    			if(value.equals("Passed")) {
    				comp.setForeground(Color.green);
    			}
    			else if(value.equals("Failed")) {
    				comp.setForeground(Color.red);
    			}
    			else if(value.equals("grade not in Acc. history")) {
    				comp.setForeground(Color.black);
    			}
    			else {
    				comp.setForeground(Color.blue);
    			}
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
        
        logout=new JButton("Logout");
        logout.setFont(font);
        finalTranscript=new JButton("Final Transcript");
        finalTranscript.setFont(font);
        finalTranscript.setBackground(Color.CYAN);
        finalTranscript.setPreferredSize(new Dimension(180,40));
        
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
        mainPanel=new JFrame();
        
        infoP1.setBackground(color);
        infoP2.setBackground(color);
        infoP3.setBackground(color);
        infoP4.setBackground(color);
        studentInfoPanel.setBackground(color);
    	trascriptPanel.setBackground(new Color(240,240,240));
    	studentGpaPanel.setBackground(color);
    	gpaP1.setBackground(color);
    	gpaP2.setBackground(color);
    	gpaP3.setBackground(color);
    	
    	borderLayout=new BorderLayout(0,0);
    	
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
        
        filterPanel=new JPanel();
        filterPanel.setLayout(new FlowLayout(FlowLayout.CENTER,60,5));
        filterPanel.setBackground(color);
        filterPanel.add(studentSemesters);
        filterPanel.add(finalTranscript);
        
        //transcript panel setup
        trascriptPanel.setLayout(new BorderLayout());
        trascriptPanel.add(filterPanel,BorderLayout.NORTH);
        trascriptPanel.add(scrollPane,BorderLayout.CENTER);
        
        //gpa panel setup
        studentGpaPanel.setLayout(new GridLayout(1,3));
        gpaP1.setLayout(new FlowLayout(FlowLayout.LEFT,1,1));
        gpaP1.add(earnedCreditsLabel);
        gpaP1.add(earnedCredits);
        
        springLayout=new SpringLayout();
        gpaP2.setLayout(springLayout);
        gpaP2.add(totalCreditsLabel);
        gpaP2.add(totalCredits);
        gpaP2.add(logout);
        springLayout.putConstraint(SpringLayout.NORTH,totalCreditsLabel,1,SpringLayout.NORTH,gpaP2);
        springLayout.putConstraint(SpringLayout.NORTH,totalCredits,1,SpringLayout.NORTH,gpaP2);
        springLayout.putConstraint(SpringLayout.WEST,totalCredits,125,SpringLayout.WEST,totalCreditsLabel);
        
        springLayout.putConstraint(SpringLayout.NORTH,logout,30,SpringLayout.NORTH,totalCreditsLabel);
        springLayout.putConstraint(SpringLayout.WEST,logout,70,SpringLayout.WEST,totalCreditsLabel);
        
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
        
        mainPanel.setTitle("Student Transcript");
		mainPanel.setSize(900, 800);
		mainPanel.setDefaultCloseOperation(EXIT_ON_CLOSE);
		mainPanel.setVisible(true);
		mainPanel.setLocationRelativeTo(null);
    	
    }

    public JFrame getMainFrame()
    {
        return this.mainPanel;
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
    public JButton getLogoutButton() {
    	return this.logout;
    }
    public JButton getFinalTranscriptButton() {
    	return this.finalTranscript;
    }
    public JComboBox<String> getStudentSemestersList() {
    	return this.studentSemesters;
    }
    
}
