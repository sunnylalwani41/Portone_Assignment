package io.portone.service;

import java.io.IOException;
import java.util.List;

import com.stripe.model.PaymentIntent;
import com.stripe.model.Refund;

import io.portone.exception.PortoneException;
import io.portone.model.PaymentIntentRequest;


public interface PaymentGatewayService {
	public PaymentIntent createIntentForPayment(PaymentIntentRequest paymentIntentRequest) throws PortoneException;
	
	public PaymentIntent attachPaymentMethod(String paymentIntentId, String paymentMethodId) throws PortoneException;
	
	public PaymentIntent captureTheCreatedIntent(String paymentIntentId) throws PortoneException;
	
	public Refund createRefundForPaymentIntent(String paymentIntentId) throws PortoneException;
	
	public List<PaymentIntent> getAllTheIntent()throws PortoneException;
}