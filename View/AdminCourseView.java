package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;

public class AdminCourseView implements View{
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
	private JLabel semesterLabelAdd;
	private JLabel codeLabel;
    private JLabel reqAddLabel;
    private JLabel reqEditLabel;

    private JLabel nameLabelEdit;
	private JLabel creditsLabelEdit;
	private JLabel houresLabelEdit;
	private JLabel majorLabelEdit;
	private JLabel yearLabelEdit;
	private JLabel semesterLabelEdit;
	private JLabel codeLabelEdit;
	
    //Fields
	private JTextField nameAdd;
	private JTextField creditsAdd;
	private JTextField houresAdd;
	private JComboBox<String> majorAdd;
	private JComboBox<String> yearAdd;
	private JComboBox<String> semesterAdd;
    private JComboBox<String> reqAdd;
    private JTextField code;
    
	private JTextField nameEdit;
	private JTextField creditsEdit;
	private JTextField houresEdit;
	private JComboBox<String> majorEdit;
	private JComboBox<String> yearEdit;
	private JComboBox<String> semesterEdit;
    private JComboBox<String> reqEdit;
    private JTextField codeEdit;
	private JComboBox<String> actionFields;
	
	//Objects
	String[] years;
	String[] yearOne;
	String[] yearTwo;
	String[] yearThree;
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

        years=new String[] {"Select Year","1","2","3"};
    	yearOne=new String[] {"Select Semester","1","2"};
    	yearTwo=new String[] {"Select Semester","3","4"};
    	yearThree=new String[] {"Select Semester","5","6"};
    	
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
        semesterLabelAdd=new JLabel("Semester: ");
        semesterLabelAdd.setFont(font);
        codeLabel=new JLabel("Course Code: ");
        codeLabel.setFont(font);
        reqAddLabel = new JLabel("PreRequisite: ");
        reqAddLabel.setFont(font);
        reqEditLabel = new JLabel("PreRequisite: ");
        reqEditLabel.setFont(font);
        
        nameAdd=new JTextField();
        nameAdd.setColumns(15);
        nameAdd.setFont(font);
        creditsAdd=new JTextField();
        creditsAdd.setColumns(5);
        creditsAdd.setFont(font);
        houresAdd=new JTextField();
        houresAdd.setColumns(5);
        houresAdd.setFont(font);
        majorAdd=new JComboBox<>(new String[]{"Select Major","Informatics","Math","Physics","Biology","Chemistry","BioChemistry"});
        majorAdd.setFont(font);
        semesterAdd=new JComboBox<String>(new String[]{"Select Semester"});
        semesterAdd.setFont(font);
        yearAdd=new JComboBox<String>(years);
        yearAdd.setFont(font);
        code=new JTextField();
        code.setColumns(5);
        code.setEditable(false);
        code.setFont(font);
        reqAdd = new JComboBox<>(new String[]{"Select Course","none"});
        reqAdd.setFont(font);
        reqEdit = new JComboBox<>(new String[]{"Select Course","none"});
        reqEdit.setFont(font);
        
        nameLabelEdit=new JLabel("Name: ");
    	nameLabelEdit.setFont(font);
        creditsLabelEdit=new JLabel("Credits: ");
        creditsLabelEdit.setFont(font);
        houresLabelEdit=new JLabel("Hours: ");
        houresLabelEdit.setFont(font);
        majorLabelEdit=new JLabel("Major: ");
        majorLabelEdit.setFont(font);
        yearLabelEdit=new JLabel("Year: ");
        yearLabelEdit.setFont(font);
        semesterLabelEdit=new JLabel("Semester: ");
        semesterLabelEdit.setFont(font);
        codeLabelEdit=new JLabel("Code: ");
        codeLabelEdit.setFont(font);
        
        
        nameEdit=new JTextField();
        nameEdit.setColumns(10);
        nameEdit.setFont(font);
        creditsEdit=new JTextField();
        creditsEdit.setColumns(5);
        creditsEdit.setFont(font);
        houresEdit=new JTextField();
        houresEdit.setColumns(5);
        houresEdit.setFont(font);
        majorEdit=new JComboBox<>(new String[]{"Select Major","Informatics","Math","Physics","Biology","Chemistry","BioChemistry"});
        majorEdit.setFont(font);
        yearEdit=new JComboBox<String>(years);
        yearEdit.setFont(font);
        semesterEdit=new JComboBox<String>(new String[]{"Select Semester"});
        semesterEdit.setFont(font);
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
    	
    	tableColumns = new Object[]{"CourseName","CourseCode","PreRequisite","Credits","Hours","Major","Year","Semester"};
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
        addPanel.add(semesterLabelAdd);
        addPanel.add(semesterAdd);
        addPanel.add(reqAddLabel);
        addPanel.add(reqAdd);
        
