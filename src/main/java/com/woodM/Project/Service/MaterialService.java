package com.woodM.Project.Service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.woodM.Project.Domain.*;

public interface MaterialService {

	public List<Material> findAll() throws DataAccessException;
	
	public void save(Material c) throws DataAccessException;
	
	public void update(Material c) throws DataAccessException;
	
	public void delete(Material c) throws DataAccessException;
}
