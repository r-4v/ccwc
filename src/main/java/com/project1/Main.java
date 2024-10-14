package com.project1;

public class Main {
    public static void main(String[] args) {
        CountsLogger countsLogger = new CountsLogger();
        ArgumentSource cliArgumentSource = new CLIArgumentSource(args);
        ArgumentParser cliArgumentParser = new CLIArgumentParser();
        countsLogger.display(cliArgumentSource, cliArgumentParser);

    }
}