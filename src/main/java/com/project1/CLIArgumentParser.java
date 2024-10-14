package com.project1;

import java.util.ArrayList;
import java.util.List;

public class CLIArgumentParser implements ArgumentParser {

    private final List<String> options = new ArrayList<String>();
    private final List<String> files = new ArrayList<String>();
    private final List<String> activeOptions = new ArrayList<String>();

    @Override
    public List<String> getFiles() {
        return files;
    }

    @Override
    public List<String> getActiveOptions() {
        return activeOptions;
    }


    @Override
    public void parse(ArgumentSource argumentSource) {
        parseInput(argumentSource.getArguments());
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
