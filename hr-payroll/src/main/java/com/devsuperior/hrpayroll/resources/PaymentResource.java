package com.devsuperior.hrpayroll.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.hrpayroll.entities.Payment;
import com.devsuperior.hrpayroll.services.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {
	
	@Autowired
	PaymentService service;
	
	@HystrixCommand(fallbackMethod = "getPaymentAlternative")
	@GetMapping(value = "/{workerId}/days/{days}")
	public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days) {
		Payment obj = service.getPayment(workerId, days);
		return ResponseEntity.ok(obj);
	}
	
	public ResponseEntity<Payment> getPaymentAlternative(Long workerId, Integer days){
		Payment obj = new Payment("Gabriel", 50.0, 15);
		return ResponseEntity.ok(obj);
	}
}
