package com.mycom.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.Expose;
import com.mycom.entity.validation.Name;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "candidate")
public class Candidate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@DecimalMax("10000.0")
	@DecimalMin("200")
	@Column(name = "salary")
	private double salary;

	@Column(name = "birthday")
	private Date birthday;

	@Name
	@Column(name = "surname")
	private String surname;

	@Name
	@Column(name = "name")
	private String name;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "candidateState")
	private CandidateState candidateState;

	@NotNull
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "candidatecompetence", joinColumns = @JoinColumn(name = "idCandidate"), inverseJoinColumns = @JoinColumn(name = "skill"))
	private Set<Skill> skills;

	@OneToMany(mappedBy = "candidate", fetch = FetchType.LAZY)
	private Set<Interview> interviews;

	public Set<Interview> getInterviews() {
		if (this.interviews == null) {
			this.interviews = new HashSet<Interview>();
		}
		return interviews;
	}

	public void setInterviews(Set<Interview> interviews) {
		this.interviews = interviews;
	}

	public Set<Skill> getSkills() {
		if (this.skills == null) {
			this.skills = new HashSet<Skill>();
		}
		return skills;
	}

	public void setSkills(Set<Skill> skills) {
		this.skills = skills;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CandidateState getCandidateState() {
		return candidateState;
	}

	public void setCandidateState(CandidateState candidateState) {
		this.candidateState = candidateState;
	}

}
