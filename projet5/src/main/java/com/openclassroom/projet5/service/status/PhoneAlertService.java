package com.openclassroom.projet5.service.status;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassroom.projet5.model.FireStations;
import com.openclassroom.projet5.model.Persons;
import com.openclassroom.projet5.model.status.PhoneAlert;
import com.openclassroom.projet5.repository.DAOJson;
import com.openclassroom.projet5.repository.IDAOJson;


/*
 * Format data from DTO into PhoneAlertService
 */
@Service
public class PhoneAlertService implements IPhoneAlertService {
    @Autowired
    private IDAOJson DTOjson;
    private static final Logger logger = LogManager.getLogger("PhoneAlertService");

    /*
     * @Param int stationNumber
     */
    @Override
    public List<PhoneAlert> getPhoneAlert(int stationNumber) {
	List<PhoneAlert> resultPhoneAlert = new ArrayList<PhoneAlert>();

	List<FireStations> fireStations = DTOjson.getJsonData().getFirestations();
	List<Persons> persons = DTOjson.getJsonData().getPersons();

	// Retrieve Addresses covered by station number
	// Loop through the list of FireStations to get all the address covered
	List<String> filteredFireStationAddresses = new ArrayList<String>();
	for (FireStations fireStation : fireStations) {
	    if (fireStation.getStation().equals(String.valueOf(stationNumber))) {
		filteredFireStationAddresses.add(fireStation.getAddress());
	    }
	}

	for (Persons person : persons) {
	    if (filteredFireStationAddresses.contains(person.getAddress())) {
		resultPhoneAlert.add(new PhoneAlert(person.getPhone()));
	    }
	}

	return resultPhoneAlert;
    }
}
