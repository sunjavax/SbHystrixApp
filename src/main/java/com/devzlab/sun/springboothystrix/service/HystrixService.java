package com.devzlab.sun.springboothystrix.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;

import com.netflix.config.ConfigurationManager;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
@EnableCircuitBreaker
public class HystrixService {
	
	@Autowired
	ApplicationConfigService applicationConfigService;
	
	@Autowired
	FirstService firstService;
		

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private void setHystrixProperties(String hystrixCommandKey) {
		logger.info("setHystrixProperties.. for hystrixCommandKey: {}", hystrixCommandKey);
        ConfigurationManager.getConfigInstance().setProperty("hystrix.command." + hystrixCommandKey + ".execution.timeout.enabled", applicationConfigService.getHxDefaultTimeoutEnabled());
        ConfigurationManager.getConfigInstance().setProperty("hystrix.command." + hystrixCommandKey + ".execution.isolation.thread.timeoutInMilliseconds", applicationConfigService.getHxDefaultTimeout());
        ConfigurationManager.getConfigInstance().setProperty("hystrix.command." + hystrixCommandKey + ".circuitBreaker.requestVolumeThreshold", applicationConfigService.getHxDefaultVolumeThreshold());
        ConfigurationManager.getConfigInstance().setProperty("hystrix.command." + hystrixCommandKey + ".circuitBreaker.errorThresholdPercentage", applicationConfigService.getHxDefaultErrorPercent());
        ConfigurationManager.getConfigInstance().setProperty("hystrix.command." + hystrixCommandKey + ".circuitBreaker.sleepWindowInMilliseconds", applicationConfigService.getHxDefaultSleepWindow());
        ConfigurationManager.getConfigInstance().setProperty("hystrix.command." + hystrixCommandKey + ".metrics.rollingStats.timeInMilliseconds", applicationConfigService.getHxDefaultRollingStatTime());
        ConfigurationManager.getConfigInstance().setProperty("hystrix.command." + hystrixCommandKey + ".threadpool.default.coreSize", applicationConfigService.getHxDefaultThreadPoolCoreSize());
    }

    @HystrixCommand(commandKey = "getData", fallbackMethod = "getDataFallback") 
    public ResponseEntity<?> getData(String id) throws HttpServerErrorException {
        setHystrixProperties("getData");
        return firstService.getData(id);
    }

    public ResponseEntity<?> getDataFallback(String id, Throwable commandException) {
        logger.error("falling back to Hystrix - getDataFallback Identifier: {}", id, commandException);     
        return new ResponseEntity<Object>("falling back to Hystrix\n "+commandException, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
