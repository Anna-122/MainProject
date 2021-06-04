package com.solution.goncharova;

import org.apache.logging.log4j.LogManager;

public class Consumer extends Thread {
    private static final org.apache.logging.log4j.Logger LOG4j2 = LogManager.getLogger(Consumer.class);

    private Object consumer1;
    private Object consumer2;

    /**
     * Overrided method where consumers takes 2 computers for 7 seconds
     *
     *@throws InterruptedException
     */
    @Override
    public void run() {

        Factory factory = new Factory();
        try {
            this.consumer1 = factory.getComputer();
            Thread thread1 = new Thread();
            thread1.sleep(7000);
            LOG4j2.info(" first consumer took 2 computers for 7 sec");
            interrupt();
            this.consumer2 = factory.getComputer();
            Thread thread2 = new Thread();
            thread2.sleep(7000);
            LOG4j2.info("second consumer took 2 computers for 7 sec");
            interrupt();
        } catch (InterruptedException e) {
            LOG4j2.info("Thread was interrupted");
        }
    }
}
