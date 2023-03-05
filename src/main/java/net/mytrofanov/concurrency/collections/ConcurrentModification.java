package net.mytrofanov.concurrency.collections;

import apple.laf.JRSUIConstants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConcurrentModification {
    List<JRSUIConstants.Widget> widgets = Collections.synchronizedList(new ArrayList<>());

    // May throw ConcurrentModificationException if other thread modifies widgets
    public void demo() throws InterruptedException {
        for (JRSUIConstants.Widget w : widgets) {
            doSomething();
            Object obj = new Object();
            obj.wait();
        }
    }

    private void doSomething() {

    }
}
