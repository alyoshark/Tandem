package w10j1.tandem.usercommand;

import w10j1.tandem.commandparser.CommandParserImpl;
import w10j1.tandem.commandparser.api.CommandParser;
import w10j1.tandem.commandprocessor.CommandProcessorImpl;
import w10j1.tandem.commandprocessor.api.CommandProcessor;
import w10j1.tandem.task.TaskImpl;

/**
 *
 * @author Chris
 */
public class UserCommand {

    public static CommandParser cpar = new CommandParserImpl();
    public static CommandProcessor cpro = new CommandProcessorImpl();
    public String request = "";
    public String command = "";
    private boolean isAfterSearch = false;

    public UserCommand(String input) {
        UserCommand.cpar.readRawInput(input);
        UserCommand.cpar.setRequest();
        this.request = UserCommand.cpar.getRequest();
        this.command = UserCommand.cpar.getCommand();
    }

    public void execute() {
        switch (this.request.charAt(0)) {
            case 'a':
                this.cpro.add(new TaskImpl(this.cpar.getDue(), this.command));
                break;
            case 's':
                this.cpro.search(this.command);
                break;
            case 'u':
                this.cpro.undo();
                break;
            case 'e':
            case 'r':
            case 'd':
                if (isAfterSearch) {
                    if (this.request.charAt(0) == 'e') {
                        this.cpro.edit(this.command);
                    } else if (this.request.charAt(0) == 'r') {
                        this.cpro.remove(this.command);
                    } else if (this.request.charAt(0) == 'd') {
                        this.cpro.setDone(this.command);
                    }
                } else {
                    // System.out.println("Please perform a search first: s {keywords/date}");
                    // Should be printed in the GUI not the console...
                }
                break;
            default:
                // Print an error message in the GUI.
                // May be done by throwing an exception.
        }
    }
}