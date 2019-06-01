package com.devswpro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="config")
public class Config {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idConfig;
	
	@Column(name="parametro",length=5)
	private String parametro;
	
	@Column(name="valor",length=25)
	private String valor;
	
	protected Integer getIdConfig() {
		return idConfig;
	}
	protected void setIdConfig(Integer idConfig) {
		this.idConfig = idConfig;
	}
	protected String getParametro() {
		return parametro;
	}
	protected void setParametro(String parametro) {
		this.parametro = parametro;
	}
	protected String getValor() {
		return valor;
	}
	protected void setValor(String valor) {
		this.valor = valor;
	}
	

}
