package com.mycom.tdt;

import java.util.Date;

public class Interviewdto {
	private Date factdate;
	private Date plandate;
	private Vacancydto vacancy;
	private Candidatedto candidate;
	private String name;

	public Interviewdto(Date factdate, Date plandate, Vacancydto vacancy, Candidatedto candidate, String name) {
		this.factdate = factdate;
		this.plandate = plandate;
		this.vacancy = vacancy;
		this.candidate = candidate;
		this.name = name;
	}

	public Date getFactdate() {
		return factdate;
	}

	public void setFactdate(Date factdate) {
		this.factdate = factdate;
	}

	public Date getPlandate() {
		return plandate;
	}

	public void setPlandate(Date plandate) {
		this.plandate = plandate;
	}

	public Vacancydto getVacancy() {
		return vacancy;
	}

	public void setVacancy(Vacancydto vacancy) {
		this.vacancy = vacancy;
	}

	public Candidatedto getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidatedto candidate) {
		this.candidate = candidate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
