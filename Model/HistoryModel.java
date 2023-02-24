package Model;

import java.sql.SQLException;
import DAO.AdminDaoImplementation;

public class HistoryModel implements Model{
    AdminDaoImplementation adminDao = new AdminDaoImplementation();

    public Object[][] getRows(String chosenTable) throws SQLException{
        return adminDao.getTableRows(chosenTable);
    }

    public int retrieve(String chosenTable, String[] info) throws SQLException{
        return adminDao.retrieveFromHistory(chosenTable, info);
    }

    public int delete(String chosenTable, String[] info) throws SQLException{
        return adminDao.deleteFromHistory(chosenTable, info);
    }

    public int deleteAll(String chosenTable) throws SQLException{
        return adminDao.deleteAllFromHistory(chosenTable);
    }
}
