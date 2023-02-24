package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.DefaultComboBoxModel;

import Model.AdminCourseModel;
import Model.Course;
import View.AdminCourseView;
import Factory.*;

public class AdminCourseController implements Controller{
	private AdminCourseModel adminCourseModel;
	private AdminCourseView adminCourseView;
	private List<Course> tableInfo;

    private ModelFactory mf = (ModelFactory) FactoryProducer.createFactory("Model");
    private ViewFactory vf = (ViewFactory) FactoryProducer.createFactory("View");

	public AdminCourseController() throws SQLException {
		adminCourseModel = (AdminCourseModel) mf.createModel("AdminCourse");
		adminCourseView = (AdminCourseView) vf.createView("AdminCourse");
		fillTable();
		addButtonAction();
		yearListAction("Add");
		majorListener("Add");
		actionCourseTable();
        //editButtonAction();
        //deleteButtonAction();
        actionFieldComboBoxListener();
        //actionCourseTable();
        //editYearListAction();
	}

	public void fillTable() throws SQLException {
		tableInfo=adminCourseModel.getAllCourses();
		Object[] courseInfo=new Object[8];
		adminCourseView.getTableModel().setNumRows(0);
		//Name,Code,Credits,Hours,Major,Year
		for(int i=0;i<tableInfo.size();i++) {
			courseInfo[0]=(Object)tableInfo.get(i).getName();
			courseInfo[1]=(Object)tableInfo.get(i).getCode();
			courseInfo[2]=(Object)tableInfo.get(i).getPreRequisite();
			courseInfo[3]=(Object)tableInfo.get(i).getCredits();
			courseInfo[4]=(Object)tableInfo.get(i).getHours();
			courseInfo[5]=(Object)tableInfo.get(i).getMajor();
			courseInfo[6]=(Object)tableInfo.get(i).getYear();
			courseInfo[7]=(Object)tableInfo.get(i).getSemester();
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
    			String year=adminCourseView.getYearAddList().getSelectedItem().toString();
    			String semester=adminCourseView.getAddSemesterList().getSelectedItem().toString();
				String preReq = adminCourseView.getPreRequisiteAdd().getSelectedItem().toString();
    			
    			if(!name.equals("") && !credits.equals("") && !hours.equals("") && !major.equals("Select Major") && !year.equals("Select Year") && !semester.equals("Select Semester") && !preReq.equals("Select Course"))
				{	Course course=new Course(code,name,preReq,Integer.parseInt(credits),Integer.parseInt(hours),major,Integer.parseInt(year),Integer.parseInt(semester));
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
						 adminCourseModel.updateCoursePrerequisites(code);
						 fillTable();
						 refreshPage("Delete");
						 adminCourseView.displayMessage("Successfully deleted course");
						}
						else
							adminCourseView.displayMessage("Error deleting course");
					} catch (SQLException e1) {e1.printStackTrace();}
								
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
    			String year=adminCourseView.getYearEditList().getSelectedItem().toString();
    			String semester=adminCourseView.getEditSemesterList().getSelectedItem().toString();
				String preReq = adminCourseView.getPreRequisiteEdit().getSelectedItem().toString();
    			
				if(!code.equals("") && !name.equals("") && !major.equals("Select Major") && !credits.equals("") && !hours.equals("") && !year.equals("Select Year") && !semester.equals("Select Semester") && !preReq.equals("Select Course"))
    			{	Course course=new Course(code,name,preReq,Integer.parseInt(credits),Integer.parseInt(hours),major,Integer.parseInt(year),Integer.parseInt(semester));
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
    	adminCourseView.getComboBoxActionFields().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	if(adminCourseView.getComboBoxActionFields().getSelectedItem().equals("Add")) {
            		adminCourseView.getCardLayout().show(adminCourseView.getCardPanel(),adminCourseView.getAddPanelCode());
					majorListener("Add");
					addButtonAction();
					yearListAction("Add");
					
            	}
            	else if(adminCourseView.getComboBoxActionFields().getSelectedItem().equals("Delete")) {
            		adminCourseView.getCardLayout().show(adminCourseView.getCardPanel(),adminCourseView.getDeletePanelCode());
					deleteButtonAction();
					
            	}
            	else if(adminCourseView.getComboBoxActionFields().getSelectedItem().equals("Edit")) {
            		adminCourseView.getCardLayout().show(adminCourseView.getCardPanel(),adminCourseView.getEditPanelCode());
					editButtonAction();
					majorListener("Edit");
					yearListAction("Edit");
					
            	}
            }
        });
    }
	
    public void actionCourseTable() {
    	adminCourseView.getCourseTable().addMouseListener(new MouseListener() {
    		public void mousePressed(MouseEvent e) {
    			int selectedRow=adminCourseView.getCourseTable().getSelectedRow();
    			if(adminCourseView.getComboBoxActionFields().getSelectedItem().equals("Edit")) {

					String name=(String)adminCourseView.getCourseTable().getValueAt(selectedRow,0);
        			String code=(String)adminCourseView.getCourseTable().getValueAt(selectedRow,1);
					String preReq=(String)adminCourseView.getCourseTable().getValueAt(selectedRow,2);
        			String credits=adminCourseView.getCourseTable().getValueAt(selectedRow,3).toString();
        			String houres=(String)adminCourseView.getCourseTable().getValueAt(selectedRow,4).toString();
        			String major=(String)adminCourseView.getCourseTable().getValueAt(selectedRow,5).toString();
        			String year=(String)adminCourseView.getCourseTable().getValueAt(selectedRow,6).toString();
        			String semester=(String)adminCourseView.getCourseTable().getValueAt(selectedRow,7).toString();
        			adminCourseView.getCodeEditField().setText(code);
    				adminCourseView.getNameEditField().setText(name);
    				adminCourseView.getCreditsEditField().setText(credits);
    				adminCourseView.getHouresEditField().setText(houres);
    				adminCourseView.getMajorEditField().setSelectedItem((Object)major);
    				adminCourseView.getYearEditList().setSelectedItem((Object)year);
    				adminCourseView.getEditSemesterList().setSelectedItem((Object)semester);
					if(Integer.parseInt(year)>1)
						fillPreRequisite(major, Integer.parseInt(year)-1, "Edit");
					adminCourseView.getPreRequisiteEdit().setSelectedItem((Object)preReq);
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

	public void majorListener(String mode)
	{
		if(mode.equals("Add"))
		{	
			adminCourseView.getMajorAddField().addItemListener(new ItemListener(){

			public void itemStateChanged(ItemEvent e)
			{	
				String yearS = adminCourseView.getYearAddList().getSelectedItem().toString();
				if(!yearS.equals("Select Year"))
				{
					int year = Integer.parseInt(yearS);
					String major = adminCourseView.getMajorAddField().getSelectedItem().toString();

					if(year>1)
						fillPreRequisite(major, year-1, mode);
				}
			}
			});
		}
		else if(mode.equals("Edit"))
		{
			adminCourseView.getMajorEditField().addItemListener(new ItemListener(){

				public void itemStateChanged(ItemEvent e)
				{	
					String yearS = adminCourseView.getYearEditList().getSelectedItem().toString();
					if(!yearS.equals("Select Year"))
					{
						int year = Integer.parseInt(yearS);
						String major = adminCourseView.getMajorEditField().getSelectedItem().toString();
	
						if(year>1)
							fillPreRequisite(major, year-1, mode);
					}
				}
				});
		}
	}

	public void refreshPage(String mode)
	{	
		if(mode.equals("Add"))
		{
			adminCourseView.getNameAddField().setText("");
			adminCourseView.getMajorAddField().setSelectedItem((Object)"Select Major");
			adminCourseView.getCreditsAddField().setText("");
			adminCourseView.getHouresAddField().setText("");
			adminCourseView.getYearAddList().setSelectedItem((Object)"Select Year");
			adminCourseView.getAddSemesterList().setSelectedItem((Object)"Select Semester");
			adminCourseView.getPreRequisiteAdd().setSelectedItem((Object)"Select Course");
		}
		else if(mode.equals("Edit"))
		{
			adminCourseView.getCodeEditField().setText("");
			adminCourseView.getNameEditField().setText("");
			adminCourseView.getMajorEditField().setSelectedItem((Object)"Select Major");
			adminCourseView.getCreditsEditField().setText("");
			adminCourseView.getHouresEditField().setText("");
			adminCourseView.getYearEditList().setSelectedItem((Object)"Select Year");
			adminCourseView.getEditSemesterList().setSelectedItem((Object)"Select Semester");
			adminCourseView.getPreRequisiteEdit().setSelectedItem((Object)"Select Course");
		}
		else 
			adminCourseView.getCodeDeleteField().setText("");
	}
	public void yearListAction(String mode) {

		if(mode.equals("Add"))
		{		
			adminCourseView.getYearAddList().addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e){
            	adminCourseView.getAddSemesterList().setModel(new DefaultComboBoxModel<String>());
            	String[] semesters=new String[3];
            	semesters[0]="Select Semester";
				String major = adminCourseView.getMajorAddField().getSelectedItem().toString();

            	if(adminCourseView.getYearAddList().getSelectedItem()=="1") {
            		semesters=adminCourseView.getYearOneSemesters();
            	}
            	else if(adminCourseView.getYearAddList().getSelectedItem()=="2") {
            		semesters=adminCourseView.getYearTwoSemesters();
					if(!major.equals("Select Major"))
						fillPreRequisite(major, 1, "Add");
            	}
            	else if(adminCourseView.getYearAddList().getSelectedItem()=="3") {
            		semesters=adminCourseView.getYearThreeSemesters();
					if(!major.equals("Select Major"))
						fillPreRequisite(major, 2,"Add");
            	}
            	adminCourseView.getAddSemesterList().setModel(new DefaultComboBoxModel<String>(semesters));
            
			}});
		}
		else if(mode.equals("Edit"))
		{
			adminCourseView.getYearEditList().addItemListener(new ItemListener(){
				@Override
				public void itemStateChanged(ItemEvent e){
					adminCourseView.getEditSemesterList().setModel(new DefaultComboBoxModel<String>());
					String[] semesters=new String[3];
					semesters[0]="Select Semester";
					String major = adminCourseView.getMajorEditField().getSelectedItem().toString();
	
					if(adminCourseView.getYearEditList().getSelectedItem()=="1") {
						semesters=adminCourseView.getYearOneSemesters();
					}
					else if(adminCourseView.getYearEditList().getSelectedItem()=="2") {
						semesters=adminCourseView.getYearTwoSemesters();
						if(!major.equals("Select Major"))
							fillPreRequisite(major, 1, "Edit");
					}
					else if(adminCourseView.getYearEditList().getSelectedItem()=="3") {
						semesters=adminCourseView.getYearThreeSemesters();
						if(!major.equals("Select Major"))
							fillPreRequisite(major, 2,"Edit");
					}
					adminCourseView.getEditSemesterList().setModel(new DefaultComboBoxModel<String>(semesters));
				
				}});
		}
	}

	public void fillPreRequisite(String major, int year, String mode)
	{
		List<String> courses = null;
		try{
			courses = adminCourseModel.getPreRequisiteCourses(major, year);
		}catch(SQLException e){e.printStackTrace();}

		if(mode.equals("Add"))
		{
			adminCourseView.getPreRequisiteAdd().removeAllItems();
			adminCourseView.getPreRequisiteAdd().addItem("Select Course");
			adminCourseView.getPreRequisiteAdd().addItem("none");	
		
			if(courses!=null)
				courses.forEach(course -> adminCourseView.getPreRequisiteAdd().addItem(course));
		
		}
		else if(mode.equals("Edit"))
		{
			adminCourseView.getPreRequisiteEdit().removeAllItems();
			adminCourseView.getPreRequisiteEdit().addItem("Select Course");
			adminCourseView.getPreRequisiteEdit().addItem("none");	
		
			if(courses!=null)
				courses.forEach(course -> adminCourseView.getPreRequisiteEdit().addItem(course));
		}
	}
}
