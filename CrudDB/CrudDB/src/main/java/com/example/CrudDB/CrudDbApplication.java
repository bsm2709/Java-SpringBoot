package com.example.CrudDB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

@SpringBootApplication()
public class CrudDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDbApplication.class, args);

	}

}
