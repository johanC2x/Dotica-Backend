package com.devswpro.service.impl;

import java.util.List;
import java.util.Optional;

import com.devswpro.dao.IAccessDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devswpro.dao.IUsuarioDAO;
import com.devswpro.dto.UsuarioDTO;
import com.devswpro.model.Usuario;
import com.devswpro.service.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	private IUsuarioDAO dao;

	@Autowired
	private IAccessDAO accessDAO;

	@Override
	public Usuario login(UsuarioDTO usuarioDTO) {
		return dao.findByUsernameAndPassword(usuarioDTO.getUsername(), usuarioDTO.getPassword());
	}

	@Override
	public Usuario registrar(Usuario obj) {
		return dao.save(obj);
	}

	@Override
	public Usuario modificar(Usuario obj) {
		return dao.save(obj);
	}

	@Override
	public List<Usuario> listar() {
		return dao.findAll();
	}

	@Override
	public Usuario leer(Integer id) {
		Optional<Usuario> op = dao.findById(id);
		return op.isPresent() ? op.get() : new Usuario();
	}
	
	public Usuario leerPorUsuario(String userName){
		Usuario op = dao.findOneByUsername(userName);
		return op != null ? op : new Usuario();
	}

	@Override
	public void eliminar(Integer id) {
		dao.deleteById(id);
	}
	
	
	
}
