package com.project1;


public class Main {
    public static void main(String[] args) {
        CountsLogger countsLogger = new CountsLogger();
        ArgumentSource cliArgumentSource = new CLIArgumentSource(args);
        ArgumentParser cliArgumentParser = new CLIArgumentParser();
        countsLogger.setup(cliArgumentSource, cliArgumentParser);
        InputDataStreamModeSwitch inputDataStreamModeSwitch = new InputDataStreamModeSwitch();
        String datamode = inputDataStreamModeSwitch.determineStreamMode(cliArgumentParser);

        countsLogger.display(datamode);
        // handle the case where there are no files and no input stream

    }
}