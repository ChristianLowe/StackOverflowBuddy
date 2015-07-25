package com.grognak.sobuddy.commands;

import com.grognak.sobuddy.app.QueryTerminal;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Set;

import static org.junit.Assert.*;

public class QuitCommandTest {
    QueryTerminal queryTerminal;
    QuitCommand quitCommand;

    @Before
    public void setUp() throws Exception {
        queryTerminal = new QueryTerminal();
        quitCommand = new QuitCommand(queryTerminal);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testHasAliases() {
        ArrayList<String> aliases = quitCommand.getAliases();

        assertNotNull(aliases);
        assertTrue(aliases.size() > 0);
    }

    @Test
    public void testHasName() {
        String name = quitCommand.getName();

        assertNotNull(name);
        assertEquals("quit", name);
    }

    @Test
    public void testHasUsage() {
        String usage = quitCommand.getUsage();

        assertNotNull(usage);
        assertTrue(usage.length() > 0);
        assertTrue(usage.contains("%s"));
    }

    @Test
    public void testHasDescription() {
        String description = quitCommand.getDescription();

        assertNotNull(description);
        assertTrue(description.length() > 0);
    }

    @Test(expected = RuntimeException.class)
    public void testQuit() {
        quitCommand.executeAndGetOutput("quit");
    }
}