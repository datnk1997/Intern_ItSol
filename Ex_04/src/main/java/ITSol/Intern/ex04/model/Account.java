package ITSol.Intern.ex04.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.*;

@Entity
@Table(name = "manager")
public class Account {
	@Id
	@Column(name = "account")
	private String nameaccount;
	@Column
	@NotEmpty(message = "Khong duoc de trong firstname ")
	private String firstname;
	@Column
	@NotEmpty(message = "khong duoc de trong lastname")
	private String lastname; 
	@Column
	@NotEmpty(message = " khong duoc de trong email")
	private String email;
	
	public Account(String nameaccount) {
		this.nameaccount = nameaccount;
	}
	public Account( String nameaccount, String firstname, String lastname, String email) {
		super();
		this.nameaccount = nameaccount;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
	}
	public Account() {
		// TODO Auto-generated constructor stub
	}
	
	public String getNameaccount() {
		return nameaccount;
	}
	public void setNameaccount(String nameaccount) {
		this.nameaccount = nameaccount;
	}
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
