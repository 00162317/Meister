package com.woodM.Project.Service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.woodM.Project.Domain.*;
import com.woodM.Project.dto.sliderDTO;

public interface ProductoService {
	

	public List<Producto> findAll() throws DataAccessException;
	
	public void insertAndUpdate(Producto c) throws DataAccessException;
	
	
	public void delete(Integer c) throws DataAccessException;
	
	public List<sliderDTO> dtoPrueba() throws DataAccessException;
		
	public Page<Producto> mostrarProductosNew(String search, Pageable page) throws DataAccessException;
	
	public Integer countProducto2(String string) throws DataAccessException;
	
	public Producto findOne(Integer code) throws DataAccessException;
	
	
}
