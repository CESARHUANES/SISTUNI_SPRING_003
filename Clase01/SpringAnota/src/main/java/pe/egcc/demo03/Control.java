package pe.egcc.demo03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class Control {
  
  private Mate mate;
  
  @Autowired
  public void setMate(Mate mate) {
    this.mate = mate;
  }
  
  public int sumar(int n1, int n2){
    return mate.sumar(n1, n2);
  }
  
  
}
