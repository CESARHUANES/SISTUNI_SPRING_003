package pe.egcc.demo01;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pe.egcc.demo01.Mate;

public class PruebaA {

  @SuppressWarnings("resource")
  public static void main(String[] args) {
    // Levantando el contexto
    String fileXML = "/pe/egcc/demo01/demo01.xml"; 
    BeanFactory bf;
    bf= new ClassPathXmlApplicationContext(fileXML);
    
    // Acceso al objeto
    Mate bean;
    // bean = bf.getBean(Mate.class);
    bean = bf.getBean("mate",Mate.class);
    
    // Prueba
    System.out.println("7 + 3 = " + bean.sumar(7, 3));
   
    
  }
}
