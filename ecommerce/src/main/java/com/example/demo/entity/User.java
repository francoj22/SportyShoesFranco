package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Repository;

@Repository
@Entity
@Table(name = "users")
public class User {
	
    @Id
    @Column(name = "usersId")
	private int usersId;
	
    @Column(name = "firstName")
	private String firstName;

    @Column(name = "lastName")
	private String lastName;
	
    @Column(name = "email")
    private String email;
	
    @Column(name = "phone")
    private String phone;  
	
    @Column(name = "gender")
    private String gender;  
    
    public User() {
    	
    }
	
    public User(String firstName, String lastName, String email, String phone, String gender, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.password = password;
	}

	public int getUsersId() {
		return usersId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public String getGender() {
		return gender;
	}

	public String getPassword() {
		return password;
	}


	public void setUsersId(int usersId) {
		this.usersId = usersId;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	@Column(name = "password")
    private String password;
	

}