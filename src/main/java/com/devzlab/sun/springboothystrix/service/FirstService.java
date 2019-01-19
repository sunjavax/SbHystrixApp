package com.devzlab.sun.springboothystrix.service;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.HttpServerErrorException;

@Service
public class FirstService {
	
	@Autowired
	ApplicationConfigService applicationConfigService;
	
	@Autowired
	FirstRestService firstRestService;		

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    public ResponseEntity<?> getData(String id) throws HttpServerErrorException {  
    	String url = applicationConfigService.getVendorUrl().replaceFirst(Pattern.quote("{id}"), id);
    	 HttpHeaders headers = new HttpHeaders();
         headers.set("Content-Type", "application/json"); 
         Map<?,?> request = new HashMap<>();
        return firstRestService.invoke(url, RequestMethod.GET, headers, request);
    }
}
