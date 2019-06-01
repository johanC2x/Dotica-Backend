package com.devswpro.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devswpro.dao.ITipoProductoDAO;
import com.devswpro.model.TipoProducto;
import com.devswpro.service.ITipoProductoService;


@Service
public class TipoProductoServiceImpl implements ITipoProductoService {
	
	
	@Autowired
	private ITipoProductoDAO dao;
	
	@Override
	public TipoProducto registrar(TipoProducto obj) {
		return dao.save(obj);
	}

	@Override
	public TipoProducto modificar(TipoProducto obj) {
		return dao.save(obj);
	}

	@Override
	public List<TipoProducto> listar() {
		return dao.findAll();
	}

	@Override
	public TipoProducto leer(Integer id) {
		Optional<TipoProducto> op = dao.findById(id);
		return op.isPresent() ? op.get() : new TipoProducto();
	}

	@Override
	public void eliminar(Integer id) {
		dao.deleteById(id);
		
	}

}
