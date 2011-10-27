/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package w10j1.tandem.datakeeper;

import com.mdimension.jchronic.utils.Span;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import static w10j1.tandem.datakeeper.TaskComparator.*;
import w10j1.tandem.datakeeper.api.DataKeeper;
import w10j1.tandem.task.TaskImpl;
import w10j1.tandem.task.api.Task;

/**
 *
 * @author Chris
 */
public class DataKeeperImpl implements DataKeeper {

    public ArrayList<Task> taskList;
    public ArrayList<Task> searchList;
    private SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");

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
    public void fileToMem(String fromFile) {
        String[] tempList = fromFile.split("\r\n");
        for (String task : tempList) {
            // Getting due
            String[] taskDetail = task.split("\\|");
            Calendar time = Calendar.getInstance();
            try {
                time.setTime(formatter.parse(taskDetail[0]));
            } catch (ParseException ex) {
                Logger.getLogger(DataKeeperImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.taskList.add(new TaskImpl(time, taskDetail[1]));
        }
    }

    @Override
    public String resultString() {
        StringBuilder sb = new StringBuilder();
        for (Task t : searchList) {
            sb.append(t.getDesc()).append("\r\n");
        }
        return sb.toString();
    }

    @Override
    public void addTask(Task task) {
        taskList.add(task);
    }

    @Override
    public void searchTask(String keywords) {
        String[] kw = keywords.split("\\s");
        for (Task task : taskList) {
            boolean hasAllWords = true;
            for (String word : kw) {
                if (!task.getDesc().contains(word)) {
                    hasAllWords = false;
                    break;
                }
            }
            if (hasAllWords) {
                searchList.add(task);
            }
        }
    }

    @Override
    public void searchTask(Span interval) {
        for (Task task : taskList) {
            if (task.getDue().compareTo(interval.getBeginCalendar()) >= 0
                    && task.getDue().compareTo(interval.getEndCalendar()) <= 0) {
                searchList.add(task);
            }
        }
    }

    @Override
    public void removeTask(Task task) {
        searchList.remove(task);
        taskList.remove(task);
    }
}