package Factory;

import java.util.HashMap;

public class FactoryProducer {
    public static final HashMap<String, Factory> flyweight = new HashMap<>();

    public static Factory createFactory(String key){
        Factory f = (Factory) flyweight.get(key);

        if (f == null){
            if (key.equals("Controller"))
                f = new ControllerFactory();
            if (key.equals("Model"))
                f = new ModelFactory();
            if (key.equals("View"))
                f = new ViewFactory();
            flyweight.put(key, f);
        }
    
        return f;
    }
}
