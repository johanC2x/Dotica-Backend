package com.devswpro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="proveedorClientes")
public class ProveedorClientes {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer iProveedorCliente;
	//idTipoEntidad

	public Integer getiProveedorCliente() {
		return iProveedorCliente;
	}

	public void setiProveedorCliente(Integer iProveedorCliente) {
		this.iProveedorCliente = iProveedorCliente;
	}



}
