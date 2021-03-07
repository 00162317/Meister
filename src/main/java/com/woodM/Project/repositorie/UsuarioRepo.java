package com.woodM.Project.repositorie;


import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.woodM.Project.Domain.Usuario;

public interface UsuarioRepo extends JpaRepository<Usuario, Integer>{

	@Query(nativeQuery = true,value="select * from public.usuario")
	public List<Usuario> mostrarTodo() throws DataAccessException;
	
	Optional<Usuario> findByNombre(String username);
}
