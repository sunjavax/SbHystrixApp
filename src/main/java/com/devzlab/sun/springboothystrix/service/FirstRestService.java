package com.devzlab.sun.springboothystrix.service;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class FirstRestService {
	
	 private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ApplicationConfigService applicationConfigService;

	public ResponseEntity<?> invoke(String url, RequestMethod requestMethod, HttpHeaders headers, Map<?, ?> request) {
		try {
			Thread.sleep(1000);
			/*for(int i=0; i<=3000; i++) {
				//donothing
			}*/
			RestTemplate restTemplate = new RestTemplate();			
			String result = restTemplate.getForObject(url, String.class);
			logger.info("Response Received from rest ......\n"+result);
			return new ResponseEntity<String>(result, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Custom Exception......", e);
			throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
