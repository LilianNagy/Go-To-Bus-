package EJBs;

import java.util.Set;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Stateless
@LocalBean
@Entity
@Table(name="STATION")


public class Station {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	int id;
	private String name ;
	private String longitude;
	private String latitude;
	
	
	
	
	
	
	
	@OneToMany(mappedBy="fromstation" ,fetch=FetchType.LAZY)
	private Set<Trip> source;
	@OneToMany(mappedBy="tostation",fetch=FetchType.LAZY)
	private Set<Trip> destination;

	
	
	
	
	
	
public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}



public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getLongitude() {
	return longitude;
}
public void setLongitude(String longitude) {
	this.longitude = longitude;
}
public String getLatitude() {
	return latitude;
}
public void setLatitude(String latitude) {
	this.latitude = latitude;
}


	

}
