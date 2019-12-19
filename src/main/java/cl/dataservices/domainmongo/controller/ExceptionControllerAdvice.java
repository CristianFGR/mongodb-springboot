package cl.dataservices.domainmongo.controller;

import cl.dataservices.domainmongo.domain.Response;
import cl.dataservices.domainmongo.exception.ResourceNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by cgonzalezr on 19-12-19.
 */
@ControllerAdvice
@ResponseBody
public class ExceptionControllerAdvice {

    private static final Logger LOGGER = LogManager.getLogger(ExceptionControllerAdvice.class);

    /**
     * Metodo que captura la excepcion generada al no poder encontrar data para buscar
     * o eliminar.
     *
     * @param ex excepcion del tipo ResourceNotFoundException.
     * @return ResponseEntity<Response> con el error capturado y el codigo HTTP
     */
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Response> handlerException(ResourceNotFoundException ex) {
        LOGGER.error("Error al generar el envio de correo {} .", ex.getMessage());
        return new ResponseEntity<>(new Response(ex.getMessage(), HttpStatus.NO_CONTENT.value()),
                HttpStatus.NO_CONTENT);
    }
}

