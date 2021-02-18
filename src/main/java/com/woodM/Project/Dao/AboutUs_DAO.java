package com.woodM.Project.Dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.woodM.Project.Domain.*;

public interface AboutUs_DAO {
	
	public List<About_us> findAll() throws DataAccessException;
	
	public void save(About_us c) throws DataAccessException;
	
	public void update(About_us c) throws DataAccessException;
	
	public void delete(About_us c) throws DataAccessException;

}
