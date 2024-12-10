package com.productmanagement.Product.Managemnt;

import com.productmanagement.Product.Managemnt.Configuration.TwilioSmsConfig;
import com.twilio.Twilio;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductManagemntApplication {

	@Autowired
	private TwilioSmsConfig configTwilio;

	public static void main(String[] args) {
		SpringApplication.run(ProductManagemntApplication.class, args);
	}


	@PostConstruct
	public void init(){
		Twilio.init(configTwilio.getAccountSid(),configTwilio.getAuthId());
	}
}
