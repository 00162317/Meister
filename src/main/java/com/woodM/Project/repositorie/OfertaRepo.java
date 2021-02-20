package com.woodM.Project.repositorie;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.woodM.Project.Domain.Oferta;

public interface OfertaRepo extends JpaRepository<Oferta, Integer>{

	
	@Query(nativeQuery = true,value="select * from public.oferta")
	public List<Oferta> mostrarTodo() throws DataAccessException;
}
