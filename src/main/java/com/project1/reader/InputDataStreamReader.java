package com.project1.reader;

import java.io.BufferedReader;
import java.util.Optional;

public interface InputDataStreamReader {
    public Optional<BufferedReader> getReader();
}
