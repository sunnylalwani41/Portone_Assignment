package io.portone.service;

import java.io.IOException;

import io.portone.exception.PortoneException;
import io.portone.model.PaymentIntentRequest;


public interface PaymentGatewayService {
	public String createIntentForPayment(PaymentIntentRequest paymentIntentRequest) throws PortoneException;
	
	public String attachPaymentMethod(String paymentIntentId, String paymentMethodId) throws PortoneException;
	
	public String captureTheCreatedIntent(String paymentIntentId) throws PortoneException;
	
	public String createRefundForPaymentIntent(String paymentIntentId) throws PortoneException;
}