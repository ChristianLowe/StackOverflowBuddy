package com.grognak.sobuddy.commands;

import com.grognak.sobuddy.app.QueryTerminal;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Set;

public class HelpCommand extends BaseCommand {
    private String ERROR_NOT_FOUND = "Unknown or invalid command '%s'.";

    public HelpCommand(QueryTerminal queryTerminal) {
        this.queryTerminal = queryTerminal;

        aliases = new ArrayList<String>();
        aliases.add("help");
        aliases.add("commands");
        aliases.add("?");

        name = "help";
        usage = "%s <command>";
        description = "Gives a description of the given command.";
    }

    @Override
    public String executeAndGetOutput(String[] parameters) {
        String output;

        if (parameters.length < 2) {
            output = getCommandListOutput();
        } else {
            output = getHelpOutput(parameters[1].toLowerCase());
        }
        return output;
    }

    private String getCommandListOutput() {
        String commandsOutput = "Commands list: ";
        Set<BaseCommand> commands = queryTerminal.getCommandList();
        for (BaseCommand command : commands) {
            commandsOutput += command.getName() + ", ";
        }
        return getTrimmedCommandsOutput(commandsOutput);
    }

    private String getTrimmedCommandsOutput(String commandsOutput) {
        int outputTrimmedSize = commandsOutput.length() - 2;
        commandsOutput = commandsOutput.substring(0, outputTrimmedSize);
        return commandsOutput;
    }

    private String getHelpOutput(String commandToLookup) {
        String helpOutput;

        try {
            helpOutput = getHelpResult(commandToLookup);
        } catch (NoSuchElementException e) {
            helpOutput = String.format(ERROR_NOT_FOUND, commandToLookup);
        }
        return helpOutput;
    }

    private String getHelpResult(String commandToLookup) throws NoSuchElementException {
        BaseCommand command;
        command = queryTerminal.commandSearch(commandToLookup);
        String helpResult = String.format("Usage: " + command.getUsage(), commandToLookup) + "\n";
        helpResult += command.getDescription();
        return helpResult;
    }

}
