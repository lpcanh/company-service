package com.lpc.company.repository;

import com.lpc.company.model.Company;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface CompanyRepository extends CrudRepository<Company, Integer> {
    @Override
    public Set<Company> findAll();
}
