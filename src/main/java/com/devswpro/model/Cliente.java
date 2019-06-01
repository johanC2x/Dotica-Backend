package com.devswpro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.CrossOrigin;



@Entity
@Table(name="cliente")
@CrossOrigin(value = "localhost:4200")
public class Cliente {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idCliente;
	
	@Column(name="razonSocial", nullable=false, length=50)
	private String razonSocial;
	
	@Column(name="ruc" , length=20)
	private long numeroRuc;
	
	@Column(name="direccion", nullable=false, length=8)
	private String direccion;
	
	@Column(name="nombres", nullable=false, length=80)
	private String nombres;
	
	@Column(name="apellidos", nullable=false, length=80) 
	private String apellidos;
	
	@Column(name="dni", nullable=false, length=8)
	private String dni;
	
	@Column(name="Telefono", nullable=false, length=9)
	private String numeroTelefonoFijo;
	
	
	
	
	
	
	
}
