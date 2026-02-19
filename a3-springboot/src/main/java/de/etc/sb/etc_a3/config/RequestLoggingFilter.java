//package de.etc.sb.etc_a3.config;
//
//public class RequestLoggerFilter {
//}


package de.etc.sb.etc_a3.config;

import de.etc.sb.etc_a3.util.DevLogger;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class RequestLoggingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        // 1. Log the incoming request using your DevLogger
        DevLogger.info(String.format(">>> INCOMING: %s %s from %s",
                req.getMethod(),
                req.getRequestURI(),
                req.getRemoteAddr()));

        long startTime = System.currentTimeMillis();

        try {
            // 2. Continue with the request
            chain.doFilter(request, response);
        } finally {
            // 3. Log the completion and the status code
            long duration = System.currentTimeMillis() - startTime;
            DevLogger.info(String.format("<<< OUTGOING: %s %s | Status: %d | Time: %dms",
                    req.getMethod(),
                    req.getRequestURI(),
                    res.getStatus(),
                    duration));
        }
    }
}