package com.woodM.Project.Service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.woodM.Project.Domain.*;
import com.woodM.Project.dto.sliderDTO;

public interface ProductoService {
	

	public List<Producto> findAll() throws DataAccessException;
	
	public void insertAndUpdate(Producto c) throws DataAccessException;
	
	
	public void delete(Producto c) throws DataAccessException;
	public List<sliderDTO> dtoPrueba() throws DataAccessException;
}
