package com.devswpro.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devswpro.model.Empresa;

public interface IEmpresaDAO extends JpaRepository<Empresa, Integer>{

}
