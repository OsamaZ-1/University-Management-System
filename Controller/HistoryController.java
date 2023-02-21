package Controller;

import java.sql.SQLException;

import Model.HistoryModel;
import View.HistoryView;

public class HistoryController {
   
    HistoryView historyView;
    HistoryModel historyModel;

    public HistoryController() throws SQLException
    {   
        historyView = new HistoryView();
        historyModel = new HistoryModel();
    }

}
