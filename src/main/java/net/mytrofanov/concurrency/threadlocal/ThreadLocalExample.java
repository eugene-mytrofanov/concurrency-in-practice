package net.mytrofanov.concurrency.threadlocal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collections;

public class ThreadLocalExample {

    private static final String DB_URL = "DB_URL";

    private static ThreadLocal<Connection> threadLocalConnectionHolder = ThreadLocal.withInitial(() -> {
        try {
            return DriverManager.getConnection(DB_URL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    });

    private static Connection getConnection() {
        ThreadLocal<Object> objectThreadLocal = new ThreadLocal<>();
        return threadLocalConnectionHolder.get();
    }
}
