package net.mytrofanov.awt;

public abstract class AbstractParent<T> {
    private final T port;

    public AbstractParent(T port) {
        this.port = port;
    }

    public T getPort() {
        return this.port;
    }
}
