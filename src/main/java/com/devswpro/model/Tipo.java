package com.devswpro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@Table(name="tipo")
@CrossOrigin(value = "localhost:4200")
public class Tipo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idTipo;
	
	@Column (name="nombre", nullable=false, length=80)
	private String nombre;

	public Integer getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(Integer idTipo) {
		this.idTipo = idTipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

	

}
