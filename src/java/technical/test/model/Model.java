package technical.test.model;

import technical.test.exception.NullException;
import technical.test.logger.LogType;
import technical.test.logger.UtilLogger;
import technical.test.model.persist.LogEntryDAO;

/**
 * Model for Back End Exam
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
     * Adds an LogEntry into databe.
     *
     * @param logEntry to add
     * @return 1 if logEntry adds successfuly, 0 in case of error.
     */
    public int addLogEntry(LogEntry logEntry) throws NullException {
        UtilLogger.registerInfo(Model.class, LogType.INFO,
                "Start addLogEntry function");
        int result = logDAO.insertEntry(logEntry);
        UtilLogger.registerInfo(Model.class, LogType.INFO,
                "Finalize addLogEntry function");
        return result;
    }
}
