package com.pd.graphql.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages="com.pd.graphql.demo")
@EnableJpaRepositories(basePackages = "com.pd.graphql.jpa")
@EntityScan("com.pd.graphql.jpa")
public class GraphQl3Application {

	public static void main(String[] args) {
		SpringApplication.run(GraphQl3Application.class, args);
	}

}
