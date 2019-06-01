package com.devswpro.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

@Entity
@Table(name="solicitud")
public class Solicitud {	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idSolicitud;
	
	@ManyToOne
	@JoinColumn(name="id_Tipo", nullable=false ,foreignKey =@ForeignKey(name="solicitud_tipo")) 
	private Tipo  tipo;
	
	@Column(name="estado", nullable=false, length=20)
	private String estado;
	
	@OneToMany(mappedBy="solicitud" , cascade= {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE}
	           ,fetch=FetchType.LAZY ,orphanRemoval=true)
	private List<DetalleSolicitud> detalleSolicitud;
	
	// ISODate 2019-10-01T05:00:00.000
	@JsonSerialize(using = ToStringSerializer.class) 
	private LocalDateTime fechaPublicacion;

	public Integer getIdSolicitud() {
		return idSolicitud;
	}

	public void setIdSolicitud(Integer idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}


	public List<DetalleSolicitud> getDetalleSolicitud() {
		return detalleSolicitud;
	}

	public void setDetalleSolicitud(List<DetalleSolicitud> detalleSolicitud) {
		this.detalleSolicitud = detalleSolicitud;
	}

	public LocalDateTime getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(LocalDateTime fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idSolicitud == null) ? 0 : idSolicitud.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Solicitud other = (Solicitud) obj;
		if (idSolicitud == null) {
			if (other.idSolicitud != null)
				return false;
		} else if (!idSolicitud.equals(other.idSolicitud))
			return false;
		return true;
	}
	
	
	
	

}
