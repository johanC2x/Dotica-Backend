package com.devswpro.model;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="cotizacion")
public class Cotizacion {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idCotizacion;

	@Column(name="motivo", nullable=true)
	private String motivo;
	
	@Column(name="descripcion", nullable=false)
	private String descripcion;
	
	@Column(name="data", nullable=true)
	private String data;
	
	@Column(name="data_coti", nullable=true,columnDefinition="TEXT")
	private String data_coti;
	
	@Column(name="tipo", nullable=false)
	private String tipo;
	
	@Column(name="estado", nullable=false, length=20)
	private String estado;
	
	@CreationTimestamp
	@Column(name = "fecha_creacion", updatable = false, nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fechaCreacion;
	
	@UpdateTimestamp
	@Column(name = "fecha_modificacion")
    @Temporal(TemporalType.DATE)
    private Calendar fechaModificacion;
	
	@Column(name = "modifica_area1")
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date modificaArea1;
	
	@Column(name = "modifica_area2")
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date modificaArea2;
	
	@Column(name = "modifica_area3")
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date modificaArea3;
	
	@ManyToOne
	@JoinColumn(name="id_usuario", nullable=false ,foreignKey = @ForeignKey(name="cotizacion_usuario")) 
	private Usuario usuario;
	
	@Column(name="area", nullable=true)
	private String area;
	
	@Column(name="cantidad", nullable=true)
	private Integer cantidad;
	
	@ManyToMany//(fetch = FetchType.EAGER)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(name = "detalle_cotizacion", joinColumns = @JoinColumn(name = "id_cotizacion", referencedColumnName = "idCotizacion"), inverseJoinColumns = @JoinColumn(name = "id_producto", referencedColumnName = "idProducto"))
	private List<Producto> productos;

	public Integer getIdCotizacion() {
		return idCotizacion;
	}

	public void setIdCotizacion(Integer idCotizacion) {
		this.idCotizacion = idCotizacion;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Calendar getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Calendar fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public Calendar getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Calendar fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getData_coti() {
		return data_coti;
	}

	public void setData_coti(String data_coti) {
		this.data_coti = data_coti;
	}

	public Date getModificaArea1() {
		return modificaArea1;
	}

	public void setModificaArea1(Date modificaArea1) {
		this.modificaArea1 = modificaArea1;
	}

	public Date getModificaArea2() {
		return modificaArea2;
	}

	public void setModificaArea2(Date modificaArea2) {
		this.modificaArea2 = modificaArea2;
	}

	public Date getModificaArea3() {
		return modificaArea3;
	}

	public void setModificaArea3(Date modificaArea3) {
		this.modificaArea3 = modificaArea3;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

}
