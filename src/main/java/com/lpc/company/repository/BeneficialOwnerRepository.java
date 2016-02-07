package com.lpc.company.repository;

import com.lpc.company.model.BeneficialOwner;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.Set;

public interface BeneficialOwnerRepository extends CrudRepository<BeneficialOwner, Integer> {
    public Set<BeneficialOwner> findByCompanyId(Integer companyId);

    public Optional<BeneficialOwner> findByCompanyIdAndId(Integer companyId, Integer id);
}
