package REST_Utilities;

import java.lang.Exception;

public class DuplicateUserException extends Exception {

    public DuplicateUserException(String message){
        super(message);
    }

}