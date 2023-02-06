package View;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AdminStudentView extends JFrame{
    
    //Panels
    private JPanel head;
    private JPanel center;
    private JPanel footEdit;
    private JPanel footManage;
    private JPanel footCombo;
    private JFrame studentFrame;

    //Buttons
    private JButton editButton;
    private JButton manageButton;

    //Fields
    private JComboBox<String> editManage;
    private JTextField fnameField;
    private JTextField lnameField;
    private JTextField majorField;
    private JTextField emailField;
    private JTextField passwordField;
    private JTextField studentIdField1;
    private JTextField studentIdField2;
    private JTextField phoneField;

    //Labels
    private JLabel fnameLabel;
    private JLabel lnameLabel;
    private JLabel majorLabel;
    private JLabel emailLabel;
    private JLabel passwordLabel;
    private JLabel studentIdLabel1;
    private JLabel studentIdLabel2;
    private JLabel phoneLabel;
    

    //Table
    private JTable studentTable;
    private JScrollPane scrollPane;
    private Object[] tableColumns;
    private DefaultTableModel tableModel;

    //Layout
    private SpringLayout springLayout;
    private Font font,fontTable;

    public AdminStudentView(){
        editButton = new JButton("Edit");
        manageButton = new JButton("Manage");
        editManage = new JComboBox<String>(new String[]{"Edit","Manage"});
        fnameField = new JTextField(10);
        lnameField = new JTextField(10);
        majorField = new JTextField(10);
        emailField = new JTextField(15);
        phoneField = new JTextField(10);
        studentIdField1 = new JTextField(5);
        studentIdField2 = new JTextField(5);
        passwordField = new JTextField(10);
        fnameLabel = new JLabel("First Name:");
        lnameLabel = new JLabel("Last Name:");
        majorLabel = new JLabel("Major:");
        emailLabel = new JLabel("Email:");
        passwordLabel = new JLabel("Password:");
        phoneLabel = new JLabel("Phone:");
        studentIdLabel1 = new JLabel("Student Id:");
        studentIdLabel2 = new JLabel("Student Id:");
        tableColumns = new Object[]{"ID","First Name","Last Name","Major","Email","Password","Phone"};
    	studentTable=new JTable();
        scrollPane = new JScrollPane(studentTable);
        tableModel = new DefaultTableModel();
        head = new JPanel();
        center = new JPanel();
        footCombo = new JPanel();
        footEdit = new JPanel();
        footManage = new JPanel();
        studentFrame = new JFrame();
        springLayout = new SpringLayout();
        font = new Font("Arial", Font.BOLD, 17);
        fontTable = new Font("Arial", Font.BOLD, 15);

        studentIdField1.setEditable(false);
        studentIdField2.setEditable(false);

        editManage.setFont(font);
        fnameField.setFont(font);
        lnameField.setFont(font);
        majorField.setFont(font);
        emailField.setFont(font);
        passwordField.setFont(font);
        phoneField.setFont(font);
        studentIdField1.setFont(font);
        studentIdField2.setFont(font);
        fnameLabel.setFont(font);
        lnameLabel.setFont(font);
        majorLabel.setFont(font);
        emailLabel.setFont(font);
        passwordLabel.setFont(font);
        phoneLabel.setFont(font);
        studentIdLabel1.setFont(font);
        studentIdLabel2.setFont(font);
        editButton.setFont(font);
        editButton.setPreferredSize(new Dimension(90,40));
        editButton.setBackground(Color.green);
        manageButton.setFont(font);
        manageButton.setPreferredSize(new Dimension(100,40));
        manageButton.setBackground(Color.cyan);
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
        footManage.setLayout(new FlowLayout(FlowLayout.CENTER));
        footManage.setPreferredSize(new Dimension(800,200));
        footManage.setVisible(false);
        
        center.setBackground(new Color(114,128,255));
        footCombo.setBackground(new Color(114,128,255));
        footEdit.setBackground(new Color(114,128,255));
        footManage.setBackground(new Color(114,128,255));

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

        springLayout.putConstraint(SpringLayout.WEST,studentIdLabel1,10,SpringLayout.WEST,footEdit);
        springLayout.putConstraint(SpringLayout.WEST,fnameLabel,10,SpringLayout.WEST,footEdit);
        springLayout.putConstraint(SpringLayout.WEST,emailLabel,10,SpringLayout.WEST,footEdit);
        springLayout.putConstraint(SpringLayout.WEST,editButton,350,SpringLayout.WEST,footEdit);

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
        footManage.add(studentIdLabel2);
        footManage.add(studentIdField2);
        footManage.add(manageButton);
        footCombo.add(footManage, BorderLayout.CENTER);
        footCombo.add(footEdit, BorderLayout.NORTH);
        
        studentFrame.getContentPane().setBackground(new Color(114,128,255));
        studentFrame.add(head,BorderLayout.NORTH);
        studentFrame.add(center,BorderLayout.CENTER);
        studentFrame.add(footCombo,BorderLayout.SOUTH);

        studentFrame.setTitle("Student Management");
        studentFrame.setSize(800,700);
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

    public JTextField getStudentFname()
    {
        return this.fnameField;
    }

    public JTextField getStudentLname()
    {
        return this.lnameField;
    }

    public JTextField getStudentMajor()
    {
        return this.majorField;
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
}
