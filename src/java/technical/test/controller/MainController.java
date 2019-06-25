package technical.test.controller;

import java.sql.Timestamp;
import java.util.Date;
import technical.test.exception.NullException;
import technical.test.logger.LogType;
import technical.test.logger.UtilLogger;
import technical.test.model.LogEntry;
import technical.test.model.Model;
import technical.test.model.Planet;
import technical.test.model.Rebel;

/**
 * Main controller class
 *
 * @author Luis Gómez
 */
public class MainController {

    private final Model model;

    public MainController() {
        this.model = new Model();
    }

    /**
     * Prepare a LogEntry object for insertion into the database.
     *
     * @param name Rebel name
     * @param planet Planet name
     * @return true if the entry has been registered correctly, false in case of
     * error.
     * @throws NullException
     */
    public boolean register(String name, String planet) throws NullException {
        boolean success;
        UtilLogger.registerInfo(MainController.class, LogType.INFO,
                "Start register function");
        try {
            if (name != null && planet != null) {
                if (name.isEmpty()) {
                    UtilLogger.registerInfo(MainController.class, LogType.WARNING,
                                    "Name can not be empty");
                    success = false;
                } else {
                    if (planet.isEmpty()) {
                        UtilLogger.registerInfo(MainController.class, LogType.WARNING,
                                    "Planet can not be empty");
                        success = false;
                    } else {
                        Rebel r = new Rebel(name);
                        Planet p = new Planet(planet);
                        Date date = new Date();
                        Timestamp ts = new Timestamp(date.getTime());
                        LogEntry le = new LogEntry(r, p, ts);

                        int result = model.addLogEntry(le);

                        if (result == 1) {
                            success = true;
                            UtilLogger.registerInfo(MainController.class, LogType.DEBUG,
                                    "New logEntry: " + le.toString());
                        } else {
                            success = false;
                        }
                    }
                }
            } else {
                success = false;
            }
        } catch (NullPointerException ex) {
            success = false;
            throw new NullException(ex.getMessage());
        }
        UtilLogger.registerInfo(MainController.class, LogType.INFO,
                "Finalize register function");
        return success;
    }
}
