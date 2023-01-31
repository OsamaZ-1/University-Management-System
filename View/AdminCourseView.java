package View;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Controller.AdminCourseController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
public class AdminCourseView extends JFrame{

	private JLabel title; 
	
	private JButton add;
	private JButton delete;
	private JButton edit;
	
	private JLabel nameLabelAdd;
	private JLabel creditsLabelAdd;
	private JLabel houresLabelAdd;
	private JLabel majorLabelAdd;
	private JLabel yearLabelAdd;
	private JLabel codeLabel;
	private JLabel editLabel;
	
	private JTextField nameAdd;
	private JTextField creditsAdd;
	private JTextField houresAdd;
	private JTextField majorAdd;
	private JTextField yearAdd;
    private JTextField code;
    
    private JLabel nameLabelEdit;
	private JLabel creditsLabelEdit;
	private JLabel houresLabelEdit;
	private JLabel majorLabelEdit;
	private JLabel yearLabelEdit;
	private JLabel codeLabelEdit;
	
	private JTextField nameEdit;
	private JTextField creditsEdit;
	private JTextField houresEdit;
	private JTextField majorEdit;
	private JTextField yearEdit;
    private JTextField codeEdit;
    
	private JComboBox actionFields;
	
	private JTable courseTable;
    private JScrollPane scrollPane;
    private Object[] tableColumns;
    private DefaultTableModel tableModelInfo;
    
    private JPanel tablePanel;
    private JPanel southPanel;
    private JPanel buttonsPanel;
    private JPanel cardPanel;
    private JPanel addPanel;
    private JPanel deletePanel;
    private JPanel editPanel;
    private JPanel titlePanel;
    private JPanel mainPanel;
    
    private Font font,fontTable;
    private CardLayout cardLayout;
    private SpringLayout springLayout,springLayout2;
    
    private final String ADD_PANEL_CODE="1";
    private final String DELETE_PANEL_CODE="2";
    private final String EDIT_PANEL_CODE="3";
    
