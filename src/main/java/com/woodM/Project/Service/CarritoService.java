package com.woodM.Project.Service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.woodM.Project.Domain.*;

public interface CarritoService {
	
	public List<Carrito> findAll() throws DataAccessException;
	
	public void insertAndUpdate(Carrito c) throws DataAccessException;
	
	
	public void delete(Carrito c) throws DataAccessException;
}
