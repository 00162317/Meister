package com.woodM.Project.Service.Impl;

import java.util.List;

import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.woodM.Project.Domain.Imagen;
import com.woodM.Project.Service.ImagenService;
import com.woodM.Project.repositorie.ImagenRepo;

@Service
public class ImagenServiceImpl implements ImagenService{

	@Autowired
	ImagenRepo Repo;
	
	@PersistenceContext(unitName = "Project")
	
	@Override
	public List<Imagen> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return Repo.mostrarTodo();
	}

	@Override
	public void insertAndUpdate(Imagen c) throws DataAccessException {
		// TODO Auto-generated method stub
		Repo.save(c);
	}

	@Override
	public void delete(Imagen c) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

}
