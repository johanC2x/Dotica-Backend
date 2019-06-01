package com.devswpro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.web.bind.annotation.CrossOrigin;

import io.swagger.annotations.ApiModelProperty;


@Entity
@Table(name="marca")
@CrossOrigin(value = "localhost:4200")
public class Marca {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idMarca;
	@ApiModelProperty(notes = "Nombre Proveedor debe tener minimo 3 caracteres")
	@Size(min=2, message="Nombre debe tener un minimo de 3 caracteres")
	@Column (name="nombre",nullable=false, length=80)
	private String nombre;
	
	public Integer getIdMarca() {
		return idMarca;
	}
	public void setIdMarca(Integer idMarca) {
		this.idMarca = idMarca;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
