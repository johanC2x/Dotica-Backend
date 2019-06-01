package com.devswpro.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.devswpro.model.ProductoInsumo;

public interface IProductoInsumoDAO extends JpaRepository<ProductoInsumo, Integer> {

	// SQL
	// @Transactional
	@Modifying
	@Query(value = "INSERT INTO producto_insumo(id_producto, id_insumo) VALUES (:idProducto, :idInsumo)", nativeQuery = true)
	Integer registrar(@Param("idProducto") Integer idProducto, @Param("idInsumo") Integer idInsumo);
	
	@Query("FROM ProductoInsumo pi where pi.producto.idProducto =:idProducto")
	List<ProductoInsumo> listarInsumoPorProducto(@Param("idProducto") Integer idproducto);
	
}
