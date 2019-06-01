package com.devswpro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="empleado")
public class Empleado {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idEmpleado;
	
	@Column(name="nombres", nullable=false, length=80)
	private String nombres;
	
	@Column(name="apellidos", nullable=false, length=80) 
	private String apellidos;
	
	@Column(name="dni", nullable=false, length=8)
	private String dni;
	
	@Column(name="direccion", nullable=false, length=8)
	private String direccion;
	
	@Column(name="numerotelefonoFijo", nullable=false, length=8)
	private String numeroTelefonoFijo;
	
	@Column(name="numeroCelular", nullable=false, length=8)
	private String numeroCelular;
	
	
	public Integer getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(Integer idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
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


	
	
	
	
}
