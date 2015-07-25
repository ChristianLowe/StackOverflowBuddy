package com.grognak.sobuddy.app;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class QueryTerminalTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testStartLoop() throws Exception {
        // pass
    }

    @Test
    public void testValidCommandSearch() throws Exception {
        QueryTerminal queryTerminal = new QueryTerminal();
        assertNotNull(queryTerminal.commandSearch("help"));
        assertNotNull(queryTerminal.commandSearch("commands"));
    }

    @Test(expected = NoSuchElementException.class)
    public void testBadCommandSearch() throws Exception {
        QueryTerminal queryTerminal = new QueryTerminal();
        queryTerminal.commandSearch("asdf");
    }
}