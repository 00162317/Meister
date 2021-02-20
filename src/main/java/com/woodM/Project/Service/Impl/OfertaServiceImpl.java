package com.woodM.Project.Service.Impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.woodM.Project.Domain.Oferta;
import com.woodM.Project.Service.OfertaService;
import com.woodM.Project.repositorie.OfertaRepo;

@Service
public class OfertaServiceImpl implements OfertaService {

	@Autowired
	OfertaRepo Repo;
	
	@PersistenceContext(unitName = "Project")
	EntityManager entityManager;
	
	@Override
	public List<Oferta> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return Repo.mostrarTodo();
	}

	@Override
	public void delete(Oferta c) throws DataAccessException {
		// TODO Auto-generated method stub
	}

	@Override
	public void insertAndUpdate(Oferta c) throws DataAccessException {
		// TODO Auto-generated method stub
		Repo.save(c);
	}

}
