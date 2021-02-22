package com.woodM.Project.repositorie;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.woodM.Project.Domain.Producto;

public interface ProductoRepo extends JpaRepository<Producto, Integer> {
	
	@Query(nativeQuery = true,value="select * from public.producto")
	public List<Producto> mostrarTodo() throws DataAccessException;
	
	@Query(nativeQuery = true, 
			value = " select p.id_producto, p.nombre, p.descripcion, p.precio, i.nombre as foto "
					+ " from public.producto p, public.imagen i where p.id_producto = i.fkproducto  "
					+ " order by p.id_producto asc ")
	public List<Object[]> sliderProducto() throws DataAccessException;

}
