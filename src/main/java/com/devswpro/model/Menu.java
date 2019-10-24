package com.devswpro.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="menu")
public class Menu {
	
	@Id
	private Integer idMenu;
	@Column(name="nombre", length=20)
	private String nombre;
	@Column(name="icono", length=20)
	private String icono;
	@Column(name="url", length=50)
	private String url;
	@Column(name="id_menu_padre", nullable = true)
	private Integer idMenuPadre;
	@Column(name="enable", columnDefinition="integer default 1")
	private Integer enable;
	
	@Transient
	private List<SubMenu> subMenu;
	@Transient
	private Integer show;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "menu_rol", joinColumns = @JoinColumn(name = "id_menu", referencedColumnName = "idMenu"), inverseJoinColumns = @JoinColumn(name = "id_rol", referencedColumnName = "idRol"))
	private List<Rol> roles;
	
	public Integer getIdMenu() {
		return idMenu;
	}
	public void setIdMenu(Integer idMenu) {
		this.idMenu = idMenu;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getIcono() {
		return icono;
	}
	public void setIcono(String icono) {
		this.icono = icono;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public List<Rol> getRoles() {
		return roles;
	}
	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}
	public Integer getIdMenuPadre() {
		return idMenuPadre;
	}
	public void setIdMenuPadre(Integer idMenuPadre) {
		this.idMenuPadre = idMenuPadre;
	}
	public List<SubMenu> getSubMenu() {
		return subMenu;
	}
	public void setSubMenu(List<SubMenu> subMenu) {
		this.subMenu = subMenu;
	}
	public Integer getShow() {
		return show;
	}
	public void setShow(Integer show) {
		this.show = show;
	}
	public Integer getEnable() {
		return enable;
	}
	public void setEnable(Integer enable) {
		this.enable = enable;
	}	
}
