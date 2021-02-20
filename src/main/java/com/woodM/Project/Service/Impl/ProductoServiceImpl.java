package com.woodM.Project.Service.Impl;

import java.util.List;

import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.woodM.Project.Domain.Producto;
import com.woodM.Project.Service.ProductoService;
import com.woodM.Project.repositorie.ProductoRepo;

@Service
public class ProductoServiceImpl implements ProductoService{

	
	@Autowired
	ProductoRepo Repo;
	
	@PersistenceContext(unitName = "Project")
	
	@Override
	public List<Producto> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return Repo.mostrarTodo();
	}

	@Override
	public void insertAndUpdate(Producto c) throws DataAccessException {
		// TODO Auto-generated method stub
		Repo.save(c);
	}

	@Override
	public void delete(Producto c) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

}
