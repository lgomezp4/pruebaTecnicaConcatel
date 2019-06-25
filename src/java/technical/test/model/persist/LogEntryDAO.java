package technical.test.model.persist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import technical.test.exception.NullException;
import technical.test.logger.LogType;
import technical.test.logger.UtilLogger;
import technical.test.model.LogEntry;

/**
 * LogEntro DAO class
 *
 * @author Luis Gómez
 */
public class LogEntryDAO implements LogEntryDAOInterface {

    private final DbConnect dbConnect;

    private final String ADD_RECORD = "insert into logEntry (name, planet, datetime) values (?, ?, ?)";

    /**
     * Constructor
     */
    public LogEntryDAO() {
        dbConnect = DbConnect.getInstance();
    }

    @Override
    public int insertEntry(LogEntry logEntry) throws NullException {
        UtilLogger.registerInfo(LogEntryDAO.class, LogType.INFO,
                "Start insertEntry function");
        int resultCode;
        try (Connection conn = dbConnect.getConnection()) {
            if (conn != null) {
                PreparedStatement insertLogEntry = conn.prepareStatement(ADD_RECORD);
                insertLogEntry.setString(1, logEntry.getRebel().getName());
                insertLogEntry.setString(2, logEntry.getPlanet().getName());
                insertLogEntry.setTimestamp(3, logEntry.getDate());
                resultCode = insertLogEntry.executeUpdate();
            } else {
                resultCode = 0;
            }
        } catch (SQLException ex) {
            resultCode = 0;
            UtilLogger.registerInfo(LogEntryDAO.class, LogType.ERROR,
                    ex.getMessage());
        } catch (NullPointerException ex) {
            resultCode = 0;
            throw new NullException(ex.getMessage());
        }
        UtilLogger.registerInfo(LogEntryDAO.class, LogType.INFO,
                "Finalize insertEntry function");
        return resultCode;
    }

}
