package service;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import EJBs.Station;
import EJBs.Trip;
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
		
		if (dpassword.equals(password) && (dusername.equals(uname))) {
			
			resultoflogin= "login successfully";
			
		}
		
		else {
			
			resultoflogin="login failed";
		}
	
		return resultoflogin;
		
	}
	

	@GET
	@Path("getuser")
	public List<User> searchUser(){
	Query query = entitymanger.createQuery("SELECT (u) from User u");
	List<User> result = query.getResultList();
	return result;
	}
	
	
	@POST
	@Path("createstation")
	public String Create_Station(Station s) {
		
		
		try
		{
			
			entitymanger.persist(s);
			return "station added successfully";

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
	

	

	@POST
	@Path("trip")
	public String Create_Trip(Trip t) {
		
		
		try
		{   
			/*Station t1 = (Station) entitymanger.find(Station.class, t.getTo_station());
			
			Station t2 = (Station) entitymanger.find(Station.class, t.getFrom_station());
            t.setFromstation(t2);
            t.setTostation(t1);*/
          
			entitymanger.persist(t);
			return "trip added successfully";

		}
		catch (Exception e) {
		
				
			throw new EJBException(e);
                         }
		
	}
	
	
	@POST
	@Path("searchtrips")
	public List<Trip> searchTrip(Trip t){
	
	
	Query query = entitymanger.createQuery("SELECT (t) FROM Trip t WHERE t.departure_time >=:fromDate and t.arrival_time <=:toDate");
	query.setParameter("fromDate",t.getDeparture_time());
	query.setParameter("toDate",t.getArrival_time());
	List<Trip> result = query.getResultList();
	return result;
	}
	
	

	@POST
	@Path("booktrip")
	public String bookTrip(User u ,Trip t) {
		try
		{
			
			entitymanger.persist(t);
			return "Trip booked successfully";

		}
		catch (Exception e) {
			throw new EJBException(e);
                         }
	
	}
	}