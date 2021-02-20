package com.woodM.Project.Service.Impl;

import java.util.List;

import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.woodM.Project.Domain.Material;
import com.woodM.Project.Service.MaterialService;
import com.woodM.Project.repositorie.MaterialRepo;

@Service
public class MaterialServiceImpl implements MaterialService {

	@Autowired
	MaterialRepo Repo;
	
	@PersistenceContext(unitName = "Project")
	
	@Override
	public List<Material> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return Repo.mostrarTodo();
	}

	@Override
	public void insertAndUpdate(Material c) throws DataAccessException {
		// TODO Auto-generated method stub
		Repo.save(c);
	}


	@Override
	public void delete(Material c) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

}
