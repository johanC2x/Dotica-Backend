package com.devswpro.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.devswpro.model.Marca;

public interface IMarcaDAO  extends JpaRepository<Marca, Integer>{

}
