package com.project1;

import java.io.File;
import java.io.FileNotFoundException;

public class FileSizeCalculator {
    private long fileSize;

    public long calculateFileSize(String pathToFile) {
        try {
            File file = new File(pathToFile);
            if (!file.exists()) {
                throw new FileNotFoundException("File " + pathToFile + " not found");
            }
            this.fileSize = file.length();

        } catch (FileNotFoundException fne) {
            System.out.println(fne.getMessage());
            java.lang.System.exit(1);
        }
        return this.fileSize;
    }


    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }
}
