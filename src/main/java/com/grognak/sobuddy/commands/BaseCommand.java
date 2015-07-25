package com.grognak.sobuddy.commands;

import com.grognak.sobuddy.app.QueryTerminal;

import java.util.ArrayList;

public class BaseCommand implements Command {
    protected QueryTerminal queryTerminal;
    protected ArrayList<String> aliases;
    protected String name;
    protected String usage;
    protected String description;

    public String getName() {
        return name;
    }

    public ArrayList<String> getAliases() {
        return aliases;
    }

    public String getUsage() {
        return usage;
    }

    public String getDescription() {
        return description;
    }

    public String executeAndGetOutput(String parameters) {
        return this.executeAndGetOutput(parameters.split("\\s+"));
    }

    public String executeAndGetOutput(String[] parameters) {
        return "";
    }
}
