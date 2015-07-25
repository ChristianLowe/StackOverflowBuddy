package com.grognak.sobuddy.commands;

import com.grognak.sobuddy.app.QueryTerminal;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Set;

public class QuitCommand extends BaseCommand {
    private String ERROR_NOT_FOUND = "Unknown or invalid command '%s'.";

    public QuitCommand(QueryTerminal queryTerminal) {
        this.queryTerminal = queryTerminal;

        aliases = new ArrayList<String>();
        aliases.add("quit");
        aliases.add("exit");
        aliases.add("q");

        name = "quit";
        usage = "%s";
        description = "Exits the StackOverflowBuddy terminal.";
    }

    @Override
    public String executeAndGetOutput(String[] parameters) {
        throw new RuntimeException("User quit program");
    }
}
