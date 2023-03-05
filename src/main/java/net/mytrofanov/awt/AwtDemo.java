package net.mytrofanov.awt;

import net.mytrofanov.awt.child.Child;

public class AwtDemo {
    public static void main(String[] args) {
//        TestFieldExample demo = new TestFieldExample();
        AwtEmployeeExample demo1 = new AwtEmployeeExample();
        Child child = new Child(8080);
        child.getPort();
        AbstractParent childPackage = new ChildPackage(8080.80);
        childPackage.getPort();
    }
}
