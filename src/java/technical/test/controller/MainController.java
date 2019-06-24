package technical.test.controller;

import java.sql.Timestamp;
import java.util.Date;
import technical.test.model.LogEntry;
import technical.test.model.Model;
import technical.test.model.Planet;
import technical.test.model.Rebel;


/**
 *
 * @author Luis Gómez
 */
public class MainController {
    
    private Model model;

    public MainController() {
        this.model = new Model();
    }
    
    public boolean register(String name, String planet){
        boolean success;
        try{
            if(name != null && planet != null){
                Rebel r = new Rebel(name);
                Planet p = new Planet(planet);
                Date date = new Date();
                Timestamp ts = new Timestamp(date.getTime());
                LogEntry le = new LogEntry(r, p, ts);
                
                System.out.println(le.toString());
                
                int result = model.addLogEntry(le);                               
                
                if(result == 1) success = true;
                else success = false;
            }else{
                success = false;
            }
        }catch(Exception e){
            success = false;
        }
        
        return success;
    }
}
