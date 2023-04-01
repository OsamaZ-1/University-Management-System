package View;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AdminStudentView implements View{
    
    //Panels
    private JPanel head;
    private JPanel center;
    private JPanel footEdit;
    private JPanel footDelete;
    private JPanel footManage;
    private JPanel footCombo;
    private JFrame studentFrame;

    //Buttons
    private JButton editButton;
    private JButton manageButton;
    private JButton deleteButton;
    private JButton generateTranscript; 
    //Fields
    private JComboBox<String> editManage;
    private JComboBox<String> majorField;
    private JComboBox<String> managementType;
    private JTextField fnameField;
    private JTextField lnameField;
    private JTextField emailField;
    private JTextField passwordField;
    private JTextField studentIdField1;
    private JTextField studentIdField2;
    private JTextField studentIdField3;
    private JTextField phoneField;

    //Labels
    private JLabel fnameLabel;
    private JLabel lnameLabel;
    private JLabel majorLabel;
    private JLabel emailLabel;
    private JLabel passwordLabel;
    private JLabel studentIdLabel1;
    private JLabel studentIdLabel2;
    private JLabel studentIdLabel3;
    private JLabel phoneLabel;
    

    //JTable
    private JTable studentTable;
    private JScrollPane scrollPane;
    private Object[] tableColumns;
    private DefaultTableModel tableModel;

    //Layout
    private SpringLayout springLayout;

    //Fonts and Color
    private Font font,fontTable;
    private Color color;

    public AdminStudentView(){
        editButton = new JButton("Edit");
        manageButton = new JButton("Manage");
        deleteButton = new JButton("Delete");
        generateTranscript = new JButton("Transcript");
        deleteButton.setBackground(Color.red);
        managementType = new JComboBox<>(new String[]{"Select Manage Type","Student-Courses","Student-Grades"});
        editManage = new JComboBox<>(new String[]{"Edit","Manage","Delete"});
        majorField = new JComboBox<>(new String[]{"Select Major","Informatics","Math","Physics","Biology","Chemistry","BioChemistry"});
        fnameField = new JTextField(10);
        lnameField = new JTextField(10);
        emailField = new JTextField(15);
        phoneField = new JTextField(10);
        studentIdField1 = new JTextField(5);
        studentIdField2 = new JTextField(5);
        studentIdField3 = new JTextField(5);
        passwordField = new JTextField(10);
        fnameLabel = new JLabel("First Name:");
        lnameLabel = new JLabel("Last Name:");
        majorLabel = new JLabel("Major:");
        emailLabel = new JLabel("Email:");
        passwordLabel = new JLabel("Password:");
        phoneLabel = new JLabel("Phone:");
        studentIdLabel1 = new JLabel("Student Id:");
        studentIdLabel2 = new JLabel("Student Id:");
        studentIdLabel3 = new JLabel("Student Id:");
        tableColumns = new Object[]{"ID","First Name","Last Name","Major","Email","Password","Phone"};
    	studentTable=new JTable();
        scrollPane = new JScrollPane(studentTable);
        tableModel = new DefaultTableModel();
        head = new JPanel();
        center = new JPanel();
        footCombo = new JPanel();
        footEdit = new JPanel();
        footDelete = new JPanel();
        footManage = new JPanel();
        studentFrame = new JFrame();
        springLayout = new SpringLayout(); 
        font = new Font("Arial", Font.BOLD, 17);
        fontTable = new Font("Arial", Font.BOLD, 15);
        color = new Color(83,131,255);

        studentIdField1.setEditable(false);
        studentIdField2.setEditable(false);
        studentIdField3.setEditable(false);

        editManage.setFont(font);
        managementType.setFont(font);
        fnameField.setFont(font);
        lnameField.setFont(font);
        majorField.setFont(font);
        emailField.setFont(font);
        passwordField.setFont(font);
        phoneField.setFont(font);
        studentIdField1.setFont(font);
        studentIdField2.setFont(font);
        studentIdField3.setFont(font);
        fnameLabel.setFont(font);
        lnameLabel.setFont(font);
        majorLabel.setFont(font);
        emailLabel.setFont(font);
        passwordLabel.setFont(font);
        phoneLabel.setFont(font);
        studentIdLabel1.setFont(font);
        studentIdLabel2.setFont(font);
        studentIdLabel3.setFont(font);
        editButton.setFont(font);
        editButton.setPreferredSize(new Dimension(90,40));
        editButton.setBackground(Color.green);
        manageButton.setFont(font);
        manageButton.setPreferredSize(new Dimension(100,40));
        manageButton.setBackground(Color.cyan);
        deleteButton.setFont(font);
        deleteButton.setPreferredSize(new Dimension(90,40));
        generateTranscript.setFont(font);
        generateTranscript.setPreferredSize(new Dimension(120,50));
        generateTranscript.setBackground(Color.green);
        studentTable.setFont(font);
    	studentTable.getTableHeader().setFont(font);
    	studentTable.getTableHeader().setForeground(Color.BLUE);

        tableModel.setColumnIdentifiers(tableColumns);
        studentTable.setModel(tableModel);
        studentTable.setFont(fontTable);

        studentFrame.setLayout(new BorderLayout());
        head.setLayout(new BorderLayout());
        center.setLayout(new FlowLayout(FlowLayout.CENTER));
        center.setPreferredSize(new Dimension(800,200));
        footCombo.setLayout(new BorderLayout());
        footCombo.setPreferredSize(new Dimension(800,200));
        footEdit.setLayout(springLayout);
        footEdit.setPreferredSize(new Dimension(800,200));
        footDelete.setLayout(springLayout);
        footDelete.setPreferredSize(new Dimension(800,200));
        footManage.setLayout(springLayout);
        footManage.setPreferredSize(new Dimension(800,200));
        footManage.setVisible(false);
        footDelete.setVisible(false);
        
        center.setBackground(color);
        footCombo.setBackground(color);
        footEdit.setBackground(color);
        footDelete.setBackground(color);
        footManage.setBackground(color);

        springLayout.putConstraint(SpringLayout.NORTH,studentIdLabel1,10,SpringLayout.NORTH,footEdit);
        springLayout.putConstraint(SpringLayout.NORTH,studentIdField1,5,SpringLayout.NORTH,footEdit);
        springLayout.putConstraint(SpringLayout.NORTH,fnameLabel,25,SpringLayout.SOUTH,studentIdLabel1);
        springLayout.putConstraint(SpringLayout.NORTH,lnameLabel,25,SpringLayout.SOUTH,studentIdLabel1);
        springLayout.putConstraint(SpringLayout.NORTH,majorLabel,25,SpringLayout.SOUTH,studentIdLabel1);
        springLayout.putConstraint(SpringLayout.NORTH,fnameField,20,SpringLayout.SOUTH,studentIdLabel1);
        springLayout.putConstraint(SpringLayout.NORTH,lnameField,20,SpringLayout.SOUTH,studentIdLabel1);
        springLayout.putConstraint(SpringLayout.NORTH,majorField,20,SpringLayout.SOUTH,studentIdLabel1);
        springLayout.putConstraint(SpringLayout.NORTH,emailLabel,30,SpringLayout.SOUTH,fnameLabel);
        springLayout.putConstraint(SpringLayout.NORTH,emailField,20,SpringLayout.SOUTH,fnameField);
        springLayout.putConstraint(SpringLayout.NORTH,passwordLabel,30,SpringLayout.SOUTH,lnameLabel);
        springLayout.putConstraint(SpringLayout.NORTH,passwordField,20,SpringLayout.SOUTH,lnameField);
        springLayout.putConstraint(SpringLayout.NORTH,phoneLabel,30,SpringLayout.SOUTH,majorLabel);
        springLayout.putConstraint(SpringLayout.NORTH,phoneField,20,SpringLayout.SOUTH,majorField);
        springLayout.putConstraint(SpringLayout.NORTH,editButton,20,SpringLayout.SOUTH,passwordField);

        springLayout.putConstraint(SpringLayout.NORTH,studentIdField3,20,SpringLayout.NORTH,footDelete);
        springLayout.putConstraint(SpringLayout.NORTH,studentIdLabel3,25,SpringLayout.NORTH,footDelete);
        springLayout.putConstraint(SpringLayout.NORTH,deleteButton,15,SpringLayout.SOUTH,studentIdField3);

        springLayout.putConstraint(SpringLayout.WEST,studentIdLabel1,10,SpringLayout.WEST,footEdit);
        springLayout.putConstraint(SpringLayout.WEST,fnameLabel,10,SpringLayout.WEST,footEdit);
        springLayout.putConstraint(SpringLayout.WEST,emailLabel,10,SpringLayout.WEST,footEdit);
        springLayout.putConstraint(SpringLayout.WEST,editButton,350,SpringLayout.WEST,footEdit);

        springLayout.putConstraint(SpringLayout.WEST,studentIdLabel3,360,SpringLayout.WEST,footDelete);
        springLayout.putConstraint(SpringLayout.WEST,studentIdField3,10,SpringLayout.EAST,studentIdLabel3);
        springLayout.putConstraint(SpringLayout.WEST,deleteButton,360,SpringLayout.WEST,footDelete);

        springLayout.putConstraint(SpringLayout.WEST,studentIdField1,5,SpringLayout.EAST,studentIdLabel1);
        springLayout.putConstraint(SpringLayout.WEST,fnameField,5,SpringLayout.EAST,fnameLabel);
        springLayout.putConstraint(SpringLayout.WEST,lnameField,5,SpringLayout.EAST,lnameLabel);
        springLayout.putConstraint(SpringLayout.WEST,majorField,5,SpringLayout.EAST,majorLabel);
        springLayout.putConstraint(SpringLayout.WEST,emailField,5,SpringLayout.EAST,emailLabel);
        springLayout.putConstraint(SpringLayout.WEST,passwordField,5,SpringLayout.EAST,passwordLabel);
        springLayout.putConstraint(SpringLayout.WEST,phoneField,5,SpringLayout.EAST,phoneLabel);

        springLayout.putConstraint(SpringLayout.WEST,lnameLabel,20,SpringLayout.EAST,fnameField);
        springLayout.putConstraint(SpringLayout.WEST,majorLabel,20,SpringLayout.EAST,lnameField);
        springLayout.putConstraint(SpringLayout.WEST,passwordLabel,20,SpringLayout.EAST,emailField);
        springLayout.putConstraint(SpringLayout.WEST,phoneLabel,20,SpringLayout.EAST,passwordField);

        springLayout.putConstraint(SpringLayout.NORTH, studentIdLabel2, 25, SpringLayout.NORTH, footManage);
        springLayout.putConstraint(SpringLayout.NORTH, studentIdField2, 20, SpringLayout.NORTH, footManage);
        springLayout.putConstraint(SpringLayout.NORTH, generateTranscript, 10, SpringLayout.NORTH, footManage);
        springLayout.putConstraint(SpringLayout.NORTH, managementType, 20, SpringLayout.SOUTH, studentIdField2);
        springLayout.putConstraint(SpringLayout.NORTH, manageButton, 20, SpringLayout.SOUTH, managementType);

        springLayout.putConstraint(SpringLayout.WEST, studentIdLabel2, 330, SpringLayout.WEST, footManage);
        springLayout.putConstraint(SpringLayout.WEST, studentIdField2, 5, SpringLayout.EAST, studentIdLabel2);
        springLayout.putConstraint(SpringLayout.WEST, generateTranscript, 175, SpringLayout.EAST, studentIdField2);
        springLayout.putConstraint(SpringLayout.WEST, managementType, 300, SpringLayout.WEST, footManage);
        springLayout.putConstraint(SpringLayout.WEST, manageButton, 350, SpringLayout.WEST, footManage);


        head.add(scrollPane,BorderLayout.CENTER);
        center.add(editManage);
        footEdit.add(studentIdLabel1);
        footEdit.add(studentIdField1);
        footEdit.add(fnameLabel);
        footEdit.add(fnameField);
        footEdit.add(lnameLabel);
        footEdit.add(lnameField);
        footEdit.add(majorLabel);
        footEdit.add(majorField);
        footEdit.add(emailLabel);
        footEdit.add(emailField);
        footEdit.add(passwordLabel);
        footEdit.add(passwordField);
        footEdit.add(phoneLabel);
        footEdit.add(phoneField);
        footEdit.add(editButton);
        footDelete.add(studentIdLabel3);
        footDelete.add(studentIdField3);
        footDelete.add(deleteButton);
        footManage.add(studentIdLabel2);
        footManage.add(studentIdField2);
        footManage.add(managementType);
        footManage.add(manageButton);
        footManage.add(generateTranscript);
        footCombo.add(footManage, BorderLayout.NORTH);
        footCombo.add(footEdit, BorderLayout.CENTER);
        footCombo.add(footDelete, BorderLayout.SOUTH);
        
        studentFrame.getContentPane().setBackground(new Color(114,128,255));
        studentFrame.add(head,BorderLayout.NORTH);
        studentFrame.add(center,BorderLayout.CENTER);
        studentFrame.add(footCombo,BorderLayout.SOUTH);

        studentFrame.setTitle("Student Management");
        studentFrame.setSize(820,700);
        studentFrame.setLocationRelativeTo(null);
        studentFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        studentFrame.setVisible(true);
    }

    public JButton getEditButton()
    {
        return this.editButton;
    }

    public JButton getManageButton()
    {
        return this.manageButton;
    }

    public JButton getDeleButton()
    {
        return this.deleteButton;
    }

    public JButton getGenerateTranscriptButton()
    {
        return this.generateTranscript;
    }

    public JTextField getStudentFname()
    {
        return this.fnameField;
    }

    public JTextField getStudentLname()
    {
        return this.lnameField;
    }

    public JComboBox<String> getStudentMajor()
    {
        return this.majorField;
    }

    public JComboBox<String> getManagementType()
    {
        return this.managementType;
    }

    public JTextField getStudentEmail()
    {
        return this.emailField;
    }

    public JTextField getStudentPassword()
    {
        return this.passwordField;
    }

    public JTextField getStudentPhone()
    {
        return this.phoneField;
    }

    public JTextField getStudentId1()
    {
        return this.studentIdField1;
    }

    public JTextField getStudentId2()
    {
        return this.studentIdField2;
    }
    
    public JTextField getStudentId3()
    {
        return this.studentIdField3;
    }

    public JComboBox<String> getEditManageComboBox()
    {
        return this.editManage;
    }

    public JTable getStudentTable()
    {
        return this.studentTable;
    }

    public DefaultTableModel getTableModel()
    {
        return this.tableModel;
    }

    public JFrame getStudentFrame()
    {
        return this.studentFrame;
    }

    public JPanel getFootManagePanel()
    {
        return this.footManage;
    }

    public JPanel getFootEditPanel()
    {
        return this.footEdit;
    }

    public JPanel getFootDeletePanel()
    {
        return this.footDelete;
    }

    public void displayMessage(String message)
    {
        JOptionPane.showMessageDialog(null, message);
    }
}
