package com.project1.calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class WordLineByteCharacterCountCalculator implements FileMetaDataCalculator {
    private long wordCount = 0;
    private long lineCount = 0;
    private long characterCount = 0;
    private long byteCount = 0;

    public long getByteCount() {
        return byteCount;
    }

    public long getWordCount() {
        return wordCount;
    }

    public long getLineCount() {
        return lineCount;
    }

    public long getCharacterCount() {
        return characterCount;
    }

    public boolean isNotWhitespaceOrControl(char c) {
        return !Character.isWhitespace(c) && !Character.isISOControl(c);
    }

    @Override
    public void calculate(BufferedReader bufferedReader) {


        try {

            char lastChar = 'c';
            int currentChar;
            boolean lastWasWord = false;


            while ((currentChar = bufferedReader.read()) != -1) {

                characterCount++;

                String charAsString = String.valueOf((char) currentChar);
                byteCount += charAsString.getBytes(StandardCharsets.UTF_8).length;


                if (Character.isWhitespace((char) currentChar) && isNotWhitespaceOrControl(lastChar)) {
                    wordCount++;
                    lastWasWord = false;
                } else if (isNotWhitespaceOrControl((char) currentChar)) {
                    lastWasWord = true;
                }
                if ((char) currentChar == '\n' && (Character.isWhitespace(lastChar) || isNotWhitespaceOrControl(lastChar))) {
                    lineCount++;

                }


                lastChar = (char) currentChar;
            }
            if (lastWasWord) {
                wordCount++;
            }

        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
            System.exit(1);
        }

    }
}

