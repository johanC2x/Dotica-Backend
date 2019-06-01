package com.devswpro.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="productoInsumo")
public class ProductoInsumo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idProductoInsumo;
	
	
	@ManyToOne
	@JoinColumn(name="idInsumo" , nullable = false)
	private  Insumo insumo;
	
	
	@ManyToOne
	@JoinColumn(name="idProducto" , nullable=false)
	private Producto producto;


	public Integer getIdProductoInsumo() {
		return idProductoInsumo;
	}


	public void setIdProductoInsumo(Integer idProductoInsumo) {
		this.idProductoInsumo = idProductoInsumo;
	}


	public Insumo getInsumo() {
		return insumo;
	}


	public void setInsumo(Insumo insumo) {
		this.insumo = insumo;
	}


	public Producto getProducto() {
		return producto;
	}


	public void setProducto(Producto producto) {
		this.producto = producto;
	}


	
	


}
