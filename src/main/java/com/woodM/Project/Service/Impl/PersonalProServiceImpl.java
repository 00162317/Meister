package com.woodM.Project.Service.Impl;

import java.util.List;

import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.woodM.Project.Domain.PersonalProfesional;
import com.woodM.Project.Service.PersonalProService;
import com.woodM.Project.repositorie.PersonalProRepo;

@Service
public class PersonalProServiceImpl implements PersonalProService{

	
	@Autowired
	PersonalProRepo Repo;
	
	@PersistenceContext(unitName = "Project")
	
	@Override
	public List<PersonalProfesional> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return Repo.mostrarTodo();
	}

	@Override
	public void insertAndUpdate(PersonalProfesional c) throws DataAccessException {
		// TODO Auto-generated method stub
		Repo.save(c);
	}


	@Override
	public void delete(PersonalProfesional c) throws DataAccessException {
		// TODO Auto-generated method stub
		Repo.delete(c);
	}

}
