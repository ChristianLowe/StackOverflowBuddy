package com.grognak.sobuddy.commands;

import com.grognak.sobuddy.app.QueryTerminal;

import java.util.ArrayList;

public class SearchCommand extends BaseCommand {
    public SearchCommand(QueryTerminal queryTerminal) {
        this.queryTerminal = queryTerminal;

        aliases = new ArrayList<String>();
        aliases.add("search");
        aliases.add("s");

        name = "search";
        usage = "%s <query>";
        description = "Runs a Stack Overflow search and returns first results.";
    }

    @Override
    public String executeAndGetOutput(String[] parameters) {
        if (parameters.length < 2) {
            HelpCommand helpCommand = new HelpCommand(queryTerminal);
            return helpCommand.executeAndGetOutput("help search");
        }

        return "";
    }
}
