package pe.egcc.app.dao.espec;

import java.util.List;
import java.util.Map;

import pe.egcc.app.domain.Cliente;

public interface EurekaDaoEspec {

  double getSaldoCuenta(String cuenta);
  
  Cliente getCliente(String codigo);
  
  Cliente getCliente2(String codigo);
  
  List<Map<String, Object>> getMovimientos(String cuenta);
  
  void procDeposito(String cuenta, double importe, String codEmp);
  
  void procDeposito2(String cuenta, double importe, String codEmp);
  
  void procRetiro(String cuenta, double importe, String codEmp, String clave);
  
}
