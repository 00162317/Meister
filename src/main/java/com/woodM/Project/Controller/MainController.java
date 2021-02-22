package com.woodM.Project.Controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.woodM.Project.Domain.*;
import com.woodM.Project.Service.*;
import com.woodM.Project.Service.Impl.*;
import com.woodM.Project.dto.sliderDTO;

@Controller
@Service
public class MainController {

	@Autowired
	private SexoService SexoService;

	@Autowired
	private MaterialService MaterialService;

	@Autowired
	private PersonalProService PersonalProService;

	@Autowired
	private ProductoService ProductoService;

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
	public ModelAndView agregar() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("agregar");
		return mav;
	}

	@RequestMapping("/eliminar")
	public ModelAndView eliminar() {
		ModelAndView mav = new ModelAndView();
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
	public ModelAndView register() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("register");
		return mav;
	}

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
