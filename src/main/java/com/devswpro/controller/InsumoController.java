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
import com.devswpro.model.Insumo;
import com.devswpro.service.IInsumoService;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RestController
@RequestMapping("/insumos")
public class InsumoController {

	@Autowired 
	private IInsumoService service;
	
	@GetMapping(produces="application/json")
	public ResponseEntity<List<Insumo>>  listar(){
		List<Insumo> lista=service.listar();
		return new ResponseEntity<List<Insumo>>(lista,HttpStatus.OK);
	}

	@GetMapping(value="/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Resource<Insumo> listarPorId(@PathVariable("id")Integer id) {
		Insumo insu= service.leer(id);
		if(insu.getIdInsumo()==null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: "+ id);
		}
		Resource<Insumo> resource = new Resource<Insumo>(insu);
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listarPorId(id));
		resource.add(linkTo.withRel("Insumo-resource"));	
		return resource;
	
	}
	@PostMapping(produces="application/json",consumes="application/json")
	public ResponseEntity<Insumo> registrar(@Valid @RequestBody Insumo insu) {
		Insumo t = service.registrar(insu);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(t.getIdInsumo()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping(produces="application/json",consumes="application/json")
	public ResponseEntity<Object> modificar(@Valid @RequestBody Insumo Tip) {
		service.modificar(Tip);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{id}")
	public void eliminar(@PathVariable("id") Integer id){
		Insumo Tip = service.leer(id);

		if (Tip.getIdInsumo() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		} else {
			service.eliminar(id);
		}
	}	
	
	
}
