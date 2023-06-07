package com.openclassroom.projet5.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassroom.projet5.model.Persons;
import com.openclassroom.projet5.repository.DAOJson;
import com.openclassroom.projet5.repository.IDAOJson;



	/*
	 * Service for CRUD operations on Persons
	 */
	@Service
	public class PersonService implements IPersonsService {
	    @Autowired
	    private IDAOJson DTOjson;
	    private static final Logger logger = LogManager.getLogger("PersonService");

	    /*
	     * Retrieve Persons from DTO
	     */
	    @Override
	    public List<Persons> getPersons() {
		return DTOjson.getJsonData().getPersons();

	    }

	    /*
	     * Add Person from JSON data
	     * 
	     * @Param Person personToAdd
	     */
	    @Override
	    public void postPerson(Persons personToAdd) {
		List<Persons> persons = getPersons();
		persons.add(personToAdd);
		DTOjson.getJsonData().setPersons(persons);
	    }

	    /*
	     * Edit Person from JSON data
	     * 
	     * @Param Person personToUpdate
	     */
	    @Override
	    public void putPerson(Persons personToUpdate) {
		List<Persons> persons = getPersons();

		for (Persons person : persons) {
		    if (person.getFirstName().equals(personToUpdate.getFirstName())
			    && person.getLastName().equals(personToUpdate.getLastName())) {
			if (personToUpdate.getAddress() != null)
			    person.setAddress(personToUpdate.getAddress());
			if (personToUpdate.getCity() != null)
			    person.setCity(personToUpdate.getCity());
			if (personToUpdate.getZip() != null)
			    person.setZip(personToUpdate.getZip());
			if (personToUpdate.getEmail() != null)
			    person.setEmail(personToUpdate.getEmail());
			if (personToUpdate.getPhone() != null)
			    person.setPhone(personToUpdate.getPhone());
		    }
		}
	    }

	    /*
	     * Delete Person from JSON data
	     * 
	     * @Param Person personToDelete
	     */
	    @Override
	    public void deletePerson(Persons personToDelete) {
		List<Persons> persons = getPersons();
		Boolean personExist = false;
		for (int i = 0; i < persons.size(); i++) {
		    if (persons.get(i).getFirstName().equals(personToDelete.getFirstName())
			    && persons.get(i).getLastName().equals(personToDelete.getLastName())) {
			persons.remove(i);
			personExist = true;
		    }
		}
	    }

	

}
