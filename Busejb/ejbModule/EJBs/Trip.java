package EJBs;


import java.util.Set;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name="Trip")


public class Trip {
	
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)

private int trip_id;

String from_station;
String To_station;
int available_seats;







public int getAvailable_seats() {
	return available_seats;
}
public void setAvailable_seats(int available_seats) {
	this.available_seats = available_seats;
}
@ManyToOne
@JoinColumn(name="fromstation")
private Station fromstation;


@ManyToOne
@JoinColumn(name="tostation")
private Station tostation;



private String departure_time;
private String  arrival_time;






/*

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


private  Set <User> users;


@ManyToOne
private Station stat;
@ManyToMany
@JoinTable(name="trips",
joinColumns=@JoinColumn(name="tripId"),
inverseJoinColumns=@JoinColumn(name="userID"))

*/

public int getTripid() {
	return trip_id;
}
public void setTripid(int trip_id) {
	trip_id = trip_id;
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
	return To_station;
}
public void setTo_station(String to_station) {
	To_station = to_station;
}


/*
public Set <User> getUsers() {
	return users;
}
public void setUsers(Set <User> users) {
	this.users = users;
}*/

}