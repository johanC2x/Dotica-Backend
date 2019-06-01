package com.devswpro.service.impl;

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

	@Override
	public Usuario login(UsuarioDTO usuarioDTO) {
		return dao.findByUsernameAndPassword(usuarioDTO.getUsername(), usuarioDTO.getPassword());
	}
	
}
