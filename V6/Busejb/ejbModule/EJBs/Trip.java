package EJBs;


import java.util.Set;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Stateless
@LocalBean
@Entity

public class Trip {
	
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)

private int Tripid;

String from_station;
String to_station;
int available_seats;
String departure_time;
String  arrival_time;


@ManyToOne
@JoinColumn(name="fromstation")
private Station fromstation;


@ManyToOne
@JoinColumn(name="tostation")
private Station tostation;



public Station getFromstation() {
	return fromstation;
}
public void setFromstation(Station fromstation) {
	this.fromstation = fromstation;
}
public Station getTostation() {
	return tostation;
}
public void setTostation(Station tostation) {
	this.tostation = tostation;
}

/*
private  Set <User> users;

@ManyToOne
private Station stat;
@ManyToMany
@JoinTable(name="trips",
joinColumns=@JoinColumn(name="tripId"),
inverseJoinColumns=@JoinColumn(name="userID"))

*/

public int getTripid() {
	return Tripid;
}
public void setTripid(int tripid) {
	Tripid = tripid;
}
public String getDeparture_time() {
	return departure_time;
}
public void setDeparture_time(String departure_time) {
	this.departure_time = departure_time;
}
public String getArrival_time() {
	return arrival_time;
}
public void setArrival_time(String arrival_time) {
	this.arrival_time = arrival_time;
}

public String getFrom_station() {
	return from_station;
}
public void setFrom_station(String from_station) {
	this.from_station = from_station;
}
public String getTo_station() {
	return to_station;
}
public void setTo_station(String to_station) {
	to_station = to_station;
}

public int getSeatsNum() {
	return available_seats;
}
public void setSeatsNum(int available_seats) {
	this.available_seats = available_seats;
}
/*
public Set <User> getUsers() {
	return users;
}
public void setUsers(Set <User> users) {
	this.users = users;
}*/

}
