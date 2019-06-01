package com.devswpro.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.devswpro.model.TipoProducto;

public interface ITipoProductoDAO extends JpaRepository<TipoProducto, Integer>{

}
