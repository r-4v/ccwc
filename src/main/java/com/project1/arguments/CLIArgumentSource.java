package com.project1.arguments;

public class CLIArgumentSource implements ArgumentSource {

    private final String[] args;

    public CLIArgumentSource(String[] args) {
        this.args = args;
    }

    @Override
    public String[] getArguments() {
        return this.args;
    }
}
