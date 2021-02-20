package com.woodM.Project.repositorie;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.woodM.Project.Domain.Material;

public interface MaterialRepo extends JpaRepository<Material, Integer>{

	@Query(nativeQuery = true,value="select * from public.material")
	public List<Material> mostrarTodo() throws DataAccessException;
}
