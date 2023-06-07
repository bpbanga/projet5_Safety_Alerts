package com.openclassroom.projet5.Service.status;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
    private static FireStations fireStationToAdd = new FireStations();

    @BeforeAll
    public static void setup() {
	fireStationToAdd.setAddress("Test Address");
	fireStationToAdd.setStation("2");
    }

    @AfterEach
    public void deleteAddedPerson() {
	fireStationService.deleteFireStation(fireStationToAdd);
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
	fireStationToEdit.setAddress("Test Address");
	fireStationToEdit.setStation("4");

	fireStationService.postFireStation(fireStationToAdd);
	fireStationService.putFireStation(fireStationToEdit);

	List<FireStations> listFireStation = fireStationService.getFireStations();
	assertEquals(listFireStation.get(listFireStation.size() - 1).getStation(), fireStationToEdit.getStation());
    }

    @Test
    public void shouldDeleteSuccessfullyPerson() {
	fireStationService.postFireStation(fireStationToAdd);
	fireStationService.deleteFireStation(fireStationToAdd);

	List<FireStations> listFireStation = fireStationService.getFireStations();
	assertFalse(listFireStation.get(listFireStation.size() - 1).getAddress().equals(fireStationToAdd.getAddress()));
    }

}