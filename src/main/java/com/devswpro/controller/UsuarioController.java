package com.devswpro.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devswpro.dto.UsuarioDTO;
import com.devswpro.model.Usuario;
import com.devswpro.service.impl.UsuarioServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UsuarioController {
	
	private static final Log logger = LogFactory.getLog(UsuarioController.class);
	
	@Autowired
	private UsuarioServiceImpl usuarioService;

	@PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> login(@RequestBody UsuarioDTO usuario) {
		logger.info(usuario.getUsername());
		logger.info(usuario.getPassword());
		Usuario user = usuarioService.login(usuario);
		return new ResponseEntity<Usuario>(user, HttpStatus.OK);
	}
	
	
}
