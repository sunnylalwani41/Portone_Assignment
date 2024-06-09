package io.portone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info= @Info(title="Stripe Payment Gateway Integration", version="1.0", description = "PortOne Assignment"))
public class StripePaymentGatewayIntegrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(StripePaymentGatewayIntegrationApplication.class, args);
	}

}
