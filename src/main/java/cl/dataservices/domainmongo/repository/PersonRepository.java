package cl.dataservices.domainmongo.repository;

import cl.dataservices.domainmongo.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by cgonzalezr on 18-12-19.
 */
public interface PersonRepository extends MongoRepository<Person,String> {

    //Person findOne(String id);
}
