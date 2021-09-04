package com.devswpro.service;

import com.devswpro.dto.UsuarioDTO;
import com.devswpro.model.Usuario;

public interface IUsuarioService extends ICRUD<Usuario> {
	
	Usuario login(UsuarioDTO usuarioDTO);
	void sendEmail(String email);
	boolean reset(UsuarioDTO usuarioDTO);
}
