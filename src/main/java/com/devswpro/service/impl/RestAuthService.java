package com.devswpro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.devswpro.dao.ISubRecursoDAO;
import com.devswpro.model.SubRecurso;

@Service
public class RestAuthService {

	@Autowired
	private ISubRecursoDAO dao;
	
	public boolean hasAccess(String path) {
		boolean isValid = false;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String username = authentication.getName();
			List<SubRecurso> lista = dao.obtenerSubRecursos(username, path);
			if(lista != null && lista.size() > 0) {
				isValid = true;
			}
		}
		return isValid;
	}
	
}
