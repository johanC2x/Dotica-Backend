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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="detalleSolicitud")
public class DetalleSolicitud {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idDetalleSolicitud;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="id_solicitud", nullable=false ,foreignKey =@ForeignKey(name="detalle_solicitud")) 
	private Solicitud solicitud;

	@Column(name="nota", nullable=false, length=100)
	private String nota;

	public Integer getIdDetalleSolicitud() {
		return idDetalleSolicitud;
	}

	public void setIdDetalleSolicitud(Integer idDetalleSolicitud) {
		this.idDetalleSolicitud = idDetalleSolicitud;
	}

	public Solicitud getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(Solicitud solicitud) {
		this.solicitud = solicitud;
	}

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	
	
}
