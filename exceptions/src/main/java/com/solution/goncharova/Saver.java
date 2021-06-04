package com.solution.goncharova;

import java.io.IOException;

/**
 * Saves text to file
 */
public interface Saver {
    /**
     *
     * @param text - text to write to file
     * @param fileAbsolutePath - absolute path to file text will be saved to
     */
    void save(String text, String fileAbsolutePath) throws IOException;
}

