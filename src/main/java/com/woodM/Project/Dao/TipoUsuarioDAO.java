package com.woodM.Project.Dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.woodM.Project.Domain.*;

public interface TipoUsuarioDAO {

	public List<TipoUsuario> findAll() throws DataAccessException;
	
	public void save(TipoUsuario c) throws DataAccessException;
	
	public void update(TipoUsuario c) throws DataAccessException;
	
	public void delete(TipoUsuario c) throws DataAccessException;
}
