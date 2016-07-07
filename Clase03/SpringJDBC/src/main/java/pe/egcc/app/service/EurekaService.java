package pe.egcc.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.egcc.app.dao.espec.EurekaDaoEspec;
import pe.egcc.app.domain.Cliente;

@Service
public class EurekaService {

  @Autowired
  private EurekaDaoEspec eurekaDao;
  
  public double getSaldoCuenta(String cuenta){
    return eurekaDao.getSaldoCuenta(cuenta);
  }
  
  public Cliente getCliente(String codigo){
    return eurekaDao.getCliente2(codigo);
  }
  
}
