package com.example.demo.services;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Payment;

@Service
public class PaymentService {
	public Payment getPayment(Integer workerId, Integer days) {
		return new Payment("Gabriel", 200.0, days);
	}
}
