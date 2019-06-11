package ITSol.Intern.ex04.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int idstudent;
	@Column(name = "name")
	private String fullname;
	@Column
	private String email;
	@Column
	private String phone;
	@Column(name = "classs")
	private String classs;
	@Column
	private String note;
	public Student(int idstudent, String fullname, String email, String phone, String classs, String note) {
		super();
		this.idstudent = idstudent;
		this.fullname = fullname;
		this.email = email;
		this.phone = phone;
		this.classs = classs;
		this.note = note;
	}
	
	public Student(String fullname, String email, String phone, String classs, String note) {
		super();
		this.fullname = fullname;
		this.email = email;
		this.phone = phone;
		this.classs = classs;
		this.note = note;
	}


	public Student() {
		// TODO Auto-generated constructor stub
	}

	public int getIdstudent() {
		return idstudent;
	}

	public void setIdstudent(int idstudent) {
		this.idstudent = idstudent;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getClasss() {
		return classs;
	}

	public void setClasss(String classs) {
		this.classs = classs;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "Student [idstudent=" + idstudent + ", fullname=" + fullname + ", email=" + email + ", phone=" + phone
				+ ", classs=" + classs + ", note=" + note + "]";
	}
	
	
}
