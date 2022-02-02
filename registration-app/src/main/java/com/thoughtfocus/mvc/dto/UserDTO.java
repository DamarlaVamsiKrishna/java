package com.thoughtfocus.mvc.dto;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "login_details")
public class UserDTO implements Serializable {

	@Id
	@GenericGenerator(name = "myid", strategy = "increment")
	@GeneratedValue(generator = "myid")
	private int id;
	private String username;
	private String password;
	@Transient
	private String confirmpassword;
	private long mobilenumber;
	private double age;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmpassword() {
		return confirmpassword;
	}

	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}

	public long getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(long mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public double getAge() {
		return age;
	}

	public void setAge(double age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "UserDTO [username=" + username + ", password=" + password + ", confirmpassword=" + confirmpassword
				+ ", mobilenumber=" + mobilenumber + ", age=" + age + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, confirmpassword, id, mobilenumber, password, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDTO other = (UserDTO) obj;
		return Double.doubleToLongBits(age) == Double.doubleToLongBits(other.age)
				&& Objects.equals(confirmpassword, other.confirmpassword) && id == other.id
				&& mobilenumber == other.mobilenumber && Objects.equals(password, other.password)
				&& Objects.equals(username, other.username);
	}

}
