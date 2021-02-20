package com.woodM.Project.repositorie;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.woodM.Project.Domain.Sexo;

public interface SexoRepo extends JpaRepository<Sexo, Integer>{

	@Query(nativeQuery = true,value="select * from public.sexo")
	public List<Sexo> mostrarTodo() throws DataAccessException;
}
