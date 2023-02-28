import java.sql.SQLException;
import Factory.*;

public class Main {

    public static void main(String[] args) throws SQLException {
    	
    	ControllerFactory cf = (ControllerFactory) FactoryProducer.createFactory("Controller");
        cf.createController("Login");
        
    }

}
