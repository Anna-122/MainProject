package com.solution.goncharova;

import org.apache.logging.log4j.LogManager;

public class Factory extends Thread {

    /**
     * org.apache.logging.log4j.Logger
     */
    private static final org.apache.logging.log4j.Logger LOG4j2 = LogManager.getLogger(Factory.class);

    private Object computer;

    /**
     * Creates a Factory with the specified characteristics
     * @param computer - object
     *
     */

    public Factory( Object computer ) {
        this.computer = computer;
    }

    /**
     * Creates a MyCollection - empty constructor
     *
     */
    public Factory() {
    }

    /**
     * Creates a getComputer - methods which returns two objects
     *
     * @return computer
     */
    public Object getComputer() {
        return computer = +2;
    }

    /**
     * Overrided method adds three computers each 5 seconds
     *
     *@throws InterruptedException
     */
    @Override
    public  void run(){
        try {
            this.computer = + 3;
            Thread.sleep(5000);
            LOG4j2.info("added three computers ");
        } catch (InterruptedException e) {
            LOG4j2.info("Thread was interrupted");
        }
        interrupt();
    }
}




