package com.openclassroom.projet5.Service.status;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.openclassroom.projet5.model.MedicalRecords;
import com.openclassroom.projet5.service.IMedicalRecordService;



@SpringBootTest
public class MedicalRecordServiceTest {

    @Autowired
    private IMedicalRecordService medicalRecordService;
    private static String idMedicalRecord ;
    private static MedicalRecords medicalRecordToAdd = new MedicalRecords();;

    @BeforeAll
    public static void setup() {

	medicalRecordToAdd.setFirstName("John");
	medicalRecordToAdd.setLastName("Doe");
	medicalRecordToAdd.setBirthdate("01/01/1990");
	medicalRecordToAdd.setMedications(Arrays.asList("aznol:350mg"));
	medicalRecordToAdd.setAllergies(Arrays.asList("nillacilan"));
	idMedicalRecord = "John" + "Doe";
    }

    @AfterEach
    public void deleteAddedMedicalRecord() {
	medicalRecordService.deleteMedicalRecord(idMedicalRecord);
    }

    @Test
    public void shouldRetrieveNonEmptyPersonList() {
	assertNotNull(medicalRecordService.getMedicalRecords());
    }

    @Test
    public void shouldAddSuccessfullyPerson() {
	medicalRecordService.postMedicalRecord(medicalRecordToAdd);

	List<MedicalRecords> listMedicalRecord = medicalRecordService.getMedicalRecords();
	assertEquals(listMedicalRecord.get(listMedicalRecord.size() - 1).getFirstName(),
		medicalRecordToAdd.getFirstName());
    }

    @Test
    public void shouldEditSuccessfullyPerson() {
	MedicalRecords medicalRecordToEdit = new MedicalRecords();
	medicalRecordToEdit.setFirstName("John");
	medicalRecordToEdit.setLastName("Doe");
	medicalRecordToEdit.setAllergies(Arrays.asList("nillacilan0"));

	medicalRecordService.postMedicalRecord(medicalRecordToAdd);
	medicalRecordService.putMedicalRecord(medicalRecordToEdit);

	List<MedicalRecords> listMedicalRecord = medicalRecordService.getMedicalRecords();
	assertEquals(listMedicalRecord.get(listMedicalRecord.size() - 1).getAllergies(),
		medicalRecordToEdit.getAllergies());
    }

    @Test
    public void shouldDeleteSuccessfullyPerson() {
	medicalRecordService.postMedicalRecord(medicalRecordToAdd);
	medicalRecordService.deleteMedicalRecord(idMedicalRecord);

	List<MedicalRecords> listMedicalRecord = medicalRecordService.getMedicalRecords();
	assertFalse(listMedicalRecord.get(listMedicalRecord.size() - 1).getLastName()
		.equals(medicalRecordToAdd.getLastName()));
    }

}