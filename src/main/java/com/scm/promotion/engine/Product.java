package com.scm.promotion.engine;

import java.util.ArrayList;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource({ "classpath:application.properties" })
public class Product {

	private static final Logger logger = LoggerFactory.getLogger(Product.class);

	@Value("${app.config.a}")
	private int promotional_a;

	@Value("${app.config.b}")
	private int promotional_b;

	@Value("${app.config.c}")
	private int promotional_c;

	@Value("${app.qty.a}")
	private int qtyA;

	@Value("${app.qty.b}")
	private int qtyB;


	private static final int UNITPRICE_A = 50;
	private static final int UNITPRICE_B = 30;
	private static final int UNITPRICE_C = 20;
	private static final int UNITPRICE_D = 15;

	public void products() {
		int noOfProducts;
		String productName;
		int totalPrice;
		Scanner sc = new Scanner(System.in);
		logger.info("Enter Number of Products: ");
		noOfProducts = sc.nextInt();
		ArrayList<String> products = new ArrayList<String>();
		for (int i = 1; i <= noOfProducts; i++) {
			logger.info("Enter the Product Name : ");
			productName = sc.next();
			products.add(productName);
		}
		logger.info("The Product Array has : " + products.toString());
		int counter_A = 0;
		int counter_B = 0;
		int counter_C = 0;
		int counter_D = 0;
		for (int j = 0; j < products.size(); j++) {
			if (products.get(j).equalsIgnoreCase("A")) {
				counter_A = counter_A + 1;
			} else if (products.get(j).equalsIgnoreCase("B")) {
				counter_B = counter_B + 1;
			} else if (products.get(j).equalsIgnoreCase("C")) {
				counter_C = counter_C + 1;
			} else if (products.get(j).equalsIgnoreCase("D")) {
				counter_D = counter_D + 1;
			}
		}
		logger.info("A: " + counter_A + " B: " + counter_B + " C: " + counter_C + " D: " + counter_D);
		int priceOfA = ((counter_A % qtyA) * UNITPRICE_A) + (Integer.valueOf(counter_A / qtyA) * promotional_a);
		int priceOfB = ((counter_B % qtyB) * UNITPRICE_B) + (Integer.valueOf(counter_B / qtyB) * promotional_b);
		int priceOfC = counter_C * UNITPRICE_C;
		int priceOfD = counter_D * UNITPRICE_D;
		if (counter_C != 0 && counter_D != 0) {
			totalPrice = priceOfA + priceOfB + promotional_c;
		} else {
			totalPrice = priceOfA + priceOfB + priceOfC + priceOfD;
		}
		logger.info("Total Amount to be Paid by Customer after appling promotional Price : " + totalPrice);
	}

}
