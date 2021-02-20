package com.woodM.Project.Service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.woodM.Project.Domain.*;

public interface TipoProductoService {

	public List<TipoProducto> findAll() throws DataAccessException;
	
	public void insertAndUpdate(TipoProducto c) throws DataAccessException;
	
	
	public void delete(TipoProducto c) throws DataAccessException;
}
