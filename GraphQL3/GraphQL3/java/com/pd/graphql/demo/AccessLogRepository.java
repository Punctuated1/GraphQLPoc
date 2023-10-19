package com.pd.graphql.demo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pd.benchmark.mongodb.Person;

public interface AccessLogRepository extends MongoRepository<Person, Long> {
	
}
