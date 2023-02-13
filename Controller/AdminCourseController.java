package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.List;

import Model.AdminCourseModel;
import Model.Course;
import View.AdminCourseView;

public class AdminCourseController {
	private AdminCourseModel adminCourseModel;
	private AdminCourseView adminCourseView;
	private List<Course> tableInfo;

	public AdminCourseController() throws SQLException {
		adminCourseModel=new AdminCourseModel();
		adminCourseView=new AdminCourseView();
		fillTable();
		addButtonAction();
        editButtonAction();
        deleteButtonAction();
        actionFieldComboBoxListener();
        actionCourseTable();
	}

	public void fillTable() throws SQLException {
		tableInfo=adminCourseModel.getAllCourses();
		Object[] courseInfo=new Object[6];
		adminCourseView.getTableModel().setNumRows(0);
		//Name,Code,Credits,Hours,Major,Year
		for(int i=0;i<tableInfo.size();i++) {
			courseInfo[0]=(Object)tableInfo.get(i).getName();
			courseInfo[1]=(Object)tableInfo.get(i).getCode();
			courseInfo[2]=(Object)tableInfo.get(i).getCredits();
			courseInfo[3]=(Object)tableInfo.get(i).getHours();
			courseInfo[4]=(Object)tableInfo.get(i).getMajor();
			courseInfo[5]=(Object)tableInfo.get(i).getYear();
			adminCourseView.getTableModel().addRow(courseInfo);
		}
	}
	public void addButtonAction() {
		adminCourseView.getAddButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
            	String code="default";
    			String name=adminCourseView.getNameAddField().getText().toString();
    			String credits=adminCourseView.getCreditsAddField().getText().toString();
    			String hours=adminCourseView.getHouresAddField().getText().toString();
    			String major=adminCourseView.getMajorAddField().getSelectedItem().toString();
    			String year=adminCourseView.getYearAddField().getText().toString();
    			
    			if(!name.equals("") && !credits.equals("") && !hours.equals("") && !major.equals("Select Major") && !year.equals(""))
				{	Course course=new Course(code,name,Integer.parseInt(credits),Integer.parseInt(hours),major,Integer.parseInt(year));
					try {

						if(adminCourseModel.addCourse(course))
						{
							fillTable();
							refreshPage("Add");
					 		adminCourseView.displayMessage("Successfully added course");
						}
						else
							adminCourseView.displayMessage("Error adding course");
					} catch (SQLException e1) {e1.printStackTrace();}
            	}
				else
					adminCourseView.displayMessage("Fill all information");
            }});
    }
    public void deleteButtonAction() {
    	adminCourseView.getDeleteButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
            	String code=adminCourseView.getCodeDeleteField().getText().toString();
				if(!code.equals(""))
            	{	
					try {
						if(adminCourseModel.deleteCourse(code))
						{
						 fillTable();
						 refreshPage("Delete");
						 adminCourseView.displayMessage("Successfully deleted course");
						}
						else
							adminCourseView.displayMessage("Error deleting course");
					} catch (SQLException e1) {
						adminCourseView.displayMessage("Not delete course have student marks");
						}
				}
				else
					adminCourseView.displayMessage("Enter course code");
            }
            });
    }
    public void editButtonAction() {
    	adminCourseView.getEditButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
            	String code=adminCourseView.getCodeEditField().getText().toString();
    			String name=adminCourseView.getNameEditField().getText().toString();
    			String credits=adminCourseView.getCreditsEditField().getText().toString();
    			String hours=adminCourseView.getHouresEditField().getText().toString();
    			String major=adminCourseView.getMajorEditField().getSelectedItem().toString();
    			String year=adminCourseView.getYearEditField().getText().toString().toString();
    			
				if(!code.equals("") && !name.equals("") && !major.equals("Select Major") && !credits.equals("") && !hours.equals("") && !major.equals("") && !year.equals("") )
    			{	Course course=new Course(code,name,Integer.parseInt(credits),Integer.parseInt(hours),major,Integer.parseInt(year));
					try {
						if(adminCourseModel.editCourse(course))
						{	
							fillTable();
							refreshPage("Edit");
							adminCourseView.displayMessage("Updated sucessfully");
						}
						else
							adminCourseView.displayMessage("Error editing info");	
					} catch (SQLException e1) {e1.printStackTrace();}
				}
				else
					adminCourseView.displayMessage("Fill all inforamtion");
            }
            });
    }

    public void actionFieldComboBoxListener() {
    	adminCourseView.getComboBoxActionFields().addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent arg0) {
            	if(adminCourseView.getComboBoxActionFields().getSelectedItem()=="Add") {
            		adminCourseView.getCardLayout().show(adminCourseView.getCardPanel(),adminCourseView.getAddPanelCode());
            	}
            	else if(adminCourseView.getComboBoxActionFields().getSelectedItem()=="Delete") {
            		adminCourseView.getCardLayout().show(adminCourseView.getCardPanel(),adminCourseView.getDeletePanelCode());
            	}
            	else if(adminCourseView.getComboBoxActionFields().getSelectedItem()=="Edit") {
            		adminCourseView.getCardLayout().show(adminCourseView.getCardPanel(),adminCourseView.getEditPanelCode());
            	}
            }
        });
    }
	
    public void actionCourseTable() {
    	adminCourseView.getCourseTable().addMouseListener(new MouseListener() {
    		public void mousePressed(MouseEvent e) {
    			int selectedRow=adminCourseView.getCourseTable().getSelectedRow();
    			if(adminCourseView.getComboBoxActionFields().getSelectedItem().equals("Edit")) {

        			String code=(String)adminCourseView.getCourseTable().getValueAt(selectedRow,1);
        			String name=(String)adminCourseView.getCourseTable().getValueAt(selectedRow,0);
        			String credits=adminCourseView.getCourseTable().getValueAt(selectedRow,2).toString();
        			String houres=(String)adminCourseView.getCourseTable().getValueAt(selectedRow,3).toString();
        			String major=(String)adminCourseView.getCourseTable().getValueAt(selectedRow,4).toString();
        			String year=(String)adminCourseView.getCourseTable().getValueAt(selectedRow,5).toString();
        			adminCourseView.getCodeEditField().setText(code);
    				adminCourseView.getNameEditField().setText(name);
    				adminCourseView.getCreditsEditField().setText(credits);
    				adminCourseView.getHouresEditField().setText(houres);
    				adminCourseView.getMajorEditField().setSelectedItem((Object)major);
    				adminCourseView.getYearEditField().setText(year);
    			}
				else if(adminCourseView.getComboBoxActionFields().getSelectedItem().equals("Delete"))
				{
					String courseCode=(String)adminCourseView.getCourseTable().getValueAt(selectedRow,1);
					adminCourseView.getCodeDeleteField().setText(courseCode);
				}
    			
    		}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
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
    	});
    }

	public void refreshPage(String mode)
	{	
		if(mode.equals("Add"))
		{
			adminCourseView.getNameAddField().setText("");
			adminCourseView.getMajorAddField().setSelectedItem((Object)"Select Major");
			adminCourseView.getCreditsAddField().setText("");
			adminCourseView.getHouresAddField().setText("");
			adminCourseView.getYearAddField().setText("");
		}
		else if(mode.equals("Edit"))
		{
			adminCourseView.getCodeEditField().setText("");
			adminCourseView.getNameEditField().setText("");
			adminCourseView.getMajorEditField().setSelectedItem((Object)"Select Major");
			adminCourseView.getCreditsEditField().setText("");
			adminCourseView.getHouresEditField().setText("");
			adminCourseView.getYearEditField().setText("");
		}
		else 
			adminCourseView.getCodeDeleteField().setText("");
	}
}