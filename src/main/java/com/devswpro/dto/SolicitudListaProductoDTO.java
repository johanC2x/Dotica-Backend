package com.devswpro.dto;

import java.util.List;

import com.devswpro.model.Producto;
import com.devswpro.model.Solicitud;

public class SolicitudListaProductoDTO {
	
	private Solicitud solicitud;
	private List<Producto> lstProducto;
	
	public Solicitud getSolicitud() {
		return solicitud;
	}
	public void setSolicitud(Solicitud solicitud) {
		this.solicitud = solicitud;
	}
	public List<Producto> getLstProducto() {
		return lstProducto;
	}
	public void setLstProducto(List<Producto> lstProducto) {
		this.lstProducto = lstProducto;
	}

	
	
}
