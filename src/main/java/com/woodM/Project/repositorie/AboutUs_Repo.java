package com.woodM.Project.repositorie;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.woodM.Project.Domain.About_us;

public interface AboutUs_Repo extends JpaRepository<About_us, Integer> {
	
	
	@Query(nativeQuery = true,value="select * from public.about_us")
	public List<About_us> mostrarTodo() throws DataAccessException;
	
}
