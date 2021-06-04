package com.solution.goncharova;

import java.io.IOException;

interface OneMessageFileLogger {
    String MESSAGE_STARTS_WITH = "MESSAGE: ";
    void log( String message ) throws Exception;
}
