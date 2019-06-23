package technical.test.model.persist;

import technical.test.model.LogEntry;

/**
 *
 * @author Luis Gómez
 */
public interface LogEntryDAOInterface {
    
    LogEntry selectById(int id);
    
    boolean register(LogEntry logEntry);
}
