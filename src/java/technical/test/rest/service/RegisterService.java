package technical.test.rest.service;

import javax.servlet.ServletContext;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.core.MediaType;
import technical.test.controller.MainController;
import technical.test.exception.NullException;
import technical.test.logger.LogType;
import technical.test.logger.UtilLogger;

/**
 * REST Web Service for register rebellious conquests.
 * 
 * @author Luis Gómez
 */
@Path("/register")
public class RegisterService {

    private final MainController controller;

    public RegisterService(@Context ServletContext context) {
        if (context.getAttribute("controller") != null) {
            controller = (MainController) context.getAttribute("controller");
        } else {
            controller = new MainController();
        }
    }

    /**
     * Adds logEntry
     *
     * @param name Rebel name
     * @param planet Planet name
     * @return true if logEntry is registered successfully, false in case of error. 
     */
    @POST
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String registerRebelIdentification(@FormParam("name") String name,
            @FormParam("planet") String planet) throws NullException {
        String result;
        UtilLogger.registerInfo(RegisterService.class, LogType.INFO,
                "Start registerRebelIdentification function");
        try {          
            boolean success = controller.register(name, planet);           
            if (success) {
                result = "true";              
            } else {
                result = "false";
            }
        } catch (NullPointerException ex) {
            result = "false";
            throw new NullException(ex.getMessage());
        } catch (IllegalStateException ex){
            UtilLogger.registerInfo(RegisterService.class, LogType.ERROR,
                ex.getMessage());
            result = "false";
        }
        UtilLogger.registerInfo(RegisterService.class, LogType.INFO,
                "Finalize registerRebelIdentification function");
        return result;
    }
}
