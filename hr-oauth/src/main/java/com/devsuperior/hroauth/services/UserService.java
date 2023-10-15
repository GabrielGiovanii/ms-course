package com.devsuperior.hroauth.services;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.hroauth.entities.User;
import com.devsuperior.hroauth.feignclients.UserFeignClient;

@Service
public class UserService {
	private static Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	UserFeignClient userClient;
	
	public User findUserByEmail(String email) {
		User obj = userClient.findByEmail(email).getBody();
		if(obj == null) {
			logger.error("Email not found: " + email);
			throw new IllegalArgumentException("Email not found.");
		}
		logger.info("All right.");
		return obj;
	}
}
