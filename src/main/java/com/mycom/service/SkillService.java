package com.mycom.service;

import java.util.List;

import com.mycom.entity.Skill;
import com.mycom.tdt.Skilldto;

public interface SkillService {
	public List<Skill> findAll();
	public void insert(Skill skill);
	public void delete(String name);
}
