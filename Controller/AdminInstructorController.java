package Controller;

import java.sql.SQLException;
import java.util.List;

import View.AdminInstructorView;
import View.AdminInstManageView;
import Model.AdminInstructorModel;
import Model.Course;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Factory.*;

public class AdminInstructorController implements Controller{
    private AdminInstructorView instView;
    private AdminInstructorModel instModel;
    private AdminInstManageView instManageView;
	private Object[][] tableInfo;

    private ModelFactory mf = (ModelFactory) FactoryProducer.createFactory("Model");
    private ViewFactory vf = (ViewFactory) FactoryProducer.createFactory("View");
    
    public AdminInstructorController(){
        instView = (AdminInstructorView) vf.createView("AdminInst");
        instModel = (AdminInstructorModel) mf.createModel("AdminInst");
        instManageView = (AdminInstManageView) vf.createView("AdminInstManage");
        instManageView.getMainFrame().setVisible(false);

        placeInfoInTable();
        editManageListener();
        editButtonListener();
        instructorTableListener();
        manageButtonListener();
        addButtonListener();
        deleteButtonListener();
		deleteInstructorListener();
    }

    public void placeInfoInTable(){
        try{
            instView.getTableModel().setRowCount(0);
            Object[][] lst = instModel.getInstructorsWithId();
            System.out.println(lst.length);
            for (Object[] inst : lst){
                instView.getTableModel().addRow(inst);
            }
        }catch(SQLException e1){
            e1.printStackTrace();
        }
    }

