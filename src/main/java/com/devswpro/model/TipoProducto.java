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
@Table(name="tipoProducto")
@CrossOrigin(value = "localhost:4200")
public class TipoProducto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idTipoProducto;
	

	
	
	@ApiModelProperty(notes = "Nombre  Tipo producto debe tener minimo 3 caracteres")
	@Size(min=3, message="Nombre  debe tener un minimo de 3 caracteres")
	@Column (name="nombre",nullable=false, length=80)
	
	private String nombre;

	public Integer getIdTipoProducto() {
		return idTipoProducto;
	}

	public void setIdTipoProducto(Integer idTipoProducto) {
		this.idTipoProducto = idTipoProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	
	
}
