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
    			int credits=Integer.parseInt(adminCourseView.getCreditsAddField().getText());
    			int houres=Integer.parseInt(adminCourseView.getHouresAddField().getText());
    			String major=adminCourseView.getMajorAddField().getText().toString();
    			int year=Integer.parseInt(adminCourseView.getYearAddField().getText().toString());
    			Course course=new Course(code,name,credits,houres,major,year);
    			try {
					adminCourseModel.addCourse(course);
					fillTable();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
            });
    }
    public void deleteButtonAction() {
    	adminCourseView.getDeleteButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
            	String code=adminCourseView.getCodeDeleteField().getText().toString();
            	try {
					adminCourseModel.deleteCourse(code);
					fillTable();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
            });
    }
    public void editButtonAction() {
    	adminCourseView.getEditButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
            	String code=adminCourseView.getCodeEditField().getText().toString();
    			String name=adminCourseView.getNameEditField().getText().toString();
    			int credits=Integer.parseInt(adminCourseView.getCreditsEditField().getText());
    			int houres=Integer.parseInt(adminCourseView.getHouresEditField().getText());
    			String major=adminCourseView.getMajorEditField().getText().toString();
    			int year=Integer.parseInt(adminCourseView.getYearEditField().getText().toString());
    			Course course=new Course(code,name,credits,houres,major,year);
    			try {
					adminCourseModel.editCourse(course);
					fillTable();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
    			
    			if(adminCourseView.getComboBoxActionFields().getSelectedItem()=="Edit") {
        			int selectedRow=adminCourseView.getCourseTable().getSelectedRow();
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
    				adminCourseView.getMajorEditField().setText(major);
    				adminCourseView.getYearEditField().setText(year);
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
}
