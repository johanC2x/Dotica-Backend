package com.devswpro.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devswpro.dao.IProveedorProductoDAO;
import com.devswpro.model.ProveedorProducto;
import com.devswpro.service.IProveedorProductoService;

@Service
public class ProveedorProductoServiceImpl implements IProveedorProductoService{

	@Autowired
	private IProveedorProductoDAO dao;
	
	@Override
	public ProveedorProducto registrar(ProveedorProducto obj) {
		return dao.save(obj);
	}

	@Override
	public ProveedorProducto modificar(ProveedorProducto obj) {
		return dao.save(obj);
	}

	@Override
	public List<ProveedorProducto> listar() {
		return dao.findAll();
	}

	@Override
	public ProveedorProducto leer(Integer id) {
		Optional<ProveedorProducto> op = dao.findById(id);
		return op.isPresent() ? op.get() : new ProveedorProducto();
	}

	@Override
	public void eliminar(Integer id) {
		dao.deleteById(id); 
		
	}
	
	


}
