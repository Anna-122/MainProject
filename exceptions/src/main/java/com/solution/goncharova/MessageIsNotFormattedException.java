package com.solution.goncharova;

public class MessageIsNotFormattedException extends Exception{

    public MessageIsNotFormattedException( String s ) {
        System.out.println("Warning!");
    }
}

