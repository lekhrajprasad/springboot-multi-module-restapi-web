package com.lpras.springboot.aspectlog;

import com.lpras.springboot.utils.EnumConstantUtils;
import io.micrometer.core.instrument.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.Instant;
import java.util.UUID;

@Component
public class CorrelationLoggerInterceptor extends HandlerInterceptorAdapter {
    private static Logger log = LoggerFactory.getLogger(CorrelationLoggerInterceptor.class);

    @Override
    public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response,
                             final Object handler) {
        final String sessionId = getSessionId(request);
        log.debug("Session Id: {}", sessionId);
        final String correlationId = getCorrelationIdFromHeader(request);
        MDC.put(EnumConstantUtils.SESSION_ID_LOG_VAR_NAME.toString(), sessionId);
        MDC.put(EnumConstantUtils.CORRELATION_ID_LOG_VAR_NAME.toString(), correlationId);
        return true;
    }

    @Override
    public void afterCompletion(final HttpServletRequest request, final HttpServletResponse response,
                                final Object handler, final Exception ex) {
        MDC.remove(EnumConstantUtils.SESSION_ID_LOG_VAR_NAME.toString());
        MDC.remove(EnumConstantUtils.CORRELATION_ID_LOG_VAR_NAME.toString());
    }

    private String getSessionId(final HttpServletRequest request) {
        if (null != request.getSession()) {
            return request.getSession().getId();
        }
        return getSessionIdFromHeader(request);
    }

    private String getSessionIdFromHeader(final HttpServletRequest request) {
        String sessionId = request.getHeader(EnumConstantUtils.SESSION_ID_HEADER_NAME.toString());
        if (StringUtils.isBlank(sessionId)) {
            log.info(EnumConstantUtils.NO_SESSION_ID_FOUND_HEADER.toString());
            throw new RuntimeException(EnumConstantUtils.NO_SESSION_ID_FOUND_HEADER.toString());
        }

        return sessionId;
    }

    private String getCorrelationIdFromHeader(final HttpServletRequest request) {
        //In some use case expecting correlaton id from header
        String correlationId = request.getHeader(EnumConstantUtils.CORRELATION_ID_HEADER_NAME.toString());
        if (StringUtils.isBlank(correlationId)) {
            correlationId = generateUniqueCorrelationId();
        }
        return correlationId;
    }

    private String generateUniqueCorrelationId() {
        Instant instant = Instant.now();
        long timeStampMillis = instant.toEpochMilli();
        String randomUniqId = UUID.randomUUID().toString();
        String correlationId = timeStampMillis + "-" + randomUniqId;
        log.info("No correlationId found in Header. Generated : {}", correlationId);
        return randomUniqId;
    }

}
