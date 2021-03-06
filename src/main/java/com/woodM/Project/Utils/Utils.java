package com.woodM.Project.Utils;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.woodM.Project.Domain.Producto;

public class Utils {
	 // Products in the cart, stored in Session.
	   public static List<Producto> getCartInSession(HttpServletRequest request) {
	 
			List<Producto> p2 = (List<Producto>) request.getSession().getAttribute("myCart");	 
	 
	      if (p2 == null) {
				List<Producto> pr = new ArrayList<>();

	    	  
	         request.getSession().setAttribute("myCart", pr);
	      }
	 
	      return p2;
	   }
	
		public static Double calcularTotal(Producto producto, List<Producto> p2) {
			
			double precio = 0;
			
			for(int i = 0; i<p2.size();i++) {
			
				precio += producto.getPrecio();
			}
			
			return precio;
		}
}
