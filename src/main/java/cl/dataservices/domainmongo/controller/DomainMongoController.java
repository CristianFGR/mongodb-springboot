package cl.dataservices.domainmongo.controller;

import cl.dataservices.domainmongo.domain.Response;
import cl.dataservices.domainmongo.exception.ResourceNotFoundException;
import cl.dataservices.domainmongo.model.Person;
import cl.dataservices.domainmongo.service.PersonService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by cgonzalezr on 18-12-19.
 */
@RestController
@RequestMapping("/persons")
public class DomainMongoController {

    @Autowired
    private PersonService personService;

    @ApiOperation(value = "Obtiene el listado de personas almacenadas en mongoDB", response = Person.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Correo enviado satisfactoriamente", response = Response.class)
    })
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Person>> getAllPersons() {
        return new ResponseEntity<>(personService.getAllPersons(), HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene persona almacenada en mongoDB mediante el id", response = Person.class)
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Error al obtener los datos mediante el id",
                    response = Response.class),
            @ApiResponse(code = 200, message = "Persona obtenida satisfactoriamente", response = Person.class)
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Person> getPersonById(@PathVariable("id") String id) throws ResourceNotFoundException {
        return new ResponseEntity<>(personService.getPersonById(id), HttpStatus.OK);
    }

    @ApiOperation(value = "Crea persona el listado de personas almacenadas en mongoDB", response = Response.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Correo enviado satisfactoriamente", response = Response.class)
    })
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Response> setPerson(@RequestBody Person person){
        return new ResponseEntity<>(new Response(personService.setPerson(person), HttpStatus.OK.value()), HttpStatus.OK);
    }

    @ApiOperation(value = "Elimina persona almacenada en mongoDB mediante el id", response = Response.class)
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Error, no se encontro data para eliminar",
                    response = Response.class),
            @ApiResponse(code = 200, message = "Persona eliminada satisfactoriamente", response = Response.class)
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Response> deletePerson(@PathVariable String id) throws ResourceNotFoundException {
        return new ResponseEntity<>(new Response(personService.deletePerson(id), HttpStatus.OK.value()), HttpStatus.OK);
    }

}
