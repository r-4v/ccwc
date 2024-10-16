package com.project1.reader;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Optional;

public class StandardInputDataStreamReader implements InputDataStreamReader {
    @Override
    public Optional<BufferedReader> getReader() {

        return Optional.of(new BufferedReader(new InputStreamReader(System.in)));
    }
}
