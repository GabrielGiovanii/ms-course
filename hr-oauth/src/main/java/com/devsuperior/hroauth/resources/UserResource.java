package com.devsuperior.hroauth.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.devsuperior.hroauth.entities.User;
import com.devsuperior.hroauth.services.UserService;

@Controller
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	UserService service;

	@GetMapping(value = "/search")
	public ResponseEntity<User> findByEmail(@RequestParam String email) {
		try {
			User obj = service.findUserByEmail(email);

			return ResponseEntity.ok(obj);
		} catch (IllegalArgumentException ex) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
}
