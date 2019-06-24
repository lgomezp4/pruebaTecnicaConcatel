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

/**
 *
 * @author super
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
     * Add an alert
     *
     * @param name to add
     * @param planet secure the method for logged in user
     * @return Json with message and result code. Code: 1 OK,
     * -1 Parameter error, -10 invalid token, -11 expired token, -12
     * Error assigning token.
     */
    @POST
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String registerRebelIdentification(@FormParam("name") String name, 
            @FormParam("planet") String planet) {
        String result;
        boolean success = controller.register(name, planet);
        
        if(success) result = "true";
        else result = "false";
        
        return result;
    }
}
