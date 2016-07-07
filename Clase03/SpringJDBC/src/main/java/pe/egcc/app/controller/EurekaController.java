package pe.egcc.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pe.egcc.app.service.EurekaService;

@Controller
public class EurekaController {

  @Autowired
  private EurekaService eurekaService;
  
  @RequestMapping(value="/saldoCuenta.htm", method=RequestMethod.GET)
  public String verSaldoCuenta(
      @RequestParam("cuenta") String cuenta, Model model){
    model.addAttribute("cuenta", cuenta);
    try {
      model.addAttribute("saldo", eurekaService.getSaldoCuenta(cuenta));
    } catch (Exception e) {
      model.addAttribute("error", e.getMessage());
    }
    return "saldoCuenta";
  }
  
  @RequestMapping(value="/verCliente.htm", method=RequestMethod.GET)
  public String verCliente(
      @RequestParam("codigo") String codigo, Model model){
    try {
      model.addAttribute("bean", eurekaService.getCliente(codigo));
    } catch (Exception e) {
      model.addAttribute("error", e.getMessage());
    }
    return "verCliente";
  }
  
  
  
}
