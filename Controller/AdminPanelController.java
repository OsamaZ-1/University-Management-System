package Controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.Student;
import Model.UniversityMember;
import View.AdminPanel;
import Model.AdminPanelModel;

public class AdminPanelController {
    AdminPanel adminPanelView;
    AdminPanelModel adminPanelModel;
    ArrayList<UniversityMember> unaccepted;
    
    public AdminPanelController(){
        adminPanelView = new AdminPanel();
        adminPanelModel = new AdminPanelModel();
        
        setUnacceptedIntoTable();
        submitChanges();
        setRefreshButtonAction();
        studentButtonAction();
        instructorButtonAction();
        courseButtonAction();
        totalCIS();
        logout();
    }

    public void setUnacceptedIntoTable(){
        DefaultTableModel model = adminPanelView.getTableModel();
        try{
            unaccepted = adminPanelModel.getUnacceptedStudents();
            unaccepted.addAll(adminPanelModel.getUnacceptedInstructors());
            for (UniversityMember um : unaccepted){
                String job;
                if (um instanceof Student){
                    job = "Student";
                }else{
                    job = "Instructor";
                }

                String activity = ""
                + "Name: " + um.getFname() + " " + um.getLname() + " -- "
                + "Email: " + um.getEmail() + " -- "
                + "Phone: " + um.getPhone() + " -- "
                + "Has requested to join the system.";

                model.addRow(new Object[]{job, activity, false, false});
            }
        }catch(SQLException e1){System.out.println(e1.getStackTrace());}
    }

    public void submitChanges(){
        adminPanelView.getSubmitButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    for (int i = 0; i < unaccepted.size(); ++i){
                        boolean acc = (boolean) adminPanelView.getActivityTable().getModel().getValueAt(i, 2);
                        boolean unacc = (boolean) adminPanelView.getActivityTable().getModel().getValueAt(i, 3);
                        if ((acc && unacc) || (!acc && !unacc))
                            continue;
                        else if (acc && !unacc){
                            if (unaccepted.get(i) instanceof Student)
                                adminPanelModel.acceptStudent(unaccepted.get(i).getEmail(), unaccepted.get(i).getPassword());
                            else
                                adminPanelModel.acceptInstructor(unaccepted.get(i).getEmail(), unaccepted.get(i).getPassword());
                        }
                        else
                            System.out.println("delete unaccepted member");
                    }
                    refreshActivity();
                }catch(SQLException e1){System.out.println(e1.getStackTrace());}
            }
        });
    }

    public void studentButtonAction(){
        adminPanelView.getStudentButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
            	try {
					new AdminStudentController();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
            }
        });
    }

    public void instructorButtonAction(){
        adminPanelView.getProfessorButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                new AdminInstructorController();
            }
        });
    }

    public void courseButtonAction() {
    	adminPanelView.getCourseButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
            	try {
					new AdminCourseController();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
            }
            });
    }

    public void refreshActivity(){
        adminPanelView.getTableModel().setRowCount(0);
        setUnacceptedIntoTable();
    }

    public void setRefreshButtonAction()
    {
        adminPanelView.getRefreshButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {   
                refreshActivity();
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
