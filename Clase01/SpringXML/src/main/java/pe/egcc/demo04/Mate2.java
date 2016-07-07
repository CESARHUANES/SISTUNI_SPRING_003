package pe.egcc.demo04;

public class Mate2 implements IMate {

  @Override
  public int sumar(int n1, int n2) {
    return ((n1 + n2)*(n1 - n2));
  }

}
