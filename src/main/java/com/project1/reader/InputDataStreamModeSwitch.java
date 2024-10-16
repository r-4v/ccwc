package com.project1.reader;

import com.project1.arguments.ArgumentParser;

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
