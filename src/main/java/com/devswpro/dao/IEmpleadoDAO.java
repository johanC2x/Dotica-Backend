package com.devswpro.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devswpro.model.Empleado;

public interface IEmpleadoDAO  extends JpaRepository<Empleado, Integer>{

}
