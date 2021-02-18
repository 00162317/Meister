package com.woodM.Project.Dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.woodM.Project.Domain.*;

public interface PersonalProDAO {
	
	public List<PersonalProfesional> findAll() throws DataAccessException;
	
	public void save(PersonalProfesional c) throws DataAccessException;
	
	public void update(PersonalProfesional c) throws DataAccessException;
	
	public void delete(PersonalProfesional c) throws DataAccessException;

}
