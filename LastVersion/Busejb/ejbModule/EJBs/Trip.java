package EJBs;

import javax.persistence.Transient;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Stateless
@LocalBean
@Entity
@Table(name="Trip")


public class Trip {
	


private static final long serialVersionUID = 1L;

public String getFrom_date() {
	return from_date;
}
public void setFrom_date(String from_date) {
	this.from_date = from_date;
}
public String getTo_date() {
	return to_date;
}
public void setTo_date(String to_date) {
	this.to_date = to_date;
}
@Transient
private String from_date;

@Transient
String to_date;

	
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int Tripid;

String from_s;
String to_s;
String from_station;
String To_station;
int available_seats;

public String getFrom_s() {
	return from_s;
}
public void setFrom_s(String from_s) {
	this.from_s = from_s;
}
public String getTo_s() {
	return to_s;
}
public void setTo_s(String to_s) {
	this.to_s = to_s;
}

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

@Column(name="departure_time")

private String departure_time;

@Column(name="arrival_time")
private String  arrival_time;

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
	return To_station;
}
public void setTo_station(String to_station) {
	To_station = to_station;
}

}










