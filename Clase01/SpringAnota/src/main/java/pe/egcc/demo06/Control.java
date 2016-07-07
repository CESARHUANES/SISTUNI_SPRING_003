package pe.egcc.demo06;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Named
public class Control {
  
  @Inject
  private Mate mate;
  

  public int sumar(int n1, int n2){
    return mate.sumar(n1, n2);
  }
  
  
}
