package com.lpc.company.service;

import com.lpc.company.model.Company;
import com.lpc.company.repository.CompanyRepository;
import com.lpc.company.web.CompanyForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class CompanyServiceImpl implements CompanyService{
    @Autowired
    CompanyRepository companyRepository;


    @Override
    public Set<Company> getAll() {
        return companyRepository.findAll();
    }

    @Override
    public Company create(CompanyForm form) {
        Company cpm = new Company();
        cpm.setName(form.getName());
        cpm.setAddress(form.getAddress());
        cpm.setCity(form.getCity());
        cpm.setCountry(form.getCountry());
        cpm.setEmail(form.getEmail());
        cpm.setPhone(form.getPhone());

        cpm.setEmployees(form.getEmployees());
        return companyRepository.save(cpm);
    }

    @Override
    public Optional<Company> get(Integer id) {
        return Optional.ofNullable(companyRepository.findOne(id));
    }

    @Override
    public Optional<Company> update(Integer id, CompanyForm form) {
        return get(id).map(cpm -> {
            cpm.setName(form.getName());
            cpm.setAddress(form.getAddress());
            cpm.setCity(form.getCity());
            cpm.setCountry(form.getCountry());
            cpm.setEmail(form.getEmail());
            cpm.setPhone(form.getPhone());

            cpm.setEmployees(form.getEmployees());
            return companyRepository.save(cpm);
        });
    }

    @Override
    public void delete(Integer id) {
        companyRepository.delete(id);
    }
}
