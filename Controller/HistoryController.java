package Controller;

import java.sql.SQLException;

import javax.swing.JTable;

import Model.HistoryModel;
import View.HistoryView;
import Factory.*;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HistoryController implements Controller{
   
    private HistoryView historyView;
    private HistoryModel historyModel;
    private String chosenTable;

    private ModelFactory mf = (ModelFactory) FactoryProducer.createFactory("Model");
    private ViewFactory vf = (ViewFactory) FactoryProducer.createFactory("View");
    

    public HistoryController() throws SQLException
    {   
        historyView = (HistoryView) vf.createView("History");
        historyModel = (HistoryModel) mf.createModel("History");
        chosenTable = "Student";

        setDropDownListener();
        setRetrieveButtonListener();
        setDeleteAllButtonListener();
        fillTable(chosenTable);
    }

    public String getHistoryTableName(String table){
        String t = null;

        switch(table){
            case "Student":
                t = "studenthistory"; break;
            case "Instructor":
                t = "instructorhistory"; break;
            case "Course":
                t = "coursehistory"; break;
            case "Instructors Courses":
                t = "instructorcoursehistory"; break;
            case "Students Grades":
                t = "studentgradeshistory"; break;
        }
        
        return t;
    }

    public String getTableName(String table){
        String t = null;

        switch(table){
            case "Student":
                t = "student"; break;
            case "Instructor":
                t = "instructors"; break;
            case "Course":
                t = "course"; break;
            case "Instructors Courses":
                t = "instructorteaches"; break;
            case "Students Grades":
                t = "studentgrades"; break;
        }
        
        return t;
    }

    public void fillTable(String table){
        historyView.getTableModel().setRowCount(0);
        String tname = getHistoryTableName(chosenTable);
        try{
            Object[][] rows = historyModel.getRows(tname);
            for (Object[] oArr : rows){
                historyView.getTableModel().addRow(oArr);
            }
        }
        catch(SQLException e1){e1.printStackTrace();}
    }

    public void setDropDownListener(){
        historyView.getTablesList().addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                chosenTable = String.valueOf(historyView.getTablesList().getSelectedItem());
                historyView.getTableModel().setColumnIdentifiers(historyView.getColumns(chosenTable));
                fillTable(chosenTable);
            }
        });
    }

    public void setRetrieveButtonListener(){
        historyView.getRetrieveButton().addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){
                JTable t = historyView.getTable();
                int selectedRow = t.getSelectedRow();
                String[] info = new String[t.getColumnCount() - 1];

                for (int i = 0; i < t.getColumnCount() - 1; ++i)
                    info[i] = String.valueOf(t.getValueAt(selectedRow, i));
                
                try{
                    historyModel.retrieve(getTableName(chosenTable), info);
                    historyModel.delete(getHistoryTableName(chosenTable), info);
                    fillTable(chosenTable);
                }
                catch(SQLException e1){e1.printStackTrace();}
            }
        });
    }

    public void setDeleteButtonListener(){
        historyView.getDeleteButton().addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e){
                JTable t = historyView.getTable();
                int selectedRow = t.getSelectedRow();
                String[] info = new String[2];

                for (int i = 0; i < 2; ++i)
                    info[i] = String.valueOf(t.getValueAt(selectedRow, i));
                
                try{
                    historyModel.delete(getHistoryTableName(chosenTable), info);
                    fillTable(chosenTable);
                }
                catch(SQLException e1){e1.printStackTrace();}
            }
        });
    }

    public void setDeleteAllButtonListener()
    {
        historyView.getDeleteAllButton().addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e)
            {
                try{
                    historyModel.deleteAll(getHistoryTableName(chosenTable));
                    fillTable(chosenTable);
                }catch(SQLException e1)
                {e1.printStackTrace();
                 historyView.displayMessage("Error deleting records");
                }
            }
        });
    }

}
