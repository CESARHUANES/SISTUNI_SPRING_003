package pe.egcc.app.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import pe.egcc.app.domain.Cliente;
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
  
  @RequestMapping(value="/verMovimientos.htm", method=RequestMethod.GET)
  public String verMovimientos(){
    return "verMovimientos";
  }
  
  @RequestMapping(value="/verMovimientos.htm", method=RequestMethod.POST)
  public String verMovimientos(
      @RequestParam("cuenta") String cuenta, Model model){
    try {
      model.addAttribute("lista", eurekaService.getMovimientos(cuenta));
    } catch (Exception e) {
      model.addAttribute("error", e.getMessage());
    }
    return "verMovimientos";
  }
  
  @RequestMapping(value="/procDeposito.htm", method=RequestMethod.GET)
  public String procDeposito(){
    return "procDeposito";
  }
  
  

  
  @RequestMapping(value="/procRetiro.htm", method=RequestMethod.GET)
  public String procRetiro(){
    return "procRetiro";
  }
  
  @RequestMapping(value="/procRetiro.htm", method=RequestMethod.POST)
  public String procDeposito(
      @RequestParam("cuenta") String cuenta, 
      @RequestParam("importe") double importe, 
      @RequestParam("clave") String clave, 
      Model model){
    try {
      eurekaService.procRetiro(cuenta, importe,"0003",clave);
      model.addAttribute("mensaje", "Proceso ejecutado correctamente.");
    } catch (Exception e) {
      model.addAttribute("error", e.getMessage());
    }
    return "procRetiro";
  }
  
  @RequestMapping(value="datos1.htm", method=RequestMethod.GET)
  @ResponseBody
  public String traerDatos(){
    Cliente bean = eurekaService.getCliente("00001");
    Gson gson = new Gson();
    String textoJson = gson.toJson(bean);
    return textoJson;
  }
  
  @RequestMapping(value="datos2.htm", method=RequestMethod.GET)
  @ResponseBody
  public String traerDatos2(){   
    List<Map<String,Object>> lista = eurekaService.getMovimientos("00100001");
    Gson gson = new Gson();
    String textoJson = gson.toJson(lista);
    return textoJson;
  }
  
  @RequestMapping(value="datos3.htm", method=RequestMethod.GET)
  @ResponseBody
  public Cliente traerDatos3(){
    Cliente bean = eurekaService.getCliente("00001");
    return bean;
  }
  
  @RequestMapping(value="datos4.htm", method=RequestMethod.GET)
  @ResponseBody
  public List<Map<String,Object>> traerDatos4(){   
    List<Map<String,Object>> lista = eurekaService.getMovimientos("00100001");
    return lista;
  }
  
}
