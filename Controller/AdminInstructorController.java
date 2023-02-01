package Controller;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import View.AdminInstructorView;
import View.AdminInstManageView;
import Model.AdminInstructorModel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminInstructorController {
    private AdminInstructorView instView;
    private AdminInstructorModel instModel;
    private AdminInstManageView instManageView;
    private Object[][] tableInfo;

    public AdminInstructorController(){
        instView = new AdminInstructorView();
        instModel = new AdminInstructorModel();
        instManageView = new AdminInstManageView();
        instManageView.setVisible(false);

        placeInfoInTable();
        editManageListener();
        editButtonListener();
        instructorTableListener();
        manageButtonListener();
        addButtonListener();
        deleteButtonListener();
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
		instView.getEditManageComboBox().addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent e) {
				String mode = String.valueOf(instView.getEditManageComboBox().getSelectedItem());
				if(mode.equals("Edit"))
				{	
					instView.getFootManagePanel().setVisible(false);
					instView.getFootEditPanel().setVisible(true);
				}
				else{
					instView.getFootEditPanel().setVisible(false);
					instView.getFootManagePanel().setVisible(true);
					
				}
			}
		});
	}

    public void instructorTableListener(){
		instView.getInstTable().addMouseListener(new MouseListener() {

			@Override
			public void mousePressed(MouseEvent e) {
				if(instView.getEditManageComboBox().getSelectedItem().equals("Edit")) {
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
				else{
					int selectedRow=instView.getInstTable().getSelectedRow();	
					String id=(String)instView.getInstTable().getValueAt(selectedRow,0).toString();
					instView.getInstId2().setText(id);
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

				if(!id.equals("") && !fname.equals("") && !lname.equals("") && !email.equals("") && !password.equals("") && !phone.equals("")){
					String[] InstInfo = new String[]{id,fname,lname,email,password,phone};
					try{
						if(instModel.updateInstructor(InstInfo)){	
							placeInfoInTable();
							JOptionPane.showMessageDialog(null,"Updated successfully");
						}
						else
							JOptionPane.showMessageDialog(null, "Error editing info");			
					}catch(SQLException ex){ex.printStackTrace();}
				}
				else
					JOptionPane.showMessageDialog(null, "choose an Instreuctor and fill in all information!");
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
				{
					instManageView.setVisible(true);
					instManageView.setInstId(id);
					try{
						placeInfoInManageTable(instView.getInstId2().getText().toString());
					}catch(SQLException ex){ex.printStackTrace();}
				}
				else
					JOptionPane.showMessageDialog(null, "Select an Instructor from table");
			}
		});
	}

    public void addButtonListener()
	{
		instManageView.getAddButton().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				String instId = instManageView.getInstIdField().getText().toString();
				String courseId = instManageView.getCourseIdField().getText().toString();

				if(!courseId.equals("")) //instId can't be null it comes filled from previous step
				{
					try{
						if(instModel.addInstructorToCourse(instId,courseId))
						{	
							placeInfoInManageTable(instId);
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
		instManageView.getDeleteButton().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				String instId = instManageView.getInstIdField().getText().toString();
				String courseId = instManageView.getCourseIdField().getText().toString();
				if(!courseId.equals("")) //instId can't be null it comes filled from previous step
				{
					try{
						if(instModel.deleteInstructorFromCourse(instId,courseId))
						{	
							placeInfoInManageTable(instId);
							JOptionPane.showMessageDialog(null,"Successfully Deleted");
						}
						else
							JOptionPane.showMessageDialog(null, "Error deleting Instructor from course");

					}catch(SQLException ex){ex.printStackTrace();}
				}
				else
					JOptionPane.showMessageDialog(null, "Choose Course Id");
			}

		});
	}
}
