package com.mycom.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "interview")
public class Interview {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "factDate")
	private Date factDate;

	@Column(name = "planDate")
	private Date planDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idVacancy")
	private Vacancy vacancy;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCandidate")
	private Candidate candidate;

	@Size(min = 5)
	@Column(name = "name")
	private String name;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "interview", fetch = FetchType.LAZY)
	private FeedBack feedback;

	public FeedBack getFeedback() {
		return feedback;
	}

	public void setFeedback(FeedBack feedback) {
		this.feedback = feedback;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFactDate() {
		return factDate;
	}

	public void setFactDate(Date factDate) {
		this.factDate = factDate;
	}

	public Date getPlanDate() {
		return planDate;
	}

	public void setPlanDate(Date planDate) {
		this.planDate = planDate;
	}

	public Vacancy getVacancy() {
		return vacancy;
	}

	public void setVacancy(Vacancy vacancy) {
		this.vacancy = vacancy;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
