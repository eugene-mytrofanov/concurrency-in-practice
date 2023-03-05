package net.mytrofanov.concurrency.synchronizers.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Preloader {
    private final FutureTask<ProductInfo> future = new FutureTask<ProductInfo>(
            new Callable<ProductInfo>() {
                @Override
                public ProductInfo call() throws DataLoadException {
                    return loadProductInfo();
                }
            }
    );
    private final Thread thread = new Thread(future);

    public void start() {
        thread.start();
        future.isDone();
    }

    public ProductInfo get() throws DataLoadException, InterruptedException {
        try {
            return future.get();
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause instanceof DataLoadException)
                throw (DataLoadException) cause;
            else
                throw launderThrowable(cause);
        }
    }

    private ProductInfo loadProductInfo() {
        // TBD Implementation logic
        return null;
    }

    private static RuntimeException launderThrowable(Throwable t) {
        if (t instanceof RuntimeException)
            return (RuntimeException) t;
        else if (t instanceof Error)
            throw (Error) t;
        else
            throw new IllegalArgumentException("Not unchecked", t);
    }

}