        springLayout.putConstraint(SpringLayout.NORTH,nameLabelAdd,15,SpringLayout.NORTH,addPanel);
        springLayout.putConstraint(SpringLayout.NORTH,nameAdd,10,SpringLayout.NORTH,addPanel);
        springLayout.putConstraint(SpringLayout.NORTH,creditsLabelAdd,35,SpringLayout.SOUTH,nameAdd);
        springLayout.putConstraint(SpringLayout.NORTH,creditsAdd,30,SpringLayout.SOUTH,nameAdd);
        springLayout.putConstraint(SpringLayout.NORTH,houresLabelAdd,35,SpringLayout.SOUTH,nameAdd);
        springLayout.putConstraint(SpringLayout.NORTH,houresAdd,30,SpringLayout.SOUTH,nameAdd);
        
        springLayout.putConstraint(SpringLayout.WEST,nameLabelAdd,10,SpringLayout.WEST,addPanel);
        springLayout.putConstraint(SpringLayout.WEST,nameAdd,0,SpringLayout.EAST,nameLabelAdd);
        springLayout.putConstraint(SpringLayout.WEST,creditsLabelAdd,10,SpringLayout.WEST,addPanel);
        springLayout.putConstraint(SpringLayout.WEST,creditsAdd,0,SpringLayout.EAST,creditsLabelAdd);
        springLayout.putConstraint(SpringLayout.WEST,houresLabelAdd,30,SpringLayout.EAST,creditsAdd);
        springLayout.putConstraint(SpringLayout.WEST,houresAdd,0,SpringLayout.EAST,houresLabelAdd);
        
        springLayout.putConstraint(SpringLayout.NORTH,majorLabelAdd,17,SpringLayout.NORTH,addPanel);
        springLayout.putConstraint(SpringLayout.WEST,majorLabelAdd,200,SpringLayout.EAST,nameAdd);
        springLayout.putConstraint(SpringLayout.NORTH,majorAdd,15,SpringLayout.NORTH,addPanel);
        springLayout.putConstraint(SpringLayout.WEST,majorAdd,0,SpringLayout.EAST,majorLabelAdd);
        
        springLayout.putConstraint(SpringLayout.NORTH,yearLabelAdd,20,SpringLayout.SOUTH,majorAdd);
        springLayout.putConstraint(SpringLayout.WEST,yearLabelAdd,8,SpringLayout.WEST,majorLabelAdd);
        springLayout.putConstraint(SpringLayout.NORTH,yearAdd,18,SpringLayout.SOUTH,nameAdd);
        springLayout.putConstraint(SpringLayout.WEST,yearAdd,0,SpringLayout.EAST,yearLabelAdd);
     
        springLayout.putConstraint(SpringLayout.NORTH,semesterLabelAdd,20,SpringLayout.SOUTH,yearAdd);
        springLayout.putConstraint(SpringLayout.WEST,semesterLabelAdd,-28,SpringLayout.WEST,majorLabelAdd);
        springLayout.putConstraint(SpringLayout.NORTH,semesterAdd,18,SpringLayout.SOUTH,yearAdd);
        springLayout.putConstraint(SpringLayout.WEST,semesterAdd,0,SpringLayout.EAST,semesterLabelAdd);
        
        springLayout.putConstraint(SpringLayout.NORTH,reqAddLabel,20,SpringLayout.SOUTH,semesterAdd);
        springLayout.putConstraint(SpringLayout.WEST,reqAddLabel,-53,SpringLayout.WEST,majorLabelAdd);
        springLayout.putConstraint(SpringLayout.NORTH,reqAdd,18,SpringLayout.SOUTH,semesterAdd);
        springLayout.putConstraint(SpringLayout.WEST,reqAdd,0,SpringLayout.EAST,reqAddLabel);

        springLayout.putConstraint(SpringLayout.NORTH,add,30,SpringLayout.SOUTH,reqAdd);
        springLayout.putConstraint(SpringLayout.WEST,add,350,SpringLayout.WEST,addPanel);
        
        
        
        addPanel.setPreferredSize(new Dimension(100,240));
        addPanel.setBackground(color);
        
        springLayout2=new SpringLayout();
        editPanel.setLayout(springLayout2);
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
        editPanel.add(semesterLabelEdit);
        editPanel.add(semesterEdit);
        editPanel.add(reqEditLabel);
        editPanel.add(reqEdit);
        
        springLayout2.putConstraint(SpringLayout.NORTH,codeLabelEdit,25,SpringLayout.NORTH,editPanel);
        springLayout2.putConstraint(SpringLayout.NORTH,codeEdit,20,SpringLayout.NORTH,editPanel);
        springLayout2.putConstraint(SpringLayout.WEST,codeLabelEdit,10,SpringLayout.WEST,editPanel);
        springLayout2.putConstraint(SpringLayout.WEST,codeEdit,0,SpringLayout.EAST,codeLabelEdit);

