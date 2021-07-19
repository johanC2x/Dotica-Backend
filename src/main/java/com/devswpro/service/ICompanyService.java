package com.devswpro.service;

import com.devswpro.dto.CompanyDTO;
import com.devswpro.model.IntCompany;

public interface ICompanyService extends ICRUD<IntCompany> {
    CompanyDTO findByRuc(String ruc);
}
