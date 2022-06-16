package com.app.employee.service.config;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class AsynConfiguration {

    @Autowired
    AsyncUncaughtExceptionHandler asyncUncaughtExceptionHandler;


    @Bean
    public Executor taskExecutor(){
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(5);
        threadPoolTaskExecutor.setMaxPoolSize(10);
        threadPoolTaskExecutor.setQueueCapacity(500);
        threadPoolTaskExecutor.setThreadNamePrefix("Async-example-thread-neeraj");
        threadPoolTaskExecutor.initialize();
        return threadPoolTaskExecutor;
    }


    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler(){
        return asyncUncaughtExceptionHandler;
    }
}
