package w10j1.tandem.commandprocessor;

import java.util.Calendar;
import w10j1.tandem.commandprocessor.api.CommandProcessor;
import w10j1.tandem.datakeeper.DataKeeperImpl;
import w10j1.tandem.datakeeper.api.DataKeeper;
import w10j1.tandem.fileoprator.FileOperator;
import w10j1.tandem.task.api.Task;

/**
 *
 * @author Chris
 */
public class CommandProcessorImpl implements CommandProcessor {

    public FileOperator fo = new FileOperator();
    public DataKeeper dk = new DataKeeperImpl();
    
    @Override
    public void add(Task task) {
        this.dk.addTask(task);
        String updateList = dk.memToFile();
        this.fo.writeFile(updateList);
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
        this.dk.removeTask(((DataKeeperImpl) this.dk).searchList.get(Integer.parseInt(command)));
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