package pe.egcc.app.dao.impl;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import pe.egcc.app.dao.espec.EurekaDaoEspec;
import pe.egcc.app.dao.mapper.ClienteMapper;
import pe.egcc.app.domain.Cliente;

@Repository
public class EurekaDaoImpl extends AbstractDao implements EurekaDaoEspec {

  @Override
  public double getSaldoCuenta(String cuenta) {
    double saldo = 0;
    try {
      String sql = "select dec_cuensaldo "
          + "from cuenta where chr_cuencodigo = ? " ;
      Object[] parms = {cuenta};
      saldo = jdbcTemplate.queryForObject(
          sql, parms, Double.class);  
    } catch (EmptyResultDataAccessException e) {
     throw new RuntimeException("Error, cuenta no existe."); 
    }
    return saldo;
  }

  @Override
  public Cliente getCliente(String codigo) {
    Cliente bean = null;
    try {
      String sql = "select chr_cliecodigo, vch_cliepaterno, "
          + "vch_cliematerno, vch_clienombre, "
          + "chr_cliedni, vch_clieciudad, vch_cliedireccion, "
          + "vch_clietelefono, vch_clieemail "
          + "from cliente "
          + "where chr_cliecodigo = ?";
      Object[] args = { codigo };
      bean = jdbcTemplate.queryForObject(sql, 
         args, new ClienteMapper());
    } catch (EmptyResultDataAccessException e) {
      throw new RuntimeException("Error, el codigo no existe");
    }
    return bean;
  }
  
  @Override
  public Cliente getCliente2(String codigo) {
    Cliente bean = null;
    try {
      String sql = "select "
          + "chr_cliecodigo codigo, "
          + "vch_cliepaterno paterno, "
          + "vch_cliematerno materno, "
          + "vch_clienombre nombre, "
          + "chr_cliedni dni, "
          + "vch_clieciudad ciudad, "
          + "vch_cliedireccion direccion, "
          + "vch_clietelefono telefono, "
          + "vch_clieemail email "
          + "from cliente "
          + "where chr_cliecodigo = ?";
      Object[] args = { codigo };
      bean = jdbcTemplate.queryForObject(sql, 
          args, new BeanPropertyRowMapper<Cliente>(Cliente.class));
    } catch (EmptyResultDataAccessException e) {
      throw new RuntimeException("Error, el codigo no existe");
    }
    return bean;
  }

}
