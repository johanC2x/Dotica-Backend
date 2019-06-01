package com.devswpro.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.devswpro.model.Producto;

public interface IProductoDAO extends JpaRepository<Producto, Integer>{
	
	@Query("from Producto p where  LOWER(p.proveedorProducto.nombre) like %:nombreProveedorProducto% or LOWER(p.tipoProducto.nombre) like %:nombreProveedorProducto%")
	List<Producto> buscar(  @Param("nombreProveedorProducto") String nombreProveedorProducto );
	
	

}
