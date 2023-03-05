package net.mytrofanov.concurrency.synchronizers.latch;

import java.util.concurrent.CountDownLatch;

public class TestHarness {

    public long timeTasks(int nThreads, final Runnable task) throws InterruptedException {
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(nThreads);

        for (int i = 0; i < nThreads; i++) {
            Thread t = new Thread() {
                @Override
                public void run() {
                    try {
                        startGate.await();
                        System.out.println("startGate " + startGate.getCount());
                        try {
                            task.run();
                        } finally {
                            endGate.countDown();
                            System.out.println("endGate count: " + endGate.getCount());
                        }
                    } catch (InterruptedException ignored) {
                    }
                }
            };
            t.start();
            t.run();
            System.out.println("The thread is started " + t.getName());
        }

        long start = System.nanoTime();
        startGate.countDown();
        endGate.await();
        long end = System.nanoTime();
        return end - start;
    }
}
