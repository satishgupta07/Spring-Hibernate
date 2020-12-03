package com.satishkumar06.SpringORM.dao;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.satishkumar06.SpringORM.entities.Student;

public class StudentDao {
	
	private HibernateTemplate hibernateTemplate;
	
	//save studnet
	@Transactional
	public int insert(Student student) {
		
		//insert
		Integer i = (Integer)this.hibernateTemplate.save(student);
		return 1;
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