        springLayout2.putConstraint(SpringLayout.NORTH,nameLabelEdit,25,SpringLayout.NORTH,editPanel);
        springLayout2.putConstraint(SpringLayout.NORTH,nameEdit,20,SpringLayout.NORTH,editPanel);
        springLayout2.putConstraint(SpringLayout.WEST,nameLabelEdit,30,SpringLayout.EAST,codeEdit);
        springLayout2.putConstraint(SpringLayout.WEST,nameEdit,0,SpringLayout.EAST,nameLabelEdit);
        
        springLayout2.putConstraint(SpringLayout.NORTH,creditsLabelEdit,20,SpringLayout.SOUTH,codeEdit);
        springLayout2.putConstraint(SpringLayout.NORTH,creditsEdit,15,SpringLayout.SOUTH,codeEdit);
        springLayout2.putConstraint(SpringLayout.WEST,creditsLabelEdit,10,SpringLayout.WEST,editPanel);
        springLayout2.putConstraint(SpringLayout.WEST,creditsEdit,0,SpringLayout.EAST,creditsLabelEdit);
        
        springLayout2.putConstraint(SpringLayout.NORTH,houresLabelEdit,20,SpringLayout.SOUTH,codeEdit);
        springLayout2.putConstraint(SpringLayout.NORTH,houresEdit,15,SpringLayout.SOUTH,codeEdit);
        springLayout2.putConstraint(SpringLayout.WEST,houresLabelEdit,50,SpringLayout.EAST,creditsEdit);
        springLayout2.putConstraint(SpringLayout.WEST,houresEdit,0,SpringLayout.EAST,houresLabelEdit);
        
        springLayout2.putConstraint(SpringLayout.NORTH,majorLabelEdit,27,SpringLayout.NORTH,editPanel);
        springLayout2.putConstraint(SpringLayout.WEST,majorLabelEdit,300,SpringLayout.EAST,nameAdd);
        springLayout2.putConstraint(SpringLayout.NORTH,majorEdit,25,SpringLayout.NORTH,editPanel);
        springLayout2.putConstraint(SpringLayout.WEST,majorEdit,0,SpringLayout.EAST,majorLabelEdit);

        springLayout2.putConstraint(SpringLayout.NORTH,yearLabelEdit,20,SpringLayout.SOUTH,majorEdit);
        springLayout2.putConstraint(SpringLayout.WEST,yearLabelEdit,8,SpringLayout.WEST,majorLabelEdit);
        springLayout2.putConstraint(SpringLayout.NORTH,yearEdit,18,SpringLayout.SOUTH,majorEdit);
        springLayout2.putConstraint(SpringLayout.WEST,yearEdit,0,SpringLayout.EAST,yearLabelEdit);
        
        springLayout2.putConstraint(SpringLayout.NORTH,semesterLabelEdit,20,SpringLayout.SOUTH,yearEdit);
        springLayout2.putConstraint(SpringLayout.WEST,semesterLabelEdit,-28,SpringLayout.WEST,majorLabelEdit);
        springLayout2.putConstraint(SpringLayout.NORTH,semesterEdit,18,SpringLayout.SOUTH,yearEdit);
        springLayout2.putConstraint(SpringLayout.WEST,semesterEdit,0,SpringLayout.EAST,semesterLabelEdit);

        springLayout2.putConstraint(SpringLayout.NORTH,reqEditLabel,20,SpringLayout.SOUTH,semesterEdit);
        springLayout2.putConstraint(SpringLayout.WEST,reqEditLabel,-53,SpringLayout.WEST,majorLabelEdit);
        springLayout2.putConstraint(SpringLayout.NORTH,reqEdit,18,SpringLayout.SOUTH,semesterEdit);
        springLayout2.putConstraint(SpringLayout.WEST,reqEdit,0,SpringLayout.EAST,reqEditLabel);
        
        springLayout2.putConstraint(SpringLayout.NORTH,edit,30,SpringLayout.SOUTH,reqEdit);
        springLayout2.putConstraint(SpringLayout.WEST,edit,355,SpringLayout.WEST,editPanel);
       
        editPanel.setPreferredSize(new Dimension(100,260));
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
		mainPanel.setSize(800, 650);
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

    public JComboBox<String> getYearEditList() {
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

    public JComboBox<String> getYearAddList() {
    	return this.yearAdd;
    }

    public JTextField getCodeDeleteField() {
    	return this.code;
    }

    public JComboBox<String> getComboBoxActionFields() {
    	return this.actionFields;
    }
    public JComboBox<String> getAddSemesterList(){
    	return this.semesterAdd;
    }
    public JComboBox<String> getEditSemesterList(){
    	return this.semesterEdit;
    }
    public JComboBox<String> getPreRequisiteAdd(){
        return this.reqAdd;
    }
    public JComboBox<String> getPreRequisiteEdit(){
        return this.reqEdit;
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
    public String[] getYearOneSemesters() {
    	return this.yearOne;
    }
    public String[] getYearTwoSemesters() {
    	return this.yearTwo;
    }
    public String[] getYearThreeSemesters() {
    	return this.yearThree;
    }
    public void displayMessage(String message){   
        JOptionPane.showMessageDialog(null, message);
    }
}
