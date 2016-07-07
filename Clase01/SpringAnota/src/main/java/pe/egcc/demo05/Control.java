package pe.egcc.demo05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class Control {
  
  @Autowired
  private Mate mate;
  

  public int sumar(int n1, int n2){
    return mate.sumar(n1, n2);
  }
  
  
}
