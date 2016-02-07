package com.lpc.company.service;

import com.lpc.company.model.BeneficialOwner;
import com.lpc.company.web.BeneficialOwnerForm;

import java.util.Optional;
import java.util.Set;

public interface BeneficialOwnerService {
    public Set<BeneficialOwner> getAll(Integer companyId);
    public BeneficialOwner create(Integer companyId, BeneficialOwnerForm form);
    public Optional<BeneficialOwner> get(Integer companyId, Integer id);
    public Optional<BeneficialOwner> update(Integer companyId, Integer id, BeneficialOwnerForm form);
    public void delete(Integer companyId, Integer id);
}
