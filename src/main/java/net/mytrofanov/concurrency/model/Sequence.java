package net.mytrofanov.concurrency.model;

import java.util.concurrent.atomic.AtomicLong;

public class Sequence implements Runnable {

    private int value;
    private AtomicLong testLong;

    @Override
    public void run() {
        printElements(5);
        testLong.getAndAdd(5L);
    }

    public int getNext() {
        return value++;
    }

    private synchronized void printElements(Integer count) {
        for (int i = 0; i < count; i++) {
            System.out.println("Thread: " + Thread.currentThread().getName() + " count: " + i + " next element: " + getNext());
        }
        reset();
    }

    private void reset() {
        value = 0;
    }
}
