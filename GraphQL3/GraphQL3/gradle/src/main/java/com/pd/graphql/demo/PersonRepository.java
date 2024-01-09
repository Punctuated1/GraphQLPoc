package com.pd.graphql.demo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pd.benchmark.mongodb.Person;

public interface PersonRepository extends MongoRepository<Person, Long> {
	List<Person> findByLastName(String lastName);
}
