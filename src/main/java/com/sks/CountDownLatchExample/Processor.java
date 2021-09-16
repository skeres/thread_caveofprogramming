package com.sks.CountDownLatchExample;

import java.util.concurrent.CountDownLatch;

class Processor implements Runnable {

    private CountDownLatch latch;   // note : no need to synchronized, CountDownlatch is already thread safe !

    public Processor(CountDownLatch latch) {
        this.latch = latch;
    }

    public void run() {
        System.out.println("Started.");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException ignored) {}


        latch.countDown(); //counting down !
    }
}