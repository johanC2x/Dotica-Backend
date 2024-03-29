package com.devswpro.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.devswpro.model.Menu;
 
public interface IMenuDAO extends JpaRepository<Menu, Integer>{

	@Query(value="select distinct m.id_menu,m.icono,m.nombre,m.url,m.enable,m.id_menu_padre from menu_rol mr inner join usuario_rol ur on ur.id_rol = mr.id_rol inner join menu m on m.id_menu = mr.id_menu inner join usuario u on u.id_usuario = ur.id_usuario where u.nombre = :nombre and m.id_menu_padre = 0 and enable = 1", nativeQuery = true)
	List<Object[]> listarMenuPorUsuario(@Param("nombre") String nombre);
	
	@Query(value="select distinct m.id_menu,m.icono,m.nombre,m.url,m.enable from menu_rol mr inner join usuario_rol ur on ur.id_rol = mr.id_rol inner join menu m on m.id_menu = mr.id_menu inner join usuario u on u.id_usuario = ur.id_usuario where u.nombre = :nombre and m.id_menu_padre <> 0 and m.id_menu_padre = :id_menu_padre order by 3 asc", nativeQuery = true)
	List<Object[]> listarSubMenuPorUsuario(@Param("nombre") String nombre, @Param("id_menu_padre") Integer idMenuPadre);
	
	//0 | [ 1, 'search', 'buscar', '/buscar']
	//1 | [ 2, 'register', 'registrar', '/consulta']
}
