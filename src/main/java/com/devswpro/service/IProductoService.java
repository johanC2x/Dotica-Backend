package com.devswpro.service;

import java.util.List;

import com.devswpro.dto.FiltroProductoDTO;
import com.devswpro.dto.ProductoListaInsumoDTO;
import com.devswpro.model.Producto;

public interface IProductoService extends ICRUD<Producto>{
	
	Producto registrarTransaccional(ProductoListaInsumoDTO dto);
	
	List<Producto> buscar(FiltroProductoDTO filtro);
	
	

}

