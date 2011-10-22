package w10j1.tandem.commandprocessor;

import java.util.Calendar;
import w10j1.tandem.commandprocessor.api.CommandProcessor;
import w10j1.tandem.datakeeper.DataKeeperImpl;

/**
 *
 * @author Chris
 */
public class CommandProcessorOld implements CommandProcessor {

    DataKeeperImpl dataKeeperInst = new DataKeeperImpl();
    String searchResults;
    
    @Override
    public void add(Calendar due, String command) {
       dataKeeperInst.taskList.add(new TaskImpl(due, cpar.getDesc(command), false, cpar.getPriority(command));
       FileOperator.writeFile(dataKeeperInst.ascDue());
    }

    public void search(String command) {
        searchResults = dataKeeperInst.resultString();
    }

    @Override
    public void edit(String command) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void remove(String command) {  
        
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