package com.devswpro.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.devswpro.dao.IProductoInsumoDAO;
import com.devswpro.model.ProductoInsumo;
import com.devswpro.service.IProductoInsumoService;
@Service
public class ProductoInsumoServiceImpl implements IProductoInsumoService{

	@Autowired
	private IProductoInsumoDAO dao; 
	
	@Override
	public ProductoInsumo registrar(ProductoInsumo obj) {
		return dao.save(obj);
	}

	@Override
	public ProductoInsumo modificar(ProductoInsumo obj) {
		return dao.save(obj);
	}

	@Override
	public List<ProductoInsumo> listar() {
		return dao.findAll();
	}

	@Override
	public ProductoInsumo leer(Integer id) {
		Optional<ProductoInsumo> op = dao.findById(id);
		return op.isPresent() ? op.get() : new ProductoInsumo();
	}

	@Override
	public void eliminar(Integer id) {
		dao.deleteById(id);
		
	}

	@Override
	public List<ProductoInsumo> listarInsumoPorProducto(Integer idproducto) {
		
		return dao.listarInsumoPorProducto(idproducto);
	}

}
