package com.devswpro.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devswpro.model.Usuario;

public interface IUsuarioDAO extends JpaRepository<Usuario,Integer> {
	
	/*
	@Query(value = "SELECT * FROM usuario u where u.nombre = :username and u.clave = :password", nativeQuery = true)
	Usuario login(@Param("username") String username, @Param("password") String password);
	*/
	
	Usuario findByUsernameAndPassword(String username, String password);
	
	Usuario findOneByUsername(String username);	
	
}
