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
import com.devswpro.model.ProveedorProducto;
import com.devswpro.service.IProveedorProductoService;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RestController
@RequestMapping("/proveedorProductos")
public class ProveedorProductoController {

	@Autowired
	private IProveedorProductoService service;
	
	@GetMapping(produces="application/json")
	public ResponseEntity<List<ProveedorProducto>>  listar(){
		List<ProveedorProducto> lista=service.listar();
		return new ResponseEntity<List<ProveedorProducto>>(lista,HttpStatus.OK);
	}

	@GetMapping(value="/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Resource<ProveedorProducto> listarPorId(@PathVariable("id")Integer id) {
		ProveedorProducto provee= service.leer(id);
		if(provee.getIdProveedorProducto()==null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: "+ id);
		}
		Resource<ProveedorProducto> resource = new Resource<ProveedorProducto>(provee);
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listarPorId(id));
		resource.add(linkTo.withRel("Entidad-resource"));	
		return resource;
	}
	
	@PostMapping(produces="application/json",consumes="application/json")
	public ResponseEntity<ProveedorProducto> registrar(@Valid @RequestBody ProveedorProducto pro) {
		ProveedorProducto provee = service.registrar(pro);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(provee.getIdProveedorProducto()).toUri();
		return ResponseEntity.created(location).build();
		
	}
	
	@PutMapping(produces="application/json",consumes="application/json")
	public ResponseEntity<Object> modificar(@Valid @RequestBody ProveedorProducto pro) {
		service.modificar(pro);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{id}")
	public void eliminar(@PathVariable("id") Integer id){
		ProveedorProducto Tip = service.leer(id);

		if (Tip.getIdProveedorProducto() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		} else {
			service.eliminar(id);
		}
	}		
	
	
}
