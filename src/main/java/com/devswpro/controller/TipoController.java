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
import com.devswpro.model.Tipo;
import com.devswpro.service.ITipoService;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RestController
@RequestMapping("/tipos")
public class TipoController {

	
	@Autowired 
	private ITipoService service;
	
	@GetMapping(produces="application/json")
	public ResponseEntity<List<Tipo>>  listar(){
		List<Tipo> lista=service.listar();
		return new ResponseEntity<List<Tipo>>(lista,HttpStatus.OK);
	}

	@GetMapping(value="/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Resource<Tipo> listarPorId(@PathVariable("id")Integer id) {
		Tipo tip= service.leer(id);
		if(tip.getIdTipo()==null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: "+ id);
		}
		Resource<Tipo> resource = new Resource<Tipo>(tip);
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listarPorId(id));
		resource.add(linkTo.withRel("Tipo-resource"));	
		return resource;
	}
	
	@PostMapping(produces="application/json",consumes="application/json")
	public ResponseEntity<Tipo> registrar(@Valid @RequestBody Tipo tip) {
		Tipo t = service.registrar(tip);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(t.getIdTipo()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping(produces="application/json",consumes="application/json")
	public ResponseEntity<Object> modificar(@Valid @RequestBody Tipo Tip) {
		service.modificar(Tip);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{id}")
	public void eliminar(@PathVariable("id") Integer id){
		Tipo Tip = service.leer(id);

		if (Tip.getIdTipo() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		} else {
			service.eliminar(id);
		}
	}
}
