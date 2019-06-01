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
import com.devswpro.model.ProveedorInsumo;
import com.devswpro.service.IProveedorInsumoService;

@RestController
@RequestMapping("/proveedorInsumos")
public class ProveedorInsumoController {
	

	@Autowired
	private IProveedorInsumoService service;
	
	@GetMapping(produces="application/json")
	public ResponseEntity<List<ProveedorInsumo>>  listar(){
		List<ProveedorInsumo> lista=service.listar();
		return new ResponseEntity<List<ProveedorInsumo>>(lista,HttpStatus.OK);
	}

	@GetMapping(value="/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Resource<ProveedorInsumo> listarPorId(@PathVariable("id")Integer id) {
		ProveedorInsumo provee= service.leer(id);
		if(provee.getIdProveedorInsumo()==null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: "+ id);
		}
		Resource<ProveedorInsumo> resource = new Resource<ProveedorInsumo>(provee);
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listarPorId(id));
		resource.add(linkTo.withRel("Entidad-resource"));	
		return resource;
	}
	
	@PostMapping(produces="application/json",consumes="application/json")
	public ResponseEntity<ProveedorInsumo> registrar(@Valid @RequestBody ProveedorInsumo pro) {
		ProveedorInsumo provee = service.registrar(pro);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(provee.getIdProveedorInsumo()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping(produces="application/json",consumes="application/json")
	public ResponseEntity<Object> modificar(@Valid @RequestBody ProveedorInsumo pro) {
		service.modificar(pro);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{id}")
	public void eliminar(@PathVariable("id") Integer id){
		ProveedorInsumo Tip = service.leer(id);

		if (Tip.getIdProveedorInsumo() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		} else {
			service.eliminar(id);
		}
	}	
}
