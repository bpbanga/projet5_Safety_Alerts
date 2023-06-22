package com.openclassroom.projet5.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.openclassroom.projet5.model.FireStations;
import com.openclassroom.projet5.service.IFireStationService;


/*
 * Controller for /firestation endpoint
 */
@RestController
public class FireStationController {
    @Autowired
    private IFireStationService FireStationService;
    private static final Logger logger = LogManager.getLogger("FireStationController");

    /*
     * Endpoint GET /firestation to return list of FireStations
     */
    @GetMapping("/firestation")
    public List<FireStations> listFireStations() {
	logger.info("GET request to /firestation");
	return FireStationService.getFireStations();
    }

    /*
     * Endpoint POST /firestation to add firestation
     * 
     * @param Firestation firestation
     */
    @PostMapping(value = "/firestation")
    public ResponseEntity<String> addFireStation(@RequestBody FireStations fireStation) {
	logger.info("POST request to /firestation");
	try {
	    if (fireStation.getAddress().equals(null)) {
		throw new Exception();
	    }
	    FireStationService.postFireStation(fireStation);
	    logger.info("FireStationService.postFireStation success");
	    return new ResponseEntity<String>("POST request to /firestation successful", HttpStatus.CREATED);
	} catch (Exception e) {
	    logger.error("FireStationService.postFireStation failed: Missing Values");
	    return new ResponseEntity<String>("POST request to /firestation failed: Missing Values",
		    HttpStatus.BAD_REQUEST);
	}
    }

    /*
     * Endpoint PUT /firestation to add firestation
     * 
     * @param Firestation firestation
     */
    @PutMapping(value = "/firestation")
    public ResponseEntity<String> updateFireStation(@RequestBody FireStations fireStation) {
	logger.info("PUT request to /firestation");
	try {
	    if (fireStation.getAddress().equals(null)) {
		throw new Exception();
	    }
	    FireStationService.putFireStation(fireStation);
	    logger.info("FireStationService.putFireStation success");
	    return new ResponseEntity<String>("PUT request to /firestation successful", HttpStatus.OK);
	} catch (Exception e) {
	    logger.error("FireStationService.putFireStation failed: Missing Values");
	    return new ResponseEntity<String>("PUT request to /firestation failed: Missing Values",
		    HttpStatus.BAD_REQUEST);
	}
    }

    /*
     * Endpoint Delete /firestation to add firestation
     * 
     * @param Firestation firestation
     */
    @DeleteMapping(value = "/firestation")
    public ResponseEntity<String> removeFireStation(@RequestBody FireStations fireStation) {
	logger.info("DELETE request to /firestation");
	try {
	    if (fireStation.getAddress().equals(null)) {
		throw new Exception();
	    }
	    FireStationService.deleteFireStation(fireStation);
	    logger.info("FireStationService.deleteFireStation success");
	    return new ResponseEntity<String>("DELETE request to /firestation successful", HttpStatus.OK);
	} catch (Exception e) {
	    logger.error("FireStationService.postFireStation failed: Missing Values");
	    return new ResponseEntity<String>("DELETE request to /firestation failed: Missing Values",
		    HttpStatus.BAD_REQUEST);
	}
    }

}

