package com.project1;

import java.util.List;

public class InputDataStreamModeSwitch {

    public String determineStreamMode(ArgumentParser argumentParser) {
        List<String> files = argumentParser.getFiles();
        if (files.isEmpty()) {
            System.out.println("No files detected, switching to standard input mode");
            return "stdinput";
        }
        return "file";
    }
}
