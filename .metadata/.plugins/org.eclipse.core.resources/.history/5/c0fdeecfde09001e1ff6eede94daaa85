package com.openclassroom.projet5.service.status;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassroom.projet5.model.MedicalRecords;
import com.openclassroom.projet5.model.Persons;
import com.openclassroom.projet5.model.status.ChildAlert;
import com.openclassroom.projet5.repository.IDAOJson;
import com.openclassroom.projet5.utils.AgeHandler;

/*
 * Format data from DTO into ChildAlert
 */
@Service
public class ChildAlertService implements IChildAlertService {
    @Autowired
    private IDAOJson DTOjson;
    private static final Logger logger = LogManager.getLogger("ChildAlertServiceService");

    /*
     * @Param String address
     */
    @Override
    public List<ChildAlert> getChildAlert(String address) {
	List<ChildAlert> resultChildAlert = new ArrayList<ChildAlert>();

	List<Persons> persons = DTOjson.getJsonData().getPersons();
	List<MedicalRecords> medicalRecords = DTOjson.getJsonData().getMedicalrecords();

	List<Persons> residents = new ArrayList<Persons>();
	List<Persons> children = new ArrayList<Persons>();
	Map<String, List<Persons>> family = new HashMap<String, List<Persons>>();

	// Retrieve the persons living in the address
	for (Persons person : persons) {
	    if (person.getAddress().equals(address)) {
		residents.add(person);

		// Map family members into HashMap for easier retrieval
		if (family.containsKey(person.getLastName())) {
		    List<Persons> existingFamily = family.get(person.getLastName());
		    existingFamily.add(person);
		    family.put(person.getLastName(), existingFamily);
		} else {
		    List<Persons> newFamily = new ArrayList<Persons>();
		    newFamily.add(person);
		    family.put(person.getLastName(), newFamily);
		}

	    }
	}

	// Looping through the resident and the MedicalRecord to retrieve BirthDate and
	// check whether resident is a child, then append result List
	for (Persons resident : residents) {
	    for (MedicalRecords medicalRecord : medicalRecords) {
		if (resident.getFirstName().equals(medicalRecord.getFirstName())
			&& resident.getLastName().equals(medicalRecord.getLastName())
			&& AgeHandler.computeAge(medicalRecord.getBirthdate(), new Date()) < 18) {
		    resultChildAlert.add(new ChildAlert(resident.getFirstName(), resident.getLastName(),
			    family.get(resident.getLastName())));
		}
	    }
	}

	return resultChildAlert;
    }
}

