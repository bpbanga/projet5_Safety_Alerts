package com.openclassroom.projet5.service;


import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassroom.projet5.model.FireStations;
import com.openclassroom.projet5.repository.IDAOJson;



/*
 * Service for CRUD operations on FireStations
 */
@Service
public class FireStationService implements IFireStationService {
    @Autowired
    private IDAOJson DTOjson;
    private static final Logger logger = LogManager.getLogger("FireStationService");

    /*
     * Retrieve FireStations from DAO
     */
    @Override
    public List<FireStations> getFireStations() {
	return DTOjson.getJsonData().getFirestations();
    }

    /*
     * Add FireStation to JSON data
     * 
     * @Param FireStation fireStationToAdd
     */
    @Override
    public void postFireStation(FireStations fireStationToAdd) {
	List<FireStations> fireStations = getFireStations();
	fireStations.add(fireStationToAdd);
	DTOjson.getJsonData().setFirestations(fireStations);
    }

    /*
     * Edit FireStation from JSON data
     * 
     * @Param FireStation fireStationToUpdate
     */
    @Override
    public void putFireStation(FireStations fireStationToUpdate) {
	List<FireStations> fireStations = getFireStations();

	for (FireStations fireStation : fireStations) {
	    if (fireStation.getAddress().equals(fireStationToUpdate.getAddress())) {
		fireStation.setStation(fireStationToUpdate.getStation());
	    }
	}
    }

    /*
     * Delete FireStation from JSON data
     * 
     * @Param FireStation fireStationToDelete
     */
    @Override
    public boolean deleteFireStation(String adresse, String id) {
    	boolean result = false;

	List<FireStations> fireStations = getFireStations();

	for (int i = 0; i < fireStations.size(); i++) {
	    if ( (adresse != null && adresse.equals(fireStations.get(i).getAddress()))
	    	||(id != null && id.equals(fireStations.get(i).getStation()) ))
		     {
	    	result = true;
		fireStations.remove(i);
	    }
	}
	return result;
    }

}