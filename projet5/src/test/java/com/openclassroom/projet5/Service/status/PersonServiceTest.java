package com.openclassroom.projet5.Service.status;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.openclassroom.projet5.model.Persons;
import com.openclassroom.projet5.service.IPersonsService;


@SpringBootTest
public class PersonServiceTest {

    @Autowired
    private IPersonsService personService;
    private static String idPerson ;
   
    private static Persons personToAdd = new Persons();;

    @BeforeAll
    public static void setup() {
	personToAdd.setFirstName("John");
	personToAdd.setLastName("Doe");
	personToAdd.setPhone("0123456789");
	personToAdd.setEmail("john@doe.net");
	personToAdd.setAddress("11 Test Road");
	personToAdd.setZip("12345");
	personToAdd.setCity("City");
	idPerson = "John" + "Doe" ;
    }

    @AfterEach
    public void deleteAddedPerson() {
	personService.deletePerson(idPerson);
    }

    @Test
    public void shouldRetrieveNonEmptyPersonList() {
	assertNotNull(personService.getPersons());
    }

    @Test
    public void shouldAddSuccessfullyPerson() {
	personService.postPerson(personToAdd);

	List<Persons> listPerson = personService.getPersons();
	// Person added to the last index of the list
	assertEquals(listPerson.get(listPerson.size() - 1).getFirstName(), personToAdd.getFirstName());
    }

    @Test
    public void shouldEditSuccessfullyPerson() {
	Persons personToEdit = new Persons();
	personToEdit.setFirstName("John");
	personToEdit.setLastName("Doe");
	personToEdit.setPhone("9999999999");
	personToEdit.setAddress("11 Test Road");
	personToEdit.setCity("City");
	personToEdit.setEmail("john@doe.net");
	personToEdit.setZip("12345");

	personService.postPerson(personToAdd);
	personService.putPerson(personToEdit);

	List<Persons> listPerson = personService.getPersons();
	assertEquals(listPerson.get(listPerson.size() - 1).getPhone(), personToEdit.getPhone());
    }

    @Test
    public void shouldDeleteSuccessfullyPerson() {
	personService.postPerson(personToAdd);
	personService.deletePerson(idPerson);

	List<Persons> listPerson = personService.getPersons();
	assertFalse(listPerson.get(listPerson.size() - 1).getLastName().equals(personToAdd.getLastName()));
    }

}