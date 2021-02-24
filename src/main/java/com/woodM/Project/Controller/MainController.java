package com.woodM.Project.Controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.woodM.Project.Domain.*;
import com.woodM.Project.Service.*;
import com.woodM.Project.Service.Impl.*;
import com.woodM.Project.dto.ProductoDTO;
import com.woodM.Project.dto.TablaDTO;
import com.woodM.Project.dto.sliderDTO;


@Controller
@Service
public class MainController {

	@Autowired
	private SexoService SexoService;

	@Autowired
	private TipoUsuarioService TipoUsuarioService;

	@Autowired
	private MaterialService MaterialService;

	@Autowired
	private PersonalProService PersonalProService;

	@Autowired
	private ProductoService ProductoService;

	@Autowired
	private TipoProductoService TipoProductoService;

	@Autowired
	private UsuarioService UsuarioService;

	@RequestMapping("/index")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();

		List<sliderDTO> slider = null;
		List<sliderDTO> slider2 = new ArrayList<>();

		try {
			slider = ProductoService.dtoPrueba();
			int aux = 0;
			int flag = 0;
			for (sliderDTO sliderDTO : slider) {
				if (aux == 0 || aux != sliderDTO.getId_producto()) {

					slider2.add(sliderDTO);
					System.out.print(sliderDTO.getId_producto());
					aux = sliderDTO.getId_producto();

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		mav.addObject("slider", slider2);
		mav.setViewName("index1");
		return mav;
	}

	@RequestMapping("/about")
	public ModelAndView about() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("about");
		return mav;
	}

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

	@RequestMapping("/login")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		return mav;
	}

	@RequestMapping("/modificar")
	public ModelAndView modificar() {
		ModelAndView mav = new ModelAndView();
		

		
		List<Producto> productos = null;
		
		try {
			
			productos=ProductoService.findAll();
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		mav.addObject("productos", productos);
		
		mav.setViewName("modificar");
		return mav;
	}

	@RequestMapping("/product")
	public ModelAndView product() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("product");
		return mav;
	}

	@RequestMapping("/register")
	public ModelAndView register(@ModelAttribute Usuario usuario) {
		ModelAndView mav = new ModelAndView();

		List<Sexo> listaSexo = null;
		List<TipoUsuario> listaTusuario = null;

		try {

			listaSexo = SexoService.findAll();
			listaTusuario = TipoUsuarioService.findAll();

		} catch (Exception e) {
			e.printStackTrace();
		}

		mav.addObject("listaSexo", listaSexo);
		mav.addObject("listaTusuario", listaTusuario);
		mav.setViewName("register");
		return mav;
	}

///////////////////////////////////////////////////////////////////////////////////////////////////////
	@RequestMapping("/ingresarUsuario")
	public ModelAndView ingresarUsuario(@RequestParam("pass") String pass, @ModelAttribute Usuario usuario) {
		ModelAndView mav = new ModelAndView();

		Usuario usuarioUno = new Usuario();
		List<Sexo> listaSexo = null;
		List<TipoUsuario> listaTusuario = null;

		try {

			listaSexo = SexoService.findAll();
			listaTusuario = TipoUsuarioService.findAll();

			if (usuario.getPassword().equals(pass)) {
				UsuarioService.insertAndUpdate(usuario);

			} else {
				System.out.print("ERROR WE");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		mav.addObject("listaSexo", listaSexo);
		mav.addObject("listaTusuario", listaTusuario);
		mav.addObject("usuario", usuario);
		mav.setViewName("register");
		return mav;
	}

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

	
	@RequestMapping("/cargarProductos")
	public @ResponseBody TablaDTO cargarProductos(@RequestParam Integer draw, @RequestParam Integer start,
			@RequestParam Integer length, @RequestParam(value="search[value]",required =false) String search,
			@RequestParam Integer id) {
		
		//PageRequest.of(start/length, length, Sort.by(Direction.ASC,"id_producto"))
		
		Page<ProductoDTO> product = ProductoService.mostrarTodos(id,
				PageRequest.of(start / length, length, Sort.by(Direction.ASC, "id_producto"))
				);
		
		List<String[]> data = new ArrayList<>();
		
		for(ProductoDTO u : product) {
			data.add(new String[] {
				u.getId_producto().toString(),u.getNombre().toString(), u.getDetalle().toString(),
				u.getPrecio().toString(), u.getId_material().toString(), u.getId_tipo_producto().toString()
			});
		}
		
		TablaDTO dto = new TablaDTO();
		
		
		dto.setData(data);
		dto.setDraw(draw);
		dto.setRecordsFiltered(ProductoService.countProducto(id));
		dto.setRecordsTotal(ProductoService.countProducto(id));
	
		return dto;
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////////////	
	@RequestMapping("/registro")
	public ModelAndView registro() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("registro");
		return mav;
	}

	@RequestMapping("/prueba")
	public ModelAndView prueba() {
		ModelAndView mav = new ModelAndView();

		List<Sexo> sexos = null;
		List<Material> materials = null;
		List<PersonalProfesional> personalProfesionals = null;

		try {

			sexos = SexoService.findAll();
			materials = MaterialService.findAll();
			personalProfesionals = PersonalProService.findAll();

		} catch (Exception e) {
			e.printStackTrace();
		}

		mav.addObject("sexos", sexos);
		mav.addObject("materials", materials);
		mav.addObject("personalProfesionals", personalProfesionals);
		mav.setViewName("prueba");
		return mav;
	}
}
