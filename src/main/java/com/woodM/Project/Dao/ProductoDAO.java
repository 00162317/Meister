package com.woodM.Project.Dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.woodM.Project.Domain.*;

public interface ProductoDAO {
	
	public List<Producto> findAll() throws DataAccessException;
	
	public void save(Producto c) throws DataAccessException;
	
	public void update(Producto c) throws DataAccessException;
	
	public void delete(Producto c) throws DataAccessException;

}
