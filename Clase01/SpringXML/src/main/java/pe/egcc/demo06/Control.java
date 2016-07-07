package pe.egcc.demo06;

public class Control {
  
  private Mate mate;
  private String nombre;
  private String ciudad;
  
  
  public Control(Mate mate, String nombre, String ciudad) {
    super();
    this.mate = mate;
    this.nombre = nombre;
    this.ciudad = ciudad;
  }

  public int sumar(int n1, int n2){
    return mate.sumar(n1, n2);
  }
  
  public String getNombre() {
    return nombre;
  }
  
  public String getCiudad() {
    return ciudad;
  }
}
