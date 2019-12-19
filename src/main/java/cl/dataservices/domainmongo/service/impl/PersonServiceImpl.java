package cl.dataservices.domainmongo.service.impl;

import cl.dataservices.domainmongo.exception.ResourceNotFoundException;
import cl.dataservices.domainmongo.model.Person;
import cl.dataservices.domainmongo.repository.PersonRepository;
import cl.dataservices.domainmongo.service.PersonService;
import cl.dataservices.domainmongo.util.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cgonzalezr on 19-12-19.
 */
@Service
public class PersonServiceImpl implements PersonService {

    private static final String SAVED_PERSON = "Dato almacenado correctamente";
    private static final String DELETED_PERSON = "Dato eliminado correctamente";

    @Autowired
    private PersonRepository repository;

    @Override
    public List<Person> getAllPersons() {
        return repository.findAll();
    }

    @Override
    public Person getPersonById(String id) throws ResourceNotFoundException {
        return repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User not found with userId " + id));
    }

    @Override
    public String setPerson(Person person) {
        person.setId(RandomUtil.unique());
        repository.save(person);
        return SAVED_PERSON;
    }

    @Override
    public String deletePerson(String id) throws ResourceNotFoundException {
        repository.delete(getPersonById(id));
        return DELETED_PERSON;
    }
}
