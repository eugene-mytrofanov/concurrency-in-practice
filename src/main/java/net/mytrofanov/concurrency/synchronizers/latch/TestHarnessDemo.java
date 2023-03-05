package net.mytrofanov.concurrency.synchronizers.latch;

public class TestHarnessDemo {
    public static void main(String[] args) throws InterruptedException {
        TestHarness th = new TestHarness();
        th.timeTasks(3, new Runnable() {
            @Override
            public void run() {
                System.out.println("Run is invoked in Runnable Task");
            }
        })
;    }
}
