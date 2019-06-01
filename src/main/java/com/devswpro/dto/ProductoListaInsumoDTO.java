package com.devswpro.dto;

import java.util.List;

import com.devswpro.model.Insumo;
import com.devswpro.model.Producto;

public class ProductoListaInsumoDTO {
	
	
	private Producto producto;
	
	private List<Insumo> lstInsumo;

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public List<Insumo> getLstInsumo() {
		return lstInsumo;
	}

	public void setLstInsumo(List<Insumo> lstInsumo) {
		this.lstInsumo = lstInsumo;
	}

	
	
}
