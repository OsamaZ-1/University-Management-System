package View;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AdminInstructorView {
    private JPanel head;
    private JPanel center;
    private JPanel footEdit;
    private JPanel footManage;
    private JPanel footCombo;
    private JFrame instFrame;

    //Buttons
    private JButton editButton;
    private JButton manageButton;

    //Fields
    private JComboBox<String> editManage;
    private JTextField fnameField;
    private JTextField lnameField;
    private JTextField emailField;
    private JTextField passwordField;
    private JTextField instIdField1;
    private JTextField instIdField2;
    private JTextField phoneField;

    //Labels
    private JLabel fnameLabel;
    private JLabel lnameLabel;
    private JLabel emailLabel;
    private JLabel passwordLabel;
    private JLabel instIdLabel1;
    private JLabel instIdLabel2;
    private JLabel phoneLabel;
    

    //Table
    private JTable instTable;
    private JScrollPane scrollPane;
    private Object[] tableColumns;
    private DefaultTableModel tableModel;

    //Layout
    private SpringLayout springLayout;
    private Font font,fontTable;
    private Color color;

    public AdminInstructorView(){
        editButton = new JButton("Edit");
        manageButton = new JButton("Manage");
        editManage = new JComboBox<String>(new String[]{"Edit","Manage"});
        fnameField = new JTextField(10);
        lnameField = new JTextField(10);
        emailField = new JTextField(15);
        phoneField = new JTextField(10);
        instIdField1 = new JTextField(5);
        instIdField2 = new JTextField(5);
        passwordField = new JTextField(10);
        fnameLabel = new JLabel("First Name:");
        lnameLabel = new JLabel("Last Name:");
        emailLabel = new JLabel("Email:");
        passwordLabel = new JLabel("Password:");
        phoneLabel = new JLabel("Phone:");
        instIdLabel1 = new JLabel("Instructor Id:");
        instIdLabel2 = new JLabel("Instructor Id:");
        tableColumns = new Object[]{"ID","First Name","Last Name","Email","Password","Phone"};
    	instTable=new JTable();
        scrollPane = new JScrollPane(instTable);
        tableModel = new DefaultTableModel();
        head = new JPanel();
        center = new JPanel();
        footCombo = new JPanel();
        footEdit = new JPanel();
        footManage = new JPanel();
        instFrame = new JFrame();
        springLayout = new SpringLayout();
        font = new Font("Arial", Font.BOLD, 17);
        fontTable = new Font("Arial", Font.BOLD, 15);
        color = new Color(83,131,255);

        instIdField1.setEditable(false);
        instIdField2.setEditable(false);

        editManage.setFont(font);
        fnameField.setFont(font);
        lnameField.setFont(font);
        emailField.setFont(font);
        passwordField.setFont(font);
        phoneField.setFont(font);
        instIdField1.setFont(font);
        instIdField2.setFont(font);
        fnameLabel.setFont(font);
        lnameLabel.setFont(font);
        emailLabel.setFont(font);
        passwordLabel.setFont(font);
        phoneLabel.setFont(font);
        instIdLabel1.setFont(font);
        instIdLabel2.setFont(font);
        editButton.setFont(font);
        editButton.setPreferredSize(new Dimension(90,40));
        editButton.setBackground(Color.green);
        manageButton.setFont(font);
        manageButton.setPreferredSize(new Dimension(100,40));
        manageButton.setBackground(Color.cyan);
        instTable.setFont(font);
    	instTable.getTableHeader().setFont(font);
    	instTable.getTableHeader().setForeground(Color.BLUE);

        tableModel.setColumnIdentifiers(tableColumns);
        instTable.setModel(tableModel);
        instTable.setFont(fontTable);

        instFrame.setLayout(new BorderLayout());
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
        
        center.setBackground(color);
        footCombo.setBackground(color);
        footEdit.setBackground(color);
        footManage.setBackground(color);

        springLayout.putConstraint(SpringLayout.NORTH,instIdLabel1,10,SpringLayout.NORTH,footEdit);
        springLayout.putConstraint(SpringLayout.NORTH,instIdField1,5,SpringLayout.NORTH,footEdit);
        springLayout.putConstraint(SpringLayout.NORTH,fnameLabel,25,SpringLayout.SOUTH,instIdLabel1);
        springLayout.putConstraint(SpringLayout.NORTH,lnameLabel,25,SpringLayout.SOUTH,instIdLabel1);
        springLayout.putConstraint(SpringLayout.NORTH,phoneLabel,25,SpringLayout.SOUTH,instIdLabel1);
        springLayout.putConstraint(SpringLayout.NORTH,fnameField,20,SpringLayout.SOUTH,instIdLabel1);
        springLayout.putConstraint(SpringLayout.NORTH,lnameField,20,SpringLayout.SOUTH,instIdLabel1);
        springLayout.putConstraint(SpringLayout.NORTH,phoneField,20,SpringLayout.SOUTH,instIdLabel1);
        springLayout.putConstraint(SpringLayout.NORTH,emailLabel,30,SpringLayout.SOUTH,fnameLabel);
        springLayout.putConstraint(SpringLayout.NORTH,emailField,20,SpringLayout.SOUTH,fnameField);
        springLayout.putConstraint(SpringLayout.NORTH,passwordLabel,30,SpringLayout.SOUTH,lnameLabel);
        springLayout.putConstraint(SpringLayout.NORTH,passwordField,20,SpringLayout.SOUTH,lnameField);
        springLayout.putConstraint(SpringLayout.NORTH,editButton,20,SpringLayout.SOUTH,passwordField);

        springLayout.putConstraint(SpringLayout.WEST,instIdLabel1,10,SpringLayout.WEST,footEdit);
        springLayout.putConstraint(SpringLayout.WEST,fnameLabel,10,SpringLayout.WEST,footEdit);
        springLayout.putConstraint(SpringLayout.WEST,emailLabel,10,SpringLayout.WEST,footEdit);
        springLayout.putConstraint(SpringLayout.WEST,editButton,350,SpringLayout.WEST,footEdit);

        springLayout.putConstraint(SpringLayout.WEST,instIdField1,5,SpringLayout.EAST,instIdLabel1);
        springLayout.putConstraint(SpringLayout.WEST,fnameField,5,SpringLayout.EAST,fnameLabel);
        springLayout.putConstraint(SpringLayout.WEST,lnameField,5,SpringLayout.EAST,lnameLabel);
        springLayout.putConstraint(SpringLayout.WEST,emailField,5,SpringLayout.EAST,emailLabel);
        springLayout.putConstraint(SpringLayout.WEST,passwordField,5,SpringLayout.EAST,passwordLabel);
        springLayout.putConstraint(SpringLayout.WEST,phoneField,5,SpringLayout.EAST,phoneLabel);

        springLayout.putConstraint(SpringLayout.WEST,lnameLabel,20,SpringLayout.EAST,fnameField);
        springLayout.putConstraint(SpringLayout.WEST,passwordLabel,20,SpringLayout.EAST,emailField);
        springLayout.putConstraint(SpringLayout.WEST,phoneLabel,20,SpringLayout.EAST,passwordField);

        head.add(scrollPane,BorderLayout.CENTER);
        center.add(editManage);
        footEdit.add(instIdLabel1);
        footEdit.add(instIdField1);
        footEdit.add(fnameLabel);
        footEdit.add(fnameField);
        footEdit.add(lnameLabel);
        footEdit.add(lnameField);
        footEdit.add(emailLabel);
        footEdit.add(emailField);
        footEdit.add(passwordLabel);
        footEdit.add(passwordField);
        footEdit.add(phoneLabel);
        footEdit.add(phoneField);
        footEdit.add(editButton);
        footManage.add(instIdLabel2);
        footManage.add(instIdField2);
        footManage.add(manageButton);
        footCombo.add(footManage, BorderLayout.CENTER);
        footCombo.add(footEdit, BorderLayout.NORTH);
        
        instFrame.getContentPane().setBackground(color);
        instFrame.add(head,BorderLayout.NORTH);
        instFrame.add(center,BorderLayout.CENTER);
        instFrame.add(footCombo,BorderLayout.SOUTH);

        instFrame.setTitle("Instructor Management");
        instFrame.setSize(820,700);
        instFrame.setLocationRelativeTo(null);
        instFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        instFrame.setVisible(true);
    }

    public JButton getEditButton()
    {
        return this.editButton;
    }

    public JButton getManageButton()
    {
        return this.manageButton;
    }

    public JTextField getInstFname()
    {
        return this.fnameField;
    }

    public JTextField getInstLname()
    {
        return this.lnameField;
    }

    public JTextField getInstEmail()
    {
        return this.emailField;
    }

    public JTextField getInstPassword()
    {
        return this.passwordField;
    }

    public JTextField getInstPhone()
    {
        return this.phoneField;
    }

    public JTextField getInstId1()
    {
        return this.instIdField1;
    }

    public JTextField getInstId2()
    {
        return this.instIdField2;
    }

    public JComboBox<String> getEditManageComboBox()
    {
        return this.editManage;
    }

    public JTable getInstTable()
    {
        return this.instTable;
    }

    public DefaultTableModel getTableModel()
    {
        return this.tableModel;
    }

    public JFrame getInstFrame()
    {
        return this.instFrame;
    }

    public JPanel getFootManagePanel()
    {
        return this.footManage;
    }

    public JPanel getFootEditPanel()
    {
        return this.footEdit;
    }

    public void displayMessage(String message)
    {
        JOptionPane.showMessageDialog(null, message);
    }
}
