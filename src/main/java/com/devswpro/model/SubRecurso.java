package com.devswpro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="subrecurso")
public class SubRecurso {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idSubRecurso;
	
	@Column(name="nombre")
	private String nombre;	
	
	@Column(name="slug")
	private String slug;	
	
	@Column(name="descripcion")
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name = "id_recurso")
	@JsonBackReference
	private Recurso recurso;

	public Integer getIdSubRecurso() {
		return idSubRecurso;
	}

	public void setIdSubRecurso(Integer idSubRecurso) {
		this.idSubRecurso = idSubRecurso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Recurso getRecurso() {
		return recurso;
	}

	public void setRecurso(Recurso recurso) {
		this.recurso = recurso;
	}
	
}
