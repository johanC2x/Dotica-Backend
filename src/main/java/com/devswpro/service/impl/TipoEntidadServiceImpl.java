package com.devswpro.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.devswpro.dao.ITipoEntidadDAO;
import com.devswpro.model.TipoEntidad;
import com.devswpro.service.ITipoEntidadService;

@Service
public class TipoEntidadServiceImpl implements ITipoEntidadService{

	@Autowired
	private ITipoEntidadDAO dao;
	
	@Override
	public TipoEntidad registrar(TipoEntidad obj) {
		return dao.save(obj);
	}

	@Override
	public TipoEntidad modificar(TipoEntidad obj) {
		return dao.save(obj);
	}

	@Override
	public List<TipoEntidad> listar() {
		return dao.findAll();
	}

	@Override
	public TipoEntidad leer(Integer id) {
		Optional<TipoEntidad> op = dao.findById(id);
		return op.isPresent() ? op.get() : new TipoEntidad();
	}

	@Override
	public void eliminar(Integer id) {
		dao.deleteById(id);
		
	}
	

}
