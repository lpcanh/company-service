package com.lpc.company.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lpc.company.web.BeneficialOwnerForm;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "beneficial_owner")
public class BeneficialOwner {
    @Id
    @GeneratedValue
    private Integer id;

    @JsonIgnore
    private Integer companyId;

    private String name;

    public BeneficialOwnerForm toForm() {
        BeneficialOwnerForm rs = new BeneficialOwnerForm();
        rs.setName(name);
        return rs;
    }
}
