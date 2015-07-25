package com.grognak.sobuddy.commands;

import java.util.ArrayList;

public interface Command {
    ArrayList<String> getAliases();
    String getName();
    String getUsage();
    String getDescription();
    String executeAndGetOutput(String[] parameters);
}