    public void editManageListener(){
		instView.getEditDeleteManageComboBox().addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent e) {
				String mode = String.valueOf(instView.getEditDeleteManageComboBox().getSelectedItem());
				if(mode.equals("Edit"))
				{	
					instView.getFootManagePanel().setVisible(false);
					instView.getFootDeletePanel().setVisible(false);
					instView.getFootEditPanel().setVisible(true);
				}
				else if(mode.equals("Manage")){
					instView.getFootEditPanel().setVisible(false);
					instView.getFootDeletePanel().setVisible(false);
					instView.getFootManagePanel().setVisible(true);
					
				}
				else 
				{
					instView.getFootEditPanel().setVisible(false);
					instView.getFootManagePanel().setVisible(false);
					instView.getFootDeletePanel().setVisible(true);	
				}
			}
		});
	}

    public void instructorTableListener(){
		instView.getInstTable().addMouseListener(new MouseListener() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				if(instView.getEditDeleteManageComboBox().getSelectedItem().toString().equals("Edit")) {
        			int selectedRow=instView.getInstTable().getSelectedRow();
        			String id=(String)instView.getInstTable().getValueAt(selectedRow,0).toString();
        			String fname=(String)instView.getInstTable().getValueAt(selectedRow,1).toString();
        			String lname=(String)instView.getInstTable().getValueAt(selectedRow,2).toString();
        			String email=(String)instView.getInstTable().getValueAt(selectedRow,3).toString();
        			String password=(String)instView.getInstTable().getValueAt(selectedRow,4).toString();
					String phone=(String)instView.getInstTable().getValueAt(selectedRow,5).toString();
        			instView.getInstId1().setText(id);
    				instView.getInstFname().setText(fname);
    				instView.getInstLname().setText(lname);
    				instView.getInstEmail().setText(email);
    				instView.getInstPassword().setText(password);
					instView.getInstPhone().setText(phone);
    			}
				else if(instView.getEditDeleteManageComboBox().getSelectedItem().toString().equals("Manage")){
					int selectedRow=instView.getInstTable().getSelectedRow();	
					String id=(String)instView.getInstTable().getValueAt(selectedRow,0).toString();
					instView.getInstId2().setText(id);
				}
				else 
				{
					int selectedRow=instView.getInstTable().getSelectedRow();	
					String id=(String)instView.getInstTable().getValueAt(selectedRow,0).toString();
					instView.getInstId3().setText(id);
				}
				
			}

            @Override
            public void mouseClicked(MouseEvent e) {
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
                
            }
        });
    }

    public void editButtonListener()
	{
		instView.getEditButton().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				String id = (String)instView.getInstId1().getText().toString();
				String fname = (String)instView.getInstFname().getText().toString();
				String lname = (String)instView.getInstLname().getText().toString();
				String email = (String)instView.getInstEmail().getText().toString();
				String password = (String)instView.getInstPassword().getText().toString();
				String phone = (String)instView.getInstPhone().getText().toString();

				if(!id.equals("") && !fname.equals("") && !lname.equals("") && !email.equals("") && !password.equals("") && !phone.equals(""))
				{	
					
					try{
							String[] InstInfo = new String[]{id,fname,lname,email,password,phone};
							try{
								if(instModel.updateInstructor(InstInfo))	
								{	placeInfoInTable();
									instView.displayMessage("Updated successfully");
								}
								else
									instView.displayMessage("Error editing info");			
							}catch(SQLException ex){ex.printStackTrace();}

						}catch(NumberFormatException ex)
						{	
							ex.printStackTrace();
							instView.displayMessage("Phone should consist of numbers only");
						}	
					
				}
				else
					instView.displayMessage("choose an Instructor and fill in all information!");
			}
		});
	}

    public void placeInfoInManageTable(String id) throws SQLException {
		instManageView.getTableModel().setNumRows(0);
		tableInfo=instModel.getAcceptedInstructorsInfo(id);
		for(int i=0;i<tableInfo.length;i++) {
			instManageView.getTableModel().addRow(tableInfo[i]);
		}
	}

    public void manageButtonListener()
	{
		instView.getManageButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String id = instView.getInstId2().getText().toString();
				if(!id.equals(""))
				{	fillCoursesList();
					instManageView.getMainFrame().setVisible(true);
					instManageView.setInstId(id);
					try{
						placeInfoInManageTable(instView.getInstId2().getText().toString());
					}catch(SQLException ex){ex.printStackTrace();}
				}
				else
					instView.displayMessage("Select an Instructor from table");
			}
		});
	}

    public void addButtonListener()
	{
		instManageView.getAddButton().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				String instId = instManageView.getInstIdField().getText().toString();
				String courseCode = instManageView.getCoursesList().getSelectedItem().toString();

				if(!courseCode.equals("")) //instId can't be null it comes filled from previous step
				{
					try{
						if(instModel.addInstructorToCourse(instId,courseCode))
						{	
							placeInfoInManageTable(instId);
							instManageView.displayMessage("Successfully added");
						}
						else
							instManageView.displayMessage("Error adding Instructor to course");

					}catch(SQLException ex){ex.printStackTrace();}
				}
				else
					instManageView.displayMessage("Choose Course Id");
			}
			
		});
	}

	public void deleteInstructorListener()
	{
		instView.getDeleteButton().addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e)
			{
				String id = instView.getInstId3().getText().toString();
				if(!id.equals(""))
				{	
					try{	
							if(instModel.deleteInstructor(id))
							{	
								placeInfoInTable();
								instView.displayMessage("Deleted successfully");		
							}
							else 
								instView.displayMessage("Error deleting instructor");
						}
						catch(SQLException ex){ex.printStackTrace();}		
				}
				else
					instView.displayMessage("Select an instructor from table");
			}
		});
	}

	public void deleteButtonListener()
	{
		instManageView.getDeleteButton().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				String instId = instManageView.getInstIdField().getText().toString();
				String courseCode = instManageView.getCoursesList().getSelectedItem().toString();
				if(!courseCode.equals("")) //instId can't be null it comes filled from previous step
				{
					try{
						if(instModel.deleteInstructorFromCourse(instId,courseCode))
						{	
							placeInfoInManageTable(instId);
							instManageView.displayMessage("Successfully Deleted");
						}
						else
							instManageView.displayMessage("Error deleting Instructor from course");

					}catch(SQLException ex){ex.printStackTrace();}
				}
				else
					instManageView.displayMessage("Choose Course Id");
			}

		});
	}

	public void fillCoursesList()
	{	
			List<Course> courses = null;
			instManageView.getCoursesList().removeAllItems();
			try{
				courses = instModel.getCoursesList();
			}catch(SQLException e){e.printStackTrace();}

			if(courses!=null)
			{
			 courses.forEach(course -> instManageView.getCoursesList().addItem(course.getCode()));
			}
	}
}
