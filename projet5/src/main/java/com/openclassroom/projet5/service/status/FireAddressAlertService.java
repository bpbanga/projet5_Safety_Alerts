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
import com.openclassroom.projet5.model.status.FireAddressAlert;
import com.openclassroom.projet5.model.status.Resident;
import com.openclassroom.projet5.repository.IDAOJson;
import com.openclassroom.projet5.utils.AgeHandler;


/*
 * Format data from DTO into FireAddressAlert
 */
@Service
public class FireAddressAlertService implements IFireAddressAlertService {
    @Autowired
    private IDAOJson DTOjson;
    private static final Logger logger = LogManager.getLogger("FireAddressAlertService");

    /*
     * @Param String address
     */
    @Override
    public FireAddressAlert getFireAddressAlert(String address) {
	FireAddressAlert resultFireAddressAlert = new FireAddressAlert();
	List<Resident> resultResidents = new ArrayList<Resident>();

	List<Persons> persons = DTOjson.getJsonData().getPersons();
	List<MedicalRecords> medicalRecords = DTOjson.getJsonData().getMedicalrecords();
	List<FireStations> fireStations = DTOjson.getJsonData().getFirestations();

	// Retrieve stationNumber from fireStation
	for (FireStations firestation : fireStations) {
	    if (firestation.getAddress().equals(address)) {
		resultFireAddressAlert.setStationNumber(Integer.parseInt(firestation.getStation()));
		break;
	    }
	}

	// Retrieve persons living in address
	List<Persons> filteredPersonsInAddress = new ArrayList<Persons>();
	for (Persons person : persons) {
	    if (person.getAddress().equals(address)) {
		filteredPersonsInAddress.add(person);
	    }
	}

	// Retrieve age, medications and allergies from medicalRecords
	for (Persons filteredPerson : filteredPersonsInAddress) {
	    for (MedicalRecords medicalRecord : medicalRecords) {
		if (filteredPerson.getFirstName().equals(medicalRecord.getFirstName())
			&& filteredPerson.getLastName().equals(medicalRecord.getLastName())) {
		    Resident residentToAdd = new Resident(filteredPerson.getFirstName(), filteredPerson.getLastName(),
			    filteredPerson.getPhone(), AgeHandler.computeAge(medicalRecord.getBirthdate(), new Date()),
			    medicalRecord.getMedications(), medicalRecord.getAllergies());
		    resultResidents.add(residentToAdd);
		}
	    }
	}
	resultFireAddressAlert.setResidents(resultResidents);

	return resultFireAddressAlert;
    }

}


