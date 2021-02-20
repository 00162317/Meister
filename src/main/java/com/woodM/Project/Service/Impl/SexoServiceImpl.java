package com.woodM.Project.Service.Impl;

import java.util.List;

import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.woodM.Project.Domain.Sexo;
import com.woodM.Project.Service.SexoService;
import com.woodM.Project.repositorie.SexoRepo;

@Service
public class SexoServiceImpl implements SexoService{

	@Autowired
	SexoRepo Repo;
	
	@PersistenceContext(unitName = "Project")
	
	@Override
	public List<Sexo> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return Repo.mostrarTodo();
	}

	@Override
	public void insertAndUpdate(Sexo c) throws DataAccessException {
		// TODO Auto-generated method stub
		Repo.save(c);
	}

	@Override
	public void delete(Sexo c) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

}
