package com.devswpro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="empresa")
public class Empresa {
		
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idEmpresa;
	
	@Column(name="razonSocial", nullable=false, length=50)
	private String razonSocial;
	
	@Column(name="direccion", nullable=false, length=8)
	private String direccion;
		
	@Column(name="ruc" , length=20)
	private long numeroRuc;
	
	@Column(name="numeroTelefonoFijo", nullable=false, length=9)
	private String numeroTelefonoFijo;
	
	@Column(name="numeroCelular", nullable=false, length=9)
	private String numeroCelular;
	
	@Column(name="correo", nullable=false, length=50)
	private String correo;

	public Integer getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public long getNumeroRuc() {
		return numeroRuc;
	}

	public void setNumeroRuc(long numeroRuc) {
		this.numeroRuc = numeroRuc;
	}

	public String getNumeroTelefonoFijo() {
		return numeroTelefonoFijo;
	}

	public void setNumeroTelefonoFijo(String numeroTelefonoFijo) {
		this.numeroTelefonoFijo = numeroTelefonoFijo;
	}

	public String getNumeroCelular() {
		return numeroCelular;
	}

	public void setNumeroCelular(String numeroCelular) {
		this.numeroCelular = numeroCelular;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	

}
