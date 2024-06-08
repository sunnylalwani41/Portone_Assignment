package io.portone.service;

import java.io.IOException;
import java.util.List;

import com.stripe.model.PaymentIntent;
import com.stripe.model.PaymentMethod;
import com.stripe.model.Refund;

import io.portone.exception.PortoneException;
import io.portone.model.PaymentIntentRequest;


public interface PaymentGatewayService {
	public String createIntentForPayment(PaymentIntentRequest paymentIntentRequest) throws PortoneException;
	
	public String attachPaymentMethod(String paymentIntentId, String paymentMethodId) throws PortoneException;
	
	public String captureTheCreatedIntent(String paymentIntentId) throws PortoneException;
	
	public String createRefundForPaymentIntent(String paymentIntentId) throws PortoneException;
	
	public List<PaymentIntent> getAllTheIntent()throws PortoneException;
	
	public String confirmPayment(PaymentIntent paymentIntent)throws PortoneException;
}