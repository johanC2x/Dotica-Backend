package com.devswpro.service;

import java.util.List;

import com.devswpro.model.ProductoInsumo;

public interface IProductoInsumoService  extends ICRUD<ProductoInsumo>{
	
	List<ProductoInsumo> listarInsumoPorProducto(Integer idproducto);

}
