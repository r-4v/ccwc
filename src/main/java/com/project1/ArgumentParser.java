package com.project1;

import java.util.ArrayList;
import java.util.List;


public class ArgumentParser {
    private final List<String> options = new ArrayList<String>();
    private final List<String> files = new ArrayList<String>();
    private final List<String> activeOptions = new ArrayList<String>();

    public List<String> getFiles() {
        return files;
    }

    public List<String> getActiveOptions() {
        return activeOptions;
    }

    public void parse(String[] args) {
        parseInput(args);
        parseOptions();
    }

    public void parseInput(String[] args) {

        for (String arg : args) {
            if (arg.startsWith("-")) {
                options.add(arg);
            } else {
                files.add(arg);
            }

        }

    }

    public void parseOptions() {
        for (String option : options) {
            int optionLength = option.length();
            while (optionLength > 1) {
                String currentOption = option.substring(optionLength - 1, optionLength);
                if (!currentOption.equals("c") && !currentOption.equals("l") && !currentOption.equals("w")) {
                    throw new IllegalArgumentException("Invalid option: " + currentOption);
                }
                activeOptions.add(currentOption);
                optionLength -= 1;
            }
        }
        if (activeOptions.isEmpty()) {
            activeOptions.add("c");
            activeOptions.add("l");
            activeOptions.add("w");
        }

    }

}
