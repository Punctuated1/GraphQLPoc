package com.pd.benchmark.mongodb;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "person")

public class Person {

	@Id
	private long id;

	public String lastName;

	public String firstName;

	public String gender;

	public String dateOfBirth;

	public String tsCr;

	public String tsup;

	public String nameUp;
	
	public String cag;

	public String getCag() {
		return cag;
	}

	public void setCag(String cag) {
		this.cag = cag;
	}

	/**
	* 
	*/
	public Person() {
		super();
// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getTsCr() {
		return tsCr;
	}

	public void setTsCr(String tsCr) {
		this.tsCr = tsCr;
	}

	public String getTsup() {
		return tsup;
	}

	public void setTsup(String tsup) {
		this.tsup = tsup;
	}

	public String getNameUp() {
		return nameUp;
	}

	public void setNameUp(String nameUp) {
		this.nameUp = nameUp;
	}
}
