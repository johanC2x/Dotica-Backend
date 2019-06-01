package com.devswpro.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devswpro.dao.IEmpleadoDAO;
import com.devswpro.model.Empleado;
import com.devswpro.service.IEmpleadoService;

@Service
public class EmpleadoServiceImpl   implements IEmpleadoService{

	@Autowired
	private IEmpleadoDAO dao;

	@Override
	public Empleado registrar(Empleado obj) {
		return dao.save(obj);
	}

	@Override
	public Empleado modificar(Empleado obj) {
		return dao.save(obj);
	}

	@Override
	public List<Empleado> listar() {
		return dao.findAll();
	}

	@Override
	public Empleado leer(Integer id) {
		Optional<Empleado> op = dao.findById(id);
		return op.isPresent() ? op.get() : new Empleado();
	}

	@Override
	public void eliminar(Integer id) {
		dao.deleteById(id);
		
	}
	

	
}
