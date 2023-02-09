package DAO;

import java.sql.SQLException;

public interface AdminDao {
    
    public int uniqueAdminExists(String email, String pass)
        throws SQLException;
}
