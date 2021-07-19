package com.devswpro.dao;

import com.devswpro.model.IntCompany;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICompanyDAO extends JpaRepository<IntCompany, Long> {
    IntCompany findByRuc(String ruc);
}