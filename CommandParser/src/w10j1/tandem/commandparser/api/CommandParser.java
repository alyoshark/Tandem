package w10j1.tandem.commandparser.api;

import java.util.Calendar;

/**
 *
 * @author Chris
 */
public interface CommandParser {

    void processDue();

    void readRawInput(String input);

    void setRequest();

    public String getRequest();

    public String getCommand();
    
    public Calendar getDue();
    
}