    public AdminCourseView() {
    	title=new JLabel("Course Manage");
    	add=new JButton("ADD");
    	delete=new JButton("DELETE");
    	edit=new JButton("EDIT");
    	
    	font=new Font ("AvantGarde", Font.BOLD, 18);
    	fontTable=new Font("AvantGarde", Font.BOLD, 15);
    	
    	title.setFont(new Font("AvantGarde", Font.BOLD, 25));
    	
    	nameLabelAdd=new JLabel("Name: ");
    	nameLabelAdd.setFont(font);
        creditsLabelAdd=new JLabel("Credits: ");
        creditsLabelAdd.setFont(font);
        houresLabelAdd=new JLabel("Houres: ");
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
        majorAdd=new JTextField();
        majorAdd.setColumns(15);
        majorAdd.setFont(font);
        yearAdd=new JTextField();
        yearAdd.setColumns(5);
        yearAdd.setFont(font);
        code=new JTextField();
        code.setColumns(5);
        code.setFont(font);
        
        nameLabelEdit=new JLabel("Name: ");
    	nameLabelEdit.setFont(font);
        creditsLabelEdit=new JLabel("Credits: ");
        creditsLabelEdit.setFont(font);
        houresLabelEdit=new JLabel("Houres: ");
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
        nameEdit.setColumns(15);
        nameEdit.setFont(font);
        creditsEdit=new JTextField();
        creditsEdit.setColumns(5);
        creditsEdit.setFont(font);
        houresEdit=new JTextField();
        houresEdit.setColumns(5);
        houresEdit.setFont(font);
        majorEdit=new JTextField();
        majorEdit.setColumns(15);
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
        
    	add.setFont(new Font ("AvantGarde", Font.BOLD, 20));
    	edit.setFont(new Font ("AvantGarde", Font.BOLD, 20));
    	delete.setFont(new Font ("AvantGarde", Font.BOLD, 20));
    	add.setBackground(Color.yellow);
    	edit.setBackground(Color.green);
    	delete.setBackground(Color.red);
    	
    	tableColumns = new Object[]{"CrseName","CrseCode","CrseCredits","CrseHours","CrseMajor","CrseYear"};
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
        mainPanel=new JPanel();
        
        tablePanel.setBackground(new Color(114,128,255));
        buttonsPanel.setBackground(new Color(114,128,255));
        titlePanel.setBackground(new Color(114,128,255));
        mainPanel.setBackground(new Color(114,128,255));
        
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
        
        springLayout.putConstraint(springLayout.NORTH,nameLabelAdd,0,springLayout.NORTH,addPanel);
        springLayout.putConstraint(springLayout.NORTH,nameAdd,0,springLayout.NORTH,addPanel);
        springLayout.putConstraint(springLayout.NORTH,majorLabelAdd,0,springLayout.NORTH,addPanel);
        springLayout.putConstraint(springLayout.NORTH,majorAdd,0,springLayout.NORTH,addPanel);
        
        springLayout.putConstraint(springLayout.WEST,nameLabelAdd,0,springLayout.WEST,addPanel);
        springLayout.putConstraint(springLayout.WEST,nameAdd,70,springLayout.WEST,nameLabelAdd);
        springLayout.putConstraint(springLayout.WEST,majorLabelAdd,250,springLayout.WEST,nameAdd);
        springLayout.putConstraint(springLayout.WEST,majorAdd,70,springLayout.WEST,majorLabelAdd);
        
        springLayout.putConstraint(springLayout.NORTH,creditsLabelAdd,30,springLayout.NORTH,nameLabelAdd);
        springLayout.putConstraint(springLayout.WEST,creditsLabelAdd,0,springLayout.WEST,addPanel);
        springLayout.putConstraint(springLayout.NORTH,creditsAdd,30,springLayout.NORTH,nameLabelAdd);
        springLayout.putConstraint(springLayout.WEST,creditsAdd,70,springLayout.WEST,creditsLabelAdd);
        
        springLayout.putConstraint(springLayout.NORTH,houresLabelAdd,30,springLayout.NORTH,addPanel);
        springLayout.putConstraint(springLayout.WEST,houresLabelAdd,150,springLayout.WEST,creditsAdd);
        springLayout.putConstraint(springLayout.NORTH,houresAdd,30,springLayout.NORTH,nameLabelAdd);
        springLayout.putConstraint(springLayout.WEST,houresAdd,70,springLayout.WEST,houresLabelAdd);
        
        springLayout.putConstraint(springLayout.NORTH,yearLabelAdd,30,springLayout.NORTH,nameLabelAdd);
        springLayout.putConstraint(springLayout.WEST,yearLabelAdd,150,springLayout.WEST,houresAdd);
        springLayout.putConstraint(springLayout.NORTH,yearAdd,30,springLayout.NORTH,nameLabelAdd);
        springLayout.putConstraint(springLayout.WEST,yearAdd,70,springLayout.WEST,yearLabelAdd);
        
        springLayout.putConstraint(springLayout.NORTH,add,30,springLayout.NORTH,yearLabelAdd);
        springLayout.putConstraint(springLayout.WEST,add,250,springLayout.WEST,addPanel);
       
        addPanel.setPreferredSize(new Dimension(100,100));
        addPanel.setBackground(new Color(114,128,255));
        
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
        
        springLayout2.putConstraint(springLayout.NORTH,editLabel,0,springLayout.NORTH,editPanel);
        springLayout2.putConstraint(springLayout.WEST,editLabel,0,springLayout.WEST,editPanel);
        
        springLayout2.putConstraint(springLayout.NORTH,codeLabelEdit,0,springLayout.NORTH,editPanel);
        springLayout2.putConstraint(springLayout.NORTH,codeEdit,0,springLayout.NORTH,editPanel);
        
        springLayout2.putConstraint(springLayout.NORTH,nameLabelEdit,30,springLayout.NORTH,editLabel);
        springLayout2.putConstraint(springLayout.NORTH,nameEdit,30,springLayout.NORTH,editLabel);
        springLayout2.putConstraint(springLayout.NORTH,majorLabelEdit,30,springLayout.NORTH,editLabel);
        springLayout2.putConstraint(springLayout.NORTH,majorEdit,30,springLayout.NORTH,editLabel);
        
        springLayout2.putConstraint(springLayout.WEST,codeLabelEdit,250,springLayout.WEST,editLabel);
        springLayout2.putConstraint(springLayout.WEST,codeEdit,70,springLayout.WEST,codeLabelEdit);
        
        springLayout2.putConstraint(springLayout.WEST,nameLabelEdit,0,springLayout.WEST,editPanel);
        springLayout2.putConstraint(springLayout.WEST,nameEdit,70,springLayout.WEST,nameLabelEdit);
        springLayout2.putConstraint(springLayout.WEST,majorLabelEdit,250,springLayout.WEST,nameEdit);
        springLayout2.putConstraint(springLayout.WEST,majorEdit,70,springLayout.WEST,majorLabelEdit);
        
        springLayout2.putConstraint(springLayout.NORTH,creditsLabelEdit,30,springLayout.NORTH,nameLabelEdit);
        springLayout2.putConstraint(springLayout.WEST,creditsLabelEdit,0,springLayout.WEST,editPanel);
        springLayout2.putConstraint(springLayout.NORTH,creditsEdit,30,springLayout.NORTH,nameLabelEdit);
        springLayout2.putConstraint(springLayout.WEST,creditsEdit,70,springLayout.WEST,creditsLabelEdit);
        
        springLayout2.putConstraint(springLayout.NORTH,houresLabelEdit,30,springLayout.NORTH,nameLabelEdit);
        springLayout2.putConstraint(springLayout.WEST,houresLabelEdit,100,springLayout.WEST,creditsEdit);
        springLayout2.putConstraint(springLayout.NORTH,houresEdit,30,springLayout.NORTH,nameLabelEdit);
        springLayout2.putConstraint(springLayout.WEST,houresEdit,70,springLayout.WEST,houresLabelEdit);
        
        springLayout2.putConstraint(springLayout.NORTH,yearLabelEdit,30,springLayout.NORTH,nameLabelEdit);
        springLayout2.putConstraint(springLayout.WEST,yearLabelEdit,100,springLayout.WEST,houresEdit);
        springLayout2.putConstraint(springLayout.NORTH,yearEdit,30,springLayout.NORTH,nameLabelEdit);
        springLayout2.putConstraint(springLayout.WEST,yearEdit,70,springLayout.WEST,yearLabelEdit);
        
        springLayout2.putConstraint(springLayout.NORTH,edit,30,springLayout.NORTH,nameLabelEdit);
        springLayout2.putConstraint(springLayout.WEST,edit,150,springLayout.WEST,yearEdit);
       
        editPanel.setPreferredSize(new Dimension(100,100));
        editPanel.setBackground(new Color(114,128,255));
        
        deletePanel.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
        deletePanel.add(codeLabel);
        deletePanel.add(code);
        deletePanel.add(delete);
        deletePanel.setPreferredSize(new Dimension(100,100));
        deletePanel.setBackground(new Color(114,128,255));
        
        cardPanel.setLayout(cardLayout);
        cardPanel.add(addPanel,getAddPanelCode());
        cardPanel.add(deletePanel,getDeletePanelCode());
        cardPanel.add(editPanel,getEditPanelCode());
        cardPanel.setBackground(new Color(114,128,255));
        
        southPanel.setLayout(new BorderLayout());
        southPanel.add(buttonsPanel,BorderLayout.NORTH);
        southPanel.add(cardPanel,BorderLayout.CENTER);
        southPanel.setBackground(new Color(114,128,255));
        
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(titlePanel,BorderLayout.NORTH);
        mainPanel.add(tablePanel,BorderLayout.CENTER);
        mainPanel.add(southPanel,BorderLayout.SOUTH);
        
        add(mainPanel);
        setBackground(new Color(114,128,255));
        setTitle("Course Manage");
		setSize(680, 550);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
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
    public JTextField getMajorEditField() {
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
    public JTextField getMajorAddField() {
    	return this.majorAdd;
    }
    public JTextField getYearAddField() {
    	return this.yearAdd;
    }
    public JTextField getCodeDeleteField() {
    	return this.code;
    }
    public JComboBox getComboBoxActionFields() {
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
