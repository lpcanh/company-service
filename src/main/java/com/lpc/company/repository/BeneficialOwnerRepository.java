package com.lpc.company.repository;

import com.lpc.company.model.BeneficialOwner;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BeneficialOwnerRepository extends CrudRepository<BeneficialOwner, Integer> {
    public List<BeneficialOwner> findByCompanyIdOrderByIdDesc(Integer companyId);

    public Optional<BeneficialOwner> findByCompanyIdAndId(Integer companyId, Integer id);

    public void deleteByCompanyId(Integer companyId);
}
