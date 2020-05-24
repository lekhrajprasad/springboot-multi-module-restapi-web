package com.lpras.springboot;

import com.lpras.springboot.aspectlog.CorrelationLoggerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private CorrelationLoggerInterceptor correlationLoggerInterceptor;

    //Registering Logger Interceptor to customized logger to log session id or correlation id
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(correlationLoggerInterceptor);
    }

    //For spring securities
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

}
