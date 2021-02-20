package com.woodM.Project.Service.Impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.woodM.Project.Domain.About_us;
import com.woodM.Project.Service.AboutUs_Service;
import com.woodM.Project.repositorie.AboutUs_Repo;

@Service
public class AboutUs_ServiceImpl implements AboutUs_Service{

	@Autowired
	AboutUs_Repo Repo;
	
	@PersistenceContext(unitName = "Project")
	EntityManager entityManager;
	
	@Override
	public List<About_us> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return Repo.mostrarTodo();
	}

	@Override
	public void insertAndUpdate(About_us c) throws DataAccessException {
		// TODO Auto-generated method stub
		Repo.save(c);
	}

	@Override
	public void delete(About_us c) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

}
