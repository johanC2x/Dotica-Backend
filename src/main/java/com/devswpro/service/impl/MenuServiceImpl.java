package com.devswpro.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devswpro.dao.IMenuDAO;
import com.devswpro.model.Menu;
import com.devswpro.model.SubMenu;
import com.devswpro.service.IMenuService;


@Service
public class MenuServiceImpl implements IMenuService {

	@Autowired
	private IMenuDAO dao;

	@Override
	public Menu registrar(Menu menu) {
		return dao.save(menu);
	}

	@Override
	public Menu modificar(Menu menu) {
		return dao.save(menu);
	}

	
	@Override
	public void eliminar(Integer id) {
		dao.deleteById(id);
	}
	
	/*
	@Override
	public Optional<Menu> leer(Integer id) {
		return dao.findByI(id);
	}
	*/
	
	@Override
	public List<Menu> listar() {
		return dao.findAll();
	}

	@Override
	public List<Menu> listarMenuPorUsuario(String nombre) {		
		List<Menu> menus = new ArrayList<>();
		dao.listarMenuPorUsuario(nombre).forEach( x -> {
			Menu m = new Menu();
			m.setIdMenu((Integer.parseInt(String.valueOf(x[0]))));
			m.setIcono(String.valueOf(x[1]));
			m.setNombre(String.valueOf(x[2]));
			m.setUrl(String.valueOf(x[3]));
			m.setShow(0);
			List<SubMenu> lista = new ArrayList<SubMenu>();
			Integer idPadre = Integer.parseInt(String.valueOf(x[0]));
			dao.listarSubMenuPorUsuario(nombre,idPadre).forEach( y -> {
				SubMenu subMenu = new SubMenu();
				subMenu.setId((Integer.parseInt(String.valueOf(y[0]))));
				subMenu.setIcono(String.valueOf(y[1]));
				subMenu.setNombre(String.valueOf(y[2]));
				subMenu.setRuta(String.valueOf(y[3]));
				lista.add(subMenu);
			});
			m.setSubMenu(lista);
			menus.add(m);
		});
		return menus;			
	}

	@Override
	public Menu leer(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
