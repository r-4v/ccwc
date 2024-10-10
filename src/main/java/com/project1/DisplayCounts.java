package com.project1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class DisplayCounts {

    public void display(String[] args) throws FileNotFoundException {

        ArgumentParser argumentParser = new ArgumentParser();
        argumentParser.parseInput(args);
        argumentParser.parseOptions();

        List<String> activeOptions = argumentParser.getActiveOptions();
        List<String> fileNames = argumentParser.getFiles();

        FileSizeCalculator fileSizeCalculator = new FileSizeCalculator();

        if (activeOptions.contains("c")) {
            try {
                long fileSize = fileSizeCalculator.calculateFileSize(fileNames.get(0));
                System.out.println("File size is: " + fileSize);
            } catch (FileNotFoundException e) {
                throw new FileNotFoundException();
            }
        }


        if (activeOptions.contains("w") || activeOptions.contains("l")) {
            WordLineCountCalculator wordLineCountCalculator = new WordLineCountCalculator();
            try {
                wordLineCountCalculator.calculateLinesAndWords(fileNames.get(0));
            } catch (
                    IOException e) {
                throw new RuntimeException(e);
            }


            if (activeOptions.contains("w")) {
                System.out.println("Word count is: " + wordLineCountCalculator.getWordCount());

            }

            if (activeOptions.contains("l")) {
                System.out.println("Line count is: " + wordLineCountCalculator.getLineCount());
            }


        }

    }

}
