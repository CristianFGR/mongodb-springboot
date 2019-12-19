package cl.dataservices.domainmongo.service;

import cl.dataservices.domainmongo.exception.ResourceNotFoundException;
import cl.dataservices.domainmongo.model.Person;

import java.util.List;

/**
 * Created by cgonzalezr on 19-12-19.
 */
public interface PersonService {

    List<Person> getAllPersons();

    Person getPersonById(String id) throws ResourceNotFoundException;

    String setPerson(Person person);

    String deletePerson(String id) throws ResourceNotFoundException;
}
