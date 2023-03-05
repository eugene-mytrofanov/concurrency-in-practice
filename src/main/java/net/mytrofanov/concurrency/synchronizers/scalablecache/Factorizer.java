package net.mytrofanov.concurrency.synchronizers.scalablecache;

import javax.servlet.*;
import java.io.IOException;
import java.math.BigInteger;

public class Factorizer implements Servlet {
    private final Computable<BigInteger, BigInteger[]> c = new Computable<BigInteger, BigInteger[]>() {
        @Override
        public BigInteger[] compute(BigInteger arg) throws InterruptedException {
            return new BigInteger[0];
        }
    };

    private final Computable<BigInteger, BigInteger[]> cache = new Memoizer<>(c);

    @Override
    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
        try {
            BigInteger i = extractFromRequest(req);
            encodeIntoResponse(resp, cache.compute(i));
        } catch (InterruptedException e) {
            encodeError(resp, "factorization interrupted");
        }
    }

    private BigInteger extractFromRequest(ServletRequest req) {
        return null;
    }

    private void encodeIntoResponse(ServletResponse resp, BigInteger[] integers) {
        return;
    }

    private void encodeError(ServletResponse resp, String str) {
        return;
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        // TBD
    }

    @Override
    public ServletConfig getServletConfig() {
        // TBD
        return null;
    }

    @Override
    public String getServletInfo() {
        // TBD
        return null;
    }

    @Override
    public void destroy() {
        // TBD
    }
}
