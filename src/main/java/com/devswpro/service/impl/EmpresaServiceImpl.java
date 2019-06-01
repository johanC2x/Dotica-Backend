package com.devswpro.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.devswpro.dao.IEmpresaDAO;
import com.devswpro.model.Empresa;
import com.devswpro.service.IEmpresaService;

@Service
public class EmpresaServiceImpl implements IEmpresaService {

	@Autowired
	private IEmpresaDAO dao;
	 
	
	@Override
	public Empresa registrar(Empresa obj) {
		return dao.save(obj);
	}

	@Override
	public Empresa modificar(Empresa obj) {
		return dao.save(obj);
	}

	@Override
	public List<Empresa> listar() {
		return dao.findAll();
	}

	@Override
	public Empresa leer(Integer id) {
		Optional<Empresa> op = dao.findById(id);
		return op.isPresent() ? op.get() : new Empresa();
	}

	@Override
	public void eliminar(Integer id) {
		dao.deleteById(id);		
	}
	
	

}
