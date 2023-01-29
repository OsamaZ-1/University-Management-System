package Controller;

import java.sql.SQLException;

import javax.lang.model.util.ElementScanner14;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.protocol.a.authentication.AuthenticationOciClient;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.Student;
import View.AdminPanel;
import View.AdminStudentView;
import Model.AdminPanelModel;

public class AdminPanelController {
    AdminPanel adminPanelView;
    AdminPanelModel adminPanelModel;
    Student[] unaccepted;

    public AdminPanelController(){
        adminPanelView = new AdminPanel();
        adminPanelModel = new AdminPanelModel();
        
        adminPanelView.getStudentButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
            	try {
					new AdminStudentController();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
            });
        
        setUnacceptedIntoTable();
        submitChanges();
        refreshActivity();
        totalCIS();
        logout();
    }

    public void setUnacceptedIntoTable(){
        DefaultTableModel model = adminPanelView.getTableModel();
        try{
            unaccepted = adminPanelModel.getUnacceptedStudents();
            for (Student st : unaccepted){
                String activity = ""
                + "Student: " + st.getFname() + " " + st.getLname() + " -- "
                + "Email: " + st.getEmail() + " -- "
                + "Phone: " + st.getPhone() + " -- "
                + "Has requested to join the system.";

                model.addRow(new Object[]{activity, false, false});
            }
        }catch(SQLException e1){System.out.println(e1.getStackTrace());}
    }

    public void submitChanges(){
        adminPanelView.getSubmitButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    for (int i = 0; i < unaccepted.length; ++i){
                        boolean acc = (boolean) adminPanelView.getActivityTable().getModel().getValueAt(i, 1);
                        boolean unacc = (boolean) adminPanelView.getActivityTable().getModel().getValueAt(i, 2);
                        if ((acc && unacc) || (!acc && !unacc))
                            continue;
                        else if (acc && !unacc)
                            adminPanelModel.acceptStudent(unaccepted[i].getEmail(), unaccepted[i].getPassword());
                        else
                            System.out.println("delete unaccepted student");
                    }
                }catch(SQLException e1){System.out.println(e1.getStackTrace());}
            }
        });
    }

    public void refreshActivity()
    {
        adminPanelView.getRefreshButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {   
                adminPanelView.getTableModel().setRowCount(0);
                setUnacceptedIntoTable();
               
            }
        });
    }

    public void totalCIS() //total Courses, Instructors, Students
    {   
        try{
            int[] total = adminPanelModel.totalCIS();
            adminPanelView.getTotalCoursesLabel().setText("Total courses "+total[0]);
            adminPanelView.getTotalProfessorsLabel().setText("Total professors "+total[1]);
            adminPanelView.getTotalStudentsLabel().setText("Total students "+total[2]);
        }catch(Exception e){System.out.println(e.getStackTrace());}
        
    }

    public void logout()
    {
        adminPanelView.getLogoutButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                adminPanelView.getAdminPanelFrame().dispose();
                new LoginController();
            }
        });
    }
}
