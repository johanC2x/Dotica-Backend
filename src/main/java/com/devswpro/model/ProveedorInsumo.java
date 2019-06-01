package com.devswpro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.springframework.web.bind.annotation.CrossOrigin;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="proveedorInsumo")
@CrossOrigin(value = "localhost:4200")
public class ProveedorInsumo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer IdProveedorInsumo;
	
	@ApiModelProperty(notes = "Nombre Proveedor debe tener minimo 3 caracteres")
	@Size(min=3, message="Nombre Proveedor debe tener un minimo de 3 caracteres")
	@Column (name="nombreProveedor",nullable=false, length=80)
	private String nombreProveedor;
	
	@ApiModelProperty(notes = "Numero de contacto  debe tener 8 caracteres")
	@Size(min = 9, max = 9, message = "Numero de contacto  debe tener 8 caracteres")
	@Column (name="numeroContacto",nullable=false, length=80)
	private String numeroContacto;
	
	@Email(message="Por favor ingrese su dirección de correo electrónico válida")
	@Column(name="correo",nullable=false, length=80)
	private String correo;
	
	@ApiModelProperty(notes = "Dirección debe tener minimo 3 caracteres")
	@Size(min = 3, max = 150, message = "Dirección debe tener minimo 3 caracteres")
	@Column(name="direccion",nullable=false, length=100)
	private String direccion;

	
	public Integer getIdProveedorInsumo() {
		return IdProveedorInsumo;
	}
	public void setIdProveedorInsumo(Integer idProveedorInsumo) {
		IdProveedorInsumo = idProveedorInsumo;
	}
	public String getNombreProveedor() {
		return nombreProveedor;
	}
	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}
	public String getNumeroContacto() {
		return numeroContacto;
	}
	public void setNumeroContacto(String numeroContacto) {
		this.numeroContacto = numeroContacto;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	

	
	
}
