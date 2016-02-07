package com.lpc.company.model;

import com.lpc.company.web.BeneficialOwnerForm;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "beneficial_owner")
public class BeneficialOwner extends Person {
    private Integer id;
    private Integer companyId;

    public BeneficialOwnerForm toForm(){
        BeneficialOwnerForm rs = new BeneficialOwnerForm();
        rs.setName(name);
        return rs;
    }
}
