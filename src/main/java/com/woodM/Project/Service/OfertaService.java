package com.woodM.Project.Service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.woodM.Project.Domain.*;

public interface OfertaService {
	
	public List<Oferta> findAll() throws DataAccessException;
	
	public void save(Oferta c) throws DataAccessException;
	
	public void update(Oferta c) throws DataAccessException;
	
	public void delete(Oferta c) throws DataAccessException;
}
