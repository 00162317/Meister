package com.woodM.Project.Controller;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

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
import org.springframework.web.servlet.mvc.method.annotation.SessionAttributeMethodArgumentResolver;

import com.woodM.Project.Domain.*;
import com.woodM.Project.Service.*;
import com.woodM.Project.Service.Impl.*;
import com.woodM.Project.Utils.Utils;
import com.woodM.Project.dto.TablaDTO;
import com.woodM.Project.dto.sliderDTO;


@Controller
@Service
public class CarritoController {
	
	@Autowired
	ProductoService ProductoService;
	
	
	
	//---------------------------------------------------------------------------------------------
	
		@RequestMapping("/carrito")
		public ModelAndView carrito() {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("carritoRegistro");
			return mav;
		}
/*
		@RequestMapping("/Shop")
		public ModelAndView addcarrito(@RequestParam Integer id, HttpServletRequest request) {
			ModelAndView mav = new ModelAndView();
			List<Producto> pr = new ArrayList<>();
			request.getAttribute("producto");
			if(request.getAttribute("producto")==null) {
				
			}
			
			Producto producto = ProductoService.findOne(id);
			pr.add(producto);
			request.setAttribute("producto", pr);
			
			List<Producto> p2 = (List<Producto>) request.getAttribute("producto");	 
		
		 
			mav.addObject("producto",p2);
			mav.setViewName("carritoRegistro");
			return mav;
		}*/
		
		@RequestMapping("/Shop")
		public ModelAndView addcarrito(@RequestParam Integer id, HttpServletRequest request) {
			ModelAndView mav = new ModelAndView();
			List<Producto> p2 = Utils.getCartInSession(request);
			Producto producto = new Producto();
			producto = ProductoService.findOne(id);
			p2.add(producto);
			
			request.getSession().setAttribute("myCart", p2);
			Double pro = Utils.calcularTotal(producto,p2);
			
			mav.addObject("producto",p2);
			mav.addObject("pro", pro);
			mav.setViewName("carritoRegistro");
			
			return mav;
		}
		

		
		@RequestMapping("/carritoIdentificar")
		public ModelAndView carritoIdentificar() {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("carritoIdentificar");
			return mav;
		}
		
		@RequestMapping("/carritoPago")
		public ModelAndView carritoPago() {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("carritoPago");
			return mav;
		}

	//---------------------------------------------------------------------------------------------


}
