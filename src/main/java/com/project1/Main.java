package com.project1;


import com.project1.arguments.ArgumentParser;
import com.project1.arguments.ArgumentSource;
import com.project1.arguments.CLIArgumentParser;
import com.project1.arguments.CLIArgumentSource;
import com.project1.output.CountsLogger;
import com.project1.reader.InputDataStreamModeSwitch;

public class Main {
    public static void main(String[] args) {
        CountsLogger countsLogger = new CountsLogger();
        ArgumentSource cliArgumentSource = new CLIArgumentSource(args);
        ArgumentParser cliArgumentParser = new CLIArgumentParser();
        countsLogger.setup(cliArgumentSource, cliArgumentParser);
        InputDataStreamModeSwitch inputDataStreamModeSwitch = new InputDataStreamModeSwitch();
        String dataMode = inputDataStreamModeSwitch.determineStreamMode(cliArgumentParser);

        countsLogger.display(dataMode);
        // handle the case where there are no files and no input stream

    }
}