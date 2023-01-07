package Controller;

import java.sql.SQLException;
import javax.swing.JCheckBox;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.Student;
import View.AdminPanel;
import Model.AdminPanelModel;

public class AdminPanelController {
    AdminPanel adminPanelView;
    AdminPanelModel adminPanelModel;

    public AdminPanelController(){
        adminPanelView = new AdminPanel();
        adminPanelModel = new AdminPanelModel();
        setUnacceptedIntoTable();
    }

    public void setUnacceptedIntoTable(){
        Student[] unaccepted;
        DefaultTableModel model = adminPanelView.getTableModel();

        try{
            unaccepted = adminPanelModel.getUnacceptedStudents();
            for (Student st : unaccepted){
                String activity = ""
                + "Student: " + st.getFname() + " " + st.getLname() + " -- "
                + "Email: " + st.getEmail() + " -- "
                + "Phone: " + st.getPhone() + " -- "
                + "Has requested to join the system.";

                model.addRow(new Object[]{activity, false});
            }
        }catch(SQLException e1){System.out.println(e1.getStackTrace());}
    }

    public void submitChanges(){
        adminPanelView.getSubmitButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                //this allows getting the value of the checkbox at i, j
                //adminPanelView.getActivityTable().getModel().getValueAt(i, j)

                //this function wil accept the students that the admin checked
            }
        });
    }
}
