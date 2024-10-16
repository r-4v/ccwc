package com.project1.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Optional;

public class FileDataStreamReader implements InputDataStreamReader {
    List<String> fileNames;

    @Override
    public Optional<BufferedReader> getReader() {

        File file;
        try {
            file = new File(fileNames.get(0));
            if (!file.exists()) {
                throw new FileNotFoundException("File" + fileNames.get(0) + "not found");
            }

            return Optional.of(new BufferedReader(new FileReader(file)));
        } catch (FileNotFoundException fne) {
            System.out.println(fne.getMessage());
            java.lang.System.exit(1);
        }
        return Optional.empty();
    }

    public void setFileNames(List<String> fileNames) {
        this.fileNames = fileNames;
    }

}
