package com.project1;

import java.io.*;

public class WordLineCountCalculator {
    private long wordCount = 0;
    private long lineCount = 0;

    public long getWordCount() {
        return wordCount;
    }

    public long getLineCount() {
        return lineCount;
    }

    public boolean isNotWhitespaceOrControl(char c) {
        return !Character.isWhitespace(c) && !Character.isISOControl(c);
    }


    public void calculateLinesAndWords(String pathToFile) throws IOException {
        File file = new File(pathToFile);
        if (!file.exists()) {
            throw new FileNotFoundException("File " + pathToFile + " not found");
        }

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        char lastChar = 'c';
        int currentChar;
        long tempWordCount = 0;

        while ((currentChar = bufferedReader.read()) != -1) {

            /*

             if current char is a letter and last char is a letter move on
             if current char is a letter and last char is a whitespace move on
             if current char is a letter and last char is a linebreak move on
             if current char is a white space and last char is a white space move on
             if current char is a white space and last char is a line break move on
             if current char is a white space and last char is a letter increase temp count
             if current char is a line break and last char is a space increase line count and add temp count to word count
             if current char is a line break and last char is a line break increase line count but don't re add temp word count
             if current char is a line break and last char is a letter increase line count and add temp word count

             */


            if (Character.isWhitespace((char) currentChar) && isNotWhitespaceOrControl(lastChar)) {
                tempWordCount++;
            }
            if ((char) currentChar == '\n' && (Character.isWhitespace(lastChar) || isNotWhitespaceOrControl(lastChar))) {
                lineCount++;
                wordCount += tempWordCount;
                tempWordCount = 0;
            }

            if ((char) currentChar == '\n' && lastChar == '\n') {
                lineCount++;
            }
            lastChar = (char) currentChar;

        }

    }
}

