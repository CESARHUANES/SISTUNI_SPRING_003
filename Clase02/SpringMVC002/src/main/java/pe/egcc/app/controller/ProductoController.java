package pe.egcc.app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pe.egcc.app.model.ProductoBean;

@Controller
public class ProductoController {

  @RequestMapping(value="producto.htm", method=RequestMethod.GET)
  public String proProducto(){
    return "productoInput";
  }

  @RequestMapping(value="producto.htm", method=RequestMethod.POST)
  public String proProducto(
      @ModelAttribute ProductoBean bean, Model model){
    
    model.addAttribute("bean", bean);
    return "productoOutput";
  }
  
  @SuppressWarnings("unchecked")
  @RequestMapping(value="producto2.htm", method=RequestMethod.POST)
  public String proProducto2(
      @ModelAttribute ProductoBean bean, 
      HttpSession session){
    
    List<ProductoBean> lista;
    if(session.getAttribute("lista") == null){
      lista = new ArrayList<ProductoBean>();
      session.setAttribute("lista", lista);
    } 
    
    lista = (List<ProductoBean>) session.getAttribute("lista");
    
    lista.add(bean);
    return "listado";
  }
  
  @RequestMapping(value="listado.htm", method=RequestMethod.GET)
  public String listado(){
    return "listado";
  }
  
  @RequestMapping(value="reset.htm", method=RequestMethod.GET)
  public String reset(HttpSession session){
    session.invalidate();
    return "listado";
  }
  
}
