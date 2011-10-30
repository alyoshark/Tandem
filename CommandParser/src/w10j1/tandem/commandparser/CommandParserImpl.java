package w10j1.tandem.commandparser;

import com.mdimension.jchronic.Chronic;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import w10j1.tandem.commandparser.api.CommandParser;

/**
 *
 * @author Chris
 */
public class CommandParserImpl implements CommandParser {

    public final String TIME_ISO_STR = "^(\\d{4,6})\\s+(\\d{4})(.*)";
    public final String COMMAND_ISO_STR = "^([adersu])\\s+(.*)";
    public final Pattern COMMAND_ISO = Pattern.compile(COMMAND_ISO_STR, Pattern.CASE_INSENSITIVE);
    public final Pattern TIME_ISO = Pattern.compile(TIME_ISO_STR);
    public Calendar due;
    public String request = "";
    public String command = "";

    public CommandParserImpl() {
        // Doing nothing first
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
    public void processDue() throws ParseException {
        Matcher match = TIME_ISO.matcher(command);
        if (match.find()) {
            String datePart = match.group(1);
            String timePart = match.group(2);
            if (datePart.length() == 4) {
                try {
                    this.due.setTime(new SimpleDateFormat("ddMM hhmm").parse(datePart +
                            (timePart != null ? " " + timePart : " 0000")));
                    if (this.due.before(Calendar.getInstance())) {
                        this.due.roll(Calendar.YEAR, 1);
                    }
                } catch (ParseException ex) {
                    Logger.getLogger(CommandParserImpl.class.getName()).log(Level.SEVERE, null, ex);
                    throw ex;
                }
            } else if (datePart.length() == 6) {
                try {
                    this.due.setTime(new SimpleDateFormat("ddMMyy hhmm").parse(datePart +
                            (timePart != null ? " " + timePart : " 0000")));
                } catch (ParseException ex) {
                    Logger.getLogger(CommandParserImpl.class.getName()).log(Level.SEVERE, null, ex);
                    throw ex;
                }
            }
        } else if ((this.due = Chronic.parse(command).getEndCalendar()) != null) {
        } else {
            ParseException ex = new ParseException("Can't parse this command, most likely an incorrect input", 0);
            Logger.getLogger(CommandParserImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
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