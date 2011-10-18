/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package w10j1.tandem.commandparser;

import com.mdimension.jchronic.Chronic;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Chris
 */
public class CommandParser {

    public final String COMMAND_ISO_STR = "^([aders])\\s(.*)";
    public final Pattern COMMAND_ISO = Pattern.compile(COMMAND_ISO_STR, Pattern.CASE_INSENSITIVE);
    public Calendar due;
    public String request = "";
    public String command = "";

    public CommandParser() {
        // Doing nothing first, may change my mind later.
    }

    public void readRawInput(String input) {
        this.command = input.trim();
    }

    public void setRequest() {
        Matcher match = COMMAND_ISO.matcher(command);
        if (match.find()) {
            request = match.group(1);
            command = match.group(2);
        } else {
            request = "a";
        }
    }

    public void processDue() {
        this.due = Chronic.parse(command).getEndCalendar();
    }
}