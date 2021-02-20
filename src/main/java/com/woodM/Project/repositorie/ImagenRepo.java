package com.woodM.Project.repositorie;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.woodM.Project.Domain.Imagen;

public interface ImagenRepo extends JpaRepository<Imagen, Integer> {
	
	@Query(nativeQuery = true,value="select * from public.imagen")
	public List<Imagen> mostrarTodo() throws DataAccessException;

}
