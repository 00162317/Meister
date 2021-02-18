package com.woodM.Project.Dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.woodM.Project.Domain.*;

public interface CarritoDAO {
	
	public List<Carrito> findAll() throws DataAccessException;
	
	public void save(Carrito c) throws DataAccessException;
	
	public void update(Carrito c) throws DataAccessException;
	
	public void delete(Carrito c) throws DataAccessException;

}
