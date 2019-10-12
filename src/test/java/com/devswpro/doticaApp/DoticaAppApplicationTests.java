package com.devswpro.doticaApp;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.devswpro.dao.IUsuarioDAO;
import com.devswpro.model.Usuario;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DoticaAppApplicationTests {

	@Autowired
	private IUsuarioDAO dao;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	//Objetivo: 
	//La clave del usuario que se envia tiene que ser la misma que esta en base de datos
	
	/*
	@Test
	public void validarPassw() {
		BCryptPasswordEncoder b=new BCryptPasswordEncoder();
		String str=b.encode("123");
		System.out.println("Encoding "+str);
	}
	*/
	
	/*
	@Test
	public void matches() {
        System.out.println(BCrypt.checkpw("123", "$2a$10$rrUasiaeKDQc/3Hncyq3NeFkrWfkNrvFpswDsWiYZoQxwHo4UV8g."));
    }
	*/
	
	@Test
	public void crearUsuario() {
		Usuario us = new Usuario();
		us.setIdUsuario(5);
		us.setUsername("adma3");
		us.setPassword(bcrypt.encode("123"));
		us.setEnabled(true);
		us.setNombres("ADM AREA 3");
		Usuario retorno = dao.save(us);		
		
		assertTrue(retorno.getPassword().equalsIgnoreCase(us.getPassword()));
	}

}
