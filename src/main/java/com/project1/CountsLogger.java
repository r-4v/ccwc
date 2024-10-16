package com.project1;

import java.io.BufferedReader;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class CountsLogger {


    List<String> activeOptions;
    List<String> fileNames;

    void setup(ArgumentSource argumentSource, ArgumentParser argumentParser) {
        argumentParser.parse(argumentSource);
        this.activeOptions = argumentParser.getActiveOptions();
        this.fileNames = argumentParser.getFiles();
    }

    Optional<BufferedReader> getInputAppropriateReader(String datamode) {
        if (Objects.equals(datamode, "file")) {
            FileDataStreamReader fileDataStreamReader = new FileDataStreamReader();
            fileDataStreamReader.setFileNames(this.fileNames);
            return fileDataStreamReader.getReader();
        }


        return new StandardInputDataStreamReader().getReader();
    }


    void display(String dataMode) {


        Optional<BufferedReader> optionalBufferedReader = this.getInputAppropriateReader(dataMode);

        if (optionalBufferedReader.isEmpty()) {
            System.out.println("No input data found");
            System.exit(1);
        }
        BufferedReader bufferedReader = optionalBufferedReader.get();

        WordLineByteCharacterCountCalculator wordLineByteCharacterCountCalculator = new WordLineByteCharacterCountCalculator();


        wordLineByteCharacterCountCalculator.calculate(bufferedReader);

        System.out.println();
        if (activeOptions.contains("c")) {

            System.out.println("Byte Count is: " + wordLineByteCharacterCountCalculator.getByteCount());
        }

        if (activeOptions.contains("w")) {
            System.out.println("Word count is: " + wordLineByteCharacterCountCalculator.getWordCount());

        }

        if (activeOptions.contains("l")) {
            System.out.println("Line count is: " + wordLineByteCharacterCountCalculator.getLineCount());

        }

        if (activeOptions.contains("m")) {
            System.out.println("Character count is: " + wordLineByteCharacterCountCalculator.getCharacterCount());
        }


    }

}
