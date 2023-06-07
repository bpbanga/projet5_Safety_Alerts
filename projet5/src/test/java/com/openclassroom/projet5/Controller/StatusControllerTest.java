package com.openclassroom.projet5.Controller;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.openclassroom.projet5.controller.StatusController;
import com.openclassroom.projet5.service.status.IChildAlertService;
import com.openclassroom.projet5.service.status.ICommunityEmailService;
import com.openclassroom.projet5.service.status.IFireAddressAlertService;
import com.openclassroom.projet5.service.status.IFireStationCoverageService;
import com.openclassroom.projet5.service.status.IFloodStationsService;
import com.openclassroom.projet5.service.status.IPersonInfoService;
import com.openclassroom.projet5.service.status.IPhoneAlertService;


@WebMvcTest(controllers = StatusController.class)
public class StatusControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IFireStationCoverageService FireStationCoverageService;

    @MockBean
    private IChildAlertService ChildAlertService;

    @MockBean
    private IPhoneAlertService PhoneAlertService;

    @MockBean
    private IFireAddressAlertService FireAddressAlertService;

    @MockBean
    private IFloodStationsService FloodStationsService;

    @MockBean
    private IPersonInfoService PersonInfoService;

    @MockBean
    private ICommunityEmailService CommunityEmailService;

    @Test
    public void shouldListFireStationCoverage() throws Exception {
	mockMvc.perform(get("/firestation?stationNumber=4")).andExpect(status().isOk());
    }

    @Test
    public void shouldListChildAlert() throws Exception {
	mockMvc.perform(get("/childAlert?address=1509 Culver St")).andExpect(status().isOk());
    }

    @Test
    public void shouldListPhoneAlert() throws Exception {
	mockMvc.perform(get("/phoneAlert?firestation=1")).andExpect(status().isOk());
    }

    @Test
    public void shouldListFireAddressAlert() throws Exception {
	mockMvc.perform(get("/fire?address=1509 Culver St")).andExpect(status().isOk());
    }

    @Test
    public void shouldListFloodStations() throws Exception {
	mockMvc.perform(get("/flood/stations?stations=1,2,3")).andExpect(status().isOk());
    }

    @Test
    public void shouldListPersonInfo() throws Exception {
	mockMvc.perform(get("/personInfo?firstName=John&lastName=Boyd")).andExpect(status().isOk());
    }

    @Test
    public void shouldNotListPersonInfo() throws Exception {
	mockMvc.perform(get("/personInfo?firstName=John")).andExpect(status().isBadRequest());
    }

    @Test
    public void shouldListCommunityEmail() throws Exception {
	mockMvc.perform(get("/communityEmail?city=Culver")).andExpect(status().isOk());
    }

}
