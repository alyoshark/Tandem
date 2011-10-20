package w10j1.tandem.commandparser;

import w10j1.tandem.commandparser.api.CommandParser;
import com.mdimension.jchronic.Chronic;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Chris
 */
public class CommandParserImpl implements CommandParser {

    public final String COMMAND_ISO_STR = "^([adersu])\\s(.*)";
    public final Pattern COMMAND_ISO = Pattern.compile(COMMAND_ISO_STR, Pattern.CASE_INSENSITIVE);
    public Calendar due;
    public String request = "";
    public String command = "";

    public CommandParserImpl() {
        // Doing nothing first, may change my mind later.
    }

    @Override
    public void readRawInput(String input) {
        this.command = input.trim();
    }

    @Override
    public void setRequest() {
        Matcher match = COMMAND_ISO.matcher(command);
        if (match.find()) {
            request = match.group(1);
            command = match.group(2);
        } else {
            request = "a";
        }
    }

    @Override
    public void processDue() {
        this.due = Chronic.parse(command).getEndCalendar();
    }

    @Override
    public String getRequest() {
        return this.request;
    }

    @Override
    public String getCommand() {
        return this.command;
    }

    @Override
    public Calendar getDue() {
        return this.due;
    }
}