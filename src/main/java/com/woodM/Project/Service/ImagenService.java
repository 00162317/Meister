package com.woodM.Project.Service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.woodM.Project.Domain.*;

public interface ImagenService {
	
	public List<Imagen> findAll() throws DataAccessException;
	
	public void save(Imagen c) throws DataAccessException;
	
	public void update(Imagen c) throws DataAccessException;
	
	public void delete(Imagen c) throws DataAccessException;
}
