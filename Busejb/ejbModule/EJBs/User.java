package EJBs;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Typed;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Stateless
@LocalBean
@Entity
@Table(name="USER")


public class User {
   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long user_id ;
	
	public long getId() {
		return user_id;
	}

	public void setId(long id) {
		this.user_id = user_id;
	}

public List<Trip> usertrips;




//private int usertripid;
	
	@Size (min=2,max=15)
	private String username ;
	
	
	@Size (min=2,max=50)
	private String full_name ;
	
	private String password ;
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	
	
	private String role ;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public String sayHello() {
		return "Hello";
	}

	public List<Trip> getUsertrips() {
		return usertrips;
	}

	public void setUsertrips(Trip t) {
		usertrips.add(t);
	}

	/*public int getUsertripid() {
		return usertripid;
	}

	public void setUsertripid(int usertripid) {
		this.usertripid = usertripid;
	}*/
	
	
}