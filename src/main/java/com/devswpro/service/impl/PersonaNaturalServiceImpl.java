package com.devswpro.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devswpro.dao.IPersonaNaturalDAO;
import com.devswpro.model.PersonaNatural;
import com.devswpro.service.IPersonaNaturalService;

@Service
public class PersonaNaturalServiceImpl implements IPersonaNaturalService{

	
	@Autowired
	private IPersonaNaturalDAO dao;
	
	@Override
	public PersonaNatural registrar(PersonaNatural obj) {
		return dao.save(obj);
	}

	@Override
	public PersonaNatural modificar(PersonaNatural obj) {
		return dao.save(obj);
	}

	@Override
	public List<PersonaNatural> listar() {
		return dao.findAll();
	}

	@Override
	public PersonaNatural leer(Integer id) {
		Optional<PersonaNatural> op = dao.findById(id);
		return op.isPresent() ? op.get() : new PersonaNatural();
	}

	@Override
	public void eliminar(Integer id) {
		dao.deleteById(id);
		
	}
} 
