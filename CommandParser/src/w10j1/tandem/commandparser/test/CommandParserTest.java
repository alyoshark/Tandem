/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package w10j1.tandem.commandparser.test;

import w10j1.tandem.commandparser.CommandParserImpl;
import w10j1.tandem.commandparser.api.CommandParser;

/**
 *
 * @author Chris
 */
public class CommandParserTest {
    public static void main(String[] args) {
        CommandParser cp = new CommandParserImpl();
        cp.readRawInput("submit dev guide to tutor by today");
        assert(cp.getRequest().compareTo("a") == 0);
        // more test cases will be done soon
    }
}
