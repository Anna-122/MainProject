package com.solution.goncharova;

import java.io.IOException;

public class MySimpleLogger implements OneMessageFileLogger {

    public String fileAbsolutePath;

    private Saver mySaver;

    public MySimpleLogger( String absoluteFilePath, Saver fileSaver ) {
    }

    /**
     * Creates a MySimpleLogger default constructor
     */
    public void MySimpleLogger() {
    }

    /**
     * Creates a MySimpleLogger with the specified characteristics
     * @param newAbsolutePath a string representing the absolute path to the file to be used for writing
     * @param newSaver the line / text that will be saved
     *
     */
    public void MySimpleLogger( String newAbsolutePath, Saver newSaver) {
        fileAbsolutePath = newAbsolutePath;
        mySaver = newSaver;
    }

    /**
     * Overrided method checks if message starts "MESSAGE: "- saving in file if not - MessageIsNotFormattedException
     *
     * @param message represents input value
     * @throws IOException
     * @throws MessageIsNotFormattedException
     */
    @Override
    public void log (String message) throws IOException, MessageIsNotFormattedException {

        if (!message.startsWith(MESSAGE_STARTS_WITH)) {
            throw new MessageIsNotFormattedException("MessageIsNotFormattedException - " + message);
        } else {
            mySaver.save(message, fileAbsolutePath);
        }
    }
}


