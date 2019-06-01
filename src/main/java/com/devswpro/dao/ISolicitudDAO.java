package com.devswpro.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devswpro.model.Solicitud;

public interface ISolicitudDAO extends JpaRepository<Solicitud, Integer> {

	
}
