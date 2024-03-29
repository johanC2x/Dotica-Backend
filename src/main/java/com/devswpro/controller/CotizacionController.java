package com.devswpro.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.devswpro.model.Cotizacion;
import com.devswpro.service.ICotizacionService;

@CrossOrigin
@RestController
@RequestMapping("/cotizacion")
public class CotizacionController {

	@Autowired
	private ICotizacionService service;

	@GetMapping(produces = "application/json")
	public ResponseEntity<List<Cotizacion>> listar() {
		List<Cotizacion> lista = service.listar();
		return new ResponseEntity<List<Cotizacion>>(lista, HttpStatus.OK);
	}
	
	@GetMapping(value = "/state", produces = "application/json")
	public ResponseEntity<List<Cotizacion>> listarPorEstado() {
		List<Cotizacion> lista = service.listar();
		lista = lista.stream().filter(coti -> !coti.getEstado().replaceAll(" ","").equals("Aprobado")).collect(Collectors.toList());
		return new ResponseEntity<List<Cotizacion>>(lista, HttpStatus.OK);
	}
	
	@GetMapping(value = "/state/requerido", produces = "application/json")
	public ResponseEntity<List<Cotizacion>> listarPorEstadoRequerido() {
		List<Cotizacion> lista = service.listar();
		lista = lista.stream().filter(coti -> !coti.getEstado().replaceAll(" ","").equals("Requerido")).collect(Collectors.toList());
		return new ResponseEntity<List<Cotizacion>>(lista, HttpStatus.OK);
	}
	
	@GetMapping(value = "/state/cotizado", produces = "application/json")
	public ResponseEntity<List<Cotizacion>> listarPorEstadoCotizado() {
		List<Cotizacion> lista = service.listar();
		lista = lista.stream().filter(coti -> !coti.getEstado().replaceAll(" ","").equals("Cotizado")).collect(Collectors.toList());
		return new ResponseEntity<List<Cotizacion>>(lista, HttpStatus.OK);
	}
	
	@GetMapping(value = "/state/aprobado", produces = "application/json")
	public ResponseEntity<List<Cotizacion>> listarPorEstadoAprobado() {
		List<Cotizacion> lista = service.listar();
		lista = lista.stream().filter(coti -> !coti.getEstado().replaceAll(" ","").equals("Aprobado")).collect(Collectors.toList());
		return new ResponseEntity<List<Cotizacion>>(lista, HttpStatus.OK);
	}
	
	@GetMapping(value = "/state/aprobadoa1", produces = "application/json")
	public ResponseEntity<List<Cotizacion>> listarPorEstadoAprobadoA1() {
		List<Cotizacion> lista = service.listar();
		lista = lista.stream().filter(coti -> !coti.getEstado().replaceAll(" ","").equals("AprobadoA1")).collect(Collectors.toList());
		return new ResponseEntity<List<Cotizacion>>(lista, HttpStatus.OK);
	}
	
	@GetMapping(value = "/state/aprobadoa2", produces = "application/json")
	public ResponseEntity<List<Cotizacion>> listarPorEstadoAprobadoA2() {
		List<Cotizacion> lista = service.listar();
		lista = lista.stream().filter(coti -> !coti.getEstado().replaceAll(" ","").equals("AprobadoA2")).collect(Collectors.toList());
		return new ResponseEntity<List<Cotizacion>>(lista, HttpStatus.OK);
	}
	
	@GetMapping(value = "/max", produces = "application/json")
	public ResponseEntity<Cotizacion> obtenerMaxId(){
		List<Cotizacion> lista = service.listar();
		Optional<Cotizacion> coti = lista.stream().reduce((a,b) -> a.getIdCotizacion().compareTo(b.getIdCotizacion()) > 0 ? a:b);
		return new ResponseEntity<Cotizacion>(coti.get(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Resource<Cotizacion> listarPorId(@PathVariable("id") Integer id) {
		Cotizacion cotizacion = service.leer(id);
		if (cotizacion.getIdCotizacion() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		}
		Resource<Cotizacion> resource = new Resource<Cotizacion>(cotizacion);
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listarPorId(id));
		resource.add(linkTo.withRel("Cotizacion-resource"));
		return resource;
	}
	
	@PostMapping(produces="application/json",consumes="application/json")
	public ResponseEntity<Cotizacion> registrar(@Valid @RequestBody Cotizacion cotizacion) {
		Cotizacion t = service.registrar(cotizacion);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(t.getIdCotizacion()).toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping(produces="application/json",consumes="application/json")
	public ResponseEntity<Object> modificar(@Valid @RequestBody Cotizacion cotizacion) {
		service.modificar(cotizacion);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{id}")
	public void eliminar(@PathVariable("id") Integer id){
		Cotizacion cotizacion = service.leer(id);
		if (cotizacion.getIdCotizacion() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		} else {
			service.eliminar(id);
		}
	}	
	
}
