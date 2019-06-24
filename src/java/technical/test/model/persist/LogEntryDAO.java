package technical.test.model.persist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import technical.test.model.LogEntry;

/**
 *
 * @author Luis Gómez
 */
public class LogEntryDAO implements LogEntryDAOInterface{

    private final DbConnect dbConnect;
    
    private final String ADD_RECORD = "insert into logEntry (name, planet, datetime) values (?, ?, ?)";
    
    /**
     * Constructor
     */
    public LogEntryDAO() {
        dbConnect = DbConnect.getInstance();
    }

    @Override
    public int register(LogEntry logEntry) {
        int resultCode;
        try(Connection conn = dbConnect.getConnection()){
            if (conn != null) {
                PreparedStatement insertLogEntry = conn.prepareStatement(ADD_RECORD);
                insertLogEntry.setString(1, logEntry.getRebel().getName());
                insertLogEntry.setString(2, logEntry.getPlanet().getName());
                insertLogEntry.setTimestamp(3, logEntry.getDate());
                resultCode = insertLogEntry.executeUpdate();              
            }else{
                resultCode = 0;
            }
        }catch(SQLException ex){
            resultCode = 0;
        }
        
        return resultCode;
    }

 
}
