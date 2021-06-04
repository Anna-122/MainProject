/*
 * Storage
 *
 * Version 1.1
 *
 * Copyright 2021. Anna Goncharova. GPL
 *
 */

package com.solution.goncharova;

/**
 * Class {@code Storage}
 * Was created to test methods realised by threads
 *
 * @author Anna Goncharova
 * @version 1.1
 */
public class Storage extends Thread {
    public static void main( String[] args ) {
        Factory factory1 = new Factory();
        Consumer consumer1 = new Consumer();
        for (int count = 0; count <= 20;count++) {
            synchronized (factory1) {
                factory1.run();
                if (count >= 9) {
                    consumer1.run();
                    factory1.interrupt();
                    consumer1.interrupt();
                }
            }
        }
    }
}


