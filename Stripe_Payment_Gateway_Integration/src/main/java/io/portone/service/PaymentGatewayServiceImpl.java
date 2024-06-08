package io.portone.service;


import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import com.stripe.param.PaymentIntentUpdateParams;

import io.portone.exception.PortoneException;
import io.portone.model.PaymentIntentRequest;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Service
public class PaymentGatewayServiceImpl implements PaymentGatewayService{
	@Value("${stripe.api.key}")
	private String stripeApiKey;

//	@Override
//	public String createIntentForPayment(Map<String, String> parameter) throws IOException {
//		String requestBodyString = supportFormat(parameter);
//		OkHttpClient client = new OkHttpClient().newBuilder()
//						.build();
//		MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
//		RequestBody body = RequestBody.create(mediaType, requestBodyString);
//		Request request = new Request.Builder()
//		  .url("https://api.stripe.com/v1/payment_intents")
//		  .method("POST", body)
//		  .addHeader("Content-Type", "application/x-www-form-urlencoded")
//		  .addHeader("Authorization", stripeApiKey)
//		  .build();
//		Response response = client.newCall(request).execute();
//		
//		return response.body().string();
//	}
	
	@Override
	public String createIntentForPayment(PaymentIntentRequest paymentIntentRequest) throws PortoneException{
		Stripe.apiKey = stripeApiKey;
		
		try {
			PaymentIntentCreateParams params = PaymentIntentCreateParams.builder().
					setAmount(Long.valueOf(paymentIntentRequest.getAmount())).
					setCurrency(paymentIntentRequest.getCurrency()).
					setAutomaticPaymentMethods( 
							PaymentIntentCreateParams.AutomaticPaymentMethods.builder().
							setEnabled(true).build()).
					build();
			PaymentIntent paymentIntent= PaymentIntent.create(params);
			return paymentIntent.toJson();
		} catch (StripeException stripeException) {
			throw new PortoneException("Error creating PaymentIntent "+stripeException.getMessage());
		}
	}
	
	private String supportFormat(Map<String, String> parameters) {
		StringBuilder parameterInStringBuilder = new StringBuilder("");
		
		for(Map.Entry<String, String> entry: parameters.entrySet()) {
			if(parameterInStringBuilder.length()>0) {
				parameterInStringBuilder.append("&");
			}
			
			parameterInStringBuilder.append(entry.getKey());
			parameterInStringBuilder.append("=");
			parameterInStringBuilder.append(entry.getValue());
		}
		
		return parameterInStringBuilder.toString();
	}

	@Override
	public String captureTheCreatedIntent(String paymentIntentId) throws PortoneException{
		Stripe.apiKey = stripeApiKey;
		
		try {
			PaymentIntent paymentIntent = PaymentIntent.retrieve(paymentIntentId);

			if ("requires_capture".equals(paymentIntent.getStatus())) {
                PaymentIntent capturedPaymentIntent = paymentIntent.capture();
                return capturedPaymentIntent.toJson();
            } else {
                throw new PortoneException("PaymentIntent cannot be captured. Current status: " + paymentIntent.getStatus());
            }
		} catch (StripeException stripeException) {
			throw new PortoneException("Error capturing PaymentIntent "+stripeException.getMessage());
		}
	}

	@Override
	public String attachPaymentMethod(String paymentIntentId, String paymentMethodId) throws PortoneException {
		Stripe.apiKey = stripeApiKey;
		
		try {
			PaymentIntentUpdateParams params = PaymentIntentUpdateParams.builder()
					.setPaymentMethod(paymentMethodId).build();
			PaymentIntent paymentIntent = PaymentIntent.retrieve(paymentIntentId);
			PaymentIntent updatedPaymentIntent= paymentIntent.update(params);
			
			updatedPaymentIntent = updatedPaymentIntent.confirm();
			
			return updatedPaymentIntent.toJson();
		}
		catch (StripeException stripeException) {
			throw new PortoneException("Error attach payment method in PaymentIntent "+stripeException.getMessage());
		}
	}

}
