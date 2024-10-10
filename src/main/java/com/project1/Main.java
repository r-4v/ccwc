package com.project1;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        DisplayCounts displayCounts = new DisplayCounts();
        try {
            displayCounts.display(args);
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        }
    }

}