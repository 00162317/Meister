package com.woodM.Project.Service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.woodM.Project.Domain.*;

public interface TipoUsuarioService {
	
	public List<TipoUsuario> findAll() throws DataAccessException;
	
	public void insertAndUpdate(TipoUsuario c) throws DataAccessException;
	
	public void delete(TipoUsuario c) throws DataAccessException;
}
