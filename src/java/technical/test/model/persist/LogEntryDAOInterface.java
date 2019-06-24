package technical.test.model.persist;

import java.sql.ResultSet;
import technical.test.model.LogEntry;

/**
 *
 * @author Luis Gómez
 */
public interface LogEntryDAOInterface {
     
    int register(LogEntry logEntry);
    
}
