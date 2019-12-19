package cl.dataservices.domainmongo.controller;

import cl.dataservices.domainmongo.model.Person;
import cl.dataservices.domainmongo.repository.PersonRepository;
import cl.dataservices.domainmongo.util.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by cgonzalezr on 18-12-19.
 */
@RestController
@RequestMapping("/persons")
public class DomainMongoController {

    @Autowired
    private PersonRepository repository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Person> getAllPersons() {
        return repository.findAll();
    }

    /*@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Person getPersonById(@PathVariable("id") String id) {
        return repository.findOne(id);
    }*/

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void setPerson(@RequestBody Person person){
        person.setId(RandomUtil.unique());
        repository.save(person);
    }

}
