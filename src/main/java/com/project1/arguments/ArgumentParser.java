package com.project1.arguments;

import java.util.List;

public interface ArgumentParser {
    public void parse(ArgumentSource argumentSource);

    public List<String> getFiles();

    public List<String> getActiveOptions();
}
