package com.openclassroom.projet5.Service.status;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.openclassroom.projet5.model.status.FloodStation;
import com.openclassroom.projet5.service.status.IFloodStationsService;


@SpringBootTest
public class FloodStationsServiceTest {
    @Autowired
    private IFloodStationsService floodStationsService;

    @Test
    public void shouldRetrieveCorrectFireStationCoverage() {
	List<Integer> testStationsList = new ArrayList<Integer>();
	testStationsList.add(1);
	testStationsList.add(2);
	List<FloodStation> floodStationsTestResult = floodStationsService.getFloodStation(testStationsList);

	assertEquals(floodStationsTestResult.get(0).getAddress(), "644 Gershwin Cir");
	assertNotNull(floodStationsTestResult.get(0).getFloodStationsPersons());
    }

}