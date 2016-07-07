package pe.egcc.app.dao.espec;

import pe.egcc.app.domain.Cliente;

public interface EurekaDaoEspec {

  double getSaldoCuenta(String cuenta);
  
  Cliente getCliente(String codigo);
  
  Cliente getCliente2(String codigo);
  
  
}
