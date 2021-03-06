package com.woodM.Project.Service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.woodM.Project.Domain.*;

public interface OrdenCompraService {
	
	public List<OrdenCompra> findAll() throws DataAccessException;
	
	public void insertAndUpdate(OrdenCompra c) throws DataAccessException;
	
	
	public void delete(OrdenCompra c) throws DataAccessException;

}
