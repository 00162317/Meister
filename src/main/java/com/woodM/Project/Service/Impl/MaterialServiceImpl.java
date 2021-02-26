package com.woodM.Project.Service.Impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.woodM.Project.Domain.Material;
import com.woodM.Project.Service.MaterialService;
import com.woodM.Project.repositorie.MaterialRepo;

@Service
public class MaterialServiceImpl implements MaterialService {

	@Autowired
	MaterialRepo Repo;
	
	@PersistenceContext(unitName = "Project")
	EntityManager entityManager;
	
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

	@Override
	public Page<Material> mostrarMateriales(String search, Pageable page) throws DataAccessException {
		// TODO Auto-generated method stub
		return Repo.mostrarMateriales(search, page);
	}

	@Override
	public Integer countMaterial(String string) throws DataAccessException {
		// TODO Auto-generated method stub
		return Repo.countMaterial(string);
	}

	@Override
	public Material findOnde(Integer code) throws DataAccessException {
		// TODO Auto-generated method stub
		return Repo.getOne(code);
	}

}
