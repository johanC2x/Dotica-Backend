package com.devswpro.service;

import com.devswpro.dto.UsuarioDTO;
import com.devswpro.model.Usuario;

public interface IUsuarioService {
	
	Usuario login(UsuarioDTO usuarioDTO);
	
}
