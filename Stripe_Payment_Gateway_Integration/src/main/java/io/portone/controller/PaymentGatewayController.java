package io.portone.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.portone.exception.PortoneException;
import io.portone.model.PaymentIntentRequest;
import io.portone.service.PaymentGatewayService;

@RestController
public class PaymentGatewayController {
	@Autowired
	private PaymentGatewayService paymentGatewayService;
	
	@PostMapping("/api/v1/create_intent")
	public String createIntentForPaymentHandler(@RequestBody PaymentIntentRequest paymentIntentRequest) throws PortoneException {
		return paymentGatewayService.createIntentForPayment(paymentIntentRequest);
	}
	
	@PostMapping("/api/v1/attach_payment_method")
	public String attachPaymentMethodHandler(@RequestParam String paymentIntentId, @RequestParam String paymentMethodId) throws PortoneException {
		return paymentGatewayService.attachPaymentMethod(paymentIntentId, paymentMethodId);
	}
	
	@PostMapping("/api/v1/capture_intent/{id}")
	public String captureTheCreatedIntentHandler(@PathVariable("id") String paymentIntentId) throws PortoneException {
		return paymentGatewayService.captureTheCreatedIntent(paymentIntentId);
	}
	
	
}
