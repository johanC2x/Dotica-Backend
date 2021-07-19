package com.devswpro.service.impl;

import com.devswpro.dao.ICompanyDAO;
import com.devswpro.dto.CompanyDTO;
import com.devswpro.model.IntCompany;
import com.devswpro.service.ICompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements ICompanyService {

    private final ICompanyDAO companyDAO;

    @Override
    public CompanyDTO findByRuc(String ruc) {
        IntCompany company = companyDAO.findByRuc(ruc);
        return CompanyDTO.builder()
                .ruc(company.getRuc())
                .name(company.getName())
                .residenceStatus(company.getResidenceCondition())
                .status(company.getTaxpayerStatus())
                .build();
    }

    @Override
    public IntCompany registrar(IntCompany company) {
        return companyDAO.save(company);
    }

    @Override
    public IntCompany modificar(IntCompany company) {
        IntCompany model = companyDAO.findByRuc(company.getRuc());
        model.setName(company.getName());
        model.setTaxpayerStatus(company.getTaxpayerStatus());
        model.setResidenceCondition(company.getResidenceCondition());
        return companyDAO.save(model);
    }

    @Override
    public List<IntCompany> listar() {
        return null;
    }

    @Override
    public IntCompany leer(Integer id) {
        return null;
    }

    @Override
    public void eliminar(Integer id) {

    }

}
