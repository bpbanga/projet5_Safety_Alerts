package com.openclassroom.projet5.model.status;


import java.util.List;

// flood/stations?
public class FloodStation {
    public String address;
    public List<FloodStationsPerson> floodStationsPersons;

    public String getAddress() {
	return address;
    }

    public void setAddress(String address) {
	this.address = address;
    }

    public List<FloodStationsPerson> getFloodStationsPersons() {
	return floodStationsPersons;
    }

    public void setFloodStationsPersons(List<FloodStationsPerson> floodStationsPersons) {
	this.floodStationsPersons = floodStationsPersons;
    }

    public FloodStation(String address, List<FloodStationsPerson> floodStationsPersons) {
	super();
	this.address = address;
	this.floodStationsPersons = floodStationsPersons;
    }

    public FloodStation() {
	super();
    }
}