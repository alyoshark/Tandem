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

    public final String DATE_PATTERN_STR = "^(([0-2]\\d)|(3[0-1])|(\\d))((/|-)?)((0[1-9])|(1[0-2])|([1-9]))$";
    public final String DATE_YEAR_PATTERN_STR = "^(([0-2]\\d)|(3[0-1])|(\\d))((/|-)?)((0[1-9])|(1[0-2])|([1-9]))(/|-)*(\\d{4})$";
    public final String TIME_VALID_STR = "^(([0-1]\\d)|(2[0-3])|(\\d))((:)?)(([0-5]\\d)|(\\d))$";
    public final String TIME_EXISTS_PATTERN_STR = "^(\\d{1,2})((:)?)(\\d{1,2})$";
    /**
     * Patterns generated base on the regular expressions
     */
    public final Pattern DATE_PATTERN = Pattern.compile(DATE_PATTERN_STR);
    public final Pattern DATE_YEAR_PATTERN = Pattern.compile(DATE_YEAR_PATTERN_STR);
    public final Pattern TIME_VALID_PATTERN = Pattern.compile(TIME_VALID_STR);
    public final Pattern TIME_EXISTS_PATTERN = Pattern.compile(TIME_EXISTS_PATTERN_STR);
    public final int DATE_INDEX = 0;
    public final int TIME_INDEX = 1;
    public final int DATE_MATCHER_INDEX = 1;
    public final int MONTH_MATCHER_INDEX = 7;
    public final int YEAR_MATCHER_INDEX = 12;
    public final String DATE_FORMAT = "dd/MM/yyyy";
    public final int HOUR_MATCHER_INDEX = 1;
    public final int MINUTE_MATCHER_INDEX = 7;
    private static final String ACTION_CHOICES = "Remove from data by specifying task index or:\r\nb. Back\t\tq. Quit\r\n";
    /**
     * Attributes of the class
     */
    private String rawInput;
    private String[] commandDetails;
    private char request;
    private boolean dateIsValid; //indicate whether date is valid 
    private boolean timeIsValid; //indicate whether time value is valid
    private boolean timeExists; //indicate whether the user entered the time but its value is invalid
    /**
     * Essential attributes of the program, which will be used by other classes
     */
    private short date;
    private short month;
    private short year;
    private short hour;
    private short minute;
    private String description;

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