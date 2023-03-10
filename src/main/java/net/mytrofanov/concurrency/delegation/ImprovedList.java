/*
package net.mytrofanov.delegation;


import java.util.List;

public class ImprovedList<T> extends List<T> {
//    @GuardedBy
    private final List<T> list;

    public ImprovedList(List<T> list) {
        this.list = list;
    }

    public synchronized boolean putIfAbsent(T x) {
        boolean contains = list.contains(x);
        if (contains)
            list.add(x);
        return !contains;
    }

    public synchronized void clear() {
        list.clear();
    }
    // similarly delegate other List methods
}
*/
