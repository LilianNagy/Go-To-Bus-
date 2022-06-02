package EJBs;
import javax.ejb.Stateless;
import javax.enterprise.inject.Typed;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Stateless


public class User {
   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id ;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}



	@NotNull
	@Size (min=2,max=15)
	private String username ;
	
	@NotNull
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



	@NotNull
	
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
	
	
}