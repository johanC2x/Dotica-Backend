package com.devswpro.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="recurso")
public class Recurso {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idRecurso;
	
	@Column(name="nombre")
	private String nombre;	
	
	@Column(name="descripcion")
	private String descripcion;
	
	@OneToMany(mappedBy = "recurso")
	private Set<SubRecurso> subRecurso = new HashSet<SubRecurso>();

	public Integer getIdRecurso() {
		return idRecurso;
	}

	public void setIdRecurso(Integer idRecurso) {
		this.idRecurso = idRecurso;
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

	public Set<SubRecurso> getSubRecurso() {
		return subRecurso;
	}

	public void setSubRecurso(Set<SubRecurso> subRecurso) {
		this.subRecurso = subRecurso;
	}
	
}
