package com.woodM.Project.Service.Impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.woodM.Project.Domain.TipoUsuario;
import com.woodM.Project.Service.TipoUsuarioService;
import com.woodM.Project.repositorie.TipoUsuarioRepo;

@Service
public class TipoUsuarioServiceImpl implements TipoUsuarioService {

	@Autowired
	TipoUsuarioRepo Repo;
	
	@PersistenceContext(unitName = "Project")
	EntityManager entityManager;
	
	@Override
	public List<TipoUsuario> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return Repo.mostrarTodo();
	}

	@Override
	public void insertAndUpdate(TipoUsuario c) throws DataAccessException {
		// TODO Auto-generated method stub
		Repo.save(c);
	}

	@Override
	public void delete(TipoUsuario c) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

}
