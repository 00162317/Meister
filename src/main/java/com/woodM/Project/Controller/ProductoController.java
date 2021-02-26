package com.woodM.Project.Controller;

import org.springframework.stereotype.Controller;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.woodM.Project.Domain.Imagen;
import com.woodM.Project.Domain.Material;
import com.woodM.Project.Domain.Producto;
import com.woodM.Project.Domain.TipoProducto;
import com.woodM.Project.Service.MaterialService;
import com.woodM.Project.Service.ProductoService;
import com.woodM.Project.Service.TipoProductoService;
import com.woodM.Project.Service.TipoUsuarioService;
import com.woodM.Project.dto.TablaDTO;

@Controller
public class ProductoController {
	
	@Autowired
	private ProductoService ProductoService;

	@Autowired
	private MaterialService MaterialService;

	@Autowired
	private TipoProductoService TipoProductoService;
	
	@Autowired
	private MainController maincontroller;

//--------------------------------------------------------------- Views
	
	@RequestMapping("/agregar")
	public ModelAndView agregar(@ModelAttribute Producto producto) {
		ModelAndView mav = new ModelAndView();

		List<Material> listaMaterial = null;
		List<TipoProducto> listaTproducto = null;

		try {

			listaMaterial = MaterialService.findAll();
			listaTproducto = TipoProductoService.findAll();

		} catch (Exception e) {
			e.printStackTrace();
		}

		mav.addObject("listaMaterial", listaMaterial);
		mav.addObject("listaTproducto", listaTproducto);
		mav.setViewName("agregar");
		return mav;
	}

	@RequestMapping("/eliminar")
	public ModelAndView eliminar() {
		ModelAndView mav = new ModelAndView();
		

		
		List<Producto> productos = null;
		
		try {
			
			productos=ProductoService.findAll();
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		mav.addObject("productos", productos);
		
		mav.setViewName("eliminar");
		return mav;
	}

	@RequestMapping("/modificar")
	public ModelAndView modificar() {
		ModelAndView mav = new ModelAndView();		
		mav.setViewName("modificar");
		return mav;
	}
	
	//--------------------------------------------------------------- CRUD
	
	@RequestMapping("/ingresarProducto")
	public ModelAndView ingresarProducto(@ModelAttribute Producto producto) {

		ModelAndView mav = new ModelAndView();

		List<Material> listaMaterial = null;
		List<TipoProducto> listaTproducto = null;

		try {

			listaMaterial = MaterialService.findAll();
			listaTproducto = TipoProductoService.findAll();
			ProductoService.insertAndUpdate(producto);

		} catch (Exception e) {
			e.printStackTrace();
		}

		mav.addObject("listaMaterial", listaMaterial);
		mav.addObject("listaTproducto", listaTproducto);
		mav.addObject("producto", producto);
		mav.setViewName("agregar");
		return mav;
	}
	
	@RequestMapping("/editarProducto")
	public ModelAndView editar(@RequestParam Integer id) {
		ModelAndView mav = new ModelAndView();
		List<Material> listaMaterial = null;
		List<TipoProducto> listaTproducto = null;
		try {

			listaMaterial = MaterialService.findAll();
			listaTproducto = TipoProductoService.findAll();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Producto c = ProductoService.findOne(id);
		mav.addObject("producto", c);
		mav.addObject("listaMaterial", listaMaterial);
		mav.addObject("listaTproducto", listaTproducto);
		mav.setViewName("agregar");
		return mav;

	}
	
	@RequestMapping("/eliminarProducto")
	public ModelAndView eliminar(@ModelAttribute Producto producto, @RequestParam Integer id) {
		ModelAndView mav = new ModelAndView();
		
		try {
			
			ProductoService.delete(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		mav.addObject("producto", producto);
		//mav.addObject("listaMaterial", listaMaterial);
		//mav.addObject("listaTproducto", listaTproducto);
		mav.setViewName("eliminar");
		return mav;
	}

	//--------------------------------------------------------------- Pageable
	
	@RequestMapping("/cargarProductos")
	public @ResponseBody TablaDTO cargar(@RequestParam Integer draw, @RequestParam Integer start,
			@RequestParam Integer length, @RequestParam(value="search[value]",required =false) String search) {
		
		
		Page<Producto> producto  = ProductoService.mostrarProductosNew(search.toLowerCase(),
				PageRequest.of(start/length, length, Sort.by(Direction.ASC,"id_producto")));
			
		List<String[]> data = new ArrayList<>();
		
		for(Producto u : producto) {
			data.add(new String[] {
				u.getId_producto().toString(), u.getNombre().toString(), u.getDetalles(),
				u.getPrecio().toString(),u.getMaterial().getNombre_material(), u.getTipo_producto().getNombre_tipo()
			});
		}
		
		TablaDTO dto = new TablaDTO();
		
		System.out.print("HOOOOOOOOOOYYYYYYY  "+data);
		dto.setData(data);
		dto.setDraw(draw);
		dto.setRecordsFiltered(ProductoService.countProducto2(search.toLowerCase()).intValue());
		dto.setRecordsTotal(ProductoService.countProducto2(search.toLowerCase()).intValue());
	
		return dto;
	}

}
