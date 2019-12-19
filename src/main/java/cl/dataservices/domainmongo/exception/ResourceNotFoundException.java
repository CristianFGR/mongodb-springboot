package cl.dataservices.domainmongo.exception;

/**
 * Created by cgonzalezr on 19-12-19.
 */
public class ResourceNotFoundException extends Exception {

    public ResourceNotFoundException(String error){
        super(error);
    }

}
