package EJBs;

import java.util.Date;

import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Stateless
@Entity
public class Notification {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int notid;
	private String message;
	
	@Temporal(TemporalType.DATE)
	private Date dateOfNOT;
	
	@ManyToOne
	private User user;
	
	public int getNotid() {
		return notid;
	}

	public void setNotid(int notid) {
		this.notid = notid;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDateOfNOT() {
		return dateOfNOT;
	}

	public void setDateOfNOT(Date dateOfNOT) {
		this.dateOfNOT = dateOfNOT;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	

}