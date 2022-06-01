package service;



import javax.ejb.EJB;
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

@Stateless
@Path("/stations")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON )
public class Stationservice {
	@EJB
	Station station;
	@PersistenceContext(unitName="hello")
	EntityManager entitymanger;
	
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
		
		
		
}}