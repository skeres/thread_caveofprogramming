package com.sks.ExecutorServiceThreadPools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


/**
 * source documentation : https://www.baeldung.com/java-executor-service-tutorial
 * - The easiest way to create ExecutorService is to use one of the factory methods of the Executors static class.
 * - There are several other factory methods to create a predefined ExecutorService that meets specific use cases. To
 * find the best method for your needs, consult Oracle's official documentation.
 * - ExecutorService is an interface, an instance of any its implementations can be used. There are several
 * implementations to choose from in the java.util.concurrent package, or you can create your own.7
 * - ExecutorService can execute Runnable and Callable tasks.
 * We can assign tasks to the ExecutorService using several methods including execute(), which is
 * inherited from the Executor interface, and also submit(), invokeAny() and invokeAll().
 *
 *
 *
 *
 */
public class Worker {

    public static void main(String[] args) {
        /**
         * Created 2 threads, and assign tasks (Processor(i).run) to the threads
         */
        ExecutorService executor = Executors.newFixedThreadPool(2);//2 Threads
        for (int i = 0; i < 5; i++) { // call the (Processor(i).run) 2 times with 2 threads
            executor.submit(new Processor(i));
        }
        executor.shutdown(); //prevents new tasks from being accepted by the ExecutorService

        System.out.println("All tasks submitted.");
        try {
            executor.awaitTermination(1, TimeUnit.DAYS);  // Oh my god, 1 day !
        } catch (InterruptedException ignored) {
        }
        System.out.println("All tasks completed.");
    }
}
