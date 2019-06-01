package com.devswpro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="kit")
public class Kit {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idKit;
	@Column(name="nombre", nullable=false, length=80)
	private String nombre;
	@Column(name="descripcion", nullable=false, length=150)
	private String descripcion;
	@Column(name="foto", nullable=false, length=150)
	private String foto;
	
	public Integer getIdKit() {
		return idKit;
	}
	public void setIdKit(Integer idKit) {
		this.idKit = idKit;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	
}
