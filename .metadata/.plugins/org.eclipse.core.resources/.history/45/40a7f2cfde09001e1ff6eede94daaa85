package com.openclassroom.projet5.service.status;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassroom.projet5.model.FireStations;
import com.openclassroom.projet5.model.MedicalRecords;
import com.openclassroom.projet5.model.Persons;
import com.openclassroom.projet5.model.status.FireStationCoverage;
import com.openclassroom.projet5.repository.IDAOJson;
import com.openclassroom.projet5.utils.AgeHandler;



/*
 * Format data from DTO into FireStationCoverage
 */
@Service
public class FireStationCoverageService implements IFireStationCoverageService {
    @Autowired
    private IDAOJson DTOjson;
    private static final Logger logger = LogManager.getLogger("FireStationCoverageService");

    /*
     * @Param int stationNumber
     */
    @Override
    public FireStationCoverage getFireStationCoverage(int stationNumber) {
	// Initialize result elements
	Integer adultNumber = 0;
	Integer childNumber = 0;

	// Retrieve Data from DTO
	List<FireStations> fireStations = DTOjson.getJsonData().getFirestations();
	List<Persons> persons = DTOjson.getJsonData().getPersons();
	List<MedicalRecords> medicalRecords = DTOjson.getJsonData().getMedicalrecords();

	// Loop through the list of FireStations to get all the address covered
	List<String> filteredFireStationAddresses = new ArrayList<String>();
	for (FireStations fireStation : fireStations) {
	    if (fireStation.getStation().equals(String.valueOf(stationNumber))) {
		filteredFireStationAddresses.add(fireStation.getAddress());
	    }
	}
	// Loop through the list of Persons to retrieve the ones living in the address
	List<Persons> filteredPersons = new ArrayList<Persons>();
	for (Persons person : persons) {
	    if (filteredFireStationAddresses.contains(person.getAddress())) {
		filteredPersons.add(person);
	    }
	}

	// Loop through MedicalRecords to retrieve the age and append the child & adult
	// counts.
	for (Persons filteredPerson : filteredPersons) {
	    for (MedicalRecords medicalRecord : medicalRecords) {
		if (filteredPerson.getFirstName().equals(medicalRecord.getFirstName())
			&& filteredPerson.getLastName().equals(medicalRecord.getLastName())) {
		    if (AgeHandler.computeAge(medicalRecord.getBirthdate(), new Date()) >= 18) {
			adultNumber += 1;
		    } else {
			childNumber += 1;
		    }
		}
	    }
	}

	return new FireStationCoverage(filteredPersons, adultNumber, childNumber);
    }

}
