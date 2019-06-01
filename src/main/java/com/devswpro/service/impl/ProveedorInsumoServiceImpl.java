package com.devswpro.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devswpro.dao.IProveedorInsumoDAO;
import com.devswpro.model.ProveedorInsumo;
import com.devswpro.service.IProveedorInsumoService;

@Service
public class ProveedorInsumoServiceImpl implements IProveedorInsumoService{

	@Autowired
	private IProveedorInsumoDAO dao;
	
	@Override
	public ProveedorInsumo registrar(ProveedorInsumo obj) {
		return dao.save(obj);
	}

	@Override
	public ProveedorInsumo modificar(ProveedorInsumo obj) {
		return dao.save(obj);
	}

	@Override
	public List<ProveedorInsumo> listar() {
		return dao.findAll();
	}

	@Override
	public ProveedorInsumo leer(Integer id) {
		Optional<ProveedorInsumo> op = dao.findById(id);
		return op.isPresent() ? op.get() : new ProveedorInsumo();
	}

	@Override
	public void eliminar(Integer id) {
		dao.deleteById(id);
		
	}



}
