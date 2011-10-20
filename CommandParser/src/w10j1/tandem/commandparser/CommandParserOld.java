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
public class CommandParserOld implements CommandParser {

    public final String COMMAND_ISO_STR = "^([adersu])\\s(.*)";
    public final Pattern COMMAND_ISO = Pattern.compile(COMMAND_ISO_STR, Pattern.CASE_INSENSITIVE);
    public Calendar due;
    public String request = "";
    public String command = "";

    @Override
    public void readRawInput(String input) {
        this.command = input.trim();
    }

    @Override
    public void setRequest() {
        // TODO
        throw new UnsupportedOperationException("Not supported yet.");
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