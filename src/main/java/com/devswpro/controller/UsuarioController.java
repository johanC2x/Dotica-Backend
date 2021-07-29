package com.devswpro.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import com.devswpro.dto.AccessDTO;
import com.devswpro.model.IntAccess;
import com.devswpro.service.impl.AccessServiceImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devswpro.dto.ProductoListaInsumoDTO;
import com.devswpro.dto.UsuarioDTO;
import com.devswpro.exception.ModeloNotFoundException;
import com.devswpro.model.Empleado;
import com.devswpro.model.Producto;
import com.devswpro.model.Usuario;
import com.devswpro.service.impl.EmpleadoServiceImpl;
import com.devswpro.service.impl.UsuarioServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UsuarioController {
	
	private static final Log logger = LogFactory.getLog(UsuarioController.class);
	
	@Autowired
	private UsuarioServiceImpl usuarioService;
	
	@Autowired
	private EmpleadoServiceImpl empleadoService;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;

	@Autowired
	private AccessServiceImpl accessService;

	@PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> login(@RequestBody UsuarioDTO usuario) {
		logger.info(usuario.getUsername());
		logger.info(usuario.getPassword());
		Usuario user = usuarioService.login(usuario);
		return new ResponseEntity<Usuario>(user, HttpStatus.OK);
	}
	
	@GetMapping(produces="application/json")
	public ResponseEntity<List<Usuario>>  listar(){
		List<Usuario> lista=usuarioService.listar();
		return new ResponseEntity<List<Usuario>>(lista,HttpStatus.OK);
	}
	
	@GetMapping(value="/empleado", produces="application/json")
	public ResponseEntity<List<Empleado>>  listarEmpleado(){
		List<Empleado> lista=empleadoService.listar();
		return new ResponseEntity<List<Empleado>>(lista,HttpStatus.OK);
	}
	
	@GetMapping(value="/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Resource<UsuarioDTO> listarPorId(@PathVariable("id")Integer id) {
		Usuario usuario = usuarioService.leer(id);
		if(usuario.getIdUsuario() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: "+ id);
		}
		UsuarioDTO userDTO = new UsuarioDTO();
		userDTO.setId(usuario.getIdUsuario().toString());
		userDTO.setUsername(usuario.getUsername());
		Resource<UsuarioDTO> resource = new Resource<UsuarioDTO>(userDTO);
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listarPorId(id));
		resource.add(linkTo.withRel("Producto-resource"));	
		return resource;
	}
	
	@GetMapping(value="/nick/{user_name}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Resource<Usuario> listarPorUsuario(@PathVariable("user_name")String userName) {
		Usuario usuario = usuarioService.leerPorUsuario(userName);
		if(usuario.getIdUsuario() == null) {
			throw new ModeloNotFoundException("USUARIO NO ENCONTRADO: "+ userName);
		}
		Resource<Usuario> resource = new Resource<Usuario>(usuario);
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listarPorUsuario(userName));
		resource.add(linkTo.withRel("Usuario-resource"));	
		return resource;
	}
	
	@PostMapping(produces="application/json",consumes="application/json")
	public ResponseEntity<Usuario> registrar(@Valid @RequestBody Usuario usuario) {
		String passw = bcrypt.encode(usuario.getPassword());
		usuario.setPassword(passw);
		Usuario user = usuarioService.registrar(usuario);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getIdUsuario()).toUri();
		return ResponseEntity.created(location).build();
	}

	@GetMapping(value="/access", produces="application/json")
	public ResponseEntity<List<AccessDTO>> findByUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return new ResponseEntity<>(accessService.findByUser(auth.getPrincipal().toString()), HttpStatus.OK);
	}

	@PostMapping(value="/access", produces="application/json")
	public ResponseEntity<IntAccess> save(@Valid @RequestBody IntAccess access) {
		UUID uuid = UUID.randomUUID();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		access.setCreatedBy(auth.getPrincipal().toString());
		access.setCreatedDate(LocalDateTime.now());
		access.setToken(uuid.toString());
		access.setState(Boolean.TRUE);
		IntAccess model = accessService.registrar(access);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(model.getIdAccess()).toUri();
		return ResponseEntity.created(location).build();
	}

	@DeleteMapping(value="/access/{id}")
	public void eliminar(@PathVariable("id") Integer id){
		IntAccess model = accessService.leer(id);
		if (model.getIdAccess() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		} else {
			accessService.eliminar(id);
		}
	}

}
