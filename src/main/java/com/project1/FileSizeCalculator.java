package com.project1;

import java.io.File;
import java.io.FileNotFoundException;

public class FileSizeCalculator {
    private long fileSize;

    public long calculateFileSize(String pathToFile) throws FileNotFoundException {
        File file = new File(pathToFile);
        if (!file.exists()) {
            throw new FileNotFoundException("File " + pathToFile + " not found");
        }
        this.fileSize = file.length();
        return this.fileSize;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }
}
