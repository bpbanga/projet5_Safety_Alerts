package com.openclassroom.projet5.Service.status;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.openclassroom.projet5.model.status.ChildAlert;
import com.openclassroom.projet5.service.status.IChildAlertService;


@SpringBootTest
public class ChildAlertServiceTest {
    @Autowired
    private IChildAlertService childAlertService;

    @Test
    public void shouldRetrieveCorrectChildrenList() {
	List<ChildAlert> childAlertTestResult = childAlertService.getChildAlert("1509 Culver St");

	assertEquals(childAlertTestResult.get(0).getFirstName(), "Tenley");
	assertEquals(childAlertTestResult.get(0).getLastName(), "Boyd");
	assertNotNull(childAlertTestResult.get(0).getFamilyMembers());
    }

}
