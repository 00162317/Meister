package com.woodM.Project.Service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.woodM.Project.Domain.*;

public interface MaterialService {

	public List<Material> findAll() throws DataAccessException;
	
	public void insertAndUpdate(Material c) throws DataAccessException;
	
	public void delete(Material c) throws DataAccessException;
}
