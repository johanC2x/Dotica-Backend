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

@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	private Integer idUsuario;

	@Column(name = "nombre", nullable = false, unique = true)
	private String username;
	
	@Column(name = "nombre_completo", nullable = true)
	private String nombres;

	@Column(name = "clave", nullable = false, unique = true)
	private String password;

	/*
	 * @Column(name="rol", nullable=false) private String rol;
	 */

	@Column(name = "estado", nullable = false)
	private boolean enabled;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "id_usuario", referencedColumnName = "idUsuario"), inverseJoinColumns = @JoinColumn(name = "id_rol", referencedColumnName = "idRol"))
	private List<Rol> roles;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "usuario_sub_recurso", joinColumns = @JoinColumn(name = "id_usuario", referencedColumnName = "idUsuario"), inverseJoinColumns = @JoinColumn(name = "id_sub_recurso", referencedColumnName = "idSubRecurso"))
	private List<SubRecurso> subRecursos;

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}

	public List<SubRecurso> getSubRecursos() {
		return subRecursos;
	}

	public void setSubRecursos(List<SubRecurso> subRecursos) {
		this.subRecursos = subRecursos;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	
}
