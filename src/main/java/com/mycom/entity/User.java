package com.mycom.entity;

import com.mycom.entity.validation.Name;
import com.mycom.entity.validation.Password;
import com.mycom.entity.validation.Email;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Name
	@Column(name = "name")
	private String name;

	@Name
	@Column(name = "surname")
	private String surname;

	@Email
	@Column(name = "email")
	private String email;

	@Password
	@Column(name = "password")
	private String password;

	@Column(name = "role")
	private String role;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "interviewer")
	private Set<FeedBack> fedbacks;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private Set<Vacancy> vacancys;

	public Set<Vacancy> getVacancys() {
		if (this.vacancys == null) {
			this.vacancys = new HashSet<Vacancy>();
		}
		return vacancys;
	}

	public void setVacancys(Set<Vacancy> vacancys) {
		this.vacancys = vacancys;
	}

	public Set<FeedBack> getFedbacks() {
		if (this.fedbacks == null) {
			this.fedbacks = new HashSet<FeedBack>();
		}
		return fedbacks;
	}

	public void setFedbacks(Set<FeedBack> fedbacks) {
		this.fedbacks = fedbacks;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
