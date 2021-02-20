package com.woodM.Project.Service.Impl;

import java.util.List;

import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.woodM.Project.Domain.OrdenCompra;
import com.woodM.Project.Service.OrdenCompraService;
import com.woodM.Project.repositorie.OrdenCompraRepo;

@Service
public class OrdenCompraServiceImpl implements OrdenCompraService{

	@Autowired
	OrdenCompraRepo Repo;
	
	@PersistenceContext(unitName = "Project")
	
	@Override
	public List<OrdenCompra> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return Repo.mostrarTodo();
	}

	@Override
	public void insertAndUpdate(OrdenCompra c) throws DataAccessException {
		// TODO Auto-generated method stub
		Repo.save(c);
	}


	@Override
	public void delete(OrdenCompra c) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

}
