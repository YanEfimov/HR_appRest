package com.mycom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycom.dao.SkillDao;
import com.mycom.entity.Skill;
import com.mycom.tdt.Skilldto;

@Service
@Transactional
public class SkillServiceImpl implements SkillService{
	
	@Autowired
	private SkillDao skilldao;

	@Override
	@Transactional
	public List<Skill> findAll() {
		return skilldao.findAll();
	}

	@Override
	@Transactional
	public void insert(Skill skill) {
		skilldao.insert(skill);
		
	}

	@Override
	@Transactional
	public void delete(String name) {
		skilldao.delete(name);
		
	}

}
