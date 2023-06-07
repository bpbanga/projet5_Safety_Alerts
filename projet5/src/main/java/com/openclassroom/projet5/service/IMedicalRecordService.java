package com.openclassroom.projet5.service;
import java.util.List;
import com.openclassroom.projet5.model.*;


public interface IMedicalRecordService {



	    List<MedicalRecords> getMedicalRecords();

	    void postMedicalRecord(MedicalRecords medicalRecordToAdd);

	    void putMedicalRecord(MedicalRecords medicalRecordToUpdate);

	    void deleteMedicalRecord(MedicalRecords medicalRecordToDelete);

}


