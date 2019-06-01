package com.devswpro.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devswpro.model.ProductoInsumo;
import com.devswpro.service.IProductoInsumoService;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RestController
@RequestMapping("/productoinsumos")
public class ProductoInsumoController {
	
	
	@Autowired
	private IProductoInsumoService service;
	
	@GetMapping(value = "/{idProducto}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductoInsumo>> listar(@PathVariable("idProducto") Integer idproducto) {
		List<ProductoInsumo> productosinsumo = new ArrayList<>();
		productosinsumo = service.listarInsumoPorProducto(idproducto);
		return new ResponseEntity<List<ProductoInsumo>>(productosinsumo, HttpStatus.OK);
	}

}
