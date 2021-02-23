package com.woodM.Project.dto;

public class ProductoDTO {
	
	private Integer id_producto;
	private String nombre, detalle;
	private Integer precio,id_material,id_tipo_producto;
	
	public ProductoDTO()
	{
		super();
	}
	public Integer getId_producto() {
		return id_producto;
	}
	public void setId_producto(Integer id_producto) {
		this.id_producto = id_producto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public Integer getPrecio() {
		return precio;
	}
	public void setPrecio(Integer precio) {
		this.precio = precio;
	}
	public Integer getId_material() {
		return id_material;
	}
	public void setId_material(Integer id_material) {
		this.id_material = id_material;
	}
	public Integer getId_tipo_producto() {
		return id_tipo_producto;
	}
	public void setId_tipo_producto(Integer id_tipo_producto) {
		this.id_tipo_producto = id_tipo_producto;
	}
	
	
	
}
