package com.devswpro.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devswpro.dto.UsuarioDTO;
import com.devswpro.exception.ModeloNotFoundException;
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
	
	@GetMapping(value="/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public Resource<Menu> obtenerPorId(@PathVariable("id")Integer id) {
		Menu menu = service.leer(id);
		if(menu.getIdMenu() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: "+ id);
		}
		Resource<Menu> resource = new Resource<Menu>(menu);
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).obtenerPorId(id));
		resource.add(linkTo.withRel("Producto-resource"));	
		return resource;
	}
	
	@PostMapping(value = "/usuario", produces = "application/json", consumes="application/json")
	public ResponseEntity<List<Menu>> listar(@RequestBody Usuario usuario) {
		List<Menu> menues = new ArrayList<>();
		menues = service.listarMenuPorUsuario(usuario.getUsername());
		return new ResponseEntity<List<Menu>>(menues, HttpStatus.OK);
	}
	
	@PostMapping(produces="application/json",consumes="application/json")
	public ResponseEntity<Menu> registrar(@Valid @RequestBody Menu menu) {
		Menu response = service.registrar(menu);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(response.getIdMenu()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping(produces="application/json",consumes="application/json")
	public ResponseEntity<Menu> actualizar(@Valid @RequestBody Menu menu) {
		Menu response = service.registrar(menu);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(response.getIdMenu()).toUri();
		return ResponseEntity.created(location).build();
	}
	
}
