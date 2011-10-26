package w10j1.tandem.datakeeper.api;

import java.util.ArrayList;
import w10j1.tandem.task.api.Task;

/**
 *
 * @author Chris
 */
public interface DataKeeper {

    public String ascDue();

    public String decDue();

    public String ascPriority();

    public String decPriority();

    public String memToFile();
    
    public void fileToMem(String fromFile);
    
    public String resultString();
    
    public void addTask(Task task);
    
    public void searchTask(String keywords);
    
    public void removeTask(Task task);
}
