package com.woodM.Project.repositorie;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.woodM.Project.Domain.PersonalProfesional;

public interface PersonalProRepo extends JpaRepository<PersonalProfesional, Integer>{
	
	@Query(nativeQuery = true,value="select * from public.personal_profesional")
	public List<PersonalProfesional> mostrarTodo() throws DataAccessException;

}
