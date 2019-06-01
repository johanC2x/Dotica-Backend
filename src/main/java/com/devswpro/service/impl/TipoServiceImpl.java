package com.devswpro.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devswpro.dao.ITipoDAO;
import com.devswpro.model.Tipo;
import com.devswpro.service.ITipoService;


@Service
public class TipoServiceImpl  implements ITipoService{

	@Autowired
	private ITipoDAO dao;

	@Override
	public Tipo registrar(Tipo obj) {
		return dao.save(obj);
	}

	@Override
	public Tipo modificar(Tipo obj) {
		return dao.save(obj);
	}

	@Override
	public List<Tipo> listar() {
		return dao.findAll();
	}

	@Override
	public Tipo leer(Integer id) {
		Optional<Tipo> op = dao.findById(id);
		return op.isPresent() ? op.get() : new Tipo();
	}

	@Override
	public void eliminar(Integer id) {
		dao.deleteById(id);		
	}
	

}
