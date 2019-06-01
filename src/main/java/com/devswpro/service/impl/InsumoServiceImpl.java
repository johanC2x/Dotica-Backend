package com.devswpro.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.devswpro.dao.IInsumoDAO;
import com.devswpro.model.Insumo;
import com.devswpro.service.IInsumoService;

@Service
public class InsumoServiceImpl implements IInsumoService{

	@Autowired
	private IInsumoDAO dao;
	
	@Override
	public Insumo registrar(Insumo obj) {
		return dao.save(obj);
	}

	@Override
	public Insumo modificar(Insumo obj) {
		return dao.save(obj);
	}

	@Override
	public List<Insumo> listar() {
		return dao.findAll();
	}

	@Override
	public Insumo leer(Integer id) {
		Optional<Insumo> op = dao.findById(id);
		return op.isPresent() ? op.get() : new Insumo();
	}

	@Override
	public void eliminar(Integer id) {
		dao.deleteById(id);
		
	}
	
	

}
