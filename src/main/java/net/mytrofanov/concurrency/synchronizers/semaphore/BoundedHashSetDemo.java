package net.mytrofanov.concurrency.synchronizers.semaphore;

public class BoundedHashSetDemo {
    public static void main(String[] args) throws InterruptedException {
        BoundedHashSet boundedHashSet = new BoundedHashSet<String>(5);
        boundedHashSet.add("first");
        System.out.println("Available permits " + boundedHashSet.availablePermits());
        boundedHashSet.add("second");
        boundedHashSet.add("third");
        boundedHashSet.add("fourth");
        boundedHashSet.add("fifth");
        System.out.println("Available permits " + boundedHashSet.availablePermits());

        String name = Thread.currentThread().getName();
        System.out.println("The thread " + name + " has a state: " + Thread.currentThread().getState());
        //        boundedHashSet.remove("fifth");
        boundedHashSet.add("sixth");
        System.out.println("The size of set is " + boundedHashSet.size());
    }
}
