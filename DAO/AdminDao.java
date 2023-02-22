package DAO;

import java.sql.SQLException;

public interface AdminDao {
    
    public int uniqueAdminExists(String email, String pass)
        throws SQLException;
    public Object[][] getTableRows(String chosenTable)
        throws SQLException;
    public int retrieveFromHistory(String chosenTable, String[] info)
        throws SQLException;
    public int deleteFromHistory(String chosenTable, String[] info)
        throws SQLException;
    public int deleteAllFromHistory(String chosenTable)
        throws SQLException;
}
