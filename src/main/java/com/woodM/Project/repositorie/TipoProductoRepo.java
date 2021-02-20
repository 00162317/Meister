package com.woodM.Project.repositorie;


import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.woodM.Project.Domain.TipoProducto;

public interface TipoProductoRepo extends JpaRepository<TipoProducto, Integer> {

	@Query(nativeQuery = true,value="select * from public.tipo_producto")
	public List<TipoProducto> mostrarTodo() throws DataAccessException;
}
