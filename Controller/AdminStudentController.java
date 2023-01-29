package Controller;

import java.sql.SQLException;

import Model.AdminStudentModel;
import View.AdminStudentView;

public class AdminStudentController {

	private AdminStudentView adminStudentView;
	private AdminStudentModel adminStudentModel;
	private Object[][] tableInfo;
	public AdminStudentController() throws SQLException {
		adminStudentView=new AdminStudentView();
		adminStudentModel=new AdminStudentModel();
		fillTable();
	}
	public void fillTable() throws SQLException {
		tableInfo=adminStudentModel.getAcceptedStudentsInfo();
		for(int i=0;i<tableInfo.length;i++) {
			adminStudentView.getTableModel().addRow(tableInfo[i]);
		}
	}
}
