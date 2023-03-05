package net.mytrofanov.concurrency.model;

public class SequenceDemo {

    public static void main(String[] args) {
        Sequence sequence = new Sequence();
        Thread thread1 = new Thread(sequence, "1st thread");
        Thread thread2 = new Thread(sequence, "2nd thread");
        thread1.start();
        thread2.start();
    }

}
