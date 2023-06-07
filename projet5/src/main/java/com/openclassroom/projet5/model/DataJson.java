package com.openclassroom.projet5.model;
import java.util.List;


import lombok.Data;

@Data

public class DataJson {

	    List<Persons> persons;
	    List<FireStations> firestations;
	    List<MedicalRecords> medicalrecords;

	    public DataJson() {
		super();
	    }

	    public DataJson(List<Persons> persons, List<FireStations> firestations, List<MedicalRecords> medicalrecords) {
		super();
		this.persons = persons;
		this.firestations = firestations;
		this.medicalrecords = medicalrecords;
	    }
	    public List<Persons> getPersons() {
	    	return persons;
	        }

	        public void setPersons(List<Persons> persons) {
	    	this.persons = persons;
	        }

	        public List<FireStations> getFirestations() {
	    	return firestations;
	        }

	        public void setFirestations(List<FireStations> firestations) {
	    	this.firestations = firestations;
	        }

	        public List<MedicalRecords> getMedicalrecords() {
	    	return medicalrecords;
	        }

	        public void setMedicalrecords(List<MedicalRecords> medicalrecords) {
	    	this.medicalrecords = medicalrecords;
	        }


	

}
