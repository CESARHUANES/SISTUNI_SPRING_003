package pe.egcc.demo05;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PruebaA {

  @SuppressWarnings("resource")
  public static void main(String[] args) {
    // Levantando el contexto
    String fileXML = "/pe/egcc/demo05/demo05.xml"; 
    BeanFactory bf;
    bf= new ClassPathXmlApplicationContext(fileXML);
    
    // Acceso al objeto
    Control bean;
    bean = bf.getBean(Control.class);
    
    // Prueba
    System.out.println("7 + 3 = " + bean.sumar(7, 3));
    System.out.println("Nombre = " + bean.getNombre());
    
    
  }
}
