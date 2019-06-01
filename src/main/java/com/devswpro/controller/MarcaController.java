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
import com.devswpro.model.Marca;
import com.devswpro.service.IMarcaService;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RestController
@RequestMapping("/marcas")
public class MarcaController {

	@Autowired 
	private IMarcaService service;
	
	@GetMapping(produces="application/json")
	public ResponseEntity<List<Marca>>  listar(){
		List<Marca> lista=service.listar();
		return new ResponseEntity<List<Marca>>(lista,HttpStatus.OK);
	}

	@GetMapping(value="/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Resource<Marca> listarPorId(@PathVariable("id")Integer id) {
		Marca mar= service.leer(id);
		if(mar.getIdMarca()==null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: "+ id);
		}
		Resource<Marca> resource = new Resource<Marca>(mar);
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listarPorId(id));
		resource.add(linkTo.withRel("Marca-resource"));	
		return resource;
	
	}
	@PostMapping(produces="application/json",consumes="application/json")
	public ResponseEntity<Marca> registrar(@Valid @RequestBody Marca mar) {
		Marca t = service.registrar(mar);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(t.getIdMarca()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping(produces="application/json",consumes="application/json")
	public ResponseEntity<Object> modificar(@Valid @RequestBody Marca mar) {
		service.modificar(mar);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{id}")
	public void eliminar(@PathVariable("id") Integer id){
		Marca mar = service.leer(id);

		if (mar.getIdMarca() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		} else {
			service.eliminar(id);
		}
	}	
	
	
	
}
