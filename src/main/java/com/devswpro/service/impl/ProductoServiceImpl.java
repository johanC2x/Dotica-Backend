package com.devswpro.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.devswpro.dao.IProductoDAO;
import com.devswpro.dao.IProductoInsumoDAO;
import com.devswpro.dto.FiltroProductoDTO;
import com.devswpro.dto.ProductoListaInsumoDTO;
import com.devswpro.model.Producto;
import com.devswpro.service.IProductoService;

@Service
public class ProductoServiceImpl implements IProductoService{

	@Autowired
	private IProductoDAO dao;
	
	@Autowired
	private IProductoInsumoDAO piDAO;
	
	@Override
	public Producto registrar(Producto obj) {
		return dao.save(obj);
	}
	
	@Override
	public Producto modificar(Producto t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Producto> listar() {
		return dao.findAll();
	}

	@Override
	public Producto leer(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		
	}
	
	@Transactional
	@Override
	public Producto registrarTransaccional(ProductoListaInsumoDTO dto) {
        //dto.getProducto().getDetalleProducto().forEach(det -> det.setProducto(dto.getProducto()));
		dao.save(dto.getProducto());	
		dto.getLstInsumo().forEach(e -> piDAO.registrar(dto.getProducto().getIdProducto(), e.getIdInsumo()));	
		return dto.getProducto();
	}

	@Override
	public List<Producto> buscar(FiltroProductoDTO filtro) {
		System.out.println(" sensar service implementacion  ="+filtro.getNombreProveedorProducto());
	    return  dao.buscar(filtro.getNombreProveedorProducto());		
	}
	

}
