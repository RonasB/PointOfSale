package integration;

/**
 * Exception that is thrown when a system has failed
 */
public class SystemFailureException extends RuntimeException {

    /**
     * Creates a new instance of the exception that notifies that the system has failed
     * @param msg The message that explains the failure
     */
    public SystemFailureException(String msg){
        super(msg);
    }
}
