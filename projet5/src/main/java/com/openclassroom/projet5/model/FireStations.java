package com.openclassroom.projet5.model;

import lombok.Data;

@Data
public class FireStations {
    public String address;
    public String station;

    public FireStations() {
	super();
    }
    public FireStations(String address, String station) {
    	super();
    	this.address = address;
    	this.station = station;
        }

        public String getAddress() {
    	return address;
        }

        public void setAddress(String address) {
    	this.address = address;
        }

        public String getStation() {
    	return station;
        }

        public void setStation(String station) {
    	this.station = station;
        }


}