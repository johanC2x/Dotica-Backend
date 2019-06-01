 package com.devswpro.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.devswpro.dao.IProveedorClientesDAO;
import com.devswpro.model.ProveedorClientes;
import com.devswpro.service.IProveedorClientesService;

@Service
public class ProveedorClientesServiceImpl  implements IProveedorClientesService{

	@Autowired
	private IProveedorClientesDAO dao;
	
	@Override
	public ProveedorClientes registrar(ProveedorClientes obj) {
		return dao.save(obj);
	}

	@Override
	public ProveedorClientes modificar(ProveedorClientes obj) {
		return dao.save(obj);
	}

	@Override
	public List<ProveedorClientes> listar() {
		return dao.findAll();
	}

	@Override
	public ProveedorClientes leer(Integer id) {
		Optional<ProveedorClientes> op = dao.findById(id);
		return op.isPresent() ? op.get() : new ProveedorClientes();
	}

	@Override
	public void eliminar(Integer id) {
		dao.deleteById(id);	
	}

}
