package com.solution.goncharova;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MySaver implements Saver {
    /**
     * Overrided method saves line/text
     * @param text  - text to write to file
     * @param fileAbsolutePath - absolute path to file text will be saved to
     * @throws IOException
     */
    @Override
    public void save(String text, String fileAbsolutePath) throws IOException {
        File file = new File(fileAbsolutePath);

        if (!file.exists()) {
            file.createNewFile();
        } else {
            throw new IOException();
        }
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(text);
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}

