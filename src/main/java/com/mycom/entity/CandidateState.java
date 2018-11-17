package com.mycom.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "candidatestate")
public class CandidateState {

	@Id
	@Column(name = "name")
	private String name;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "candidateState")
	private transient Set<Candidate> candidates;

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
