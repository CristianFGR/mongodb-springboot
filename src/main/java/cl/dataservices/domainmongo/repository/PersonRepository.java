package cl.dataservices.domainmongo.repository;

import cl.dataservices.domainmongo.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by cgonzalezr on 18-12-19.
 */
@Repository
public interface PersonRepository extends MongoRepository<Person,String> {

    Optional<Person> findById(String id);
}
