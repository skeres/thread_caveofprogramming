package com.sks.BlockSynchronizedUsingLockObjects_4;

public class RunningAll {

    public static void main(String[] args) {
        System.out.println("Synchronized Objects: ");
        WorkerBlocksSynchronized workerBlocksSynchronized = new WorkerBlocksSynchronized();
        workerBlocksSynchronized.main();
        System.out.println("Synchronized Methods: ");
        WorkerMethodsSynchronized worker2 = new WorkerMethodsSynchronized();
        worker2.main();
    }
}
