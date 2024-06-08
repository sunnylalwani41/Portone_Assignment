package io.portone.model;

import lombok.Data;

@Data
public class PaymentIntentRequest {
	private int amount;
	private String currency;
}