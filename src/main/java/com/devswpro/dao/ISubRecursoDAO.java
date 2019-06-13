package com.devswpro.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.devswpro.model.SubRecurso;
import com.devswpro.model.Usuario;

public interface ISubRecursoDAO extends JpaRepository<SubRecurso,Integer> {

	@Query(value = "select s.* from usuario_sub_recurso us, usuario u, subrecurso s\r\n" + 
					"where us.id_usuario = u.id_usuario and us.id_sub_recurso = s.id_sub_recurso\r\n" + 
					"and u.nombre = :username and s.slug = :path", nativeQuery = true)
	List<SubRecurso> obtenerSubRecursos(@Param("username") String username, @Param("path") String path);
	
}
