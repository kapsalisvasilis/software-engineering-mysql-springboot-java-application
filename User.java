package texnologia.logismikou;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="users")

public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long professor_id;
	@Column(nullable = false, unique = true, length = 45)
	private String email;
	@Column(nullable = false, length=64)
	private String password;
	@Column(nullable = false, length=20)
	private String firstName;
	@Column(nullable = false, length=20)
	private String lastname;
	
	
	
	
	
	public long getId() {
		return professor_id;
	}
	public void setId(long id) {
		this.professor_id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
}
