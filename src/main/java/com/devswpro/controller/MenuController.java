package com.devswpro.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devswpro.model.Menu;
import com.devswpro.model.Usuario;
import com.devswpro.service.IMenuService;

@RestController
@RequestMapping("/menus")
public class MenuController {
	
	@Autowired
	private IMenuService service;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Menu>> listar() {
		List<Menu> menues = new ArrayList<>();
		menues = service.listar();
		return new ResponseEntity<List<Menu>>(menues, HttpStatus.OK);
	}
	
	@PostMapping(value = "/usuario", produces = "application/json", consumes="application/json")
	public ResponseEntity<List<Menu>> listar(@RequestBody Usuario usuario) {
		System.out.println("=>>>" + usuario.getUsername());
		List<Menu> menues = new ArrayList<>();
		menues = service.listarMenuPorUsuario(usuario.getUsername());
		return new ResponseEntity<List<Menu>>(menues, HttpStatus.OK);
	}
	
}