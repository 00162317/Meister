package com.woodM.Project.Service;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.woodM.Project.Domain.*;
import com.woodM.Project.dto.ProductoDTO;
import com.woodM.Project.dto.sliderDTO;

public interface ProductoService {
	

	public List<Producto> findAll() throws DataAccessException;
	
	public void insertAndUpdate(Producto c) throws DataAccessException;
	
	
	public void delete(Producto c) throws DataAccessException;
	public List<sliderDTO> dtoPrueba() throws DataAccessException;
	
	public Page<ProductoDTO> findAll(Integer code, Pageable pageable) throws DataAccessException;
	
	public Integer countProducto(Integer id) throws DataAccessException;
}
