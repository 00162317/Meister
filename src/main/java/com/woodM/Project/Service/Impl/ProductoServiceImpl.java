package com.woodM.Project.Service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.woodM.Project.Domain.Producto;
import com.woodM.Project.Service.ProductoService;
import com.woodM.Project.dto.ProductoDTO;
import com.woodM.Project.dto.sliderDTO;
import com.woodM.Project.repositorie.ProductoRepo;

@Service
public class ProductoServiceImpl implements ProductoService {

	int aux = 0;
	@Autowired
	ProductoRepo Repo;

	@PersistenceContext(unitName = "Project")
	EntityManager entityManager;

	@Override
	public List<Producto> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return Repo.mostrarTodo();
	}

	@Override
	public void insertAndUpdate(Producto c) throws DataAccessException {
		// TODO Auto-generated method stub
		Repo.save(c);
	}

	@Override
	public void delete(Producto c) throws DataAccessException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<sliderDTO> dtoPrueba() throws DataAccessException {
		// TODO Auto-generated method stub p.id_producto, p.nombre, p.descripcion,
		// p.precio, i.nombre
		List<sliderDTO> slider = Repo.sliderProducto().stream().map(obj -> {
			sliderDTO e = new sliderDTO();

			e.setId_producto(Integer.valueOf(obj[0].toString()));
			e.setNombre(obj[1].toString());
			e.setDescripcion(obj[2].toString());
			e.setPrecio(Integer.valueOf(obj[3].toString()));
			e.setNombreImagen(obj[4].toString());
			aux = Integer.valueOf(obj[0].toString());
			return e;
		}).collect(Collectors.toList());
		aux = 0;
		System.out.print(slider.toString());
		return slider;
	}

	@Override
	public Page<ProductoDTO> mostrarTodos(Integer code, Pageable pageable) throws DataAccessException {
		// TODO Auto-generated method stub
		
		List<ProductoDTO> productos = Repo.todoProductoDTO(code,pageable).stream().map(obj->{
			ProductoDTO e = new ProductoDTO();

			e.setId_producto(Integer.parseInt(obj[0].toString()));//Cambiar
			e.setNombre(obj[1].toString());
			e.setDetalle(obj[2].toString());
			e.setPrecio(Integer.parseInt(obj[3].toString()));
			e.setId_material(Integer.parseInt(obj[4].toString()));
			e.setId_tipo_producto(Integer.parseInt(obj[5].toString()));
			return e;
			
		}).collect(Collectors.toList());
		
		Page<ProductoDTO> page2 = new PageImpl<>(productos);
		
		return page2;
	}

	@Override
	public Integer countProducto(Integer id) throws DataAccessException {
		// TODO Auto-generated method stub
		return Repo.countProduct(id);
	}

}
