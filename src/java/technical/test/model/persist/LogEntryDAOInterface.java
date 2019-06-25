package technical.test.model.persist;

import technical.test.exception.NullException;
import technical.test.model.LogEntry;

/**
 * LogEntry DAO Interface
 * 
 * @author Luis Gómez
 */
public interface LogEntryDAOInterface {
    
    /**
     * Adds a new logEntry into datebase
     * @param logEntry to be insered
     * @return number of rows insered
     * @throws NullException 
     */
    int insertEntry(LogEntry logEntry) throws NullException;
    
}
