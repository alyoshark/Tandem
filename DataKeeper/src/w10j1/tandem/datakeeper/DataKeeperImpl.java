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
        StringBuilder sb = new StringBuilder();
        for (Task t : taskList) {
            sb.append(t.toString());
        }
        return sb.toString();
    }

    @Override
    public ArrayList<Task> fileToMem(String fromFile) {
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
