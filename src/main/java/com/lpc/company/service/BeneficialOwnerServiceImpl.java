package com.lpc.company.service;

import com.lpc.company.model.BeneficialOwner;
import com.lpc.company.repository.BeneficialOwnerRepository;
import com.lpc.company.web.BeneficialOwnerForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Slf4j
public class BeneficialOwnerServiceImpl implements BeneficialOwnerService{
    @Autowired
    BeneficialOwnerRepository beneficialOwnerRepository;


    @Override
    public List<BeneficialOwner> getAll(Integer companyId) {
        return beneficialOwnerRepository.findByCompanyIdOrderByIdDesc(companyId);
    }

    @Override
    public BeneficialOwner create(Integer companyId, BeneficialOwnerForm form) {
        BeneficialOwner beneficialOwner = new BeneficialOwner();
        beneficialOwner.setName(form.getName());
        beneficialOwner.setCompanyId(companyId);
        return beneficialOwnerRepository.save(beneficialOwner);
    }

    @Override
    public Optional<BeneficialOwner> get(Integer companyId, Integer id) {
        return beneficialOwnerRepository.findByCompanyIdAndId(companyId, id);
    }

    @Override
    public Optional<BeneficialOwner> update(Integer companyId, Integer id, BeneficialOwnerForm form) {
        return get(companyId, id).map(beneficialOwner -> {
            beneficialOwner.setName(form.getName());
            return beneficialOwnerRepository.save(beneficialOwner);
        });
    }

    @Override
    public void delete(Integer companyId, Integer id) {
        get(companyId, id).ifPresent(beneficialOwner -> {
            beneficialOwnerRepository.delete(beneficialOwner);
        });
    }
}
