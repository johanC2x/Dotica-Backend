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
@Table(name="producto")
@CrossOrigin(value = "localhost:4200")
public class Producto {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idProducto;
	
	@ManyToOne
	@JoinColumn(name = "id_tipo_producto", nullable = false, foreignKey = @ForeignKey(name = "producto_tipo_producto"))
	private TipoProducto tipoProducto;

	@ManyToOne
	@JoinColumn(name = "id_proveedor_producto", nullable = false, foreignKey = @ForeignKey(name = "producto_proveedor_producto"))
	private ProveedorProducto proveedorProducto;
		
	
	@ApiModelProperty(notes = "Nombre Proveedor debe tener minimo 3 caracteres")
	@Size(min=3, message="Nombre debe tener un minimo de 3 caracteres")
	@Column (name="nombre",nullable=false, length=80)
	private String nombre;
	
	@ApiModelProperty(notes = "Descripcion debe tener minimo 3 caracteres")
	@Size(min=3, message="descripcion debe tener un minimo de 3 caracteres")
	@Column (name="descripcion", length=100)
	private String descripcion;
	
	@Column (name="costo")
	private Double costo;
	
	@Column (name="costo")
	private Integer stock;

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public TipoProducto getTipoProducto() {
		return tipoProducto;
	}

	public void setTipoProducto(TipoProducto tipoProducto) {
		this.tipoProducto = tipoProducto;
	}

	public ProveedorProducto getProveedorProducto() {
		return proveedorProducto;
	}

	public void setProveedorProducto(ProveedorProducto proveedorProducto) {
		this.proveedorProducto = proveedorProducto;
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

	public Double getCosto() {
		return costo;
	}

	public void setCosto(Double costo) {
		this.costo = costo;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}
	
}
