package w10j1.tandem.commandprocessor.api;

import java.util.Calendar;

/**
 *
 * @author Chris
 */
public interface CommandProcessor {

    public void add(Calendar due, String command);

    public void search(String command);

    public void edit(String command);

    public void remove(String command);

    public void setDone(String command);

    public void undo();
    
}
