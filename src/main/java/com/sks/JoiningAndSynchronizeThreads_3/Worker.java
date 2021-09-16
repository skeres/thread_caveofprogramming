package com.sks.JoiningAndSynchronizeThreads_3;

/**
 * Cette classe illustre plusieurs choses :
 *
 * - instruction join apliquée à thread1 : demande au thread courant
 * d'attendre la fin du thread1 avant de poursuivre
 * Dans cet exemple, si absence de join, alors System.out.println("Count is: " + count)
 * affiche ZERO !
 *
 * - synchronized : pause un verrou par jeton sur une méthode; un seul thread
 * à la fois peut executer la méthode.
 * Sans x, count++ ne marche pas bien => equivalent à count=count+1; qui n'est PAS
 * une opération atomique ! Entre le moment ou count est pris, additioné et réaffecté
 * à lui me,l peut se passer beaucoup de chose dans l'autre thread ...
 *
 */
public class Worker {

    private int count = 0;

    public static void main(String[] args) {
        Worker worker = new Worker();
        worker.doWork();
    }

    /**
     * Run code again by removing the synchronized and join keywords By removing
     * synchronized keyword count variable will vary that is it is not atomic in
     * this case due to the reason that count is shared between the threads or
     * without join keyword count will output wrong.
     */
    public synchronized void increment(String threadName) throws InterruptedException {
        count++;
        //Thread.sleep(1000);
        System.out.println("Thread in Progress: " + threadName + " and count is: " + count);
    }

    public void doWork() {
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    try {
                        increment(Thread.currentThread().getName());
                    } catch (InterruptedException ex) {
                        System.out.println("Thread1 "+ex.getMessage());
                    }
                }
            }
        });
        thread1.start();
        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    try {
                        increment(Thread.currentThread().getName());
                    } catch (InterruptedException ex) {
                        System.out.println("Thread 2 "+ex.getMessage());
                    }
                }
            }
        });
        thread2.start();

        /**
         * Join Threads: Finish until thread finishes execution, then progress
         * the code Reminder: your method is also a thread so without joining
         * threads System.out.println("Count is: " + count); will work
         * immediately. Join does not terminate Thread 2, just progress of the
         * code stops until Threads terminate.
         */
        try {
            thread1.join();     //pause current thread and wait that thread1 has finished
            System.out.println("join on t1");
            thread2.join();     //same as above
            System.out.println("join on t2");
        } catch (InterruptedException ignored) {}

        System.out.println("Count is: " + count);
    }
}