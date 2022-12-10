package com.sidant.mimir;

import com.sidant.mimir.TelegramBot.MimirBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MimirApplication {

	public static void main(String[] args) {
		SpringApplication.run(MimirApplication.class, args);
		//WebhookHandler.mimirBot = new MimirBot();
	}
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
