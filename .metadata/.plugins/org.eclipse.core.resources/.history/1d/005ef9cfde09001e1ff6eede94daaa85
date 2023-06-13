package com.openclassroom.projet5.service.status;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassroom.projet5.model.MedicalRecords;
import com.openclassroom.projet5.model.Persons;
import com.openclassroom.projet5.model.status.PersonInfo;
import com.openclassroom.projet5.repository.IDAOJson;
import com.openclassroom.projet5.utils.AgeHandler;

/*
 * Format data from DTO into PersonInfo
 */
@Service
public class PersonInfoService implements IPersonInfoService {
    @Autowired
    private IDAOJson DTOjson;
    private static final Logger logger = LogManager.getLogger("PersonInfoService");

    /*
     * @Param String firstName, String lastName
     */
    @Override
    public List<PersonInfo> getPersonInfo(String firstName, String lastName) {
	List<PersonInfo> resultPersonInfo = new ArrayList<PersonInfo>();

	List<Persons> persons = DTOjson.getJsonData().getPersons();
	List<MedicalRecords> medicalRecords = DTOjson.getJsonData().getMedicalrecords();

	List<Persons> filteredPersons = new ArrayList<Persons>();

	// Filtering list of Person to retrieve all occurrences of firstName/lastName
	// combinations
	for (Persons person : persons) {
	    if (person.getFirstName().equals(firstName) && person.getLastName().equals(lastName)) {
		filteredPersons.add(person);
	    }
	}

	// Looping through the filtered list of persons to retrieve the relevant data
	// from medicalRecords
	for (Persons filteredPerson : filteredPersons) {
	    PersonInfo personInfoToAdd = new PersonInfo();
	    for (MedicalRecords medicalRecord : medicalRecords) {
		if (medicalRecord.getFirstName().equals(filteredPerson.getFirstName())
			&& medicalRecord.getLastName().equals(filteredPerson.getLastName())) {
		    // adding the results to resultPersonInfo through a new PersonInfo object
		    resultPersonInfo.add(new PersonInfo(filteredPerson.getFirstName(), filteredPerson.getLastName(),
			    AgeHandler.computeAge(medicalRecord.getBirthdate(), new Date()), filteredPerson.address,
			    filteredPerson.city, filteredPerson.zip, medicalRecord.getAllergies(),
			    medicalRecord.getMedications()));
		}

	    }
	}

	return resultPersonInfo;
    }
}