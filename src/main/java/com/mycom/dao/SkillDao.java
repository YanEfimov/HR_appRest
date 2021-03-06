package com.mycom.dao;

import com.mycom.entity.Skill;
import com.mycom.tdt.Skilldto;

import java.util.List;

public interface SkillDao {

	public List<Skill> findAll();

	public void insert(Skill skill);

	public void delete(String name);
}
