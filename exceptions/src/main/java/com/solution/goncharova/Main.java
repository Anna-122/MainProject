/*
 * Main
 *
 * Version 1.1
 *
 * Copyright 2020. Anna Goncharova. GPL
 *
 */
package com.solution.goncharova;

import java.io.IOException;

/**
 * Class {@code Main}
 * Was created for saving message in file
 * @author Goncharova Anna
 * @version 1.1
 */
public class Main {
    public static void main( String[] args ) throws IOException {
        String message = "MESSAGE: message_body";
        MySaver mySimpleLogger1 = new MySaver();
        mySimpleLogger1.save( message,"/home/anna/Документы/CheckFile.txt");
    }
}

