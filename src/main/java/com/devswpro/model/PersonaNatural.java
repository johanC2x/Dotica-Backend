package com.devswpro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@Table(name="personaNatural")
@CrossOrigin(value = "localhost:4200")
public class PersonaNatural {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idPersonaNatural;
	
	
	@Column(name="nombres", nullable=false, length=50)
	private String nombres;
	
	@Column(name="apellidos", nullable=false, length=50)
	private String apellidos;
	
	@Column(name="dni", nullable=false, length=50)
	private String dni;
	
	@Column(name="direccion", nullable=false, length=50)
	private String direccion;
	
	@Column(name="numeroTelefonoFijo", nullable=false, length=250)
	private String numeroTelefonoFijo;
	
	@Column(name="numeroCelular", nullable=false, length=50)
	private String numeroCelular;
	
	@Column(name="correo", nullable=false, length=50)
	private String correo;
	
	@Column(name="tipoEntidad", nullable=false, length=50)
	private String tipoEntidad;

	public Integer getIdPersonaNatural() {
		return idPersonaNatural;
	}

	public void setIdPersonaNatural(Integer idPersonaNatural) {
		this.idPersonaNatural = idPersonaNatural;
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

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	protected String getTipoEntidad() {
		return tipoEntidad;
	}

	protected void setTipoEntidad(String tipoEntidad) {
		this.tipoEntidad = tipoEntidad;
	}
	
	

}
