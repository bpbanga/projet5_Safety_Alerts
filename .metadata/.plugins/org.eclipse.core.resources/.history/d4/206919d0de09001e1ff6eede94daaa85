package com.openclassroom.projet5.Service.status;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.openclassroom.projet5.model.status.CommunityEmail;
import com.openclassroom.projet5.service.status.ICommunityEmailService;


@SpringBootTest
public class CommunityEmailServiceTest {
    @Autowired
    private ICommunityEmailService communityEmailService;

    @Test
    public void shouldRetrieveCommunityEmailList() {
	List<CommunityEmail> testCommunityEmail = communityEmailService.getCommunityEmail("Culver");

	assertEquals(testCommunityEmail.get(0).getEmail(), "jaboyd@email.com");
    }
}