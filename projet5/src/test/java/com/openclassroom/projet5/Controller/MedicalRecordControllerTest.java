package com.openclassroom.projet5.Controller;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.openclassroom.projet5.controller.MedicalRecordController;
import com.openclassroom.projet5.service.MedicalRecordService;



@WebMvcTest(controllers = MedicalRecordController.class)
public class MedicalRecordControllerTest {
    final String contentBody = "{\"firstName\": \"John\", \"lastName\": \"Boyd\", \"birthdate\": \"01/01/1990\", \"medications\": [\"aznol:350mg\"], \"allergies\": [\"nillacilan\"]}";
    final String contentBodyWithoutFirstname = "{\"lastName\": \"Doe\", \"birthdate\": \"01/01/1990\", \"medications\": [\"aznol:350mg\"], \"allergies\": [\"nillacilan\"]}";
    final String id = "JohnDoe";
    final String contentBodyKo = "{\"firstName\": null, \"lastName\":null, \"birthdate\": \"01/01/1990\", \"medications\": [\"aznol:350mg\"], \"allergies\": [\"nillacilan\"]}";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MedicalRecordService medicalRecordService;

    @Test
    public void testGetMedicalRecord() throws Exception {
	mockMvc.perform(get("/medicalRecord")).andExpect(status().isOk());
    }

    @Test
    public void testPostMedicalRecord() throws Exception {
	mockMvc.perform(post("/medicalRecord").contentType(MediaType.APPLICATION_JSON).content(contentBody))
		.andExpect(status().isCreated());
    }

    @Test
    public void testPutMedicalRecord() throws Exception {
	mockMvc.perform(put("/medicalRecord").contentType(MediaType.APPLICATION_JSON).content(contentBody))
		.andExpect(status().isOk());
    }
    
    @Test
    public void testDeleteMedicalRecord() throws Exception {
    	Mockito.when(medicalRecordService.deleteMedicalRecord("JohnDoe")).thenReturn(true);
    	mockMvc.perform(delete("/medicalRecord")
    			.param("id", "JohnDoe")
    			.contentType(MediaType.APPLICATION_JSON))
		        .andExpect(status().isOk());
    }

    @Test
    public void testPostWrongMedicalRecord() throws Exception {
	mockMvc.perform(post("/medicalRecord").contentType(MediaType.APPLICATION_JSON).content(contentBodyWithoutFirstname))
		.andExpect(status().isBadRequest());
    }

    @Test
    public void testPutWrongMedicalRecord() throws Exception {
	mockMvc.perform(put("/medicalRecord").contentType(MediaType.APPLICATION_JSON).content(contentBodyWithoutFirstname))
		.andExpect(status().isBadRequest());
    }

    @Test
    public void testDeleteWrongMedicalRecord() throws Exception {
    	mockMvc.perform(delete("/medicalRecord").contentType(MediaType.APPLICATION_JSON).content(contentBodyWithoutFirstname))
		.andExpect(status().isBadRequest());
    }
    
    @Test
    public void testDeleteMedicalRecordNotFound() throws Exception {
    	Mockito.when(medicalRecordService.deleteMedicalRecord("JohnDoe")).thenReturn(false);
    	mockMvc.perform(delete("/medicalRecord")
    			.param("id", "JohnDoe")
    			.contentType(MediaType.APPLICATION_JSON))
		        .andExpect(status().isNotFound());
    }
    
    @Test
    public void testPostMedicalRecordKo() throws Exception {
	mockMvc.perform(post("/medicalRecord").contentType(MediaType.APPLICATION_JSON).content(contentBodyKo))
		.andExpect(status().isBadRequest());
    }
    
    @Test
    public void testPutMedicalRecordKo() throws Exception {
	mockMvc.perform(put("/medicalRecord").contentType(MediaType.APPLICATION_JSON).content(contentBodyKo))
		.andExpect(status().isBadRequest());
    }
    
    
    @Test
    public void testDeleteMedicalRecordKo() throws Exception {
    	mockMvc.perform(delete("/medicalRecord")
    			.param("id", "")
    			.contentType(MediaType.APPLICATION_JSON))
		        .andExpect(status().isBadRequest());
    }

}
