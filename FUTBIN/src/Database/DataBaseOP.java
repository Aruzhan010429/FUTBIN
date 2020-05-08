package Database;

import java.util.Map;

import javafx.collections.ObservableList;

public interface DataBaseOP {

    public String addOperation(Object obj);
    public ObservableList<Map> viewOperation();
    public String deleteOperation(String key);
    public String updateOperation(Object obj);

}
