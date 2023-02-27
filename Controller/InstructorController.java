package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import Model.InstructorCourseModel;
import View.InstructorPanelView;
import Factory.*;

public class InstructorController implements Controller{
    InstructorCourseModel instructorModel;
    InstructorPanelView instructorView;

    private ControllerFactory cf = (ControllerFactory) FactoryProducer.createFactory("Controller");
    private ModelFactory mf = (ModelFactory) FactoryProducer.createFactory("Model");
    private ViewFactory vf = (ViewFactory) FactoryProducer.createFactory("View");

    public InstructorController(String email, String pass) throws SQLException
    {
        instructorModel = (InstructorCourseModel) mf.createModel("InstCourse");
        instructorView = (InstructorPanelView) vf.createView("InstPanel");
        logout();
        fillCoursesList(email,pass);
        fillInstructorInfo(email, pass);
        coursesListListener();
        tableListener();
        addbuttonListener();
        saveButtonListener();
    }

    public void logout()
    {
        instructorView.getLogoutButton().addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                instructorView.getInstructorFrame().dispose();
                try{
                    cf.createController("Login");
                } catch (SQLException e1){
                    e1.printStackTrace();
                }
            }
            
        });
    }

    public void fillCoursesList(String instEmail, String instPass) throws SQLException
    {   
            List<String> courses = instructorModel.getInstructorCourses(instEmail, instPass);
            courses.forEach(code -> instructorView.getCoursesList().addItem(code));

    }

    public void fillInstructorInfo(String instEmail, String instPass) throws SQLException
    {
            HashMap<String,String> instructorInfo = instructorModel.getInstructorInfo(instEmail, instPass);
            instructorView.getInstructorNameLabel().setText("Full Name: "+instructorInfo.get("fullName"));
            instructorView.getInstructorIdLabel().setText("ID: "+instructorInfo.get("ID"));

    }

    public void coursesListListener()
    {
        instructorView.getCoursesList().addItemListener(new ItemListener(){

            @Override
            public void itemStateChanged(ItemEvent e){
                String courseCode = instructorView.getCoursesList().getSelectedItem().toString();
                instructorView.getCourseCodeField().setText(courseCode);
                try{
                    fillTable(courseCode);
                }catch(SQLException ex){ex.printStackTrace();}
            }
            
        });
    }

    public void fillTable(String courseCode) throws SQLException
    {
        Object[][] students = instructorModel.getEnrolledStudents(courseCode);
        instructorView.getTableModel().setRowCount(0);
        for(Object[] std : students)
            instructorView.getTableModel().addRow(std);
    }

    public void tableListener() throws SQLException
    {
        instructorView.getStudentsCourseGradesTable().addMouseListener(new MouseListener(){


            @Override
            public void mousePressed(MouseEvent e) {
                int selectedRow = instructorView.getStudentsCourseGradesTable().getSelectedRow();
                String id = instructorView.getStudentsCourseGradesTable().getValueAt(selectedRow, 0).toString();
                instructorView.getStudentIdField().setText(id);
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
                
            }
            
        });
            
    }

    public void addbuttonListener()
    {
        instructorView.getAddButton().addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                String studentId = instructorView.getStudentIdField().getText().toString();
                String courseCode = instructorView.getCourseCodeField().getText().toString();
                String grade = instructorView.getStudentGradeField().getText().toString();

                if(!studentId.equals("") && !courseCode.equals("") && !grade.equals(""))
                {   
                    float gradeCasted=-1;
                    try{
                            gradeCasted = Float.valueOf(grade);
                            if(gradeCasted>=0 && gradeCasted<=100)
                            {
                                try{
                                    if(instructorModel.updateStudentGrade(studentId,courseCode,grade))
                                    {
                                        fillTable(courseCode);
                                        instructorView.displayMessage("Successfully Updated"); 
                                    }
                                    else
                                        instructorView.displayMessage("Grade for this student already Submitted!!");   
                                }catch(SQLException ex){ex.printStackTrace();}   
                                instructorView.getStudentIdField().setText("");
                                instructorView.getStudentGradeField().setText("");
                            }
                            else 
                                instructorView.displayMessage("Grade must be between 0 and 100");
                        }catch(NumberFormatException ex)
                        {   ex.printStackTrace();
                            instructorView.displayMessage("Grade must be a number");
                        }

                    
                }
                else
                    instructorView.displayMessage("You must fill in all fields");
                
            }
            
        });
    }

    public void saveButtonListener()
    {
        instructorView.getSaveButton().addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e)
            {   String courseCode = instructorView.getCoursesList().getSelectedItem().toString();
                if(!courseCode.equals("Courses"))
                {    
                    try{
                         if(instructorModel.saveStudentsGrades(courseCode))
                         {  
                            fillTable(courseCode);
                            instructorView.displayMessage("Grades Sumbitted!!");
                         }
                         else
                            instructorView.displayMessage("Everything Up-to-Date");
                    }catch(SQLException ex){ex.printStackTrace();}
           
                }
                else
                    instructorView.displayMessage("You must select a course");
            }
        });
    }
}
