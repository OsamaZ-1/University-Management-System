package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;


import Model.AdminStudentModel;
import Model.Course;
import View.AdminStudentManageView;
import View.AdminStudentView;

public class AdminStudentController {

	private AdminStudentManageView adminStudentManageView;
	private AdminStudentView adminStudentView;
	private AdminStudentModel adminStudentModel;
	private Object[][] tableInfo;
	private String studentMajor;
	public AdminStudentController() throws SQLException {
		adminStudentManageView= new AdminStudentManageView();
		adminStudentView = new AdminStudentView();
		adminStudentModel=new AdminStudentModel();
		adminStudentManageView.getMainFrame().setVisible(false);
		fillFirstTable();
		editManageListener();
		studentTableListener();
		manageButtonListener();
		editButtonListener();
		addButtonListener();
		deleteButtonListener();
	}

	public void fillSecondTable(String id) throws SQLException {
		adminStudentManageView.getTableModel().setNumRows(0);
		tableInfo=adminStudentModel.getAcceptedStudentsInfo(id);
		for(int i=0;i<tableInfo.length;i++) {
			adminStudentManageView.getTableModel().addRow(tableInfo[i]);
		}
	}

	public void fillFirstTable() throws SQLException{
		Object[][] listStudents = adminStudentModel.getStudents();
		adminStudentView.getTableModel().setRowCount(0);
		for(int i=0; i<listStudents.length;i++)
			adminStudentView.getTableModel().addRow(listStudents[i]);
	}

	public void editManageListener(){
		adminStudentView.getEditManageComboBox().addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				String mode = String.valueOf(adminStudentView.getEditManageComboBox().getSelectedItem());
				if(mode.equals("Edit"))
				{	
					adminStudentView.getFootManagePanel().setVisible(false);
					adminStudentView.getFootEditPanel().setVisible(true);
				}
				else{
					adminStudentView.getFootEditPanel().setVisible(false);
					adminStudentView.getFootManagePanel().setVisible(true);
					
				}
			}
			
			
		});
	}

	public void studentTableListener()
	{
		adminStudentView.getStudentTable().addMouseListener(new MouseListener() {

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				if(adminStudentView.getEditManageComboBox().getSelectedItem().equals("Edit")) {
        			int selectedRow=adminStudentView.getStudentTable().getSelectedRow();
        			String id=(String)adminStudentView.getStudentTable().getValueAt(selectedRow,0).toString();
        			String fname=(String)adminStudentView.getStudentTable().getValueAt(selectedRow,1).toString();
        			String lname=(String)adminStudentView.getStudentTable().getValueAt(selectedRow,2).toString();
        		    String major=(String)adminStudentView.getStudentTable().getValueAt(selectedRow,3).toString();
        			String email=(String)adminStudentView.getStudentTable().getValueAt(selectedRow,4).toString();
        			String password=(String)adminStudentView.getStudentTable().getValueAt(selectedRow,5).toString();
					String phone=(String)adminStudentView.getStudentTable().getValueAt(selectedRow,6).toString();
        			adminStudentView.getStudentId1().setText(id);
    				adminStudentView.getStudentFname().setText(fname);
    				adminStudentView.getStudentLname().setText(lname);
    				adminStudentView.getStudentMajor().setSelectedItem((Object)major);
    				adminStudentView.getStudentEmail().setText(email);
    				adminStudentView.getStudentPassword().setText(password);
					adminStudentView.getStudentPhone().setText(phone);
    			}
				else
				{
					int selectedRow=adminStudentView.getStudentTable().getSelectedRow();	
					String id=(String)adminStudentView.getStudentTable().getValueAt(selectedRow,0).toString();
				    studentMajor=(String)adminStudentView.getStudentTable().getValueAt(selectedRow,3).toString();
					adminStudentView.getStudentId2().setText(id);
				}
				
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

	public void editButtonListener()
	{
		adminStudentView.getEditButton().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String id = (String)adminStudentView.getStudentId1().getText().toString();
				String fname = (String)adminStudentView.getStudentFname().getText().toString();
				String lname = (String)adminStudentView.getStudentLname().getText().toString();
				String major = (String)adminStudentView.getStudentMajor().getSelectedItem().toString();
				String email = (String)adminStudentView.getStudentEmail().getText().toString();
				String password = (String)adminStudentView.getStudentPassword().getText().toString();
				String phone = (String)adminStudentView.getStudentPhone().getText().toString();

				if(!id.equals("") && !fname.equals("") && !lname.equals("") && !major.equals("Select Major") && !email.equals("") && !password.equals("") && !phone.equals(""))
				{
					String[] studentInfo = new String[]{id,fname,lname,major,email,password,phone};
					try{
						if(adminStudentModel.updateStudent(studentInfo))
						{	
							fillFirstTable();
							JOptionPane.showMessageDialog(null,"Updated successfully");
							
						}
						else
							JOptionPane.showMessageDialog(null, "Error editing info");			
					}catch(SQLException ex){ex.printStackTrace();}
				}
				else
					JOptionPane.showMessageDialog(null, "choose a student and fill in all information!");
			}
			
		});
	}

	public void manageButtonListener()
	{
		adminStudentView.getManageButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String id = adminStudentView.getStudentId2().getText().toString();
				if(!id.equals(""))
				{	
					fillCoursesList(studentMajor);
					adminStudentManageView.getMainFrame().setVisible(true);
					adminStudentManageView.setStudentId(id);
					try{
						fillSecondTable(adminStudentView.getStudentId2().getText().toString());
					}catch(SQLException ex){ex.printStackTrace();}
				}
				else
					JOptionPane.showMessageDialog(null, "Select a student from table");
			}
		});
	}

	public void addButtonListener()
	{
		adminStudentManageView.getAddButton().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String studentId = adminStudentManageView.getStudentIdField().getText().toString();
				String courseCode = adminStudentManageView.getCoursesList().getSelectedItem().toString();
				if(!courseCode.equals("")) //studentId can't be null it comes filled from previous step
				{
					try{
						if(adminStudentModel.addStudentToCourse(studentId,courseCode))
						{	
							fillSecondTable(studentId);
							JOptionPane.showMessageDialog(null,"Successfully added");
						}
						else
							JOptionPane.showMessageDialog(null, "Error adding student to course");

					}catch(SQLException ex){ex.printStackTrace();}
				}
				else
					JOptionPane.showMessageDialog(null, "Choose Course Id");
			}
			
		});
	}

	public void deleteButtonListener()
	{
		adminStudentManageView.getDeleteButton().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String studentId = adminStudentManageView.getStudentIdField().getText().toString();
				String courseCode = adminStudentManageView.getCoursesList().getSelectedItem().toString();
				if(!courseCode.equals("")) //studentId can't be null it comes filled from previous step
				{
					try{
						if(adminStudentModel.deleteStudentFromCourse(studentId,courseCode))
						{	
							fillSecondTable(studentId);
							JOptionPane.showMessageDialog(null,"Successfully Deleted");
						}
						else
							JOptionPane.showMessageDialog(null, "Error deleting student from course");

					}catch(SQLException ex){ex.printStackTrace();}
				}
				else
					JOptionPane.showMessageDialog(null, "Choose Course Id");
			}

		});
	}

	public void fillCoursesList(String major)
	{	
		List<Course> courses = null;
		adminStudentManageView.getCoursesList().removeAllItems();
		try{
			courses = adminStudentModel.getCoursesList(major);
		}catch(SQLException e){e.printStackTrace();}

		if(courses!=null)
		{
			courses.forEach(course -> adminStudentManageView.getCoursesList().addItem(course.getCode()));
		}
	}
}
