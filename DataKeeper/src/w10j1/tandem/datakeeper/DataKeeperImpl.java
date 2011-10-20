/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package w10j1.tandem.datakeeper;

import java.util.ArrayList;
import java.util.Collections;
import w10j1.tandem.task.api.Task;
import w10j1.tandem.datakeeper.api.DataKeeper;
import static w10j1.tandem.datakeeper.TaskComparator.*;

/**
 *
 * @author Chris
 */
public class DataKeeperImpl implements DataKeeper {

    public ArrayList<Task> taskList;
    public ArrayList<Task> searchList;

    public DataKeeperImpl() {
        taskList = new ArrayList<Task>();
    }

    @Override
    public String ascDue() {
        Collections.sort(searchList, ascending(DUE_SORT));
        return this.resultString();
    }

    @Override
    public String decDue() {
        Collections.sort(searchList, decending(DUE_SORT));
        return this.resultString();
    }

    @Override
    public String ascPriority() {
        Collections.sort(searchList, ascending(PRIORITY_SORT));
        return this.resultString();
    }

    @Override
    public String decPriority() {
        Collections.sort(searchList, decending(PRIORITY_SORT));
        return this.resultString();
    }

    @Override
    public String memToFile() {
        Collections.sort(taskList, ascending(DUE_SORT));
        StringBuilder sb = new StringBuilder();
        for (Task t : taskList) {
            sb.append(t.toString());
        }
        return sb.toString();
    }

    @Override
    public ArrayList<Task> fileToMem(String fromFile) {
        // TODO
        // Create a new Calendar instance with the info provided and description string.
        // Leave aside the done/undone and priority first.
        // Suppose the record is still stored in the same way in side the data file as 0.1 version.
        // dd|mm|yyyy|hh|mm|description..
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String resultString() {
        StringBuilder sb = new StringBuilder();
        for (Task t : searchList) {
            sb.append(t.getDesc()).append("\r\n");
        }
        return sb.toString();
    }
}