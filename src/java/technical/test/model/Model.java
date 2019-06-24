package technical.test.model;

import technical.test.model.persist.LogEntryDAO;

/**
 *
 * @author Luis Gómez
 */
public class Model {
    
    private LogEntryDAO logDAO;
    
    //constructor
    public Model() {
        logDAO = new LogEntryDAO();
    }
    
    /**
     * Adds a category into databe
     * @param logEntry to add
     * @return 1 if category adds successfuly, 0 if category already exist,
     * -1 in case of error
     */
    public int addLogEntry(LogEntry logEntry){
        int result = logDAO.register(logEntry);
        return result;
    }
}
