package com.devswpro.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devswpro.dao.IKitDAO;
import com.devswpro.model.Kit;
import com.devswpro.service.IKitService;

@Service
public class KitServiceImpl implements IKitService{
	
	@Autowired
	private IKitDAO dao;
	
	@Override
	public Kit registrar(Kit obj) {
		return dao.save(obj);
	}

	@Override
	public Kit modificar(Kit obj) {
		return dao.save(obj);
	}

	@Override
	public List<Kit> listar() {
		return dao.findAll();
	}

	@Override
	public Kit leer(Integer id) {
		Optional<Kit> op = dao.findById(id);
		return op.isPresent() ? op.get() : new Kit();
	}

	@Override
	public void eliminar(Integer id) {
		dao.deleteById(id);		
	}


}
