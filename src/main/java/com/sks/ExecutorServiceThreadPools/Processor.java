package com.sks.ExecutorServiceThreadPools;

class Processor implements Runnable {

    private int id;

    public Processor(int id) {
        this.id = id;
    }

    public void run() {
        System.out.println("Starting: " + id);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ignored) {
        }
        System.out.println("Completed: " + id);
    }
}

