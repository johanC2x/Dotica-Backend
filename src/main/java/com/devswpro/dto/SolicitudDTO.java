package com.devswpro.dto;

import org.springframework.hateoas.ResourceSupport;

import com.devswpro.model.Tipo;

public class SolicitudDTO extends ResourceSupport {
	
	private int idSolicitud;
	private Tipo tipo;
	
	public int getIdSolicitud() {
		return idSolicitud;
	}
	public void setIdSolicitud(int idSolicitud) {
		this.idSolicitud = idSolicitud;
	}
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
	
	
}
