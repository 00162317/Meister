package com.woodM.Project.Service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.woodM.Project.Domain.*;

public interface SexoService {

	public List<Sexo> findAll() throws DataAccessException;
	
	public void save(Sexo c) throws DataAccessException;
	
	public void update(Sexo c) throws DataAccessException;
	
	public void delete(Sexo c) throws DataAccessException;
}
