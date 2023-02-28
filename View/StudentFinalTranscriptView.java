package View;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import java.awt.*;
public class StudentFinalTranscriptView implements View{

	private JFrame sFTFrame;
	
	//transcripts table for student marks
	private JTable finalTranscriptTable;
	private JScrollPane scrollPane;
	private Object[] tableColumns;
	private DefaultTableModel tableModelInfo;
	    
	private JLabel totalCreditsLabel;
	private JLabel earnedCreditsLabel;
	private JLabel remainingCreditsLabel;
	private JLabel graduatedGPALabel;
	
	private JLabel totalCredits;
	private JLabel earnedCredits;
	private JLabel remainingCredits;
	private JLabel graduatedGPA;
	
	private JLabel appreciationLabel;
	private JLabel appreciation;
	
	private JPanel northPanel;
	private JPanel centerPanel;
	private JPanel southPanel;
	private JPanel totalCreditPanel;
	private JPanel earnedCreditPanel;
	private JPanel remainingCreditPanel;
	private JPanel totalGPAPanel;
	private JPanel mainPanel;
	
	private Font font,fontTable,bigFont;
    private Color color;
	
	public StudentFinalTranscriptView() {
		font=new Font ("Arial", Font.BOLD, 17);
		bigFont=new Font ("Arial", Font.BOLD, 22);
    	fontTable=new Font("Arial", Font.BOLD, 15);
        color = new Color(83,131,255);
		sFTFrame=new JFrame();
        
        tableColumns = new Object[]{"Year","Sem","Crse Code","Title","Credits","Grade","Observation"};
    	
    	finalTranscriptTable = new JTable() {
    		public Component prepareRenderer(TableCellRenderer render1,int row1,int col1) {
    			Component comp1=super.prepareRenderer(render1, row1, col1);
    			Object value1=getModel().getValueAt(row1, col1);
    			if(value1.equals("Passed")) {
    				comp1.setForeground(Color.green);
    			}
    			else if(value1.equals("Failed")) {
    				comp1.setForeground(Color.red);
    			}
    			else if(value1.equals("N/A") || value1.equals("Not Registed")) {
    				comp1.setForeground(Color.black);
    			}
    			else {
    				comp1.setForeground(Color.blue);
    			}
    			
    			return comp1;
    		}};
    		
    	finalTranscriptTable.setFont(fontTable);
    	finalTranscriptTable.getTableHeader().setFont(font);
    	finalTranscriptTable.getTableHeader().setForeground(Color.BLUE);
        scrollPane = new JScrollPane(finalTranscriptTable);
        
        tableModelInfo = new DefaultTableModel();
        tableModelInfo.setColumnIdentifiers(tableColumns);
        finalTranscriptTable.setModel(tableModelInfo);
        
        totalCreditsLabel=new JLabel("Total Credits:");
        totalCreditsLabel.setFont(font);
        earnedCreditsLabel=new JLabel("Earned Credits:");
        earnedCreditsLabel.setFont(font);
        remainingCreditsLabel=new JLabel("Remaining Credits:");
        remainingCreditsLabel.setFont(font);
        graduatedGPALabel=new JLabel("Total GPA:");
        graduatedGPALabel.setFont(bigFont);
        
        totalCredits=new JLabel("180");
        totalCredits.setFont(font);
        earnedCredits=new JLabel("180");
        earnedCredits.setFont(font);
        remainingCredits=new JLabel("0");
        remainingCredits.setFont(font);
        graduatedGPA=new JLabel("71");
        graduatedGPA.setFont(bigFont);
        graduatedGPA.setForeground(Color.red);
        
        appreciationLabel=new JLabel("Graduated");
        appreciationLabel.setFont(bigFont);
        appreciation=new JLabel("Graduted with good average");
        appreciation.setFont(bigFont);
        
        northPanel=new JPanel();
        northPanel.setBackground(color);
        southPanel=new JPanel();
        southPanel.setBackground(color);
        centerPanel=new JPanel();
        centerPanel.setBackground(color);
        totalCreditPanel=new JPanel();
        totalCreditPanel.setBackground(color);
        earnedCreditPanel=new JPanel();
        earnedCreditPanel.setBackground(color);
        remainingCreditPanel=new JPanel();
        remainingCreditPanel.setBackground(color);
        totalGPAPanel=new JPanel();
        totalGPAPanel.setBackground(color);
        mainPanel=new JPanel();
        mainPanel.setBackground(color);
        
        northPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        northPanel.add(appreciationLabel);
        northPanel.add(appreciation);
        
        centerPanel.setLayout(new BorderLayout());
        centerPanel.add(scrollPane);
        
        totalCreditPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        totalCreditPanel.add(totalCreditsLabel);
        totalCreditPanel.add(totalCredits);
        
        earnedCreditPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        earnedCreditPanel.add(earnedCreditsLabel);
        earnedCreditPanel.add(earnedCredits);
        
        remainingCreditPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        remainingCreditPanel.add(remainingCreditsLabel);
        remainingCreditPanel.add(remainingCredits);
        
        totalGPAPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        totalGPAPanel.add(graduatedGPALabel);
        totalGPAPanel.add(graduatedGPA);
        
        southPanel.setLayout(new GridLayout(2,2));
        southPanel.add(earnedCreditPanel);
        southPanel.add(totalCreditPanel);
        southPanel.add(remainingCreditPanel);
        southPanel.add(totalGPAPanel);
        
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(northPanel,BorderLayout.NORTH);
        mainPanel.add(centerPanel,BorderLayout.CENTER);
        mainPanel.add(southPanel,BorderLayout.SOUTH);
        
        sFTFrame.setBackground(color);
        sFTFrame.add(mainPanel);
        sFTFrame.setTitle("Student Transcript");
        sFTFrame.setSize(800, 700);
        sFTFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        sFTFrame.setVisible(true);
        sFTFrame.setLocationRelativeTo(null);
        
	}

	public JFrame getsFTFrame() {
		return sFTFrame;
	}

	public JTable getFinalTranscriptTable() {
		return finalTranscriptTable;
	}

	public DefaultTableModel getTableModelInfo() {
		return tableModelInfo;
	}

	public JLabel getTotalCredits() {
		return totalCredits;
	}

	public JLabel getEarnedCredits() {
		return earnedCredits;
	}

	public JLabel getRemainingCredits() {
		return remainingCredits;
	}

	public JLabel getGraduatedGPA() {
		return graduatedGPA;
	}

	public JLabel getAppreciation() {
		return appreciation;
	}

	
	
}
