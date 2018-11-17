package com.mycom.tdt;

import java.util.Date;
import java.util.List;

public class Candidatedto {
	private Long id;
	private String name;
	private String surname;
	private Date birthday;
	private double salary;
	private List<Skilldto> skills;
	private CandidateStatedto candidateState;

	public Candidatedto(Long id, String name, String surname, Date birthday, double salary, List<Skilldto> skills,
			CandidateStatedto state) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.birthday = birthday;
		this.salary = salary;
		this.skills = skills;
		this.candidateState = state;
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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public List<Skilldto> getSkills() {
		return skills;
	}

	public void setSkills(List<Skilldto> skills) {
		this.skills = skills;
	}

	public CandidateStatedto getState() {
		return candidateState;
	}

	public void setState(CandidateStatedto state) {
		this.candidateState = state;
	}

}
