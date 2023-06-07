package com.openclassroom.projet5.model.status;

import java.util.List;

// fire?address
public class Resident {
    public String firstName;
    public String lastName;
    public String phone;
    public Integer age;
    public List<String> medications;
    public List<String> allergies;

    public Resident(String firstName, String lastName, String phone, Integer age, List<String> medications,
	    List<String> allergies) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.phone = phone;
	this.age = age;
	this.medications = medications;
	this.allergies = allergies;
    }

    public String getFirstName() {
	return firstName;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    public String getLastName() {
	return lastName;
    }

    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    public String getPhone() {
	return phone;
    }

    public void setPhone(String phone) {
	this.phone = phone;
    }

    public Integer getAge() {
	return age;
    }

    public void setAge(Integer age) {
	this.age = age;
    }

    public List<String> getMedications() {
	return medications;
    }

    public void setMedications(List<String> medications) {
	this.medications = medications;
    }

    public List<String> getAllergies() {
	return allergies;
    }

    public void setAllergies(List<String> allergies) {
	this.allergies = allergies;
    }

}