package EJBs;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
