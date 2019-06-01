package com.devswpro.controller;


import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devswpro.exception.ModeloNotFoundException;
import com.devswpro.model.PersonaNatural;
import com.devswpro.service.IPersonaNaturalService;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RestController
@RequestMapping("/personasNaturales")
public class PersonaNaturalController {

	@Autowired 
	private IPersonaNaturalService service;
	
	@GetMapping(produces="application/json")
	public ResponseEntity<List<PersonaNatural>>  listar(){
		List<PersonaNatural> lista=service.listar();
		return new ResponseEntity<List<PersonaNatural>>(lista,HttpStatus.OK);
	}

	@GetMapping(value="/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Resource<PersonaNatural> listarPorId(@PathVariable("id")Integer id) {
		PersonaNatural pnl= service.leer(id);
		if(pnl.getIdPersonaNatural()==null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: "+ id);
		}
		Resource<PersonaNatural> resource = new Resource<PersonaNatural>(pnl);
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listarPorId(id));
		resource.add(linkTo.withRel("PersonaNatural-resource"));	
		return resource;
	}
	
	@PostMapping(produces="application/json",consumes="application/json")
	public ResponseEntity<PersonaNatural> registrar(@Valid @RequestBody PersonaNatural pnl) {
		PersonaNatural pn = service.registrar(pnl);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pn.getIdPersonaNatural()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping(produces="application/json",consumes="application/json")
	public ResponseEntity<Object> modificar(@Valid @RequestBody PersonaNatural pnl) {
		service.modificar(pnl);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{id}")
	public void eliminar(@PathVariable("id") Integer id){
		PersonaNatural pnl = service.leer(id);

		if (pnl.getIdPersonaNatural() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		} else {
			service.eliminar(id);
		}
	}	
	
	
}
