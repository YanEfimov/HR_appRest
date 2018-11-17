package com.mycom.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "vacancy")
public class Vacancy {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@DecimalMax("10000.0")
	@DecimalMin("200")
	@Column(name = "salaryto")
	private double salaryto;

	@DecimalMax("10000.0")
	@DecimalMin("200")
	@Column(name = "salaryfrom")
	private double salaryfrom;

	@DecimalMax("30.0")
	@DecimalMin("0.0")
	@Column(name = "experienceYearRequire")
	private double experienceYearRequire;

	@Size(min = 5)
	@Column(name = "position")
	private String position;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idDeveloper")
	private User user;

	@Expose(serialize = false)
	@NotNull
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "vacancyrequirement", joinColumns = @JoinColumn(name = "idVacancy"), inverseJoinColumns = @JoinColumn(name = "skill"))
	private Set<Skill> skills;

	@OneToMany(mappedBy = "vacancy", fetch = FetchType.LAZY)
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getSalaryto() {
		return salaryto;
	}

	public void setSalaryto(double salaryto) {
		this.salaryto = salaryto;
	}

	public double getSalaryfrom() {
		return salaryfrom;
	}

	public void setSalaryfrom(double salaryfrom) {
		this.salaryfrom = salaryfrom;
	}

	public double getExperienceYearRequire() {
		return experienceYearRequire;
	}

	public void setExperienceYearRequire(double experienceYearRequire) {
		this.experienceYearRequire = experienceYearRequire;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

}
