package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;

public class AdminCourseView{
	//Buttons
	private JButton add;
	private JButton delete;
	private JButton edit;
	
    //Labels
    private JLabel title; 
	private JLabel nameLabelAdd;
	private JLabel creditsLabelAdd;
	private JLabel houresLabelAdd;
	private JLabel majorLabelAdd;
	private JLabel yearLabelAdd;
	private JLabel codeLabel;
	private JLabel editLabel;

    private JLabel nameLabelEdit;
	private JLabel creditsLabelEdit;
	private JLabel houresLabelEdit;
	private JLabel majorLabelEdit;
	private JLabel yearLabelEdit;
	private JLabel codeLabelEdit;
	
    //Fields
	private JTextField nameAdd;
	private JTextField creditsAdd;
	private JTextField houresAdd;
	private JComboBox<String> majorAdd;
	private JTextField yearAdd;
    private JTextField code;
    
	private JTextField nameEdit;
	private JTextField creditsEdit;
	private JTextField houresEdit;
	private JComboBox<String> majorEdit;
	private JTextField yearEdit;
    private JTextField codeEdit;
	private JComboBox<String> actionFields;
	
    //Table
	private JTable courseTable;
    private JScrollPane scrollPane;
    private Object[] tableColumns;
    private DefaultTableModel tableModelInfo;
    
    //Panel
    private JPanel tablePanel;
    private JPanel southPanel;
    private JPanel buttonsPanel;
    private JPanel cardPanel;
    private JPanel addPanel;
    private JPanel deletePanel;
    private JPanel editPanel;
    private JPanel titlePanel;
    private JFrame mainPanel;
    
    //Fonts and Color
    private Font font,fontTable,buttonFont;
    private CardLayout cardLayout;
    private SpringLayout springLayout,springLayout2;
    private Color color;
    
    private final String ADD_PANEL_CODE="1";
    private final String DELETE_PANEL_CODE="2";
    private final String EDIT_PANEL_CODE="3";
    
