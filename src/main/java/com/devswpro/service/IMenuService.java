package com.devswpro.service;

import java.util.List;

import com.devswpro.model.Menu;

public interface IMenuService extends ICRUD<Menu>{
	
	List<Menu> listarMenuPorUsuario(String nombre);
}
