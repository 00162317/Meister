package com.woodM.Project.Service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.woodM.Project.Domain.*;

public interface PersonalProService {
	
	public List<PersonalProfesional> findAll() throws DataAccessException;
	
	public void insertAndUpdate(PersonalProfesional c) throws DataAccessException;
	
	
	public void delete(PersonalProfesional c) throws DataAccessException;

}
