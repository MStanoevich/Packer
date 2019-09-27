package exceptions;

public class APIException extends Exception {

    public APIException(String message, Throwable throwable){
        super(message, throwable);
    }
}
