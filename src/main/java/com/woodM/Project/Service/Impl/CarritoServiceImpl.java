package com.woodM.Project.Service.Impl;

import java.util.List;

import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.woodM.Project.Domain.Carrito;
import com.woodM.Project.Service.CarritoService;
import com.woodM.Project.repositorie.CarritoRepo;

@Service
public class CarritoServiceImpl implements CarritoService{

	
	@Autowired
	CarritoRepo Repo;
	
	@PersistenceContext(unitName = "Project")
	
	@Override
	public List<Carrito> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return Repo.mostrarTodo();
	}

	@Override
	public void insertAndUpdate(Carrito c) throws DataAccessException {
		// TODO Auto-generated method stub
		Repo.save(c);
	}

	@Override
	public void delete(Carrito c) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

}
