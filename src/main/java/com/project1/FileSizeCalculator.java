package com.project1;

import java.io.File;
import java.io.FileNotFoundException;

public class FileSizeCalculator implements FileMetaDataCalculator {
    private long fileSize;

    @Override
    public void calculate(String pathToFile) {
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

    }


    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }
}
