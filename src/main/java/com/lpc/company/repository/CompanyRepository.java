package com.lpc.company.repository;

import com.lpc.company.model.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CompanyRepository extends CrudRepository<Company, Integer> {
    @Override
    @Query("SELECT cpm FROM #{#entityName} cpm ORDER BY id DESC")
    public List<Company> findAll();
}
