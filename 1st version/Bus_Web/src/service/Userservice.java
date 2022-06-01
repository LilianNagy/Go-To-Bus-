package service;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import EJBs.User;
//import org.jboss.security.auth.spi.Users.User;
@Stateless
@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON )
public class Userservice {

		
	@PersistenceContext(unitName="hello")
	EntityManager entitymanger;

	
	
	
	@POST
	@Path("/register")
	
	public String register(User u) {
		try
		{
			
			entitymanger.persist(u);
			return "user added successfully";

		}
		catch (Exception e) {
			return e.getMessage();
		
				
      //  throw new EJBException(e);
                         }
		
		
		
		
		
	

	}
	
	@GET
	@Path("hello")
	public String getMssg() {
		User user=new User();
		return user.sayHello();
	}



}