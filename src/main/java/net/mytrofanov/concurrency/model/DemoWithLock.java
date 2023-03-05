package net.mytrofanov.concurrency.model;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DemoWithLock {

    public static void main(String[] args) {
        final Lock lock = new ReentrantLock(true);

        Thread threadOne = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                lock.lock();
                printThreadName();
                lock.unlock();
            }
        }, "1st");

        Thread threadTwo = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                lock.lock();
                printThreadName();
                lock.unlock();
            }
        }, "2nd");

        threadOne.start();
        threadTwo.start();
    }

    private static void printThreadName() {
        System.out.println("Hello this is " + Thread.currentThread().getName() + " thread");
    }
}
