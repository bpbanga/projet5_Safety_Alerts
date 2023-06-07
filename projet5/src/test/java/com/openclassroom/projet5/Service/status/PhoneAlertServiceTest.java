package com.openclassroom.projet5.Service.status;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.openclassroom.projet5.model.status.PhoneAlert;
import com.openclassroom.projet5.service.status.IPhoneAlertService;


@SpringBootTest
public class PhoneAlertServiceTest {
    @Autowired
    private IPhoneAlertService phoneAlertService;

    @Test
    public void shouldRetrieveCorrectPhoneAlert() {
	List<PhoneAlert> phoneAlertResult = phoneAlertService.getPhoneAlert(1);

	assertEquals(phoneAlertResult.get(0).getPhone(), "841-874-6512");
	assertNotNull(phoneAlertResult);
    }

}