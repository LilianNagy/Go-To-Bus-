package service;

import java.util.List;

import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
		
		if (dpassword.equals(password) & dusername.equals(uname) ) {
			
			resultoflogin= "login successfully";
			
		}
		
		else {
			
			resultoflogin="login failed";
		}
	
		return resultoflogin;
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
		
			entitymanger.persist(t);
			return "trip added successfully";

		}
		catch (Exception e) {
			throw new EJBException(e);
                         }
	}
	
	
 @GET
	@Path("gettrip/{id}")
	public Trip gettrip(@PathParam("id") int Tripid) {
		return entitymanger.find(Trip.class, Tripid) ;
		
		
	
	}
	
	public Station getStationById(int id) {
		return entitymanger.find(Station.class, id);
	}
	
	@POST
	@Path("searchtrips")
	
	public List<Trip> searchTrips(Trip tb ){
		
		
		try
		{ 
			
			TypedQuery<Trip>query = entitymanger.createQuery("select t from Trip  t  where t.departure_time >= ?2 and t.arrival_time <= ?1 and t.from_station like ?3 and t.To_station like ?4  ",Trip.class);
			query.setParameter(2,  tb.getFrom_date());
			query.setParameter(1,  tb.getTo_date());
			query.setParameter(3,  tb.getFrom_station());
			query.setParameter(4,  tb.getTo_station());
			List<Trip> trips = query.getResultList();
			return trips;
		
		}
		catch (Exception e) {
			throw new EJBException(e);
                         }
	}
	

	
}