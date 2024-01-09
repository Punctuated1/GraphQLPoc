package com.pd.graphql.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.pd.benchmark.mongodb.Person;

@Controller
public class PersonController {
	@Autowired
	private PersonRepository personRepository;

	@QueryMapping
	public Person personById(@Argument String id) {
		long personId = Long.parseLong(id);
    	Optional<Person> personOptional = personRepository.findById(personId);
        return personOptional.get();
	}

	@QueryMapping
	public List<Person> personsByLastName(@Argument String lastName) {
        return personRepository.findByLastName(lastName);
	}

}
