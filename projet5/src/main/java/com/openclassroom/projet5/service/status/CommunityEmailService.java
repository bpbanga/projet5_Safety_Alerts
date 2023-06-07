package com.openclassroom.projet5.service.status;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassroom.projet5.model.Persons;
import com.openclassroom.projet5.model.status.CommunityEmail;
import com.openclassroom.projet5.repository.IDAOJson;

/*
 * Format data from DTO into CommunityEmail
 */
@Service
public class CommunityEmailService implements ICommunityEmailService {
    @Autowired
    private IDAOJson DTOjson;
    private static final Logger logger = LogManager.getLogger("CommunityEmailService");

    /*
     * @Param String city
     */
    @Override
    public List<CommunityEmail> getCommunityEmail(String city) {
	List<CommunityEmail> resultCommunityEmail = new ArrayList<CommunityEmail>();
	List<Persons> persons = DTOjson.getJsonData().getPersons();

	// Looping through persons to filter out the person living in the city and
	// adding the mail to the list of CommunityEmail
	for (Persons person : persons) {
	    if (person.getCity().equals(city)) {
		resultCommunityEmail.add(new CommunityEmail(person.getEmail()));
	    }
	}

	return resultCommunityEmail;
    }

}
