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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devswpro.dto.FiltroProductoDTO;
import com.devswpro.dto.ProductoListaInsumoDTO;
import com.devswpro.exception.ModeloNotFoundException;
import com.devswpro.model.Producto;
import com.devswpro.service.IProductoService;

@RestController
@RequestMapping("/productos")

public class ProductoController {
	
	@Autowired 
	private IProductoService service;
	
	@GetMapping(produces="application/json")
	public ResponseEntity<List<Producto>>  listar(){
		List<Producto> lista=service.listar();
		return new ResponseEntity<List<Producto>>(lista,HttpStatus.OK);
	}

	@GetMapping(value="/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Resource<Producto> listarPorId(@PathVariable("id")Integer id) {
		Producto prod= service.leer(id);
		if(prod.getIdProducto()==null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: "+ id);
		}
		Resource<Producto> resource = new Resource<Producto>(prod);
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listarPorId(id));
		resource.add(linkTo.withRel("Producto-resource"));	
		return resource;
	}
	
	@PostMapping(produces="application/json",consumes="application/json")
	public ResponseEntity<Producto> registrar(@Valid @RequestBody ProductoListaInsumoDTO prodDTO) {
		Producto pro = service.registrarTransaccional(prodDTO);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pro.getIdProducto()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping(produces="application/json",consumes="application/json")
	public ResponseEntity<Object> modificar(@Valid @RequestBody Producto prod) {
		service.modificar(prod);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{id}")
	public void eliminar(@PathVariable("id") Integer id){
		Producto pro = service.leer(id);

		if (pro.getIdProducto() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		} else {
			service.eliminar(id);
		}
	}
	
 //######### controller buscar ##################
	

	@PostMapping(value = "/buscar", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Producto>> buscar(@RequestBody FiltroProductoDTO filtro) {
		List<Producto> producto = new ArrayList<>();
	
		
		
		System.out.println(" sensar 0 ="+filtro.getNombreProveedorProducto());
		
		//System.out.println(" sensar tipoCONTROLLER ="+filtro.getNombretipoProducto());
		filtro.getClass().getTypeParameters();
		if (filtro != null) {
			if (filtro.getNombreProveedorProducto()!= null) {
				producto = service.buscar(filtro);
			}
		}
		return new ResponseEntity<List<Producto>>(producto, HttpStatus.OK);
	}
	
	
	
	
	

}
