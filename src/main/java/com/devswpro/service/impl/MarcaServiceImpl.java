package com.devswpro.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devswpro.dao.IMarcaDAO;
import com.devswpro.model.Marca;
import com.devswpro.service.IMarcaService;

@Service
public class MarcaServiceImpl implements IMarcaService {

	@Autowired
	private IMarcaDAO dao;
	
	@Override
	public Marca registrar(Marca obj) {
		return dao.save(obj);
	}

	@Override
	public Marca modificar(Marca obj) {
		return dao.save(obj);
	}

	@Override
	public List<Marca> listar() {
		return dao.findAll();
	}

	@Override
	public Marca leer(Integer id) {
		Optional<Marca> op = dao.findById(id);
		return op.isPresent() ? op.get() : new Marca();
	}

	@Override
	public void eliminar(Integer id) {
		dao.deleteById(id);
		
	}
	

}
