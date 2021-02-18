package com.woodM.Project.Service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.woodM.Project.Domain.*;

public interface UsuarioService {
	
	public List<Usuario> findAll() throws DataAccessException;
	
	public void save(Usuario c) throws DataAccessException;
	
	public void update(Usuario c) throws DataAccessException;
	
	public void delete(Usuario c) throws DataAccessException;
}
