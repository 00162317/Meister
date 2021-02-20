package com.woodM.Project.repositorie;


import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.woodM.Project.Domain.TipoUsuario;

public interface TipoUsuarioRepo extends JpaRepository<TipoUsuario, Integer>{
	
	@Query(nativeQuery = true,value="select * from public.tipo_usuario")
	public List<TipoUsuario> mostrarTodo() throws DataAccessException;

}
