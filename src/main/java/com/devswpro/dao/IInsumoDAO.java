package com.devswpro.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.devswpro.model.Insumo;

public interface IInsumoDAO extends JpaRepository<Insumo, Integer>{

}
