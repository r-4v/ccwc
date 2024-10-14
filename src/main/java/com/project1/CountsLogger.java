package com.project1;

import java.util.List;

public class CountsLogger {

    public void display(ArgumentSource argumentSource, ArgumentParser argumentParser) {

        argumentParser.parse(argumentSource);

        List<String> activeOptions = argumentParser.getActiveOptions();
        List<String> fileNames = argumentParser.getFiles();

        FileSizeCalculator fileSizeCalculator = new FileSizeCalculator();

        if (activeOptions.contains("c")) {
            fileSizeCalculator.calculate(fileNames.get(0));
            long fileSize = fileSizeCalculator.getFileSize();
            System.out.println("File size is: " + fileSize);
        }


        if (activeOptions.contains("w") || activeOptions.contains("l")) {
            WordLineCountCalculator wordLineCountCalculator = new WordLineCountCalculator();

            wordLineCountCalculator.calculate(fileNames.get(0));


            if (activeOptions.contains("w")) {
                System.out.println("Word count is: " + wordLineCountCalculator.getWordCount());

            }

            if (activeOptions.contains("l")) {
                System.out.println("Line count is: " + wordLineCountCalculator.getLineCount());
            }


        }

    }
    
}
