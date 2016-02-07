package com.lpc.company.service;

import com.lpc.company.model.Company;
import com.lpc.company.web.CompanyForm;

import java.util.Optional;
import java.util.Set;

public interface CompanyService {
    public Set<Company> getAll();
    public Company create(CompanyForm form);
    public Optional<Company> get(Integer id);
    public Optional<Company> update(Integer id, CompanyForm form);
    public void delete(Integer id);
}
