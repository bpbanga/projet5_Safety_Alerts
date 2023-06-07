package com.openclassroom.projet5.model.status;

import java.util.List;

import com.openclassroom.projet5.model.Persons;


//firestation?stationNumber
public class FireStationCoverage {
    public List<Persons> fireStationCoveragePerson;
    public Integer adultNumber;
    public Integer childNumber;

    public List<Persons> getFireStationCoveragePerson() {
	return fireStationCoveragePerson;
    }

    public void setFireStationCoveragePerson(List<Persons> fireStationCoveragePerson) {
	this.fireStationCoveragePerson = fireStationCoveragePerson;
    }

    public Integer getChildNumber() {
	return childNumber;
    }

    public void setChildNumber(Integer childNumber) {
	this.childNumber = childNumber;
    }

    public Integer getAdultNumber() {
	return adultNumber;
    }

    public void setAdultNumber(Integer adultNumber) {
	this.adultNumber = adultNumber;
    }

    public FireStationCoverage(List<Persons> fireStationCoveragePerson, Integer adultNumber, Integer childNumber) {
	super();
	this.fireStationCoveragePerson = fireStationCoveragePerson;
	this.adultNumber = adultNumber;
	this.childNumber = childNumber;
    }

    public FireStationCoverage() {
	super();
    }

}

