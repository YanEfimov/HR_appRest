package com.mycom.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.google.gson.annotations.*;

@Entity
@Table(name = "skill")
public class Skill {

	@Size(min = 1)
	@Id
	@Column(name = "name")
	private String name;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "candidatecompetence", joinColumns = @JoinColumn(name = "skill"), inverseJoinColumns = @JoinColumn(name = "IdCandidate"))
	private Set<Candidate> candidates;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "vacancyrequirement", joinColumns = @JoinColumn(name = "skill"), inverseJoinColumns = @JoinColumn(name = "idVacancy"))
	private transient Set<Vacancy> vacancys;

	public Set<Vacancy> getVacancys() {
		if (this.vacancys == null) {
			this.vacancys = new HashSet<Vacancy>();
		}
		return vacancys;
	}

	public void setVacancys(Set<Vacancy> vacancys) {
		this.vacancys = vacancys;
	}

	public Set<Candidate> getCandidates() {
		if (this.candidates == null) {
			this.candidates = new HashSet<Candidate>();
		}
		return candidates;
	}

	public void setCandidates(Set<Candidate> candidates) {
		this.candidates = candidates;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
