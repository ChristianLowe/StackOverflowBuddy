package com.grognak.sobuddy.commands;

import com.grognak.sobuddy.app.QueryTerminal;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Set;

import static org.junit.Assert.*;

public class HelpCommandTest {
    QueryTerminal queryTerminal;
    HelpCommand helpCommand;

    @Before
    public void setUp() throws Exception {
        queryTerminal = new QueryTerminal();
        helpCommand = new HelpCommand(queryTerminal);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testHasAliases() {
        ArrayList<String> aliases = helpCommand.getAliases();

        assertNotNull(aliases);
        assertTrue(aliases.size() > 0);
    }

    @Test
    public void testHasName() {
        String name = helpCommand.getName();

        assertNotNull(name);
        assertEquals("help", name);
    }

    @Test
    public void testHasUsage() {
        String usage = helpCommand.getUsage();

        assertNotNull(usage);
        assertTrue(usage.length() > 0);
        assertTrue(usage.indexOf("%s") > -1);
    }

    @Test
    public void testHasDescription() {
        String description = helpCommand.getDescription();

        assertNotNull(description);
        assertTrue(description.length() > 0);
    }

    @Test
    public void testHelpForNoCommand() {
        String generatedOutput = helpCommand.executeAndGetOutput("help");
        assertTrue(generatedOutput.contains("Commands list: "));
        assertTrue(generatedOutput.contains("help"));
    }

    @Test
    public void testHelpForInvalidCommand() {
        String generatedOutput = helpCommand.executeAndGetOutput("help asdf");
        String expectedOutput = "Unknown or invalid command 'asdf'.";
        assertTrue(generatedOutput.equals(expectedOutput));
    }

    @Test
    public void testHelpForCommand() {
        String generatedOutput= helpCommand.executeAndGetOutput("help help");
        String expectedOutput = String.format("Usage: help <command>\n%s", helpCommand.getDescription());
        assertTrue(generatedOutput.equals(expectedOutput));
    }
}