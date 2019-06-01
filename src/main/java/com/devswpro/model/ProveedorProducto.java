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
@Table(name="proveedorProducto")
@CrossOrigin(value = "localhost:4200")
public class ProveedorProducto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idProveedorProducto;
	
	@ApiModelProperty(notes = "Nombre  debe tener minimo 3 caracteres")
	@Size(min=3, message="Nombre  debe tener un minimo de 3 caracteres")
	@Column (name="nombre",nullable=false, length=80)
	private String nombre;

	public Integer getIdProveedorProducto() {
		return idProveedorProducto;
	}

	public void setIdProveedorProducto(Integer idProveedorProducto) {
		this.idProveedorProducto = idProveedorProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




}
