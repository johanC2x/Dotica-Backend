package com.devswpro.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devswpro.dao.ICotizacionDAO;
import com.devswpro.model.Cotizacion;
import com.devswpro.service.ICotizacionService;

@Service
public class CotizacionServiceImpl implements ICotizacionService {

	@Autowired
	private ICotizacionDAO dao;

	@Override
	public Cotizacion registrar(Cotizacion obj) {
		return dao.save(obj);
	}

	@Override
	public Cotizacion modificar(Cotizacion obj) {
		return dao.save(obj);
	}

	@Override
	public List<Cotizacion> listar() {
		return dao.findAll();
	}
	
	@Override
	public Cotizacion leer(Integer id) {
		Optional<Cotizacion> op = dao.findById(id);
		return op.isPresent() ? op.get() : new Cotizacion();
	}

	@Override
	public void eliminar(Integer id) {
		dao.deleteById(id);
	}
	
}
