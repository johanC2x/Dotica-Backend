package com.devswpro.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.devswpro.dao.ITicketDAO;
import com.devswpro.model.Ticket;
import com.devswpro.service.ITicketService;

@Service
public class TicketServiceImpl implements ITicketService {

	@Autowired
	private ITicketDAO dao;
	
	@Override
	public Ticket registrar(Ticket obj) {
		return dao.save(obj);
	}

	@Override
	public Ticket modificar(Ticket obj) {
		return dao.save(obj);
	}

	@Override
	public List<Ticket> listar() {
		return dao.findAll();
	}

	@Override
	public Ticket leer(Integer id) {
		Optional<Ticket> op = dao.findById(id);
		return op.isPresent() ? op.get() : new Ticket();
	}

	@Override
	public void eliminar(Integer id) {
		dao.deleteById(id);
		
	}
	
}
