package w10j1.tandem.commandprocessor;

import java.util.Calendar;
import w10j1.tandem.commandprocessor.api.CommandProcessor;

/**
 *
 * @author Chris
 */
public class CommandProcessorOld implements CommandProcessor {

    @Override
    public void add(Calendar due, String command) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void search(String command) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void edit(String command) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void remove(String command) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setDone(String command) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void undo() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}