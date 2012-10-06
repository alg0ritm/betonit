package domain.user;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User implements Serializable {
	
	private static final long serialVersionUID = -7733417984884960370L;
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;

	@Column(name = "email")
	private String email;

	@Column(name = "username")
	private String username;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "surname")
	private String surname;

	@Column(name = "password")
	private String password;
	
	@Column(name = "logins")
	private int logins;
	
	@Column(name = "last_login")
	private int lastLogin;
	
	@Column(name = "reset_token")
	private String reseToken;
	
	@Column(name = "registered")
	private Date registered;
	
	@Column(name = "balance")
	private int balance;
	
	@Column(name = "last_game_played")
	private Date lastGamePlayed;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getLogins() {
		return logins;
	}

	public void setLogins(int logins) {
		this.logins = logins;
	}

	public int getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(int lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getReseToken() {
		return reseToken;
	}

	public void setReseToken(String reseToken) {
		this.reseToken = reseToken;
	}

	public Date getRegistered() {
		return registered;
	}

	public void setRegistered(Date registered) {
		this.registered = registered;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public Date getLastGamePlayed() {
		return lastGamePlayed;
	}

	public void setLastGamePlayed(Date lastGamePlayed) {
		this.lastGamePlayed = lastGamePlayed;
	}
	
	public String toString() {
		return "Name: " + firstName + " " + surname + ", username: " + username + ", email: " + email;
	}
}