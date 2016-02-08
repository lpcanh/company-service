package com.lpc.company.service;

import com.lpc.company.model.Company;
import com.lpc.company.web.CompanyForm;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface CompanyService {
    public List<Company> getAll();

    public Company create(CompanyForm form);

    public Optional<Company> get(Integer id);

    public Optional<Company> update(Integer id, CompanyForm form);

    @Transactional
    public void delete(Integer id);
}
