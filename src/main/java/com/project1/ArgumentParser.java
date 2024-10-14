package com.project1;

import java.util.List;

public interface ArgumentParser {
    public void parse(ArgumentSource argumentSource);

    public List<String> getFiles();

    public List<String> getActiveOptions();
}
