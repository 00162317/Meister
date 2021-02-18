package com.woodM.Project.Dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.woodM.Project.Domain.*;

public interface OrdenCompraDAO {
	
	public List<OrdenCompra> findAll() throws DataAccessException;
	
	public void save(OrdenCompra c) throws DataAccessException;
	
	public void update(OrdenCompra c) throws DataAccessException;
	
	public void delete(OrdenCompra c) throws DataAccessException;

}
