package com.scm.promotion.engine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PromotionEngineApplication implements CommandLineRunner{
	
	@Autowired
	Product product;
	
	@Override
	public void run(String... args) {
		product.products();
	}

	public static void main(String[] args) {
		SpringApplication.run(PromotionEngineApplication.class, args);
	}

}