    public AdminCourseView() {
    	title=new JLabel("Course Management");
    	add=new JButton("Add");
    	delete=new JButton("Delete");
    	edit=new JButton("Edit");
    	
    	font=new Font ("Arial", Font.BOLD, 17);
    	fontTable=new Font("Arial", Font.BOLD, 15);
    	buttonFont = new Font("Arial",Font.BOLD,17);
        color = new Color(83,131,255);

    	title.setFont(new Font("Arial", Font.BOLD, 25));
    	
    	nameLabelAdd=new JLabel("Name: ");
    	nameLabelAdd.setFont(font);
        creditsLabelAdd=new JLabel("Credits: ");
        creditsLabelAdd.setFont(font);
        houresLabelAdd=new JLabel("Hours: ");
        houresLabelAdd.setFont(font);
        majorLabelAdd=new JLabel("Major: ");
        majorLabelAdd.setFont(font);
        yearLabelAdd=new JLabel("Year: ");
        yearLabelAdd.setFont(font);
        codeLabel=new JLabel("Course Code: ");
        codeLabel.setFont(font);
        
        nameAdd=new JTextField();
        nameAdd.setColumns(15);
        nameAdd.setFont(font);
        creditsAdd=new JTextField();
        creditsAdd.setColumns(5);
        creditsAdd.setFont(font);
        houresAdd=new JTextField();
        houresAdd.setColumns(5);
        houresAdd.setFont(font);
        majorAdd=new JComboBox<>(new String[]{"Select Major","Informatics","Math","Physics","Biology","Chemistry"});
        majorAdd.setFont(font);
        yearAdd=new JTextField();
        yearAdd.setColumns(5);
        yearAdd.setFont(font);
        code=new JTextField();
        code.setColumns(5);
        code.setEditable(false);
        code.setFont(font);
        
        nameLabelEdit=new JLabel("Name: ");
    	nameLabelEdit.setFont(font);
        creditsLabelEdit=new JLabel("Credits: ");
        creditsLabelEdit.setFont(font);
        houresLabelEdit=new JLabel("Hours: ");
        houresLabelEdit.setFont(font);
        majorLabelEdit=new JLabel("Major: ");
        majorLabelEdit.setFont(font);
        yearLabelEdit=new JLabel("Year:");
        yearLabelEdit.setFont(font);
        codeLabelEdit=new JLabel("Code: ");
        codeLabelEdit.setFont(font);
        editLabel=new JLabel("Select Row To Fill Fields");
        editLabel.setFont(font);
        
        nameEdit=new JTextField();
        nameEdit.setColumns(10);
        nameEdit.setFont(font);
        creditsEdit=new JTextField();
        creditsEdit.setColumns(5);
        creditsEdit.setFont(font);
        houresEdit=new JTextField();
        houresEdit.setColumns(5);
        houresEdit.setFont(font);
        majorEdit=new JComboBox<>(new String[]{"Select Major","Informatics","Math","Physics","Biology","Chemistry"});
        majorEdit.setFont(font);
        yearEdit=new JTextField();
        yearEdit.setColumns(5);
        yearEdit.setFont(font);
        codeEdit=new JTextField();
        codeEdit.setColumns(5);
        codeEdit.setFont(font);
    	codeEdit.setEditable(false);
        
        actionFields=new JComboBox<String>(new String[]{"Add","Edit","Delete"});
        actionFields.setFont(font);
        
    	add.setFont(buttonFont);
        add.setPreferredSize(new Dimension(90,40));
    	edit.setFont(buttonFont);
        edit.setPreferredSize(new Dimension(90,40));
    	delete.setFont(buttonFont);
        delete.setPreferredSize(new Dimension(90,40));
    	add.setBackground(Color.yellow);
    	edit.setBackground(Color.green);
    	delete.setBackground(Color.red);
    	
    	tableColumns = new Object[]{"CourseName","CourseCode","CourseCredits","CourseHours","CourseMajor","CourseYear"};
    	courseTable=new JTable();
    
    	courseTable.setFont(fontTable);
    	courseTable.getTableHeader().setFont(font);
    	courseTable.getTableHeader().setForeground(Color.BLUE);
    	scrollPane = new JScrollPane(courseTable);
    	
        tableModelInfo = new DefaultTableModel();
        tableModelInfo.setColumnIdentifiers(tableColumns);
        courseTable.setModel(tableModelInfo);
        
        cardLayout=new CardLayout();
        tablePanel=new JPanel();
        southPanel=new JPanel();
        buttonsPanel=new JPanel();
        cardPanel=new JPanel();
        addPanel=new JPanel();
        deletePanel=new JPanel();
        editPanel=new JPanel();
        titlePanel=new JPanel();
        mainPanel=new JFrame();
        
        tablePanel.setBackground(color);
        buttonsPanel.setBackground(color);
        titlePanel.setBackground(color);
        mainPanel.setBackground(color);
        
        titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        titlePanel.add(title);
        
        tablePanel.setLayout(new BorderLayout());
        tablePanel.add(scrollPane,BorderLayout.CENTER);
        
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER,4,4));
        buttonsPanel.add(actionFields);
        buttonsPanel.setPreferredSize(new Dimension(40,40));
        
        springLayout=new SpringLayout();
        addPanel.setLayout(springLayout);
        addPanel.add(nameLabelAdd);
        addPanel.add(nameAdd);
        addPanel.add(majorLabelAdd);
        addPanel.add(majorAdd);
        
        addPanel.add(creditsLabelAdd);
        addPanel.add(creditsAdd);
        addPanel.add(houresLabelAdd);
        addPanel.add(houresAdd);
        addPanel.add(yearLabelAdd);
        addPanel.add(yearAdd);
        addPanel.add(add);
        
        springLayout.putConstraint(SpringLayout.NORTH,nameLabelAdd,25,SpringLayout.NORTH,addPanel);
        springLayout.putConstraint(SpringLayout.NORTH,nameAdd,20,SpringLayout.NORTH,addPanel);
        springLayout.putConstraint(SpringLayout.NORTH,majorLabelAdd,25,SpringLayout.NORTH,addPanel);
        springLayout.putConstraint(SpringLayout.NORTH,majorAdd,25,SpringLayout.NORTH,addPanel);
        
        springLayout.putConstraint(SpringLayout.WEST,nameLabelAdd,0,SpringLayout.WEST,addPanel);
        springLayout.putConstraint(SpringLayout.WEST,nameAdd,0,SpringLayout.EAST,nameLabelAdd);
        springLayout.putConstraint(SpringLayout.WEST,majorLabelAdd,270,SpringLayout.WEST,nameAdd);
        springLayout.putConstraint(SpringLayout.WEST,majorAdd,0,SpringLayout.EAST,majorLabelAdd);
        
        springLayout.putConstraint(SpringLayout.NORTH,creditsLabelAdd,40,SpringLayout.NORTH,nameLabelAdd);
        springLayout.putConstraint(SpringLayout.WEST,creditsLabelAdd,0,SpringLayout.WEST,addPanel);
        springLayout.putConstraint(SpringLayout.NORTH,creditsAdd,35,SpringLayout.NORTH,nameLabelAdd);
        springLayout.putConstraint(SpringLayout.WEST,creditsAdd,5,SpringLayout.EAST,creditsLabelAdd);
        
        springLayout.putConstraint(SpringLayout.NORTH,houresLabelAdd,40,SpringLayout.NORTH,nameLabelAdd);
        springLayout.putConstraint(SpringLayout.WEST,houresLabelAdd,150,SpringLayout.WEST,creditsAdd);
        springLayout.putConstraint(SpringLayout.NORTH,houresAdd,35,SpringLayout.NORTH,nameLabelAdd);
        springLayout.putConstraint(SpringLayout.WEST,houresAdd,5,SpringLayout.EAST,houresLabelAdd);
        
        springLayout.putConstraint(SpringLayout.NORTH,yearLabelAdd,40,SpringLayout.NORTH,nameLabelAdd);
        springLayout.putConstraint(SpringLayout.WEST,yearLabelAdd,150,SpringLayout.WEST,houresAdd);
        springLayout.putConstraint(SpringLayout.NORTH,yearAdd,35,SpringLayout.NORTH,nameLabelAdd);
        springLayout.putConstraint(SpringLayout.WEST,yearAdd,5,SpringLayout.EAST,yearLabelAdd);
        
        springLayout.putConstraint(SpringLayout.NORTH,add,50,SpringLayout.SOUTH,yearLabelAdd);
        springLayout.putConstraint(SpringLayout.WEST,add,310,SpringLayout.WEST,addPanel);
       
        addPanel.setPreferredSize(new Dimension(100,150));
        addPanel.setBackground(color);
        
        springLayout2=new SpringLayout();
        editPanel.setLayout(springLayout2);
        editPanel.add(editLabel);
        editPanel.add(codeLabelEdit);
        editPanel.add(codeEdit);
        editPanel.add(nameLabelEdit);
        editPanel.add(nameEdit);
        editPanel.add(majorLabelEdit);
        editPanel.add(majorEdit);
        editPanel.add(creditsLabelEdit);
        editPanel.add(creditsEdit);
        editPanel.add(houresLabelEdit);
        editPanel.add(houresEdit);
        editPanel.add(yearLabelEdit);
        editPanel.add(yearEdit);
        editPanel.add(edit);
        
        springLayout2.putConstraint(SpringLayout.NORTH,editLabel,0,SpringLayout.NORTH,editPanel);
        springLayout2.putConstraint(SpringLayout.WEST,editLabel,0,SpringLayout.WEST,editPanel);
        
        springLayout2.putConstraint(SpringLayout.NORTH,codeLabelEdit,10,SpringLayout.SOUTH,editLabel);
        springLayout2.putConstraint(SpringLayout.NORTH,codeEdit,5,SpringLayout.SOUTH,editLabel);
        
        springLayout2.putConstraint(SpringLayout.NORTH,nameLabelEdit,45,SpringLayout.SOUTH,editLabel);
        springLayout2.putConstraint(SpringLayout.NORTH,nameEdit,40,SpringLayout.SOUTH,editLabel);
        springLayout2.putConstraint(SpringLayout.NORTH,majorLabelEdit,45,SpringLayout.SOUTH,editLabel);
        springLayout2.putConstraint(SpringLayout.NORTH,majorEdit,45,SpringLayout.SOUTH,editLabel);
        
        springLayout2.putConstraint(SpringLayout.WEST,codeLabelEdit,0,SpringLayout.WEST,editPanel);
        springLayout2.putConstraint(SpringLayout.WEST,codeEdit,10,SpringLayout.EAST,codeLabelEdit);
        
        springLayout2.putConstraint(SpringLayout.WEST,nameLabelEdit,0,SpringLayout.WEST,editPanel);
        springLayout2.putConstraint(SpringLayout.WEST,nameEdit,68,SpringLayout.WEST,nameLabelEdit);
        springLayout2.putConstraint(SpringLayout.WEST,majorLabelEdit,250,SpringLayout.WEST,nameEdit);
        springLayout2.putConstraint(SpringLayout.WEST,majorEdit,70,SpringLayout.WEST,majorLabelEdit);
        
        springLayout2.putConstraint(SpringLayout.NORTH,creditsLabelEdit,35,SpringLayout.NORTH,nameLabelEdit);
        springLayout2.putConstraint(SpringLayout.WEST,creditsLabelEdit,0,SpringLayout.WEST,editPanel);
        springLayout2.putConstraint(SpringLayout.NORTH,creditsEdit,30,SpringLayout.NORTH,nameLabelEdit);
        springLayout2.putConstraint(SpringLayout.WEST,creditsEdit,5,SpringLayout.EAST,creditsLabelEdit);
        
        springLayout2.putConstraint(SpringLayout.NORTH,houresLabelEdit,35,SpringLayout.NORTH,nameLabelEdit);
        springLayout2.putConstraint(SpringLayout.WEST,houresLabelEdit,100,SpringLayout.WEST,creditsEdit);
        springLayout2.putConstraint(SpringLayout.NORTH,houresEdit,30,SpringLayout.NORTH,nameLabelEdit);
        springLayout2.putConstraint(SpringLayout.WEST,houresEdit,5,SpringLayout.EAST,houresLabelEdit);
        
        springLayout2.putConstraint(SpringLayout.NORTH,yearLabelEdit,35,SpringLayout.NORTH,nameLabelEdit);
        springLayout2.putConstraint(SpringLayout.WEST,yearLabelEdit,100,SpringLayout.WEST,houresEdit);
        springLayout2.putConstraint(SpringLayout.NORTH,yearEdit,30,SpringLayout.NORTH,nameLabelEdit);
        springLayout2.putConstraint(SpringLayout.WEST,yearEdit,5,SpringLayout.EAST,yearLabelEdit);
        
        springLayout2.putConstraint(SpringLayout.NORTH,edit,20,SpringLayout.SOUTH,yearLabelEdit);
        springLayout2.putConstraint(SpringLayout.WEST,edit,310,SpringLayout.WEST,editPanel);
       
        editPanel.setPreferredSize(new Dimension(100,180));
        editPanel.setBackground(color);
        
        deletePanel.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
        deletePanel.add(codeLabel);
        deletePanel.add(code);
        deletePanel.add(delete);
        deletePanel.setPreferredSize(new Dimension(100,100));
        deletePanel.setBackground(color);
        
        cardPanel.setLayout(cardLayout);
        cardPanel.add(addPanel,getAddPanelCode());
        cardPanel.add(deletePanel,getDeletePanelCode());
        cardPanel.add(editPanel,getEditPanelCode());
        cardPanel.setBackground(color);
        
        southPanel.setLayout(new BorderLayout());
        southPanel.add(buttonsPanel,BorderLayout.NORTH);
        southPanel.add(cardPanel,BorderLayout.CENTER);
        southPanel.setBackground(color);
        
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(titlePanel,BorderLayout.NORTH);
        mainPanel.add(tablePanel,BorderLayout.CENTER);
        mainPanel.add(southPanel,BorderLayout.SOUTH);
        
        
        mainPanel.setBackground(color);
        mainPanel.setTitle("Course Management");
		mainPanel.setSize(720, 550);
		mainPanel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		mainPanel.setVisible(true);
		mainPanel.setLocationRelativeTo(null);
    }
    
    public JFrame getMainFrame()
    {
        return this.mainPanel;
    }

    public JTable getCourseTable() {
    	return this.courseTable;
    }

    public DefaultTableModel getTableModel() {
    	return this.tableModelInfo;
    }

    public JButton getAddButton() {
    	return this.add;
    }

    public JButton getEditButton() {
    	return this.edit;
    }

    public JButton getDeleteButton() {
    	return this.delete;
    }

    public JTextField getNameEditField() {
    	return this.nameEdit;
    }

    public JTextField getCreditsEditField() {
    	return this.creditsEdit;
    }

    public JTextField getHouresEditField() {
    	return this.houresEdit;
    }

    public JComboBox<String> getMajorEditField() {
    	return this.majorEdit;
    }

    public JTextField getYearEditField() {
    	return this.yearEdit;
    }

    public JTextField getCodeEditField() {
    	return this.codeEdit;
    }

    public JTextField getNameAddField() {
    	return this.nameAdd;
    }

    public JTextField getCreditsAddField() {
    	return this.creditsAdd;
    }

    public JTextField getHouresAddField() {
    	return this.houresAdd;
    }

    public JComboBox<String> getMajorAddField() {
    	return this.majorAdd;
    }

    public JTextField getYearAddField() {
    	return this.yearAdd;
    }

    public JTextField getCodeDeleteField() {
    	return this.code;
    }

    public JComboBox<String> getComboBoxActionFields() {
    	return this.actionFields;
    }

    public CardLayout getCardLayout() {
    	return this.cardLayout;
    }

    public JPanel getCardPanel() {
    	return this.cardPanel;
    }

    public String getAddPanelCode() {
    	return this.ADD_PANEL_CODE;
    }

    public String getEditPanelCode() {
    	return this.EDIT_PANEL_CODE;
    }

    public String getDeletePanelCode() {
    	return this.DELETE_PANEL_CODE;
    }
}
