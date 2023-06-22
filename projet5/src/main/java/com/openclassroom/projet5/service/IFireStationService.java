package com.openclassroom.projet5.service;
import java.util.List;
import com.openclassroom.projet5.model.*;


public interface IFireStationService {

	    public List<FireStations> getFireStations();

	    public void postFireStation(FireStations fireStationToAdd);

	    public void putFireStation(FireStations fireStationToUpdate);

	    public boolean deleteFireStation(String address, String id);
	
}
