package com.lpc.company.service;

import com.lpc.company.model.BeneficialOwner;
import com.lpc.company.web.BeneficialOwnerForm;

import java.util.List;
import java.util.Optional;

public interface BeneficialOwnerService {
    public List<BeneficialOwner> getAll(Integer companyId);
    public BeneficialOwner create(Integer companyId, BeneficialOwnerForm form);
    public Optional<BeneficialOwner> get(Integer companyId, Integer id);
    public Optional<BeneficialOwner> update(Integer companyId, Integer id, BeneficialOwnerForm form);
    public void delete(Integer companyId, Integer id);
}
