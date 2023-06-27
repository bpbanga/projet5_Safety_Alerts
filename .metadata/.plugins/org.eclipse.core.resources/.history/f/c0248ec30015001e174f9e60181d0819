package com.openclassroom.projet5.Service.status;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.openclassroom.projet5.model.FireStations;
import com.openclassroom.projet5.service.IFireStationService;


@SpringBootTest
public class FireStationServiceTest {
    @Autowired
    private IFireStationService fireStationService;
    private static String idfireStationAddress ;
    private static String idfireStationNber ;

    

    private static FireStations fireStationToAdd = new FireStations();

    @BeforeAll
    public static void setup() {
	fireStationToAdd.setAddress("150955 Culver St");
	fireStationToAdd.setStation("2");
	idfireStationAddress = "150955 Culver St";
	idfireStationNber = "2";
    }

    @AfterEach
    public void deleteAddedFireStation() {
	fireStationService.deleteFireStation( idfireStationAddress , idfireStationNber );
    }

    @Test
    public void shouldRetrieveNonEmptyFireStationList() {
	assertNotNull(fireStationService.getFireStations());
    }

    @Test
    public void shouldAddSuccessfullyFireStation() {
	fireStationService.postFireStation(fireStationToAdd);

	List<FireStations> listFireStation = fireStationService.getFireStations();
	assertEquals(listFireStation.get(listFireStation.size() - 1).getAddress(), fireStationToAdd.getAddress());
    }

    @Test
    public void shouldEditSuccessfullyFireStation() {
    	FireStations fireStationToEdit = new FireStations();
	fireStationToEdit.setAddress(idfireStationAddress);
	fireStationToEdit.setStation("4");

	fireStationService.postFireStation(fireStationToAdd);
	fireStationService.putFireStation(fireStationToEdit);

	List<FireStations> listFireStation = fireStationService.getFireStations();
	assertEquals(listFireStation.get(listFireStation.size() - 1).getStation(), fireStationToEdit.getStation());
    }

    @Test
    public void shouldDeleteSuccessfullyFireStationByAdress() {
	fireStationService.postFireStation(fireStationToAdd);
	int nbStation = fireStationService.getFireStations().size();
	fireStationService.deleteFireStation(  idfireStationAddress, null );

	List<FireStations> listFireStation = fireStationService.getFireStations();
	assertTrue(listFireStation.size() == nbStation - 1);
    }
    
    @Test
    public void shouldDeleteSuccessfullyFireStationById() {
	fireStationService.postFireStation(fireStationToAdd);
	int nbStation = fireStationService.getFireStations().size();
	fireStationService.deleteFireStation(   null , idfireStationNber);

	List<FireStations> listFireStation = fireStationService.getFireStations();
	assertTrue(listFireStation.size() == nbStation - 1);
    }

}