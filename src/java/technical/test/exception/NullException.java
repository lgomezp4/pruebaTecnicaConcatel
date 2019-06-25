package technical.test.exception;

import technical.test.logger.LogType;
import technical.test.logger.UtilLogger;

/**
 * Custom Exception class
 * @author Luis Gómez
 */
public class NullException extends Exception{

    /**
     * Constructor
     * @param message information about the error
     */
    public NullException(String message) {
        super(message);
        UtilLogger.registerInfo(NullException.class, LogType.ERROR,
                message);
    }
    
}
