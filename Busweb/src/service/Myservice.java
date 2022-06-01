package service;


import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import EJBs.Station;
import EJBs.User;
//import org.jboss.security.auth.spi.Users.User;
@Stateless
@Path("users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON )
public class Myservice {

		
	@PersistenceContext(unitName="hello")
	EntityManager entitymanger;

	
	
	
	@POST
	@Path("register")
	
	public String register(User u) {
		try
		{
			
			entitymanger.persist(u);
			return "user added successfully";

		}
		catch (Exception e) {
			throw new EJBException(e);
		
				
                         }
	
	}
	@POST
	@Path("login")
	public String login(User s){
		
		String resultoflogin;
	    String password= s.getPassword();
		String uname = s.getUsername();
		User u1= (User) entitymanger.createQuery("SELECT u from User u WHERE u.username= :UserName", User.class).setParameter("UserName", uname).getSingleResult();	
		
		String dpassword = u1.getPassword();
		String dusername=u1.getUsername();
		
		if (dpassword.equals(password) ) {
			
			resultoflogin= "login successfully";
			
		}
		else if (dusername.equals(uname)){
			
			resultoflogin= "login successfully";
			
		  }
		
		else {
			
			resultoflogin="login failed";
		  }
	
		return resultoflogin;
		
		
		
		
	}
	@GET
	@Path("hello")
	public String getMssg() {
		User user=new User();
		return user.sayHello();
	}
	@POST
	@Path("createstation")
	public String Create_Station(Station s) {
		
		
		try
		{
			
			entitymanger.persist(s);
			return "user added successfully";

		}
		catch (Exception e) {
		
				
			throw new EJBException(e);
                         }
		
	}

	@GET
	@Path("getstation/{id}")
	public Station getStation(@PathParam("id") int id) {
		return entitymanger.find(Station.class, id) ;
		
		
	
	}


}