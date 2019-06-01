
package com.devswpro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.web.bind.annotation.CrossOrigin;

import io.swagger.annotations.ApiModelProperty;


@Entity
@Table(name="insumo")
@CrossOrigin(value = "localhost:4200")
public class Insumo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idInsumo;
	
	@ManyToOne
	@JoinColumn(name = "id_marca", nullable = false, foreignKey = @ForeignKey(name = "insumo_marca"))
	private Marca marca;

	@ManyToOne
	@JoinColumn(name = "id_proveedor_insumo", nullable = false, foreignKey = @ForeignKey(name = "insumo_proveedor_insumo"))
	private ProveedorInsumo proveedorInsumo;
	
	@ApiModelProperty(notes = "Nombre Proveedor debe tener minimo 3 caracteres")
	@Size(min=3, message="Nombre debe tener un minimo de 3 caracteres")
	@Column (name="nombre",nullable=false, length=80)
	private String nombre;
	@ApiModelProperty(notes = "Descripcion debe tener minimo 3 caracteres")
	@Size(min=3, message="descripcion debe tener un minimo de 3 caracteres")
	@Column (name="descripcion",nullable=false, length=80)
	private String descripcion;
	

	public Integer getIdInsumo() {
		return idInsumo;
	}

	public void setIdInsumo(Integer idInsumo) {
		this.idInsumo = idInsumo;
	}
	

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public ProveedorInsumo getProveedorInsumo() {
		return proveedorInsumo;
	}

	public void setProveedorInsumo(ProveedorInsumo proveedorInsumo) {
		this.proveedorInsumo = proveedorInsumo;
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





}
