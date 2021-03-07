package com.woodM.Project.Service.Impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.woodM.Project.Domain.Usuario;
import com.woodM.Project.Service.UsuarioService;
import com.woodM.Project.repositorie.UsuarioRepo;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	UsuarioRepo Repo;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@PersistenceContext(unitName = "Project")
	EntityManager entityManager;
	
	@Override
	public List<Usuario> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return Repo.mostrarTodo();
	}

	@Override
	public void insertAndUpdate(Usuario c) throws DataAccessException {
		// TODO Auto-generated method stub
		c.setPassword(passwordEncoder.encode(c.getPassword()));
		
		Repo.save(c);

	}

	@Override
	public void delete(Usuario c) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<Usuario> findByNombre(String username) throws DataAccessException {
		// TODO Auto-generated method stub
		return Repo.findByNombre(username);
	}

}
