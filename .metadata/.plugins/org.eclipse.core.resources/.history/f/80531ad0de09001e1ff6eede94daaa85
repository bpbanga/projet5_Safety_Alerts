package com.openclassroom.projet5.Service.status;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.openclassroom.projet5.model.status.FireStationCoverage;
import com.openclassroom.projet5.service.status.IFireStationCoverageService;


@SpringBootTest
public class FireStationCoverageServiceTest {
    @Autowired
    private IFireStationCoverageService fireStationCoverageService;

    @Test
    public void shouldRetrieveCorrectFireStationCoverage() {
	FireStationCoverage fireStationTestResult = fireStationCoverageService.getFireStationCoverage(2);

	assertEquals(fireStationTestResult.getAdultNumber(), 4);
	assertEquals(fireStationTestResult.getChildNumber(), 1);
	assertNotNull(fireStationTestResult.getFireStationCoveragePerson());

    }
}
