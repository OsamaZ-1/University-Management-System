package View;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

public class HistoryView implements View{
    
    //Labels
    private JLabel title;

    //Field
    private JComboBox<String> tablesList;

    //Button
    private JButton retrieveButton;
    private JButton deleteButton;
    private JButton deleteAllButton;

    //Panels
    private JFrame mainFrame;
    private JPanel headPanelTitle;
    private JPanel headPanelList;
    private JPanel headPanel;
    private JPanel bodyPanel;
    private JPanel footPanel;

    //Table
    private JTable table;
    private JScrollPane scrollPane;
    private DefaultTableModel tableModelInfo;

    //Table Columns
    private Object[] studentTableColumns, instructorTableColumns, courseTableColumns, instCrsTableColumns, stdGradeTableColumns;

    //Layout
    private SpringLayout springLayout;

    //Colors and Fonts
    private Color mainColor;
    private Font font,fontTable;

    public HistoryView()
    {
        mainColor = new Color(83,131,255);
        font=new Font ("Arial", Font.BOLD, 17);
    	fontTable=new Font("Arial", Font.BOLD, 15);
        springLayout = new SpringLayout();

        studentTableColumns = new Object[] {"Id","FName","LName","Major","Password","Email","Phone","Accepted","Date"};
        instructorTableColumns = new Object[] {"Id","FName","LName","Password","Email","Phone","Accepted","Date"};
        courseTableColumns = new Object[] {"Id","Name","Code","PreRequisite","Credits","Hours","Major","Year","Semester","Date"};
        instCrsTableColumns = new Object[] {"Instructor Id","Course Id","Date"};
        stdGradeTableColumns = new Object[] {"Student Id","Course Id","Grade","Year","Submitted","Date"};
        tablesList = new JComboBox<>(new String[]{"Student","Instructor","Course","Students Grades","Instructors Courses"});

        title = new JLabel("History Management");
        title.setFont(new Font("Arial", Font.BOLD, 25));

        retrieveButton = new JButton("Retrieve");
        retrieveButton.setFont(font);
        retrieveButton.setPreferredSize(new Dimension(120,40));
        deleteButton = new JButton("Delete");
        deleteButton.setFont(font);
        deleteButton.setPreferredSize(new Dimension(120,40));
        deleteAllButton = new JButton("Delete All");
        deleteAllButton.setFont(font);
        deleteAllButton.setPreferredSize(new Dimension(120,40));

        table = new JTable();
        table.setFont(fontTable);
    	table.getTableHeader().setFont(font);
    	table.getTableHeader().setForeground(Color.BLUE);
    	scrollPane = new JScrollPane(table);
    	
        tableModelInfo = new DefaultTableModel();
        tableModelInfo.setColumnIdentifiers(studentTableColumns);
        table.setModel(tableModelInfo);

        mainFrame = new JFrame();
        mainFrame.setLayout(new BorderLayout());
        headPanelTitle = new JPanel(new FlowLayout(FlowLayout.CENTER));
        headPanelTitle.setBackground(mainColor);
        headPanelTitle.setPreferredSize(new Dimension(800,50));
        headPanelList = new JPanel(new FlowLayout(FlowLayout.CENTER));
        headPanelList.setPreferredSize(new Dimension(800,50));
        headPanelList.setBackground(mainColor);
        headPanel = new JPanel(new GridLayout(2,1));
        headPanel.setPreferredSize(new Dimension(800,100));
        headPanel.setBackground(mainColor);
        bodyPanel = new JPanel(new BorderLayout());
        bodyPanel.setPreferredSize(new Dimension(800,500));
        footPanel = new JPanel(springLayout);
        footPanel.setPreferredSize(new Dimension(800,90));
        footPanel.setBackground(mainColor);

        headPanelTitle.add(title);
        headPanelList.add(tablesList);
        headPanel.add(headPanelTitle);
        headPanel.add(headPanelList);
        bodyPanel.add(scrollPane);
        footPanel.add(retrieveButton);
        footPanel.add(deleteButton);
        footPanel.add(deleteAllButton);

        springLayout.putConstraint(SpringLayout.NORTH, retrieveButton, 20, SpringLayout.NORTH, footPanel);
        springLayout.putConstraint(SpringLayout.WEST, retrieveButton, 250, SpringLayout.WEST, footPanel);
        springLayout.putConstraint(SpringLayout.NORTH, deleteButton, 20, SpringLayout.NORTH, footPanel);
        springLayout.putConstraint(SpringLayout.WEST, deleteButton, 20, SpringLayout.EAST, retrieveButton);
        springLayout.putConstraint(SpringLayout.NORTH, deleteAllButton, 20, SpringLayout.NORTH, footPanel);
        springLayout.putConstraint(SpringLayout.WEST, deleteAllButton, 20, SpringLayout.EAST, deleteButton);

        mainFrame.add(headPanel,BorderLayout.NORTH);
        mainFrame.add(bodyPanel,BorderLayout.CENTER);
        mainFrame.add(footPanel,BorderLayout.SOUTH);

        mainFrame.setTitle("History Management");
        mainFrame.setBackground(mainColor);
        mainFrame.setSize(800,650);
        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		mainFrame.setVisible(true);
		mainFrame.setLocationRelativeTo(null);
    }

    public JFrame getMainFrame()
    {
        return this.mainFrame;
    }

    public JComboBox<String> getTablesList()
    {
        return this.tablesList;
    }

    public JButton getRetrieveButton()
    {
        return this.retrieveButton;
    }

    public JButton getDeleteButton()
    {
        return this.deleteButton;
    }

    public JButton getDeleteAllButton()
    {
        return this.deleteAllButton;
    }

    public JTable getTable()
    {
        return this.table;
    }

    public DefaultTableModel getTableModel()
    {
        return this.tableModelInfo;
    }

    public Object[] getColumns(String table)
    {   
        Object[] columns = null;

        switch(table){
            case "Student":
                columns = studentTableColumns; break;
            case "Instructor":
                columns = instructorTableColumns; break;
            case "Course":
                columns = courseTableColumns; break;
            case "Instructors Courses":
                columns = instCrsTableColumns; break;
            case "Students Grades":
                columns = stdGradeTableColumns; break;
        }

        return columns;
    }

    public void displayMessage(String message)
    {
        JOptionPane.showMessageDialog(null, message);
    }
}
