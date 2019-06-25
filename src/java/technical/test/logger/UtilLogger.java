package technical.test.logger;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * UtilLogger class  
 * 
 * @author Luis Gómez
 */
public class UtilLogger {

    private static Logger log = Logger.getLogger(UtilLogger.class);

    /**
     * Takes the information to save in log
     * @param c
     * @param type
     * @param message 
     */
    @SuppressWarnings("rawtypes")    
    public static void registerInfo(Class c, LogType type, String message) {
        log = LogManager.getLogger(c);

        switch (type) {
            case DEBUG:
                log.debug(message);
                break;
            case ERROR:
                log.error(message);
                break;            
            case INFO:
                log.info(message);
                break;
            case WARNING:
                log.warn(message);
        }
    }
}
