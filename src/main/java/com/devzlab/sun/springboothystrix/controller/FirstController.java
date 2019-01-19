package com.devzlab.sun.springboothystrix.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;

import com.devzlab.sun.springboothystrix.service.HystrixService;

@RestController
@RequestMapping(value = "/firstController")
public class FirstController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	HystrixService hystrixService; 
	
	@RequestMapping(value = "/data/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getData(@PathVariable(value = "id") String id) throws HttpServerErrorException, InterruptedException {
		logger.info("springboothystrix:getData- for id: {}", id);
		return (ResponseEntity<?>) hystrixService.getData(id);
	}
	
}
