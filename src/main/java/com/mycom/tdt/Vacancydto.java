package com.mycom.tdt;

import java.util.List;

public class Vacancydto {
	private double salaryto;
	private double salaryfrom;
	private double experienceYear;
	private String position;
	private Userdto developer;
	private List<Skilldto> skills;

	public Vacancydto(double salaryto, double salaryfrom, double experienceYear, String position, Userdto developer, List<Skilldto> skills) {
		this.salaryto = salaryto;
		this.salaryfrom = salaryfrom;
		this.experienceYear = experienceYear;
		this.position = position;
		this.developer = developer;
		this.skills = skills;
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

	public double getExperienceYear() {
		return experienceYear;
	}

	public void setExperienceYear(double experienceYear) {
		this.experienceYear = experienceYear;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Userdto getDeveloper() {
		return developer;
	}

	public void setDeveloper(Userdto developer) {
		this.developer = developer;
	}

	public List<Skilldto> getSkills() {
		return skills;
	}

	public void setSkills(List<Skilldto> skills) {
		this.skills = skills;
	}
	

}
