package com.devswpro.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devswpro.model.Usuario;

public interface IUsuarioDAO extends JpaRepository<Usuario,Serializable> {
	
	/*
	@Query(value = "SELECT * FROM usuario u where u.nombre = :username and u.clave = :password", nativeQuery = true)
	Usuario login(@Param("username") String username, @Param("password") String password);
	*/
	
	Usuario findByUsernameAndPassword(String username, String password);
	
}
