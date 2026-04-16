package com.expensetracker.sajilo_finance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SajiloFinanceApplication {

	public static void main(String[] args) {
		try{
		SpringApplication.run(SajiloFinanceApplication.class, args);
		}catch(Exception e){
			System.out.println(e);
		
		}
	}

}
