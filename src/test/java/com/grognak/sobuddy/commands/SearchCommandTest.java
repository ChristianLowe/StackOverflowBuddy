package com.grognak.sobuddy.commands;

import com.grognak.sobuddy.app.QueryTerminal;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SearchCommandTest {
    QueryTerminal queryTerminal;
    SearchCommand searchCommand;

    @Before
    public void setUp() throws Exception {
        queryTerminal = new QueryTerminal();
        searchCommand = new SearchCommand(queryTerminal);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testHasAliases() {
        ArrayList<String> aliases = searchCommand.getAliases();

        assertNotNull(aliases);
        assertTrue(aliases.size() > 0);
    }

    @Test
    public void testHasName() {
        String name = searchCommand.getName();

        assertNotNull(name);
        assertEquals("search", name);
    }

    @Test
    public void testHasUsage() {
        String usage = searchCommand.getUsage();

        assertNotNull(usage);
        assertTrue(usage.length() > 0);
        assertTrue(usage.contains("%s"));
    }

    @Test
    public void testHasDescription() {
        String description = searchCommand.getDescription();

        assertNotNull(description);
        assertTrue(description.length() > 0);
    }

    @Test
    public void testSearchForNoCommand() {
        String generatedOutput = searchCommand.executeAndGetOutput("search");

        assertTrue(generatedOutput.contains(searchCommand.getName()));
        assertTrue(generatedOutput.contains(searchCommand.getDescription()));
    }

    @Ignore
    @Test
    public void testSearchForInvalidInput() {
        String generatedOutput = searchCommand.executeAndGetOutput("search invalid");
    }

    @Ignore
    @Test
    public void testSearchForGoodInput() {
        String generatedOutput = searchCommand.executeAndGetOutput("search valid");
    }
}